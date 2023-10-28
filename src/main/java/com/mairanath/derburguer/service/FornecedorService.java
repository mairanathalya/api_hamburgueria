package com.mairanath.derburguer.service;

import com.mairanath.derburguer.model.Fornecedor;
import com.mairanath.derburguer.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    FornecedorRepository repository;

    public Fornecedor create (Fornecedor fornecedor){
        return repository.save(fornecedor);
    }

    public Fornecedor update (Fornecedor fornecedor){
        return repository.save(fornecedor);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }

    public List<Fornecedor> listaTodos(){
        return repository.findAll();
    }

    public Optional<Fornecedor> findById(Long id){
        return repository.findById(id);
    }

    public List<Fornecedor> listaPorRazaoSocial(String razaoSocial){
        return repository.findByRazaoSocialContainsIgnoreCase(razaoSocial);
    }

}
