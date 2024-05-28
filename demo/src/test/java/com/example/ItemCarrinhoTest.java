package com.example;
import org.junit.Test;
import org.junit.Assert;

public class ItemCarrinhoTest 
{
    private Livro livro_teste = new Livro("LivroTeste", 99.99f, "Autor", "Categoria", true);

    @Test
    public void calculaTotalItem()
    {
        ItemCarrinho item = new ItemCarrinho(livro_teste, 3); //Confere se o valor do item no carrinho "bate"
        float total = item.calculaTotalItem();
        Assert.assertEquals(total, item.getQuantidade() * item.getItem().getPreco(), 0.001);
    }
}
