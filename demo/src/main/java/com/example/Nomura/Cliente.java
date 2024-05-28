package com.example;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

public class Cliente//Classe para representar os clientes da loja
{
    private String nome; //Atributos
    private String CPF;
    private String email;
    private String senha;
    private LinkedList<ItemCarrinho> carrinho = new LinkedList<>(); //Carrinho do cliente
    private LinkedList<Compra> pedidos = new LinkedList<>(); //Lista de pedidos realizados pelo cliente
    private static final int TOTAL_CLIENTES = 2;

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
    public LinkedList<Compra> getPedidos() {return pedidos;}

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

    //opção de comprar um item do carrinho (testar)
    public void CompraItemDoCarrinho(int index)
    {
      index -= 1;
      if(index < 0)
      {
        System.out.println("Índice inválido!");
        return;
      }
      
      ItemCarrinho item = carrinho.get(index);
      carrinho.remove(index);
      realizaCompra(item.getItem(), item.getQuantidade());
    }

    //opção de comprar todos os itens do carrinho (testar)
    public void CompraCarrinho()
    {
      for(int i = 0; i < carrinho.size(); i++)
      {
        ItemCarrinho item = carrinho.get(i);
        realizaCompra(item.getItem(), item.getQuantidade());
      }
      carrinho.clear();
    }

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
        int i = 1;
        for(ItemCarrinho item : this.carrinho)
        {
          String preco = String.format("%.2f", item.calculaTotalItem());
          System.out.println(i + ") " + item.getItem().getNome() + "\t" + item.getQuantidade() + "\t" + preco);
          i++;
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
        int i = 1;
        for(Compra compra : this.pedidos)
        {
          String preco = String.format("%.2f", compra.calculaTotalCompra());
          System.out.println(i + ") " + compra.getItem().getNome() + "\t" + compra.getQuantidade() + "\t" + preco + "\t" + compra.getData_compra());
          i++;
        }
      }
    }
    
   public void removeDoCarrinho(int index) //remove livro do carrinho do cliente pelo indice
   {
      index -= 1;
      carrinho.remove(index);
   }
   
    public void cancelaPedido(int indice)//Cliente cancela pedido
    {
      if (indice < 0 || indice >= pedidos.size()){
        System.out.println("Indice inválido");
        return;
      }
      String[] dataAtual = LocalDate.now().toString().split("-");
      int somaDataAtual = (Integer.parseInt(dataAtual[0])) * 365 + (Integer.parseInt(dataAtual[1]))
      * 30 + Integer.parseInt(dataAtual[2]);

      Compra pedido = pedidos.get(indice);

      String[] dataPedido = pedido.getData_compra().split("-");
      int somaDataPedido = (Integer.parseInt(dataPedido[0])) * 365 + (Integer.parseInt(dataPedido[1]))
      * 30 + Integer.parseInt(dataPedido[2]);
      // Verifica se o pedido foi feita a mais de uma semana, se sim não é possível cancelá-lo
      
      if (somaDataAtual - somaDataPedido > 7){
        System.out.println("Desculpe, não foi possível cancelar o pedido porque foi efetuado a mais de uma semana");
        return;
      }
      pedidos.remove(indice);
      System.out.println("Pedido foi cancelado com sucesso");
      System.out.println("Valor de" + pedido.getValor_compra() + "reembolsado");
    }


    public boolean ValidaAcesso(String nome, String senha) //Valida o acesso a conta do cliente
    {
      if (getNome().equals(nome) && getSenha().equals(senha))
        return true;
      else
        return false;
    }

  //------------------------------------------------- SetUpCadastro() (Lê arquivo binário) -------------------------------------------------------------
    public Cliente[] setUpCadastro(boolean NaoEhTeste) //Extrai informações dos livros contidas no arquivo binário livros.bin
    {   
        try {
            Cliente[] lista_clientes = new Cliente[TOTAL_CLIENTES]; //Cria vetor de clientes
            int num_clientes = 0;
            // Abrir o arquivo binário para leitura
            String caminho;
            if(NaoEhTeste)
              caminho = "./demo/src/main/java/com/example/usuarios.bin"; //Caminho para execução normal do programa
            else
              caminho = "../demo/src/main/java/com/example/usuarios.bin"; //Caminho para execução de testes do programa

            FileInputStream fileInput = new FileInputStream(caminho); //OBS: Mude o caminho se necessário
            DataInputStream dataInput = new DataInputStream(fileInput);
            
            // Ler os dados do arquivo binário e criar objetos Livro
            while (dataInput.available() > 0) {
                dataInput.readUTF();
                String Nome = dataInput.readUTF();

                dataInput.readUTF();
                String CPF = dataInput.readUTF();

                dataInput.readUTF();
                String email = dataInput.readUTF();

                dataInput.readUTF();
                String senha = dataInput.readUTF();
                //Lê disponibilidade
                
                // Criar objeto Livro e adicionar à linked list
                Cliente cliente = new Cliente(Nome, CPF, email, senha);
                lista_clientes[num_clientes] = cliente;
                num_clientes++;
                
            }
            
            // Fechar o fluxo de entrada
            dataInput.close();
            fileInput.close();
            return lista_clientes;
        } 
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao ler o arquivo binário usuarios.bin: " + e.getMessage());
            return null;
        }
    }

}
