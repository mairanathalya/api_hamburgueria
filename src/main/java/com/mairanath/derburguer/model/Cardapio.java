package com.mairanath.derburguer.model;

import com.mairanath.derburguer.enuns.Batatas;
import com.mairanath.derburguer.enuns.Bebidas;
import com.mairanath.derburguer.enuns.Hamburgueres;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Cardapio {
    @Column(name = "Hamburgueres")
    @Enumerated(EnumType.STRING)
    private Hamburgueres hamburgueres;
    @Column(name = "Bebidas")
    @Enumerated(EnumType.STRING)
    private Bebidas bebidas;
    @Column(name = "Batatas")
    @Enumerated(EnumType.STRING)
    private Batatas batatas;

}
