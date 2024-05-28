import java.util.LinkedList;
import java.util.Arrays;

public class Controller {
  private Cliente cliente_logado;
  private String nome_cliente; 
  private Catalogo catalogo;
  private Cliente[] clientes;
  private int num_clientes;


// isso aqui tira
  public Controller(){ // controller com o teste
    this("Ronaldo", 
         new Catalogo(new LinkedList<Livro>(Arrays.asList(
           new Livro(1, "Livro 1", 10.0f, "Autor 1", "Categoria 1"), 
           new Livro(2, "Livro 2", 20.0f, "Autor 2", "Categoria 2")))),new Cliente[] {
           new Cliente("Ronaldo", "123", "plsgq@example.com", "senha", new LinkedList(), new LinkedList())}, 1);
  }

  
// isso aqui tira
  public Controller(String nome_cliente, Catalogo catalogo, Cliente[] clientes, int num_clientes){
    this.nome_cliente = nome_cliente;
    this.catalogo = catalogo;
    this.clientes = clientes;
    this.num_clientes = num_clientes;
  }

  // ver carrinho simplificado 
  public String[] verCarrinho(){
    if (nome_cliente == null){
      return new String[0];
    } else{
      return acessaCliente(nome_cliente).getCarrinho();
    }
  }
  
// feito pelo Victor
    public void addNoCarrinho(String livro_str, int qtde) //Adiciona um livro no carrinho pelo nome
    {
        if (qtde <= 0) {
            System.out.println("Valor para quantidade de livros inválido!");
        }else{
            Livro livro = catalogo.buscaLivroNomeLivro(livro_str); //busca o livro no catálogo e retorna o livro
            if(livro != null){
                cliente_logado.addNoCarrinho(livro, qtde);
                System.out.println("Livro adicionado com sucesso!");
            }
        }
    }


  // remove completamente do carrinho
  // feito pelo Victor
  public void removerDoCarrinho(String nome){
    Livro livro = catalogo.buscaLivroNomeLivro(nome); 
            if(livro != null) {
                cliente_logado.(livro, qtde);
                System.out.println("Livro removido com sucesso!");
            }
  }

  // compra tudo do carrinho (não testado manualmente)
  // feito pelo Victor
    public void comprarDoCarrinho() {
        if (cliente != null) {
            cliente_logado.compraCarrinho();
        }
    }
  }
}
