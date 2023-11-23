package com.mairanath.derburguer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Funcionario {
    private Long id;

    private String nome;

    private String cpf;

    private String telefone;

    @ManyToOne
    @JoinColumn(name = "email_funcionario")
    private Email emails;
}
