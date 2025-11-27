package org.example;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {

    List<Produto> produtos = new ArrayList<>();

    public EstoqueService() {
        this.produtos = new ArrayList<>();


    }


    public void adicionarProduto(Produto produto) throws ProdutoJaCadastradoException, NomeJaCadastrado {
        Produto existente = buscarPorCodigo(produto.getCodigo());
        Produto nomeExistente = buscarPorNome(produto.getNome());
        if (existente != null) {
            throw new ProdutoJaCadastradoException("Ja existe um produto com esse codigo");
        }
        if (nomeExistente != null) {
            throw new NomeJaCadastrado("    Nome ja existente");
        }
        produtos.add(produto);
    }

    public Produto buscarPorNome(String nome) {

        for (Produto p : produtos) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                return p;

            }
        }
        return null;
    }

    public void mostrarTodosProduto() {
        for (Produto p : produtos) {
            p.exibirInfo();
        }
    }

    public Produto ApagarProdutoPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                produtos.remove(p);
                return p;
            }
        }
        return null;
    }


}
