package com.example;

import java.util.LinkedList;

class ItemCarrinho
{
  private Livro item;
  private int quantidade;

  public ItemCarrinho(Livro item, int quantidade)
  {
    this.item = item;
    this.quantidade = quantidade;
  }
  public Livro getItem() {return item;}
  public int getQuantidade() {return quantidade;}
  public void setItem(Livro item) {this.item = item;}
  public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
}

public class Cliente//Classe para representar os clientes da loja
{
    protected String nome; //Atributos
    private String CPF;
    private String email;
    private String senha;
    private LinkedList<ItemCarrinho> carrinho; //Carrinho do cliente
    private LinkedList<Compra> pedidos; //Lista de pedidos realizados pelo cliente
    private boolean valida_login;

    public Cliente() //Construtor sem parâmetros
    {
      this("","","","");
    }

    //Construtor com parâmetros
    public Cliente(String nome, String CPF, String email, String senha)
    {
      this.nome = nome;
      this.CPF = CPF;
      this.email = email;
      this.senha = senha;
    }

    //Getters
    public String getNome(){return nome;} 
    public String getCPF(){return CPF;}
    public String getEmail(){return email;}
    private String getSenha(){return senha;}
    public boolean getValida_login() {return valida_login;}

    //Setters
    public void setNome(String nome){this.nome = nome;}
    public void setCPF(String CPF){this.CPF = CPF;}
    public void setEmail(String email){this.email = email;}
    public void setSenha(String senha){this.senha = senha;}
    public void setLogado(){this.valida_login = true;}
    public void setNaoLogado(){this.valida_login = false;}

    public void realizaCompra(Livro livro, int qtde)
    {
      Compra compra = new Compra(livro, qtde);
      pedidos.addFirst(compra);
    }

    public void addNoCarrinho(Livro livro, int qtde)
    {
      ItemCarrinho new_item = new ItemCarrinho(livro, qtde);
      carrinho.addFirst(new_item);
    }

    //Adicionar opção de comprar um item do carrinho
    //Adicionar opção de comprar todos os itens do carrinho

    public void showCarrinho()
    {
      System.out.println("\tLivros no meu carrinho: ");
      System.out.println("Nome do Livro\tQuantidade\tPreço do item");
      for(ItemCarrinho item : carrinho)
      {
        System.out.println(item.getItem().getNome() + "\t" + item.getQuantidade() + "\t" + (item.getItem().getPreco() * item.getQuantidade()));
      }
    }

    public void showCompras()
    {
      System.out.println("\tMeus pedidos: ");
      System.out.println("Nome do Livro\tQuantidade\tPreço do item");
      for(Compra compra : pedidos)
      {
        System.out.println(compra.getItem().getNome() + "\t" + compra.getQuantidade() + "\t" + (compra.getItem().getPreco() * compra.getQuantidade()));
      }
    }
    
    //Cliente remove livro do carrinho
    //Cliente cancela pedido

    protected boolean ValidaAcesso(String senha) //Valida o acesso a conta do cliente
    {
      if (this.senha == senha)
        return true;
      else
        return false;
    }
}
