package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class ClienteTest 
{
    private Cliente cli_teste = new Cliente();

    @Before
    void setUpCadastro()
    {
        Cliente[] resultado = cli_teste.setUpCadastro();
        Assert.assertEquals(resultado[0].getNome(), "João");
        Assert.assertEquals(resultado[1].getEmail(), "zezinho@gmail.com");
    }

    @Test
    void realizaCompra()
    {
        Livro livro_teste = new Livro("LivroTeste", 99.99f, "Autor", "Categoria");
        Compra compra_teste = new Compra(livro_teste, 2);
        Assert.assertEquals(livro_teste, compra_teste.getItem());
        Assert.assertEquals(2, compra_teste.getQuantidade());
    }

    
    

}