package com.example;
import java.io.*;
import java.util.LinkedList;

public class Controller 
{
    private String cliente;
    private Clientes clientes;
    private Catalogo catalogo;

    public Controller(String cliente, Clientes clientes){
        this.cliente = cliente;
        this.clientes = clientes;
      }
    

    public Catalogo setUpCatalogo() //Extrai informações dos livros contidas no arquivo binário livros.bin
    {
        LinkedList<Livro> listaLivros = new LinkedList<>();
        
        try {
            // Abrir o arquivo binário para leitura
            FileInputStream fileInput = new FileInputStream("./demo/src/main/java/com/example/livros.bin"); //OBS: Mude o caminho se necessário
            DataInputStream dataInput = new DataInputStream(fileInput);
            
            // Ler os dados do arquivo binário e criar objetos Livro
            while (dataInput.available() > 0) {
                String titulo = dataInput.readUTF();
                float preco = dataInput.readFloat();
                String autor = dataInput.readUTF();
                String categoria = dataInput.readUTF();
                
                // Criar objeto Livro e adicionar à linked list
                Livro livro = new Livro(titulo, preco, autor, categoria);
                listaLivros.add(livro);
            }
            
            // Fechar o fluxo de entrada
            dataInput.close();
            fileInput.close();
            
            Catalogo catalogo = new Catalogo(listaLivros);
            return catalogo;
        } 
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao ler o arquivo binário: " + e.getMessage());
            return null;
        }
    }

    public boolean validaAcesso(String nome, String senha)
    {
        if (clientes.ValidaAcesso(nome, senha)){
          this.cliente = nome;
          return true;
        } else {
          return false;
        }
    }

    /* fazer um show catálogo
  public String[] buscaTodosLivros(){
    return catalogo.buscaTodosLivros();
  }
  */
  /* fazer um ver carrinho
    public String[] verCarrinho(){
    if (cliente == null){
      return new String[0];
    } else{
      return clientes.acessaCliente(cliente).getCarrinho();
    }
  }
  remover do carrinho
   */
}

