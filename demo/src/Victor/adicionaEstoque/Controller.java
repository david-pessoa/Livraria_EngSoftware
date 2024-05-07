public class Controller {
  private Fornecedoras fornecedoras;
  private String nome; // meio burrice mas funciona

  // public Controller(){
  //   this.fornecedoras = new Fornecedoras(new Fornecedora[] {new Fornecedora("Fornecedora 1", "123456789", "abc@mail.com", "senha", new Produtos[] { 
  //       new Produtos(new Livro(1, "Livro 1", 10.0f, "Autor 1", "Categoria 1"), 10), 
  //       new Produtos(new Livro(2, "Livro 2", 20.0f, "Autor 2", "Categoria 2"), 5) },"123.456.789-00"), 
  //     new Fornecedora("Fornecedora 2", "987654321", "def@mail.com", "senha", new Produtos[] { 
  //       new Produtos(new Livro(3, "Livro 3", 30.0f, "Autor 3", "Categoria 3"),20), }, "987.654.321-00"),
  //     new Fornecedora("Fornecedora 3", "456789123", "ghi@mail.com", "senha", new Produtos[]{
  //       new Produtos(new Livro(4, "Livro 4", 40.0f, "Autor 4", "Categoria 1"), 15), 
  //       new Produtos(new Livro(5, "Livro 5", 50.0f, "Autor 5" , "Categoria 2"), 12), 
  //       new Produtos(new Livro(6, "Livro 6", 60.0f, "Autor 1", "Categoria 3"),8),
  //       new Produtos(new Livro(7, "Livro 7", 100.0f, "Autor 2" , "Categoria 3"), 20),
  //       new Produtos(new Livro(8, "Livro 8", 10.0f, "Autor 5" , "Categoria 4"), 9)},"987.654.123-00")} 
  //   );
  // }

  public Controller(){
    this.fornecedoras = new Fornecedoras(new Fornecedora[] {new Fornecedora()});
    this.nome = "";
  }

  public boolean adicionaFornecedora(String nome, String CNPJ, String email, String senha, Produtos[] produtos, String dados_bancarios){
    return fornecedoras.adicionaFornecedora(nome, CNPJ, email, senha, produtos, dados_bancarios);
  }

  public boolean validaAcesso(String nome, String senha){
    if (fornecedoras.ValidaAcesso(nome, senha)){
      this.nome = nome;
      return true;
    } else {
      return false;
    }
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String listaEstoque(){
    return fornecedoras.buscaCliente(nome).listaEstoque();
  }

  public boolean addNoEstoque(String nome_livro, int quant, String data_envio, String data_recebimento){
    return fornecedoras.buscaCliente(nome).addNoEstoque(nome_livro, quant, data_envio, data_recebimento);
  }

  public boolean addNoEstoque(int id,String nome_livro, float preco, String autor, String categoria, int quant, String data_envio, String data_recebimento){
    return fornecedoras.buscaCliente(nome).addNoEstoque(id,nome_livro, preco, autor, categoria, quant,data_envio, data_recebimento);
  }
}