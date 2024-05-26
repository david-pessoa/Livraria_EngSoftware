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

    
    

}