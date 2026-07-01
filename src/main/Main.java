package main;

import model.Mesa;
import model.Pedido;
import model.Produto;

import service.Sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Sistema sistema = new Sistema();
        boolean menu = true;
        while (menu){

            System.out.println("=====================");
            System.out.println("      FastOrder      ");
            System.out.println("=====================");
            System.out.println();
            System.out.println("1 - Cadastrar mesa");
            System.out.println("2 - Mostrar mesa");
            System.out.println("3 - Cadastrar produto");
            System.out.println("4 - Mostrar cardápio");
            System.out.println("5 - Abrir pedido");
            System.out.println("6 - Adicionar item ao pedido");
            System.out.println("7 - Visualizar pedido");
            System.out.println("8 - Fechar pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha: "); int op = scan.nextInt();

            switch (op){
                case 0:
                    menu = false;
                    break;

                case 1:
                    cadastrarMesa(scan, sistema);
                    break;

                case 2:
                    sistema.mostrarMesas();
                    break;

                case 3:
                    cadastrarProduto(scan, sistema);
                    break;

                case 4:
                    sistema.mostrarCardapio();
                    break;

                case 5:
                    abrirPedido(scan, sistema);
                    break;

                case 6:
                    adicionarItemAoPedido(scan, sistema);
                    break;

                case 7:
                    visualizarPedido(scan, sistema);
                    break;

                case 8:
                    fecharPedido(scan, sistema);
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }
        scan.close();
    }

    private static void cadastrarMesa(Scanner scan, Sistema sistema){
        System.out.println("==== CADASTRAR MESA ==== ");
        System.out.print("Digite numero da mesa: ");
        int idMesa = scan.nextInt();
        if(sistema.buscarMesa(idMesa) != null){
            System.out.println("Mesa já cadastrada!");
        } else{
            sistema.adicionarMesa(new Mesa(idMesa));
            System.out.println("Mesa " + idMesa + " cadastrada com sucesso!");
        }
    }

    private static void cadastrarProduto(Scanner scan, Sistema sistema){
        System.out.println("==== CADASTRAR PRODUTO ====");
        System.out.print("ID do Produto: ");
        int idProduto = scan.nextInt();
        scan.nextLine(); //limpar o Enter
        System.out.print("Nome do Produto: ");
        String nomeProduto = scan.nextLine();
        System.out.print("Valor do Produto: ");
        double valorProduto = scan.nextDouble();
        if(sistema.buscarProduto(idProduto) != null){
            System.out.println("Produto já cadastrado!");
        } else{
            sistema.adicionarProduto(new Produto(idProduto, nomeProduto, valorProduto));
            System.out.println("Produto " + nomeProduto + " cadastrado com sucesso!");
        }
    }

    private static void abrirPedido(Scanner scan, Sistema sistema){
        System.out.println("==== CRIANDO PEDIDO ====");
        System.out.print("ID do Pedido: ");
        int idPedido = scan.nextInt();
        sistema.mostrarMesas();
        Mesa mesa = selecionarMesa(scan, sistema);
        if(mesa == null){
            return;
        }
        if(sistema.buscarPedido(idPedido) != null){
            System.out.println("Pedido em aberto!");
        } else{
            sistema.criarPedido(idPedido, mesa);
        }
    }

    private static void adicionarItemAoPedido(Scanner scan, Sistema sistema){
        System.out.println("==== ADICIONAR ITEM AO PEDIDO ====");
        sistema.mostrarPedidos();
        Pedido pedido = selecionarPedido(scan, sistema);
        if(pedido == null){
            return;
        }
        sistema.mostrarCardapio();
        Produto produto = selecionarProduto(scan, sistema);
        if(produto == null){
            return;
        }
        System.out.print("Quantidade: ");
        int quantidade = scan.nextInt();
        sistema.adcionarItemAoPedido(pedido, produto, quantidade);
        System.out.println(produto.getNome() + " adicionado com sucesso!");
    }

    private static void visualizarPedido(Scanner scan, Sistema sistema){
        sistema.mostrarPedidos();
        Pedido pedido = selecionarPedido(scan, sistema);
        if(pedido == null){
            return;
        }
        pedido.visualizarPedido();
    }

    private static void fecharPedido(Scanner scan, Sistema sistema){
        sistema.mostrarPedidos();
        Pedido pedido = selecionarPedido(scan, sistema);
        if(pedido == null){
            return;
        }
        sistema.fecharPedido(pedido);
    }

    private static Pedido selecionarPedido(Scanner scan, Sistema sistema){
        System.out.print("Selecione um Pedido: ");
        Pedido pedido = sistema.buscarPedido(scan.nextInt());
        if(pedido == null){
            System.out.println("Pedido não encontrado!");
            return null;
        }
        return pedido;
    }

    private static Produto selecionarProduto(Scanner scan, Sistema sistema){
        System.out.print("Selecione um Produto: ");
        Produto produto = sistema.buscarProduto(scan.nextInt());
        if(produto == null){
            System.out.println("Produto não encontrado!");
            return null;
        }
        return produto;
    }

    private static Mesa selecionarMesa(Scanner scan, Sistema sistema){
        System.out.print("Selecione uma Mesa: ");
        Mesa mesa = sistema.buscarMesa(scan.nextInt());
        if(mesa == null){
            System.out.println("Mesa não encontrada!");
            return null;
        }
        return mesa;
    }
}
