import java.util.LinkedList;

public class Controller {
  private String nome_fornecedora;
  private Fornecedora[] lista_fornecedoras;
  private int num_fornecedoras;
  private static final int MAX_FORNECEDORAS = 10;

  public Controller(){
    this.lista_fornecedoras = new Fornecedora[MAX_FORNECEDORAS];
    this.num_fornecedoras = 0;
    this.nome_fornecedora = "";
  }

  public boolean validaAcesso(String nome, String senha) {
    for (int i = 0; i < num_fornecedoras; i++) {
      if (lista_fornecedoras[i].nome.equals(nome)) {
        if (lista_fornecedoras[i].ValidaAcesso(senha)){
          this.nome_fornecedora = nome;
          return true;
        }
      }
    }
    return false;
  }

  public Fornecedora buscaFornecedora(String nome) {
    for (int i = 0; i < num_fornecedoras; i++) {
      if (lista_fornecedoras[i].nome.equals(nome)) {
        return lista_fornecedoras[i];
      }
    }
    return null;
  }

  public boolean adicionaFornecedora(String nome, String CNPJ, String email, String senha,LinkedList<Produtos> produtos, String dados_bancarios){
      lista_fornecedoras[num_fornecedoras] = new Fornecedora(nome, CNPJ, email, senha, produtos, dados_bancarios);
    num_fornecedoras++;
    return true;
  }

  public void setNome(String nome_fornecedora){
    this.nome_fornecedora = nome_fornecedora;
  }

  public String listaEstoque(){
    return buscaFornecedora(nome_fornecedora).listaEstoque();
  }

  public boolean addNoEstoque(String nome_livro, int quant, String data_envio, String data_recebimento){
    return buscaFornecedora(nome_fornecedora).addNoEstoque(nome_livro, quant, data_envio, data_recebimento);
  }

  
  public boolean addNoEstoque(int id,String nome_livro, float preco, String autor, String categoria, int quant, String data_envio, String data_recebimento){
    return buscaFornecedora(nome_fornecedora).addNoEstoque(id,nome_livro, preco, autor, categoria, quant,data_envio, data_recebimento);
  }
}