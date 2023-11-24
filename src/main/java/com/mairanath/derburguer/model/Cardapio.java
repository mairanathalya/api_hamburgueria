package com.mairanath.derburguer.model;

import com.mairanath.derburguer.enuns.TipoCardapio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Cardapio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private TipoCardapio tipoCardapio;
}
