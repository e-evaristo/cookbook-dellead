package com.dellead.aula.validations;

import com.dellead.aula.DTO.UsuarioCreateDTO;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailMatch implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UsuarioCreateDTO usuario = (UsuarioCreateDTO) target;
        if (!usuario.getEmail().equals(usuario.getEmailConfirm())) {
            errors.rejectValue("emailConfirm", "EmailMatch.emailConfirm");
        }
    }
}
