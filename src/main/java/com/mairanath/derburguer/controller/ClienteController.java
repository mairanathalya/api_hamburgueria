package com.mairanath.derburguer.controller;

import com.mairanath.derburguer.model.Cliente;
import com.mairanath.derburguer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
       Cliente clienteCreate = service.create(cliente);
       return ResponseEntity.status(201).body(clienteCreate);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        Cliente clienteCreate = service.update(cliente);
        return ResponseEntity.status(201).body(clienteCreate);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cliente> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/listar_todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll(){
        return service.listaTodos();
    }

    @GetMapping("/listar_por_nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscaPorNome(@PathVariable String nome){
        return service.listaPorNome(nome);
    }


}
