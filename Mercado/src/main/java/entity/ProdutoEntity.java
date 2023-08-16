package com.example.mercado.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    private Long id;
    private String nome;
    private double preco;

    // Construtores, getters e setters
}
