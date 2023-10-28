package com.mairanath.derburguer.service;

import com.mairanath.derburguer.model.Produto;
import com.mairanath.derburguer.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public Produto create(Produto produto){
        return repository.save(produto);
    }

    public Produto update(Produto produto){
        return repository.save(produto);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }

    public List<Produto> listaTodos(){
        return repository.findAll();
    }

    public Optional<Produto> findById(Long id){
        return repository.findById(id);
    }

    public List<Produto> listaPorNome(String nome){
        return repository.findByNomeContainsIgnoreCase(nome);
    }

}
