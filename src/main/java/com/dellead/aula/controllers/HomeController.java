package com.dellead.aula.controllers;

import com.dellead.aula.DTO.UsuarioCreateDTO;
import com.dellead.aula.services.UsuarioService;
import com.dellead.aula.validations.DateVerification;
import com.dellead.aula.validations.EmailAlreadyRegistered;
import com.dellead.aula.validations.EmailMatch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UsuarioService usuarioService;
    private final DateVerification dateVerification;
    private final EmailMatch emailMatch;
    private final EmailAlreadyRegistered emailAlreadyRegistered;

    public HomeController(UsuarioService usuarioService, DateVerification dateVerification, EmailMatch emailMatch, EmailAlreadyRegistered emailAlreadyRegistered) {
        this.usuarioService = usuarioService;
        this.dateVerification = dateVerification;
        this.emailMatch = emailMatch;
        this.emailAlreadyRegistered = emailAlreadyRegistered;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        UsuarioCreateDTO usuario = new UsuarioCreateDTO();
        model.addAttribute("usuario", usuario);
        return "login-register";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        UsuarioCreateDTO usuario = new UsuarioCreateDTO();
        model.addAttribute("usuario", usuario);
        model.addAttribute("alerta","erro");
        model.addAttribute("titulo","Credenciais inválidas!");
        model.addAttribute("texto","Login ou senha incorretos. Verifique seus dados de acesso.");
        return "login-register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("usuario") UsuarioCreateDTO usuario, BindingResult result, Model model) {

        emailMatch.validate(usuario, result);
        dateVerification.validate(usuario, result);
        emailAlreadyRegistered.validate(usuario, result);

        if (result.hasErrors()) {
            return "login-register";
        }
        model.addAttribute("usuario", usuario);
        usuarioService.register(usuario);

        return "redirect:/dashboard";
    }

}
