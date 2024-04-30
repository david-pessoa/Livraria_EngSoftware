package com.example;
import java.util.Date;

public class Pagamento 
{
    // Atributos
    private int idPagamento;
    private float valor;
    private String status;
    private Date dataPagamento;
    private String formaPagamento;

    // Construtor
    public Pagamento(int idPagamento, float valor, String status, Date dataPagamento, String formaPagamento) {
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.status = status;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
    }

    // Getters
    public int getIdPagamento() {
        return idPagamento;
    }

    public float getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    
    public void realizarPagamento(float precoTotal, String cartao) {
       
        System.out.println("Pagamento de R$" + precoTotal + " realizado com sucesso utilizando o cartão " + cartao);
    }
}
