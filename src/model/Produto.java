package model;// Classe model.Produto
// Ela guarda tres atributos, sendo eles
// idProduto, do tipo int
// nome, em String
// valor unitario, do tipo double ( usado no metodo subTotal em model.ItemPedido )

public class Produto {
    private int idProduto;
    private String nome;
    private double valor;

    // Metodo principal, pede primeiro o id, depois o nome e o valor unitario
    public Produto(int idProduto, String nome, double  valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor do produto inválido!");
        }
        if(idProduto <= 0){
            throw new IllegalArgumentException("Identificação do produto inválido!");
        }
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome inválido");
        }

        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
    }

    // Retrona o ID do produto em int
    public int getIdProduto() {
        return idProduto;
    }

    // Retorna o nome do produto em String
    public String getNome() {
        return nome;
    }

    // Retorna o valor unitario do produto em double
    public double getValor() {
        return valor;
    }
}
