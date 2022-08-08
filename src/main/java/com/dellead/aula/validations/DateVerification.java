package com.dellead.aula.validations;

import com.dellead.aula.DTO.UsuarioCreateDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class DateVerification implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UsuarioCreateDTO usuario = (UsuarioCreateDTO) target;
        try {
            LocalDate.parse(usuario.getDtnasc_ano() + "-" + usuario.getDtnasc_mes() + "-" + usuario.getDtnasc_dia());
        } catch (DateTimeParseException e) {
            errors.rejectValue("dataNascimento", "DateVerification.dataNascimento");
        }
    }
}
