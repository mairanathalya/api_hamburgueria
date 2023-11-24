package com.mairanath.derburguer.service;


import com.mairanath.derburguer.model.Gerente;
import com.mairanath.derburguer.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    GerenteRepository repository;

    public Gerente create (Gerente gerente){
        return repository.save(gerente);
    }

    public Gerente update (Gerente gerente){
        return repository.save(gerente);
    }

    public void  delete (Long id){
        repository.deleteById(id);
    }

    public List<Gerente> listaTodos(){
        return repository.findAll();
    }

    public List<Gerente> listaPorNome(String nome){
        return repository.findByNomeContainsIgnoreCase(nome);
    }
    public Optional<Gerente> findById(Long id){
        return repository.findById(id);
    }
}
