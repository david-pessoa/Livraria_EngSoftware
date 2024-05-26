package com.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest 
{
    Controller c = new Controller(false);
    
    @Before
    public void ValidaAcesso()
    {
        boolean bool1 = c.validaAcesso("João", "senha");
        Assert.assertTrue(bool1);
        boolean bool2 = c.validaAcesso("João", "pandas");
        Assert.assertFalse(bool2);
        boolean bool3 = c.validaAcesso("Zé", "pandas");
        Assert.assertTrue(bool3);
        boolean bool4 = c.validaAcesso("Zé", "pimenta");
        Assert.assertFalse(bool4);

    }
    
    @Test
    public void buscaLivroNome()
    {   
        Assert.assertEquals(c.buscaLivroNome("1984"), "1984");
        Assert.assertEquals(c.buscaLivroNome("Sandman"), null);
    }

    @Test
    public void buscaLivroAutor()
    {   
        Assert.assertEquals(c.buscaLivroAutor("George Orwell"), "1984");
        Assert.assertEquals(c.buscaLivroNome("Neil Gaiman"), null);
        Assert.assertEquals(c.buscaLivroNome("Orgulho e Preconceito"), "Orgulho e Preconceito");
    }

    @Test
    public void getDisponibilidade()
    {
        Assert.assertEquals(c.getDisponibilidadeLivro("Crime e Castigo"), true);
        Assert.assertEquals(c.getDisponibilidadeLivro("O Senhor dos Anéis"), true);
        Assert.assertEquals(c.getDisponibilidadeLivro("Boa noite Punpun"), false);
    }



    
}
