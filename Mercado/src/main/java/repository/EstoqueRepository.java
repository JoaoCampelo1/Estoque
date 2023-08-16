package com.example.mercado.repository;

import com.example.mercado.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Produto, Long> {
    boolean temEstoque(Produto produto);
}
