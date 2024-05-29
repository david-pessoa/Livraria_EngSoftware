package com.example;

class ItemCarrinho // Classe que representa um livro dentro do carrinho, com o Livro e a sua respectiva quantidade especificamente para o carrinho 
{
  private Livro item;
  private int quantidade;

  public ItemCarrinho(Livro item, int quantidade) //Construtor
  {
    this.item = item;
    this.quantidade = quantidade;
  }
  //Getters e setters
  public Livro getItem() {return item;}
  public int getQuantidade() {return quantidade;}
  public void setItem(Livro item) {this.item = item;}
  public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

  public float calculaTotalItem() //calcula o valor total do item no carrinho
    {
      return item.getPreco() * quantidade;
    }
}
