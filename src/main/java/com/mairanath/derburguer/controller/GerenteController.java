package com.mairanath.derburguer.controller;

import com.mairanath.derburguer.model.Gerente;
import com.mairanath.derburguer.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    GerenteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Gerente> create(@RequestBody Gerente gerente){
        Gerente gerenteCreate = service.create(gerente);
        return ResponseEntity.status(201).body(gerenteCreate);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Gerente> update(@RequestBody Gerente gerente){
        Gerente gerenteCreate = service.update(gerente);
        return ResponseEntity.status(201).body(gerenteCreate);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Gerente> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/listar_todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Gerente> findAll(){
        return service.listaTodos();
    }

    @GetMapping("/listar_por_nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Gerente> buscaPorNome(@PathVariable String nome){
        return service.listaPorNome(nome);
    }
}
