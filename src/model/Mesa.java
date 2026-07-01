package model;
import enums.StatusMesa;
// Aqui estou criando a classe model.Mesa
// E definindo dois atributos Privados
// idMesa, que vai ser usado pra indentificar o numero dela
// status, que é do tipo enum enums.StatusMesa, que pode ser LIVRE ou OCUPADA

public class Mesa {
    private int idMesa;
    private StatusMesa status;

    // Metodo principal que ao criar o obejto model.Mesa, ele pede um numero inteiro, que vai ser o idMesa
    // Assim, ele guarda o numero no id, e define o staus automaticamente como LIVRE
    public Mesa(int idMesa){
        this.idMesa = idMesa;
        this.status = StatusMesa.LIVRE;
    }

    // Retorna o ID da mesa em int
    public int getIdMesa() {
        return idMesa;
    }

    // Retorna o Status da mesa
    public StatusMesa getStatus() {
        return status;
    }

    // Atualiza o Status da mesa
    public void liberar(){
        if(this.status == StatusMesa.LIVRE){
            System.out.println("Mesa já está livre!");
            return;
        }

        this.status = StatusMesa.LIVRE;
    }

    public void ocupar(){
        if(this.status == StatusMesa.OCUPADA){
            System.out.println("Mesa já está ocupada!");
            return;
        }

        this.status = StatusMesa.OCUPADA;
    }
}
