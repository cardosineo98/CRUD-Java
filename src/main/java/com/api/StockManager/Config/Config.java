package com.api.StockManager.Config;

import com.api.StockManager.services.ProdutoService;
import org.springframework.context.annotation.Bean;

public class Config {
    @Bean
    public ProdutoService produtoService() {return new ProdutoService();}
}
