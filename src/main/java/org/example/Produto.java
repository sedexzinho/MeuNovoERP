package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Produto {
    private final String codigo;
    private String nome;
    private double precoCusto;
    private double precoVenda;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, double precoCusto, double precoVenda, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void exibirInfo() {
        System.out.println("**************************************");
        System.out.println("Codigo do produto: " + getCodigo());
        System.out.println("Nome do produto: " + getNome());
        System.out.println("Preco de custo: " + getPrecoCusto());
        System.out.println("Preco de venda: " + getPrecoVenda());
        System.out.println("Quantidade estoque: " + getQuantidadeEstoque());
        System.out.println("**************************************");

    }
}
