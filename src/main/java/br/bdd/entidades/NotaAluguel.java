package br.bdd.entidades;

import java.util.Date;

public class NotaAluguel {

    private Date dataEntrega;
    private int preco;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getDataEntrega(){
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        dataEntrega = time;
    }
}
