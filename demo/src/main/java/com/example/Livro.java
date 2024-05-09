package com.example;

import java.util.Random;

public class Livro 
{
    // Atributos
    private int id;
    private String nome;
    private float preco;
    private String autor;
    private String categoria;
    private boolean disponivel;

    // Construtor
    public Livro(String nome, float preco, String autor, String categoria) {
        this.id = geraID();
        this.nome = nome;
        this.preco = preco;
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = true;
    }

    private int geraID() //Cria ID aleatório para o livro
   {
      Random random = new Random();
      return random.nextInt(10000);
   }

    // Métodos de acesso (getters)
    public String getNome() {return nome;}
    public String getAutor() {return autor;}
    public float getPreco() {return preco;}
    public String getCategoria() {return categoria;}
    public int getId() {return id;}   
    public boolean getDisponibilidade() {return disponivel;} 
}
