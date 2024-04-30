package com.example;

public class Catalogo 
{
    private int num_total_livros;
    private int quant_de_categorias;
    private String[] categorias;
    private Livro[] livros;
  
  
    public Catalogo(int num_total_livros, int quant_de_categorias, String[] categorias,Livro[] livros){
      this.num_total_livros = num_total_livros;
      this.quant_de_categorias = quant_de_categorias;
      this.categorias = categorias;
      this.livros = livros;
    }
    public Livro[] buscaLivro(String nome){
      Livro[] resp1 = buscaLivron(nome);
      Livro[] resp2 = buscaLivroa(nome);
      Livro[] resp3 = new Livro[resp1.length + resp2.length];
      int o = 0;
      for (int i = 0; i < resp1.length; i++){
        resp3[o] = resp1[i]; 
        o = o +1;
      }
      for (int i = 0; i < resp2.length; i++){
        resp3[o] = resp2[i];
        o = o +1;
      }
      return resp3;
    }
  
    private Livro[] buscaLivron(String nomeLivro){
      Livro[] resposta = new Livro[num_total_livros];
      int o = 0;
      for(int i = 0; i < num_total_livros; i++){
        if (livros[i].getNome().equals(nomeLivro)){
          resposta[o] = livros[i];
          o = o+1;
        }
      }
      return resposta;
    }
  
    private Livro[] buscaLivroa(String nomeAutor){
      Livro[] resposta = new Livro[num_total_livros];
      int o = 0;
      for(int i = 0; i < num_total_livros; i++){
        if (livros[i].getAutor().equals(nomeAutor)){
          resposta[o] = livros[i];
          o = o+1;
        }
      }
      return resposta;
    }
  
    public float CalculaPreco(int id_livro)
    {
      for (int i = 0; i < num_total_livros; i++)
      {
        if (livros[i].getId() == id_livro)
        {
          return livros[i].getPreco();
        }
      }
      return 0;
    }
  }
