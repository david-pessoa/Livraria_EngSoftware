import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Cliente {
  protected String nome;
  private String CPF;
  private String email;
  private String senha;
  private LinkedList<Map<Livro, Integer>> carrinho; // carrinho tem que ser assim por causa da quantidade de itens e não ficar feio aquela classe a mais itemCarrinho
  private LinkedList<Compra> pedidos;

  // isso pode tirar
  public Cliente() {
    this("", "", "", "", new LinkedList<Map<Livro, Integer>>(), new LinkedList<Compra>());
  }

  // isso pode tirar
  public Cliente(String nome, String CPF, String email, String senha, LinkedList<Map<Livro, Integer>> carrinho, LinkedList<Compra> pedidos) {
    this.nome = nome;
    this.CPF = CPF;
    this.email = email;
    this.senha = senha;
    this.carrinho = carrinho;
    this.pedidos = pedidos;
  }
  
  // feito pelo Victor
  public boolean adicionarNoCarrinho(Livro livro, int quant) {
    if (quant <= 0) {
      return false;
    }
    Map<Livro, Integer> item = new HashMap<>();
    item.put(livro, quant);
    carrinho.add(item);
    return true;
  }

  // feito pelo Victor
  public boolean removerDoCarrinho(Livro livro) {
    boolean flag = false;
    if (livro == null) {
      return false;
    }
    for (Map<Livro, Integer> item : carrinho) {
      if (item.containsKey(livro)) {
        carrinho.remove(item);
        flag = true;
        break;
      }
    }
    return flag;
  }

  // caso precise (pra mim tira)
  public boolean editarCarrinho(Livro livro, int quant) {
    if (livro == null || quant == 0) {
      return false;
    }
    for (Map<Livro, Integer> item : carrinho) {
      if (item.containsKey(livro)) {
        item.put(livro, quant);
        return true;
      }
    }
    return false;
  }

  // feito pelo victor que comprar tudo do carrinho
  public void compraCarrinho() {
    for (Map<Livro, Integer> item : carrinho) {
        for (Map.Entry<Livro, Integer> entry : item.entrySet()) {
            Livro livro = entry.getKey();
            Integer quantidade = entry.getValue();
            Compra compra = new Compra(livro, quantidade);
            pedidos.addFirst(compra);
        }
    }
    carrinho.clear();
   }
  
  public void realizaCompra(Livro livro, int qtde)
    {

      Compra compra = new Compra(livro, qtde);
      pedidos.addFirst(compra);
    }

  // isso pode tirar era para o terminal
  public String[] getCarrinho() {
    String[] resposta = new String[carrinho.size()];
    int i = 0;
    for (Map<Livro, Integer> item : carrinho) {
      for (Map.Entry<Livro, Integer> entry : item.entrySet()) {
        Livro livro = entry.getKey();
        Integer quantidade = entry.getValue();
        resposta[i] = "nome: " + livro.getNome() + " | quant: " + quantidade;
      }
      i++;
    }
    return resposta;
  }

  public String getNome() {
    return nome;
  }

  public String getCPF() {
    return CPF;
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }

  // preciso disso no teste
  public LinkedList<Compra> getPedidos(){
    return pedidos;
  }

  // preciso disso no teste
  public LinkedList<Map<Livro, Integer>> getListaCarrinho() {
    return carrinho;
  }

  protected boolean ValidaAcesso(String senha) {
    if (this.senha == senha)
      return true;
    else
      return false;
  }
}
