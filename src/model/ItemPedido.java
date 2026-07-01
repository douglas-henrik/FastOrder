package model;// Criando a classe model.ItemPedido
// Serve para informar o produto escolhido, e a quantidade
// Para facilitar na hora de chamar o produto
// model.Produto, chama um objeto do tipo model.Produto
// quantidade, informa a quantidade desse model.Produto
// observacao, para caso de adicionais ou tirar igredientes do model.Produto

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private String observacao;

    // Metodo principal, que precisa de um model.Produto e um numero referente a quantidade
    public ItemPedido(Produto produto, int quantidade){
        if(produto == null){
            throw new IllegalArgumentException("Produto obrigatório!");
        }
        if(quantidade <= 0){
            throw new IllegalArgumentException("Quantidade inválida!");
        }

        this.produto = produto;
        this.quantidade = quantidade;
        this.observacao = "";
    }

    // Retorna o model.Produto do objeto
    public Produto getProduto() {
        return produto;
    }

    // Retorna a quantidade em int
    public int getQuantidade() {
        return quantidade;
    }

    // Retorna uma String de observacao
    public String getObservacao() {
        return observacao;
    }

    // Guardar ou Atualizar em observacao
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    // Metodo subTotal, retorna o valor do produto vezes a quantidade
    // Exemplo, duas pizza de 15 reais, ele retorna 30 em double
    public double subTotal(){
        return produto.getValor() * quantidade;
    }
}
