package com.example;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Assert;


public class ClienteTest 
{
    private Cliente cli_teste = new Cliente();
    private Livro livro_teste = new Livro("LivroTeste", 99.99f, "Autor", "Categoria", true);
    private Livro livro_teste2 = new Livro("LivroTeste2", 99.99f, "Autor2", "Categoria2", true);

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
    public void testAdicionarNoCarrinho() {
        cli_teste.addNoCarrinho(livro_teste2, 2);
        LinkedList<ItemCarrinho> carrinho = cli_teste.getCarrinho();
        assertEquals(1, carrinho.size());
        assertEquals(livro_teste2, carrinho.get(0).getItem());
        assertEquals(2, carrinho.get(0).getQuantidade());
    }

    @Test
    public void testRemoverDoCarrinho() {
        cli_teste.addNoCarrinho(livro_teste, 2);
        cli_teste.removeDoCarrinho(1);
        LinkedList<ItemCarrinho> carrinho = cli_teste.getCarrinho();
        assertEquals(0, carrinho.size());
    }

    @Test
    public void testRealizaCompra() {
        cli_teste.addNoCarrinho(livro_teste, 2);
        cli_teste.addNoCarrinho(livro_teste2, 3);
        cli_teste.CompraCarrinho();

        LinkedList<Compra> pedidos = cli_teste.getPedidos();
        assertEquals(2, pedidos.size());

        Compra compra1 = pedidos.get(1); 
        Compra compra2 = pedidos.get(0);

        assertEquals(livro_teste2.getNome(), compra1.getItem().getNome());
        assertEquals(3, compra1.getQuantidade()); 

        assertEquals(livro_teste.getNome(), compra2.getItem().getNome());
        assertEquals(2, compra2.getQuantidade());

        LinkedList<ItemCarrinho> carrinho = cli_teste.getCarrinho();
        assertEquals(0, carrinho.size());
    }

    @Test
    public void testCancelaPedido()
    {
        Cliente cliente = new Cliente();
        Livro livro = new Livro("Jogador numero 1", 50,"Ernest Cline","Ficção cientifica", true);
        Livro livro2 = new Livro("Percy Jackson", 30, "Rick Riordan", "Fantasia", true);

        cliente.realizaCompra(livro2, 1);
        cliente.realizaCompra(livro, 1);
        cliente.cancelaPedido(0);

        LinkedList<Compra> pedidos = new LinkedList<>();
        Compra compra = new Compra(livro2, 1);
        pedidos.add(compra);

        Assert.assertEquals(cliente.getPedidos().getFirst().getItem().getNome(), pedidos.getLast().getItem().getNome());
    }

    
    

}