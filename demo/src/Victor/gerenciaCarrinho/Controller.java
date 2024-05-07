public class Controller {
  private String cliente; // meio burrice mas funciona
  private Clientes clientes;
  private Catalogo catalogo;

  public Controller(){
    this("Ronaldo", 
         new Clientes(
           new Cliente[] { 
             new Cliente("Ronaldo", "123", "plsgq@example.com" , "senha", new String[] { "Livro 1| id: 1"})}), 
         new Catalogo(2, 2, new String[] { "Categoria 1", "Categoria 2" }, 
                      new Livro[] { 
                        new Livro(1, "Livro 1", 10.0f, "Autor 1", "Categoria 1"), new Livro(2, "Livro 2", 20.0f, "Autor 2", "Categoria 2")}));
  }

  public Controller(String cliente, Clientes clientes, Catalogo catalogo){
    this.cliente = cliente;
    this.clientes = clientes;
    this.catalogo = catalogo;
  }


  public boolean validaAcesso(String nome, String senha){
    if (clientes.ValidaAcesso(nome, senha)){
      this.cliente = nome;
      return true;
    } else {
      return false;
    }
  }
  
  public String[] buscaTodosLivros(){
    return catalogo.buscaTodosLivros();
  }

  public String[] verCarrinho(){
    if (cliente == null){
      return new String[0];
    } else{
      return clientes.acessaCliente(cliente).getCarrinho();
    }
  }

  public boolean adicionarNoCarrinho(String livro){
    String[] tudo = buscaTodosLivros();
    for (int i = 0; i < tudo.length; i++){
      String[] partes = tudo[i].split("\\|");  //maracutaia para adicionar pelo nome porque depende da interface grafica
      for (int j = 0; j < partes.length; j++) {
        partes[j] = partes[j].trim();
      }
      String[] separa = new String[3];
      separa[0] = partes[0];
      separa[1] = partes[1].split(":")[1].trim();
      separa[2] = partes[2].split(":")[1].trim();
      if (separa[0].equals(livro)){
        return clientes.acessaCliente(cliente).adicionarNoCarrinho(separa[0], Integer.parseInt(separa[1]));
      }
    }
    return false;
  }

  public boolean removerDoCarrinho(String livro){
    String[] tudo = verCarrinho();
    for (int i = 0; i < tudo.length; i++){
      String[] partes = tudo[i].split("\\|"); //maracutaia para remover pelo id porque depende da interface grafica
      for (int j = 0; j < partes.length; j++) {
          partes[j] = partes[j].trim();
      }
      String[] separa = new String[2];
      separa[0] = partes[0];
      separa[1] = partes[1].split(":")[1].trim();
      if (separa[0].equals(livro)){
        return clientes.acessaCliente(cliente).removerDoCarrinho(Integer.parseInt(separa[1]));
      }
    }
    return false;
  }
}