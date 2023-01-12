package com.api.StockManager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoDto {

    @NotBlank
    private String nomeProduto;
    @NotNull
    private double preco;
    @NotNull
    private double qtdItem;
    @NotNull
    private Long codBarras;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(double qtdItem) {
        this.qtdItem = qtdItem;
    }

    public Long getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(Long codBarras) {
        this.codBarras = codBarras;
    }
}
