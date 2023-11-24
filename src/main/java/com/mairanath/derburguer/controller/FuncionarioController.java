package com.mairanath.derburguer.controller;

import com.mairanath.derburguer.model.Funcionario;
import com.mairanath.derburguer.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario){
        Funcionario funcionarioCreate = service.create(funcionario);
        return ResponseEntity.status(201).body(funcionarioCreate);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario){
        Funcionario funcionarioCreate = service.update(funcionario);
        return ResponseEntity.status(201).body(funcionarioCreate);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Funcionario> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/listar_todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> findAll(){
        return service.listaTodos();
    }

    @GetMapping("/listar_por_nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> buscaPorNome(@PathVariable String nome){
        return service.listaPorNome(nome);
    }
}
