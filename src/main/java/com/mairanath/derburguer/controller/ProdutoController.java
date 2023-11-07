package com.mairanath.derburguer.controller;

import com.mairanath.derburguer.model.Produto;
import com.mairanath.derburguer.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        Produto produtoCreate = service.create(produto);
        return ResponseEntity.status(201).body(produtoCreate);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        Produto produtoCreate = service.update(produto);
        return ResponseEntity.status(201).body(produtoCreate);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Produto> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/listar_todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> findAll(){
        return service.listaTodos();
    }

    @GetMapping("/listar_por_nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscaPorNome(@PathVariable String nome){
        return service.listaPorNome(nome);
    }

}
