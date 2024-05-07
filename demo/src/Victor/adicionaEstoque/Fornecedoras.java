public class Fornecedoras {
  private Fornecedora[] fornecedoras;
  private int num_fornecedoras;

  public Fornecedoras(Fornecedora[] nome) {
    this.fornecedoras = nome;
    this.num_fornecedoras = fornecedoras.length;
  }

  public Fornecedora buscaCliente(String nome) {
    for (int i = 0; i < num_fornecedoras; i++) {
      if (fornecedoras[i].nome == nome) {
        return fornecedoras[i];
      }
    }
    return null;
  }

  public boolean adicionaFornecedora(String nome, String CNPJ, String email, String senha,Produtos[] produtos, String dados_bancarios){
    fornecedoras[num_fornecedoras] = new Fornecedora(nome, CNPJ, email, senha, produtos, dados_bancarios);
    num_fornecedoras++;
    return true;
  }

  public boolean ValidaAcesso(String nome, String senha) {
    for (int i = 0; i < num_fornecedoras; i++) {
      if (fornecedoras[i].nome == nome) {
        return fornecedoras[i].ValidaAcesso(senha);
      }
    }
    return false;
  }

}