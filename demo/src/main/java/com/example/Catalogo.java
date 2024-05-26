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

    public void showCatalogo()
    { System.out.println("Nome: \t Autor: \t" + " Categoria: \t" + " Preço: \t" + "Disponibilidade\n");
      for(Livro l : livros_do_catalogo)
      {
        System.out.printf(l.getNome() + "\t" + l.getAutor() + "\t" + l.getCategoria() + "\tR$%.2f", l.getPreco()); //Pesquisar como deixar alinhado
        System.out.println("\n");
      }
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

  }
