public class Catalogo {
  private int num_total_livros;
  private int quant_de_categorias;
  private String[] categorias;
  private Livro[] livros;

  public Catalogo(int num_total_livros, int quant_de_categorias, String[] categorias, Livro[] livros) {
    this.num_total_livros = num_total_livros;
    this.quant_de_categorias = quant_de_categorias;
    this.categorias = categorias;
    this.livros = livros;
  }

  // retorna o que esta relacionado com o input, tanto como nome do livro e nome do autor
  public Livro[] buscaLivro(String nome) {
    Livro[] resp1 = buscaLivroNomeLivro(nome);
    Livro[] resp2 = buscaLivroNomeAutor(nome);
    Livro[] resp3 = new Livro[resp1.length + resp2.length];
    int o = 0;
    for (int i = 0; i < resp1.length; i++) {
      resp3[o] = resp1[i];
      o = o + 1;
    }
    for (int i = 0; i < resp2.length; i++) {
      resp3[o] = resp2[i];
      o = o + 1;
    }
    return resp3;
  }

  private Livro[] buscaLivroNomeLivro(String nomeLivro) {
    Livro[] resposta = new Livro[num_total_livros];
    int o = 0;
    for (int i = 0; i < num_total_livros; i++) {
      if (livros[i].getNome().equals(nomeLivro)) {
        resposta[o] = livros[i];
        o = o + 1;
      }
    }
    return resposta;
  }

  private Livro[] buscaLivroNomeAutor(String nomeAutor) {
    Livro[] resposta = new Livro[num_total_livros];
    int o = 0;
    for (int i = 0; i < num_total_livros; i++) {
      if (livros[i].getAutor().equals(nomeAutor)) {
        resposta[o] = livros[i];
        o = o + 1;
      }
    }
    return resposta;
  }

  public String[] buscaTodosLivros() {
    String[] resposta = new String[num_total_livros];
    for (int i = 0; i < num_total_livros; i++) {
      resposta[i] = livros[i].getNome() + "| id: " + livros[i].getId() + "| preco: " + livros[i].getPreco();
    }
    return resposta;
  }

  public Livro buscaId(int id){
    for(int i=0;i < num_total_livros;i++){
      if (livros[i].getId() == id){
        return livros[i];
      }
    }
    return null;
  }
  
  public float CalculaPreco(int id_livro) {
    for (int i = 0; i < num_total_livros; i++) {
      if (livros[i].getId() == id_livro) {
        return livros[i].getPreco();
      }
    }
    return 0.0f;
  }
}