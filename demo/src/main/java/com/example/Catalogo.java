package com.example;

import java.util.LinkedList;

public class Catalogo 
{
    private int num_total_livros; //total de livros do catálogo
    
    private LinkedList<Livro> livros_do_catalogo;
  
    //Construtor com parâmetros
    public Catalogo(int num_total_livros, LinkedList<Livro> livros)
    {
      this.num_total_livros = num_total_livros;
      this.livros_do_catalogo = livros;
    }

    public Livro buscaLivroNome(String nome)
    {
      for(Livro l : livros_do_catalogo)
      {
        if (l.getNome().equals(nome))
          return l;
      }
      return null;
    }

    public Livro buscaLivroAutor(String autor)
    {
      for(Livro l : livros_do_catalogo)
      {
        if (l.getAutor().equals(autor))
          return l;
      }
      return null;
    }


  }
