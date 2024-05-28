package com.example;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;


public class ClienteTest 
{
    private Cliente cli_teste = new Cliente();
    private Livro livro_teste = new Livro("LivroTeste", 99.99f, "Autor", "Categoria");

    @Before
    public void setUpCadastro() //Consertar setUpCadastro() dá erro...
    {   
        Cliente[] resultado = cli_teste.setUpCadastro(false);
        cli_teste = resultado[0];
        Assert.assertEquals(resultado[0].getNome(), "João"); //Verifica nome do primeiro usuário na lista
        Assert.assertEquals(resultado[1].getEmail(), "zezinho@gmail.com"); //Verifica email do segundo usuário na lista
    }

    @Test
    public void realizaCompra() //Verifica se o nome do livro pedido e a quantidade pedida conferem
    {
        cli_teste.realizaCompra(livro_teste, 2);
        LinkedList<Compra> lista_pedidos = cli_teste.getPedidos();
        Assert.assertEquals(lista_pedidos.getFirst().getItem().getNome(), livro_teste.getNome());
        Assert.assertEquals(lista_pedidos.getFirst().getQuantidade(), 2);
    }


    @Test
    public void testCancelaPedido(){
        Cliente cliente = new Cliente();
        Livro livro = new Livro("Jogador numero 1", 50,"Ernest Cline","Ficção cientifica");
        Livro livro2 = new Livro("Percy Jackson", 30, "Rick Riordan", "Fantasia");

        cliente.realizaCompra(livro, 1);
        cliente.realizaCompra(livro2, 1);
        cliente.cancelaPedido(0);

        LinkedList<Compra> pedidos = new LinkedList<>();
        Compra compra = new Compra(livro2, 1);
        pedidos.add(compra);

        Assert.assertEquals(cliente.getPedidos(), pedidos);
    }

    
    

}