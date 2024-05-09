package com.example;

import java.util.LinkedList;

public class Catalogo 
{
    private LinkedList<Livro> livros_do_catalogo;
  
    //Construtor com parâmetros
    public Catalogo(LinkedList<Livro> livros)
    {
      this.livros_do_catalogo = livros;
    }

    //Procura um livro no catálogo pelo nome do livro
    public Livro buscaLivroNome(String nome)
    {
      for(Livro l : livros_do_catalogo)
      {
        if (l.getNome().equals(nome))
          return l;
      }
      System.out.println("Esse livro não existe no catálogo!");
      return null;
    }

    //Procura um livro no catálogo pelo nome do autor
    public Livro buscaLivroAutor(String autor)
    {
      for(Livro l : livros_do_catalogo)
      {
        if (l.getAutor().equals(autor))
          return l;
      }
      System.out.println("Não foi encontrado nenhum livro deste autor no catálogo");
      return null;
    }

    //Retorna a uma linked list com todos os livros do catálogo
    public LinkedList<Livro> getLivros_do_catalogo()
    {
        return livros_do_catalogo;
    }

    public void showCatalogo()
    {
      for(Livro l : livros_do_catalogo)
      {
        System.out.println(l.getNome() + " Autor: " + l.getAutor() + " Categoria: " + l.getCategoria() + " Preço: " + l.getPreco());
      }
    }

    public Livro buscaIDlivro(int id) //testar
    {
      for(Livro l : livros_do_catalogo)
      {
        if(l.getId() == id)
          return l;
      }
      return null;
    }


  }
