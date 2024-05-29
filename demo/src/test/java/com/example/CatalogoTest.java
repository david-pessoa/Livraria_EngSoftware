package com.example;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class CatalogoTest 
{
    private Catalogo catalogo = new Catalogo(false);
    

    @Before
    public void setUpCatalogo()
    {
        LinkedList<Livro> lista_livros = catalogo.setUpCatalogo(false); //Preenche lista com setUpCatalogo
        Assert.assertEquals(lista_livros.getFirst().getNome(), "O Hobbit");
        Assert.assertEquals(lista_livros.getLast().getAutor(), "John Green");
    }

    @Test
    public void buscaLivroNome()
    {
        Livro livro = catalogo.buscaLivroNome("doM QuIxoTE"); //Testa função de buscar livro pelo nome
        Assert.assertEquals(livro.getNome(), "Dom Quixote");
        Assert.assertEquals(livro.getAutor(), "Miguel de Cervantes");
        Assert.assertEquals(livro.getPreco(), 24.9f, 0.001);
        Assert.assertEquals(livro.getCategoria(), "Clássico");
    }

    @Test
    public void buscaLivroAutor()
    {
        Livro livro = catalogo.buscaLivroAutor("GEOrge OrweLL"); //Testa função de buscar livro pelo nome do autor
        Assert.assertEquals(livro.getNome(), "1984");
        Assert.assertEquals(livro.getAutor(), "George Orwell");
        Assert.assertEquals(livro.getPreco(), 32.0f, 0.001);
        Assert.assertEquals(livro.getCategoria(), "Distopia");
    }

    @Test
    public void testGetPrecoLivro()
    {    
        LinkedList<Livro> lista_livros = catalogo.setUpCatalogo(false);
        float preco = catalogo.buscaLivroNome("O Hobbit").getPreco();
        Assert.assertEquals(preco, 38.0f, 0.0001);
    }

}
