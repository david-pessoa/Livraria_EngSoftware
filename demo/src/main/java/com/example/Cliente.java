package com.example;

public class Cliente extends Clientes
{
    protected String nome;
    private String CPF;
    private String email;
    private String senha;
    private String[] carrinho;
    private boolean valida_login;

    public Cliente()
    {
      this("","","","", new String[]{""});
    }

    public Cliente(String nome, String CPF, String email, String senha, String[] carrinho)
    {
      this.nome = nome;
      this.CPF = CPF;
      this.email = email;
      this.senha = senha;
      this.carrinho = carrinho;
    }

    public String getNome()
    {
      return nome;
    }

    public String getCPF(){return CPF;}
    public String getEmail(){return email;}
    public String getSenha(){return senha;}
    public String[] getCarrinho(){return carrinho;}

    protected boolean ValidaAcesso(String senha) //Ver se funciona com protected
    {
      if (this.senha == senha)
        return true;
      else
        return false;
    }
}
