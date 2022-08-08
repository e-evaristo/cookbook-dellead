package com.dellead.aula.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UsuarioCreateDTO {

    @NotNull
    @Size(min = 3, max = 100)
    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Email
    private String emailConfirm;

    @NotNull
    private String senha;

    @DateTimeFormat(pattern = "yyyy-mm-yy")
    @Past
    private LocalDate dataNascimento;

    private Character sexo;

    @NotNull
    private String dtnasc_dia;
    @NotNull
    private String dtnasc_mes;
    @NotNull
    private String dtnasc_ano;

}
