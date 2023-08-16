package com.example.mercado.service;

import com.example.mercado.model.Produto;
import com.example.mercado.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    private final EstoqueRepository estoque;

    public EstoqueService(EstoqueRepository estoque) {
        this.estoque = estoque;
    }

    public boolean temProduto(Produto produto){
       return estoque.temEstoque(produto);
    }

}
