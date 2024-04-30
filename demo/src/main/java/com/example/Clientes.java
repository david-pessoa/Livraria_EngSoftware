package com.example;

public class Clientes 
{
    private Cliente[] clientes;
    private int num_clientes;
  
    public Clientes(Cliente[] clientes)
    {
      this.clientes = clientes;
      this.num_clientes = clientes.length;
    }
  
    public Clientes()
    {
      this(null);
    }
  
  
    public String buscaCliente(String username)
    {
      for(int i = 0; i < num_clientes; i++)
      {
        if (clientes[i].nome == username)
        {
          return clientes[i].nome; //Ver se dá certo com protected
        }
      }
      return "";
    }
    
     public boolean ValidaAcesso(String username, String senha)
    {
      for(int i = 0; i < num_clientes; i++)
      {
        if (clientes[i].nome == username)
        {
          return clientes[i].ValidaAcesso(senha);
        }
      }
      return false;
    }
}
