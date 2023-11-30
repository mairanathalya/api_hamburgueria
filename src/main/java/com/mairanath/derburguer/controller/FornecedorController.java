package com.mairanath.derburguer.controller;

import com.mairanath.derburguer.model.Fornecedor;
import com.mairanath.derburguer.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedor){
        Fornecedor fornecedorCreate = service.create(fornecedor);
        return ResponseEntity.status(201).body(fornecedorCreate);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fornecedor> update(@RequestBody Fornecedor fornecedor){
        Fornecedor fornecedorCreate = service.update(fornecedor);
        return ResponseEntity.status(201).body(fornecedorCreate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Fornecedor> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/listar_todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Fornecedor> findAll(){
        return service.listaTodos();
    }
    @GetMapping("/listar_por_razao_social/{razaoSocial}")
    @ResponseStatus(HttpStatus.OK)
     public List<Fornecedor> buscaPorRazaoSocial(@PathVariable String razaoSocial){
        return service.listaPorRazaoSocial(razaoSocial);
     }

}
