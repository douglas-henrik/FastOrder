package model;// Importando os Arrys

import java.util.ArrayList;
import enums.StatusPedido;

// Classe model.Pedido
// Basicamente tudo se concentra aqui
// idPedido, mesa, um arry de tipo model.ItemPedido, chamando outra classe
// status do tipo enum, que pode ser EM_PREPARO, PRONTO, ENTREGUE, AGUARDANDO_PAGAMENTO, PAGO, CANCELADO

public class Pedido {
    private int idPedido;
    private Mesa mesa;
    private ArrayList<ItemPedido> itens;
    private StatusPedido status;

    // Metodo principal, para criar um pedido precisa informar o id e a mesa do pedido
    // Caso nao exista mesa, nao poderar criar o pedido
    // Assim que iformar, ele criar o pedido ja iniciando um arry vazio, e com status de EM_PREPARO
    public Pedido(int idPedido, Mesa mesa){
        this.idPedido = idPedido;
        this.mesa = mesa;
        itens = new ArrayList<>();
        this.status = StatusPedido.EM_PREPARO;
    }

    // Retorna a model.Mesa do pedido
    public Mesa getMesa(){
        return mesa;
    }

    // Retorna o ID do pedido em int
    public int getIdPedido() {
        return idPedido;
    }

    // Retorna o status do pedido
    public StatusPedido getStatus() {
        return status;
    }

    // Atualiza o status do pedido
    public void pedidoPronto(){
        this.status = StatusPedido.PRONTO;
    }

    public void entregar(){
        this.status = StatusPedido.ENTREGUE;
    }

    public void pagar(){
        this.status = StatusPedido.PAGO;
    }

    public void cancelar(){
        this.status = StatusPedido.CANCELADO;
    }

    // Adiciona um item ao model.Pedido
    // E informa o nome deste produto que foi adicionado
    public void adicionarItem(ItemPedido item){
        itens.add(item);
    }

    // Remoce um item do model.Pedido
    // E informa o nome do produto removido
    public void removerItem(ItemPedido item){
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i).getProduto().getIdProduto() == item.getProduto().getIdProduto()){
                itens.remove(i);
                break;
            }
        }
    }

    // Metodo valorTotal
    // cada item é um objeto do tipo model.ItemPedido, contendo produto e quantidade
    // ele soma todos os subtotais de cada item, assim
    // retorna o valor total do pedido em double
    public double valorTotal(){
        double valor = 0;
        for(int i = 0; i < itens.size(); i++){
            valor += itens.get(i).subTotal();
        }
        return valor;
    }

    // Metodo para vizualizar todos os itens
    // tambem informa o id do pedido, e sua mesa
    // e por fim o valor total do pedido
    public void visualizarPedido(){
        System.out.println("==== PEDIDO " + getIdPedido() + " ====");
        System.out.println("Mesa: " + getMesa().getIdMesa());
        System.out.println("Status: " + getStatus());
        System.out.println("Itens: ");
        for(int i = 0; i < itens.size(); i++){
            System.out.println(
                    itens.get(i).getQuantidade() + " | "
                    + itens.get(i).getProduto().getNome() + " | R$ "
                    + itens.get(i).subTotal()
            );
        }
        System.out.println("Valor total: R$ " + valorTotal());
    }
}
