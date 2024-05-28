package com.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

public class Catalogo 
{
    private LinkedList<Livro> livros_do_catalogo;
  
    //Construtor com parâmetros
    public Catalogo(boolean NaoEhTeste)
    {
      this.livros_do_catalogo = this.setUpCatalogo(NaoEhTeste);
    }

    //Procura um livro no catálogo pelo nome do livro
    public Livro buscaLivroNome(String nome)
    {
      for(Livro l : this.livros_do_catalogo)
      {
        String temp = l.getNome();
        temp = temp.toLowerCase();
        nome = nome.toLowerCase();
        if (temp.equals(nome))
          return l;
      }
      return null;
    }

    //Procura um livro no catálogo pelo nome do autor
    public Livro buscaLivroAutor(String autor)
    {
      for(Livro l : this.livros_do_catalogo)
      {
        String temp = l.getAutor();
        temp = temp.toLowerCase();
        autor = autor.toLowerCase();
        if (temp.equals(autor))
          return l;
      }
      return null;
    }

    //Retorna a uma linked list com todos os livros do catálogo
    public LinkedList<Livro> getLivros_do_catalogo()
    {
        return livros_do_catalogo;
    }

    public Livro buscaIDlivro(int id) //testar
    {
      for(Livro l : this.livros_do_catalogo)
      {
        if(l.getId() == id)
          return l;
      }
      return null;
    }

        //------------------------------------------------- SetUpCatalogo() (Lê arquivo binário) -------------------------------------------------------------
    
    public LinkedList<Livro> setUpCatalogo(boolean NaoEhTeste) //Extrai informações dos livros contidas no arquivo binário livros.bin
    {
        LinkedList<Livro> listaLivros = new LinkedList<>();
        
        String binFilename;
        if(NaoEhTeste)
          binFilename = "./demo/src/main/java/com/example/livros.bin";
        else
          binFilename = "../demo/src/main/java/com/example/livros.bin";

        try (FileInputStream fis = new FileInputStream(binFilename)) 
        {
            byte[] tituloBytes = new byte[100];
            byte[] autorBytes = new byte[50];
            byte[] generoBytes = new byte[30];

            while (fis.available() > 0) 
            {
                // Ler título
                fis.read(tituloBytes);
                String titulo = new String(tituloBytes).trim();

                // Ler preço
                byte[] precoBytes = new byte[4];
                fis.read(precoBytes);
                float preco = ByteBuffer.wrap(precoBytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();

                // Ler autor
                fis.read(autorBytes);
                String autor = new String(autorBytes).trim();

                // Ler gênero
                fis.read(generoBytes);
                String genero = new String(generoBytes).trim();

                // Ler disponível
                byte[] disponivelBytes = new byte[1];
                fis.read(disponivelBytes);
                boolean disponivel = disponivelBytes[0] != 0;

                Livro new_livro = new Livro(titulo, preco, autor, genero, disponivel);
                listaLivros.add(new_livro);
            }
            return listaLivros;
        }          
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao ler o arquivo binário livros.bin: " + e.getMessage());
            return null;
        }
    }
    

    public void showCatalogo() //Exibe o catálogo numa tabela
    {
      System.out.println("\n\t\t\t\t\t\t\tCatálogo");
      int[] larguraColunas = {40, 12, 25, 25, 10}; //Largura de cada coluna 
      String[] cabecalho = {"Nome", "Preço", "Autor", "Categoria", "Disponibilidade"}; //Cabeçalho
        imprimirLinha(cabecalho, larguraColunas); //Imprime cabeçalho
        imprimirLinhaSeparadora(larguraColunas); //Imprime linha separadora

        for (Livro livro : livros_do_catalogo) //Imprime as informações de cada livro numa linha
        {
          String disponibilidade;
          if(livro.getDisponibilidade())
            disponibilidade = "Disponível";
          else
            disponibilidade = "Indisponível";

            String[] linha = {
                livro.getNome(),
                String.valueOf(livro.getPreco()),
                livro.getAutor(),
                livro.getCategoria(),
                disponibilidade
            };
            imprimirLinha(linha, larguraColunas);
        }
    }


  private static void imprimirLinhaSeparadora(int[] larguraColunas) //Função para imprimir linha do cabeçalho
  {
    for (int largura : larguraColunas) {
        for (int i = 0; i < largura; i++) {
            System.out.print("-");
        }
    }
    System.out.print("------\n");

  }

  private static void imprimirLinha(String[] linha, int[] larguraColunas) //Imprime as linhas da tabela
  {
    for (int i = 0; i < linha.length; i++) 
    {
        System.out.printf("%-" + larguraColunas[i] + "s", linha[i]);
    }
    System.out.println();
  }
}
