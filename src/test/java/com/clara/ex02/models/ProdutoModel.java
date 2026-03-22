package com.clara.ex02.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="tb_produto")

public class ProdutoModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "Nome do produto")
private String nome;

private BigDecimal preco;

public ProdutoModel(){

}

@Column(name = "Quantidade no estoque")
private Integer qtd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
