package com.example;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
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
        
        try {
            // Abrir o arquivo binário para leitura
            String caminho;
            if(NaoEhTeste)
              caminho = "./demo/src/main/java/com/example/livros.bin"; //Caminho para execução normal do programa
            else
              caminho = "../demo/src/main/java/com/example/livros.bin"; //Caminho para execução de testes do programa

            FileInputStream fileInput = new FileInputStream(caminho); //OBS: Mude o caminho se necessário
            DataInputStream dataInput = new DataInputStream(fileInput);
            
            // Ler os dados do arquivo binário e criar objetos Livro
            while (dataInput.available() > 0) {
                String titulo = dataInput.readUTF();
                float preco = dataInput.readFloat();
                String autor = dataInput.readUTF();
                String categoria = dataInput.readUTF();
                //Lê disponibilidade
                
                // Criar objeto Livro e adicionar à linked list
                Livro livro = new Livro(titulo, preco, autor, categoria);
                listaLivros.add(livro);
            }
            
            // Fechar o fluxo de entrada
            dataInput.close();
            fileInput.close();
            
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
      int[] larguraColunas = {40, 12, 40, 20, 10}; //Largura de cada coluna 
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
