package com.api.StockManager.services;

import com.api.StockManager.model.Produto;
import com.api.StockManager.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }
    public boolean existsByNomeProduto(String nomeProduto){
        return produtoRepository.existsByNomeProduto(nomeProduto);
    }
    public boolean existsByCodBarras(Long codBarras) {
        return produtoRepository.existsByCodBarras(codBarras);
    }
    public Iterable<Produto> findAll(){
        return produtoRepository.findAll();
    }
    public Optional<Produto> findByCodBarras(Long codBarras){
        return produtoRepository.findByCodBarras(codBarras);
    }
    public Optional<Produto> findByNomeProduto(String nomeProduto){
        return produtoRepository.findByNomeProduto(nomeProduto);
    }

    public void delete(Produto produto){
        produtoRepository.delete(produto);
    }

}
