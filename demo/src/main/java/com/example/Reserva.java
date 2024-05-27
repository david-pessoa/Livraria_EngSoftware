package com.example;

import java.time.LocalDate;

public class Reserva {
    private Livro livro;
    private int quantidade;
    private LocalDate dataReserva;

    public Reserva(Livro livro, int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.dataReserva = LocalDate.now();
    }

    // Getters
    public Livro getLivro() { return livro; }
    public int getQuantidade() { return quantidade; }
    public LocalDate getDataReserva() { return dataReserva; }

    // Método para calcular o total da reserva
    public double calculaTotalReserva() {
        return livro.getPreco() * quantidade;
    }
}
