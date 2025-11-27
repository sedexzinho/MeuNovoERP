package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EstoqueService estoqueService = new EstoqueService();
        Scanner scanner = new Scanner(System.in);
        List<String> listaDeProdutos = new ArrayList<>();
        String codigo;
        String nome;
        double custoCompra;
        double custoVenda;
        int quantidadeEstoque;

        while (true) {

            System.out.println("Digite o codigo (ou 'pare') para encerrar");
            codigo = scanner.next();


            if (codigo.equals("pare")) {

                if (estoqueService.produtos.isEmpty()) {
                    System.err.println("Cadastre pelo menos um produto");
                    continue;
                }
                break;
            }


            if (estoqueService.buscarPorCodigo(codigo) != null) {
                System.err.println("O codigo ja existe, tente outro");
                continue;
            }
            System.out.println("Nome do produto: ");
            nome = scanner.next();
            if (estoqueService.buscarPorNome(nome) != null) {
                System.err.println("O nome ja existe, tente outro");
                continue;
            }
            System.out.println("Valor de compra:");
            custoCompra = scanner.nextDouble();
            do {

                System.out.println("Valor de venda:");
                custoVenda = scanner.nextDouble();
                if (custoVenda < custoCompra) {
                    System.err.println("O valor de venda NÃO pode ser menor que o de compra. Tente novamente.");
                }
            }
            while (custoVenda < custoCompra);

            System.out.println("Quantidade de Estoque do produto: ");

            quantidadeEstoque = scanner.nextInt();
            if (quantidadeEstoque < 0 || quantidadeEstoque > 100001) {
                System.out.println("Quantidade invalida, digite um numero entre 1 e 100.000");
                continue;
            }
            scanner.nextLine();
            Produto produto = new Produto(codigo, nome, custoCompra, custoVenda, quantidadeEstoque);
            try {
                estoqueService.adicionarProduto(produto);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("\n DESEJA BUSCAR ALGUM PRODUTO PELO CODIGO?");
        while (true) {

            System.out.println("\n Digite 'sim' ou 'nao' para continuar");
            String opcao = scanner.next();
            if (opcao.equalsIgnoreCase("sim")) {
                System.out.println("Digite o codigo do produto: ");
                String codigoProd = scanner.next();
                Produto encontrar = estoqueService.buscarPorCodigo(codigoProd);
                if (encontrar != null) {
                    encontrar.exibirInfo();
                } else {
                    System.err.println("Produto não encontrado!");
                    continue;
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("DESEJA APAGAR ALGUM PRODUTO PELO CODIGO?");
            String opcaoDeletar = scanner.next();
            if (opcaoDeletar.equals("sim")) {
                System.out.println("Digite o codigo do produto: ");
                String codigoProdDelete = scanner.next();
                Produto codigoProd = estoqueService.ApagarProdutoPorCodigo(codigoProdDelete);
                if (codigoProd != null) {
                    System.out.println("Produto apagado com sucesso!");
                    codigoProd.exibirInfo();
                    continue;
                } else {
                    System.err.println("Produto não encontrado!");
                    continue;
                }
            }
            break;
        }

        System.out.println("VISUALIZAR TODOS PRODUTOS");

        if (estoqueService.produtos.isEmpty()) {
            System.out.println("NENHUM PRODUTO CADASTRADO!");
        } else {
            estoqueService.mostrarTodosProduto();
        }
    }
}



