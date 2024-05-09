public class Produtos {
  private Livro livro;
  private int quanti;

  public Produtos(Livro livro, int quanti) {
    this.livro = livro;
    this.quanti = quanti;
  }

  public Produtos() {
    this(new Livro(), -1);
  }

  public Livro getLivro() {
    return livro;
  }

  public int getQuanti() {
    return quanti;
  }

  public void setQuanti(int quanti) {
    this.quanti = quanti;
  }

  public boolean falta() {
    return quanti <= 10;
  }

}