package com.dellead.aula.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = {"email"}) })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull
    @Size(min = 3, max = 100)
    private String nome;

    @Column(length = 200, nullable = false)
    @NotNull
    @Email
    private String email;

    @Column(length = 200, nullable = false)
    @NotNull
    @Email
    @Transient
    private String emailConfirm;

    @Column(nullable = false)
    @NotNull
    private String senha;

    @Column(name = "data_nascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "usuario")
    private Collection<Receita> receitas;

    private Character sexo;

    @Transient
    private String dtnasc_dia;
    @Transient
    private String dtnasc_mes;
    @Transient
    private String dtnasc_ano;
}
