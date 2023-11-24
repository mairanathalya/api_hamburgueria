package com.mairanath.derburguer.service;


import com.mairanath.derburguer.model.Funcionario;
import com.mairanath.derburguer.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public Funcionario create (Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Funcionario update (Funcionario funcionario){
        return repository.save(funcionario);
    }

    public void  delete (Long id){
        repository.deleteById(id);
    }

    public List<Funcionario> listaTodos(){
        return repository.findAll();
    }

    public List<Funcionario> listaPorNome(String nome){
        return repository.findByNomeContainsIgnoreCase(nome);
    }
    public Optional<Funcionario> findById(Long id){
        return repository.findById(id);
    }
}
