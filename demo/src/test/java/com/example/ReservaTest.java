package com.example;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class ReservaTest {

    @Test
    public void calculaTotalReserva() {
        Livro livroTeste = new Livro("LivroTeste", 99.99f, "Autor", "Categoria");
        int quantidadeTeste = 3;
        Reserva reservaTeste = new Reserva(livroTeste, quantidadeTeste);

        double totalEsperado = livroTeste.getPreco() * quantidadeTeste;
        double totalCalculado = reservaTeste.calculaTotalReserva();

        Assert.assertEquals(totalEsperado, totalCalculado, 0.001);
    }

    @Test
    public void dataReservaDeveSerAtual() {
        Livro livroTeste = new Livro("LivroTeste", 99.99f, "Autor", "Categoria");
        int quantidadeTeste = 3;
        Reserva reservaTeste = new Reserva(livroTeste, quantidadeTeste);

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataReserva = reservaTeste.getDataReserva();

        Assert.assertEquals(dataAtual, dataReserva);
    }
}