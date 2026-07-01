package service;

import model.ItemPedido;
import model.Mesa;
import model.Pedido;
import model.Produto;

import enums.StatusMesa;

import java.util.ArrayList;

// Classe principal
// responsavel por fazer as regras do sistema
public class Sistema {
    private ArrayList<Mesa> mesas;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Produto> cardapio;

    // Assim que cria o objeto, ele recebe duas arrys vazias
    // um arry de mesas e um de pedidos
    public Sistema(){
        mesas = new ArrayList<>();
        pedidos = new ArrayList<>();
        cardapio = new ArrayList<>();
    }

    // Metodo para adcionar mesa a lista de Mesas
    public void adicionarMesa(Mesa mesa){
        mesas.add(mesa);
    }

    // Metodo para buscar a model.Mesa solicitada pelo id dela
    // Dentro da lista de mesas do sistema
    public Mesa buscarMesa(int idMesa){
        for(int i = 0; i < mesas.size(); i++){
            if(mesas.get(i).getIdMesa() == idMesa){
                return mesas.get(i);
            }
        }
        return null;
    }

    // Metodo para mostrar todas as mesas registradas
    public void mostrarMesas(){
        System.out.println("==== MESAS ====");
        for(int i = 0; i < mesas.size(); i++){
            System.out.println(
                    "Mesa " + mesas.get(i).getIdMesa() +
                    " - " + mesas.get(i).getStatus()
            );
        }
    }

    // Metodo para criar pedido, com regras
    // model.Pedido so pode ser criado se a mesa do pedido estiver livre
    public Pedido criarPedido(int idPedido, Mesa mesa){
        if(mesa.getStatus() == StatusMesa.OCUPADA){
            System.out.println("Mesa " + mesa.getIdMesa() + " está ocupada!");
            return null;
        }
        mesa.ocupar();
        Pedido pedido = new Pedido(idPedido, mesa);
        System.out.println("Pedido " + idPedido + " criado.");
        pedidos.add(pedido);
        return pedido;
    }

    // Metodo para fechar o pedido
    // Assim que encerrado, o pedido vai constar como pago e a mesa ficara livre para outro pedido
    public void fecharPedido(Pedido pedido){
        pedido.pagar();
        pedido.getMesa().liberar();
        pedidos.remove(pedido);
        System.out.println("Pedido " + pedido.getIdPedido() + " fechado.");
    }

    // Metodo para buscar o pedido
    public Pedido buscarPedido(int idPedido){
        for(int i = 0; i < pedidos.size(); i++){
            if(pedidos.get(i).getIdPedido() == idPedido){
                return pedidos.get(i);
            }
        }
        return null;
    }

    // Metodo parar mostrar os pedidos
    public void mostrarPedidos(){
        System.out.println("==== PEDIDOS ====");
        for(int i = 0; i < pedidos.size(); i++){
            System.out.println(
                    "Pedido " + pedidos.get(i).getIdPedido() +
                    " | Mesa " + pedidos.get(i).getMesa().getIdMesa() +
                    " | " + pedidos.get(i).getStatus()
            );
        }
    }

    // Metodo para adicionar um produto a lista do sistema
    public void adicionarProduto(Produto produto){
        cardapio.add(produto);
    }

    // Metodo de busca, para buscar um produto pelo id
    // Buscar o produto dentro do cardapio(lista do sistema), e retorna ele
    public Produto buscarProduto(int idProduto){
        for(int i = 0; i < cardapio.size(); i++){
            if(cardapio.get(i).getIdProduto() == idProduto){
                return cardapio.get(i);
            }
        }
        return null;
    }

    // Metodo para exibir o cardapio
    // Mostra todos os produtos cadastrados
    public void mostrarCardapio(){
        System.out.println("==== CARDÁPIO ====");
        for (int i = 0; i < cardapio.size(); i++){
            System.out.println(
                    cardapio.get(i).getIdProduto() + " - " +
                    cardapio.get(i).getNome() + " | R$ " +
                    cardapio.get(i).getValor()
            );
        }
    }

    public void adcionarItemAoPedido(Pedido pedido, Produto produto, int quantidade){
        ItemPedido item = new ItemPedido(produto, quantidade);
        pedido.adicionarItem(item);
    }
}
