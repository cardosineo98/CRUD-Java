package com.api.StockManager.controller;

import com.api.StockManager.dtos.ProdutoDto;
import com.api.StockManager.model.Produto;
import com.api.StockManager.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoRestController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> getAllProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto){
        if(produtoService.existsByNomeProduto(produtoDto.getNomeProduto())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto Já Cadastrado no Sistema.");
        }
        if(produtoService.existsByCodBarras(produtoDto.getCodBarras())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Produto Já Cadastrado no Sistema.");
        }
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }

    @GetMapping("/codbarras/{codigobarras}")
    public ResponseEntity<Object> buscarPeloCod(@PathVariable(value = "codigobarras")Long codigobarras){
        Optional<Produto> produtoOptional = produtoService.findByCodBarras(codigobarras);
        if(!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Object> buscarPeloNome(@PathVariable(value = "nome")String nome){
        Optional<Produto> produtoOptional = produtoService.findByNomeProduto(nome);
        if(!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
    }

    @DeleteMapping("/deletar/{codigobarras}")
    public ResponseEntity<Object> deleteUmProduto(@PathVariable(value = "codigobarras")Long codigobarras){
        Optional<Produto> produtoOptional = produtoService.findByCodBarras(codigobarras);
        if(!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não existente");
        }
        produtoService.delete(produtoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto Excluido com sucesso");
    }
    @PutMapping("/upgrade/{codigobarras}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "codigobarras")Long codBarras,
                                                @RequestBody @Valid ProdutoDto produtoDto){
        Optional<Produto> produtoOptional = produtoService.findByCodBarras(codBarras);
        if(!produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Não Existente");
        }
        var produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        produto.setPreco(produtoOptional.get().getPreco());
        produto.setQtdItem(produtoOptional.get().getQtdItem());
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }
}
