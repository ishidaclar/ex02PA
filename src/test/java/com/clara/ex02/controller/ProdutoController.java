package com.clara.ex02.controller;


import com.clara.ex02.models.ProdutoModel;
import com.clara.ex02.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> requeste = produtoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
    ProdutoModel requeste = produtoService.criarProduto(produtoModel);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(produtoModel.getId()).toUri();

    return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        produtoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{/id}")
    public Optional<ProdutoModel> buscarId(@PathVariable Long id){
        return produtoService.findById(id);
    }
}
