package com.example;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class CatalogoTest 
{
    private Catalogo catalogo = new Catalogo();

    @Before
    public void setUpCatalogo()
    {
        LinkedList<Livro> lista_livros = catalogo.setUpCatalogo(false);
        Assert.assertEquals(lista_livros.getFirst().getNome(), "O Pequeno Príncipe");
        Assert.assertEquals(lista_livros.getLast().getAutor(), "J.R.R. Tolkien");
    }

    @Test
    public void buscaLivroNome()
    {
        //depende do setUpCatalogo() funcionar....
    }

    @Test
    public void buscaLivroAutor()
    {
        //depende do setUpCatalogo() funcionar....
    }

    @Test
    public void buscaIDlivro()
    {
        //depende do setUpCatalogo() funcionar....
    }

    



}
