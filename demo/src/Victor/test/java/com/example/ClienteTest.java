import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class ClienteTest {

    private Cliente cliente;
    private Livro livro;
    private Livro livro2;

    @Before
    public void setUp() {
        cliente = new Cliente();
        livro = new Livro("Livro Teste", "Autor Teste", 123);
        livro2 = new Livro("Livro Teste 2", "Autor Teste 2", 456);
    }

    @Test
    public void testAdicionarNoCarrinho() {
        assertTrue(cliente.adicionarNoCarrinho(livro, 2));
        LinkedList<ItemCarrinho> carrinho = cliente.getListaCarrinho();
        assertEquals(1, carrinho.size());
        assertEquals(livro, carrinho.get(0).getLivro());
        assertEquals(2, carrinho.get(0).getQuantidade());
    }

    @Test
    public void testRemoverDoCarrinho() {
        cliente.adicionarNoCarrinho(livro, 2);
        assertTrue(cliente.removerDoCarrinho(livro));
        LinkedList<ItemCarrinho> carrinho = cliente.getListaCarrinho();
        assertEquals(0, carrinho.size());
    }
    
    @Test
    public void testRealizaCompra() {
        cliente.adicionarNoCarrinho(livro, 2);
        cliente.adicionarNoCarrinho(livro2, 3);
        cliente.compraCarrinho();

        LinkedList<Compra> pedidos = cliente.getPedidos();
        assertEquals(2, pedidos.size());

        Compra compra1 = pedidos.get(1); 
        Compra compra2 = pedidos.get(0);

        assertEquals(livro, compra1.getItem());
        assertEquals(2, compra1.getQuantidade()); 

        assertEquals(livro2, compra2.getItem());
        assertEquals(3, compra2.getQuantidade());

        LinkedList<ItemCarrinho> carrinho = cliente.getListaCarrinho();
        assertEquals(0, carrinho.size());
    }
}
