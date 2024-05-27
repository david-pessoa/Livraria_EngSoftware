import java.util.LinkedList;
import java.util.Arrays;

public class Controller {
  private String nome_cliente; 
  private Catalogo catalogo;
  private Cliente[] clientes;
  private int num_clientes;

  public Controller(){ // controller com o teste
    this("Ronaldo", 
         new Catalogo(new LinkedList<Livro>(Arrays.asList(
           new Livro(1, "Livro 1", 10.0f, "Autor 1", "Categoria 1"), 
           new Livro(2, "Livro 2", 20.0f, "Autor 2", "Categoria 2")))),new Cliente[] {
           new Cliente("Ronaldo", "123", "plsgq@example.com", "senha", new LinkedList(), new LinkedList())}, 1);
  }

  

  public Controller(String nome_cliente, Catalogo catalogo, Cliente[] clientes, int num_clientes){
    this.nome_cliente = nome_cliente;
    this.catalogo = catalogo;
    this.clientes = clientes;
    this.num_clientes = num_clientes;
  }

  
  public Cliente acessaCliente(String nome) {
    for (int i = 0; i < num_clientes; i++) {
      if (clientes[i].getNome().equals(nome)) {
        return clientes[i];
      }
    }
    return null;
  }

  public String buscaCliente(String username) {
    for (int i = 0; i < num_clientes; i++) {
      if (clientes[i].nome == username) {
        return clientes[i].nome;
      }
    }
    return "";
  }

  public boolean validaAcesso(String username, String senha) {
    for (int i = 0; i < num_clientes; i++) {
      if (clientes[i].nome == username) {
        if (clientes[i].ValidaAcesso(senha)){
          this.nome_cliente = username;
          return true;
        }
      }
    }
    return false;
  }


  // mostra o catalogo
  public void buscaTodosLivros(){
    catalogo.showCatalogo();
  }

  // ver carrinho simplificado 
  public String[] verCarrinho(){
    if (nome_cliente == null){
      return new String[0];
    } else{
      return acessaCliente(nome_cliente).getCarrinho();
    }
  }

  // adiciona item ao carrinho
  public boolean adicionarNoCarrinho(int id, int quant){
    if (catalogo.buscaIDlivro(id) != null){
      return acessaCliente(nome_cliente).adicionarNoCarrinho(catalogo.buscaIDlivro(id), quant);
    }
    return false;
  }

  // remove completamente o carrinho
  public boolean removerDoCarrinho(int id){
    if (catalogo.buscaIDlivro(id) != null){
      return acessaCliente(nome_cliente).removerDoCarrinho(catalogo.buscaIDlivro(id));
    }
    return false;
  }

  // edita a quantidade no carrinho
  public boolean editarCarrinho(int id, int quant){
    if (catalogo.buscaIDlivro(id) != null){
      return acessaCliente(nome_cliente).editarCarrinho(catalogo.buscaIDlivro(id), quant);
    }
    return false;
  }

  // compra tudo do carrinho (não testado manualmente)
    public void comprarDoCarrinho() {
        Cliente cliente = acessaCliente(nome_cliente);
        if (cliente != null) {
            cliente.compraCarrinho();
        }
    }
  }
}
