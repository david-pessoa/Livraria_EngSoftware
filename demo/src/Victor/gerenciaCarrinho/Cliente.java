public class Cliente {
  protected String nome;
  private String CPF;
  private String email;
  private String senha;
  private String[] carrinho;

  public Cliente() {
    this("", "", "", "", new String[] { "" });
  }

  public Cliente(String nome, String CPF, String email, String senha, String[] carrinho) {
    this.nome = nome;
    this.CPF = CPF;
    this.email = email;
    this.senha = senha;
    this.carrinho = carrinho;
  }

  public boolean adicionarNoCarrinho(String livro, int id) {
    String[] aux = new String[carrinho.length + 1];
    for (int i = 0; i < carrinho.length; i++) {
      aux[i] = carrinho[i];
    }
    aux[carrinho.length] = livro + "| id: "+ id;
    this.carrinho = aux;
    return true;
  }

  public boolean removerDoCarrinho(int id) {
    String[] aux = new String[carrinho.length - 1];
    int j = 0;
    for (int i = 0; i < carrinho.length; i++) {
      String[] partes = carrinho[i].split("\\|"); //maracutaia para remover pelo id porque depende da interface grafica
      for (int f = 0; f < partes.length; f++) {
          partes[f] = partes[f].trim();
      }
      String[] separa = new String[2];
      separa[0] = partes[0];
      separa[1] = partes[1].split(":")[1].trim();
      if (Integer.parseInt(separa[1])!= id) {
        aux[j++] = carrinho[i];
      }
    }
    this.carrinho = aux;
    return true;
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

  public String[] getCarrinho() {
    return carrinho;
  }

  protected boolean ValidaAcesso(String senha) {
    if (this.senha == senha)
      return true;
    else
      return false;
  }
}