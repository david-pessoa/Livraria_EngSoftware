package com.example;
import org.junit.Test;
import org.junit.Assert;

public class CompraTest 
{
    private Livro livro_teste = new Livro("LivroTeste", 99.99f, "Autor", "Categoria", true);

    @Test
    public void calculaTotalCompra()
    {
        Compra compra_teste = new Compra(livro_teste, 4); //Confere se o valor da compra "bate"
        float total = compra_teste.calculaTotalCompra();
        Assert.assertEquals(total, compra_teste.getValor_compra(), 0.001);
    }
}
