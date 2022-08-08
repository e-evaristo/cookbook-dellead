package com.dellead.aula.validations;

import com.dellead.aula.DTO.UsuarioCreateDTO;
import com.dellead.aula.services.UsuarioService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailAlreadyRegistered implements Validator {

    private final UsuarioService usuarioService;

    public EmailAlreadyRegistered(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UsuarioCreateDTO usuario = (UsuarioCreateDTO) target;

        if (usuarioService.findByEmail(usuario.getEmail()).isPresent()) {
            errors.rejectValue("email", "EmailAlreadyRegistered.email");
        }
    }
}
