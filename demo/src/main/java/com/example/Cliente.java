package com.example;

import java.util.LinkedList;

public class Cliente//Classe para representar os clientes da loja
{
    protected String nome; //Atributos
    private String CPF;
    private String email;
    private String senha;
    private LinkedList<ItemCarrinho> carrinho = new LinkedList<>(); //Carrinho do cliente
    private LinkedList<Compra> pedidos = new LinkedList<>(); //Lista de pedidos realizados pelo cliente

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

    //Setters
    public void setNome(String nome){this.nome = nome;}
    public void setCPF(String CPF){this.CPF = CPF;}
    public void setEmail(String email){this.email = email;}
    public void setSenha(String senha){this.senha = senha;}

    //Método para realizar a compra de um livro do catálogo e adicionar à lista de pedidos do cliente
    public void realizaCompra(Livro livro, int qtde)
    {
      Compra compra = new Compra(livro, qtde);
      pedidos.addFirst(compra);
    }

    //Método para adicionar um livro ao carrinho do cliente
    public void addNoCarrinho(Livro livro, int qtde)
    {
      ItemCarrinho new_item = new ItemCarrinho(livro, qtde);
      carrinho.addFirst(new_item);
    }

    //Adicionar opção de comprar um item do carrinho
    //Adicionar opção de comprar todos os itens do carrinho

    public void showCarrinho() //Exibe o carrinho do cliente
    {
      if(this.carrinho.size() == 0 || this.carrinho == null)
      {
        System.out.println("Seu carrinho está vazio.");
      }
      else
      {
        System.out.println("\tLivros no meu carrinho: ");
        System.out.println("Nome do Livro" + "\t" + "Quantidade" + "\t" + "Preço do item");
        for(ItemCarrinho item : this.carrinho)
        {
          System.out.println(item.getItem().getNome() + "\t" + item.getQuantidade() + "\t" + item.calculaTotalItem());
        }
      }
    }

    public void showCompras() //Exibe lista de pedidos feitos pelo cliente
    {
      if(this.pedidos.size() == 0 || this.pedidos == null)
      {
        System.out.println("Não há nenhum pedido feito ainda.");
      }
      else
      {
        System.out.println("\tMeus pedidos: ");
        System.out.println("Nome do Livro\tQuantidade\tPreço do item\tData da compra");
        for(Compra compra : this.pedidos)
        {
          System.out.println(compra.getItem().getNome() + "\t" + compra.getQuantidade() + "\t" + compra.calculaTotalCompra() + "\t" + compra.getData_compra());
        }
      }
    }
    
    //Cliente remove livro do carrinho
    //Cliente cancela pedido

    public boolean ValidaAcesso(String nome, String senha) //Valida o acesso a conta do cliente
    {
      if (getNome().equals(nome) && getSenha().equals(senha))
        return true;
      else
        return false;
    }
}
