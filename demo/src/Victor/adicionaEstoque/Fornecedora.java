public class Fornecedora {
  protected String nome;
  private String CNPJ;
  private String email;
  private String senha;
  private Produtos[] produtos;
  private String dados_bancarios;
  
  public Fornecedora() {
    this("", "", "", "", new Produtos[0],"");
  }

  public Fornecedora(String nome, String CNPJ, String email, String senha, Produtos[] produtos,String dados_bancarios) {
    this.nome = nome;
    this.CNPJ = CNPJ;
    this.email = email;
    this.senha = senha;
    this.produtos = produtos;
    this.dados_bancarios = dados_bancarios;
  }

  public String getNome() {
    return nome;
  }

  public String listaEstoque() {
    String retorno = "";
    for (int i = 0; i < produtos.length; i++) {
      retorno += "nome: " + produtos[i].getLivro().getNome() + "\nquantidade: " + produtos[i].getQuanti()
          + "\nem falta?: " + (produtos[i].falta() ? "SIM" : "NÃO") + "\n\n";
    }
    return retorno;
  }

  public boolean addNoEstoque(String nome, int quant, String data_envio, String data_recebimento) {
    for (int i = 0; i < produtos.length; i++) {
      if (produtos[i].getLivro().getNome().equals(nome)) {
        produtos[i].setQuanti(produtos[i].getQuanti() + quant);
        // talvez uma comunicação aqui com a instituição financeira
        return true;
      }
    }
    return false;
  }

  public boolean addNoEstoque(int id,String nome, float preco, String autor, String categoria, int quant, String data_envio, String data_recebimento) {
    Produtos[] aux = new Produtos[produtos.length + 1];
    for (int i = 0; i < produtos.length; i++){
      aux[i] = produtos[i];
    }
    aux[produtos.length] = new Produtos(new Livro(id, nome, preco, autor, categoria),quant);
    this.produtos = aux;
    // talvez uma comunicação aqui com a instituição financeira
    return true;
  }
  
  public String getCPF() {
    return CNPJ;
  }

  public String getEmail() {
    return email;
  }

  public String getSenha() {
    return senha;
  }

  public String getDados_bancarios(){
    return dados_bancarios;
  }

  protected boolean ValidaAcesso(String senha) {
    if (this.senha == senha)
      return true;
    else
      return false;
  }
}