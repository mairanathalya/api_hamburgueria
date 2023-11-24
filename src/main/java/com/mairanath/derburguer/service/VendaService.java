package com.mairanath.derburguer.service;

import com.mairanath.derburguer.model.Produto;
import com.mairanath.derburguer.repository.EstoqueRepository;
import com.mairanath.derburguer.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    private EstoqueRepository estoqueRepository;

    private ProdutoRepository produtoRepository;

    public List<Produto> consultarCodigoDeBarras (String codigoDeBarras){
        return produtoRepository.findByCodigoDeBarrasContainsIgnoreCase(codigoDeBarras);
    }


}
