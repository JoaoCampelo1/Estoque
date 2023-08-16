package com.example.mercado.service;

import com.example.mercado.factory.ProdutoFactory;
import com.example.mercado.model.*;
import com.example.mercado.web.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.mercado.model.CategoriaProduto.get;

@Service
public class MercadoService {

    private final EstoqueService estoque;
    private final Mercado mercado;
    private final ProdutoFactory factory;

    public MercadoService(EstoqueService estoque, ProdutoFactory factory) {
        this.estoque = estoque;
        this.factory = factory;
        this.mercado = new Mercado();
    }

    private void venderProduto(Produto produto){
        Double preco = mercado.calcularPreco(produto);
        if(produto.getCliente().aceitaPreco(preco)){
            System.out.printf("Cliente %s aceitou o preço de %.2f para o produto %s%n", produto.getCliente().getNome(), preco, produto);
            if(mercado.hasFuncionarioDisponivel()) {
                System.out.printf("Funcionario %s disponivel, verificando disponibilidade de produto%n", mercado.getFuncionarioDisponivel().getNome());
                if (estoque.temProduto(produto)){
                    System.out.printf("Produto %s disponivel, iniciando a venda%n", produto.getNome());
                    mercado.vender(produto);
                } else {
                    System.out.printf("Produto %s nao disponivel, aguardando reposição%n", produto.getNome());
                    mercado.getFuncionarioDisponivel().setDisponivel();
                }
            } else {
                System.out.printf("Nenhum funcionario disponivel, o produto será vendido assim que possível%n");
            }

        } else {
            System.out.printf("Cliente %s não aceitou o preço de %.2f%n", produto.getCliente().getNome(), preco);
        }

    }

    public void venderProduto(ProdutoDTO produtoDTO) {

        if(get(produtoDTO.getCategoria()).isEmpty()) {
            throw new RuntimeException(String.format("Categoria de produto %s inválida", produtoDTO.getCategoria()));
        }

        venderProduto(factory.getProduto(produtoDTO), new Produto(produtoDTO.getNome(), produtoDTO.getCategoria()));
    }

    public List<Produto> listarProdutos() {
        return mercado.getProdutos();
    }

    public Produto getProduto(int id) {
        return mercado.getProdutos().get(id-1);
    }

    public void removerProduto(int id) {
        mercado.remover(id-1);
    }
}
