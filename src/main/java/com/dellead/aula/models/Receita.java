package com.dellead.aula.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "receitas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull
    @Size(min = 3, max = 200)
    private String titulo;

    @Column(nullable = false, columnDefinition="TEXT")
    @NotNull
    private String ingredientes;

    @Column(nullable = false, columnDefinition="TEXT")
    @NotNull
    private String procedimentos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
