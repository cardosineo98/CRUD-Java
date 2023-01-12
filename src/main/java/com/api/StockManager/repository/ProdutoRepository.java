package com.api.StockManager.repository;

import com.api.StockManager.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNomeProduto(String nomeProduto);

    boolean existsByCodBarras(Long codBarras);

    Optional<Produto> findByNomeProduto(String nomeProduto);

    Optional<Produto> findByCodBarras(Long codBarras);
}
