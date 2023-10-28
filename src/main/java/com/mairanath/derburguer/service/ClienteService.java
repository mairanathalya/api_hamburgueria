package com.mairanath.derburguer.service;

import com.mairanath.derburguer.model.Cliente;
import com.mairanath.derburguer.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
   private ClienteRepository repository;

    public Cliente create (Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente update (Cliente cliente){
        return repository.save(cliente);
    }

    public void  delete (Long id){
         repository.deleteById(id);
    }

    public List<Cliente> listaTodos(){
        return repository.findAll();
    }

   public List<Cliente> listaPorNome(String nome){
        return repository.findByNomeContainsIgnoreCase(nome);
   }
    public Optional<Cliente> findById(Long id){
        return repository.findById(id);
    }

}
