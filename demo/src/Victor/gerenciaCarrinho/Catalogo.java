import java.util.LinkedList;

public class Catalogo {
  private LinkedList<Livro> livros_do_catalogo;

  // Construtor com parâmetros
  public Catalogo(LinkedList<Livro> livros) {
    this.livros_do_catalogo = livros;
  }

  // Procura um livro no catálogo pelo nome do livro (eu preciso disso)
  public Livro buscaLivroNomeLivro(String nome) {
    for (Livro l : livros_do_catalogo) {
      String temp = l.getNome();
      temp = temp.toLowerCase();
      nome = nome.toLowerCase();
      if (temp.equals(nome))
        return l;
    }
    return null;
  }

  // Retorna a uma linked list com todos os livros do catálogo
  public LinkedList<Livro> getLivros_do_catalogo() {
    return livros_do_catalogo;
  }

  
  public void showCatalogo() {
    for (Livro l : livros_do_catalogo) {
      System.out.println(l.getNome() + " Autor: " + l.getAutor() + " Categoria: " + l.getCategoria() + " Preço: "
          + l.getPreco() + "\n");
    }
  }

  public Livro buscaIDlivro(int id)
  {
    for (Livro l : livros_do_catalogo) {
      if (l.getId() == id)
        return l;
    }
    return null;
  }

}
