package com.example;

public class Cliente//Classe para representar os clientes da loja
{
    protected String nome; //Atributos
    private String CPF;
    private String email;
    private String senha;
    private Livro[] carrinho;
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
    public Livro[] getCarrinho(){return carrinho;}

    //Setters
    public void setNome(String nome){this.nome = nome;}
    public void setCPF(String CPF){this.CPF = CPF;}
    public void setEmail(String email){this.email = email;}
    public void setSenha(String senha){this.senha = senha;}
    
    //Cliente add livro do carrinho
    //Cliente remove livro do carrinho
    //Cliente compra livro

    protected boolean ValidaAcesso(String senha) //Valida o acesso a conta do cliente
    {
      if (this.senha == senha)
        return true;
      else
        return false;
    }
}
