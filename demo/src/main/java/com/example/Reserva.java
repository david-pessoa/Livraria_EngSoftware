package com.example;
import java.time.LocalDate;
import java.util.Random;

public class Reserva {
    private int id_reserva; // Número de identificação ID da reserva
    private Livro item; // Item reservado
    private int quantidade; // Quantidade de livros reservados
    private String data_reserva; // Data da reserva

    // Construtor

    public Reserva(Livro item, int quantidade) {
        this.id_reserva = geraID();
        this.item = item;
        this.quantidade = quantidade;
        this.data_reserva = LocalDate.now().toString();
        
    }

    // Métodos de acesso
    public int getId_reserva() {
        return id_reserva;
    }

    public Livro getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getData_reserva() {
        return data_reserva;
    }

    // Método privado para gerar um ID aleatório para a reserva
    private int geraID() {
        Random random = new Random();
        return random.nextInt(10000);
    }
}
