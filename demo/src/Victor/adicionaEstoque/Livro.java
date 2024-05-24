public class Livro {
  private int id;
  private String nome;
  private float preco;
  private String autor;
  private String categoria;

  public Livro() {
    this(-1, "", -1, "", "");
  }

  public Livro(int id, String nome,float preco, String autor, String categoria) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.autor = autor;
    this.categoria = categoria;
  }

  public String getNome() {
    return nome;
  }

  public String getAutor() {
    return autor;
  }

  
  public float getPreco() {
    return preco;
  }

  public int getId() {
    return id;
  }

}