import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class ClienteTest {

    private Cliente cliente;
    private Livro livro;

    @Before
    public void setUp() {
        cliente = new Cliente();
        livro = new Livro("Livro Teste", "Autor Teste", 123);
    }

    @Test
    public void testAdicionarNoCarrinho() {
        assertTrue(cliente.adicionarNoCarrinho(livro, 2));
        LinkedList<Map<Livro, Integer>> carrinho = cliente.getListaCarrinho();
        assertEquals(1, carrinho.size());
        assertEquals(Integer.valueOf(2), carrinho.get(0).get(livro));
    }

    @Test
    public void testRemoverDoCarrinho() {
        cliente.adicionarNoCarrinho(livro, 2);
        assertTrue(cliente.removerDoCarrinho(livro));
        LinkedList<Map<Livro, Integer>> carrinho = cliente.getListaCarrinho();
        assertEquals(0, carrinho.size());
    }
    
    @Test
    public void testRealizaCompra() {
        cliente.adicionarNoCarrinho(livro1, 2);
        cliente.adicionarNoCarrinho(livro2, 3);
        cliente.realizaCompra();

        LinkedList<Compra> pedidos = cliente.getPedidos();
        assertEquals(2, pedidos.size());

        Compra compra1 = pedidos.get(1); 
        Compra compra2 = pedidos.get(0);

        assertEquals(livro1, compra1.getItem());
        assertEquals(2, compra1.getQuantidade()); 

        assertEquals(livro2, compra2.getItem());
        assertEquals(3, compra2.getQuantidade());

        LinkedList<Map<Livro, Integer>> carrinho = cliente.getListaCarrinho();
        assertEquals(0, carrinho.size());
    }
}
