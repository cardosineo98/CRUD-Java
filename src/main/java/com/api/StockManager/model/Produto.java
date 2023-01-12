package com.api.StockManager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codInterno;
    @Column(nullable = false, length = 70)
    private String nomeProduto;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private double qtdItem;
    @Column(nullable = false)
    private Long codBarras;



    public Long getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(Long codInterno) {
        this.codInterno = codInterno;
    }

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
