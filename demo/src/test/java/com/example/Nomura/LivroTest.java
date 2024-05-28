package com.example;
import org.junit.Test;
import org.junit.Assert;

public class LivroTest 
{
    @Test
    public void Livro()
    {
        Livro livro = new Livro("NomeDoLivro", 16.80f, "Autor", "Categoria");
        Assert.assertEquals(livro.getNome(), "NomeDoLivro");
        Assert.assertEquals(livro.getPreco(), 16.80f, 0.001);
    }
}
