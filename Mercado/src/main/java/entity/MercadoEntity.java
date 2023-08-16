package com.example.mercado.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "mercado")
public class MercadoEntity {

    @Id
    private Long id;
    private String nome;
    @OneToMany
    private List<ProdutoEntity> produtos;
}
