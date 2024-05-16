package com.example;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Compra //Classe que representa um pedido feito pelo cliente
{
    private int id_compra; //número de identificação ID da compra
    private float valor_compra; //valor da compra
    private String data_compra; //data da compra
    private Livro item; //Item da compra
    private int quantidade; //Quantidade de livros pedidos

  //Construtor
   public Compra(Livro item, int quantidade)
   {
     this.id_compra = geraID();
     this.item = item;
     this.quantidade = quantidade;
     this.data_compra = LocalDate.now().toString();
     this.valor_compra = calculaTotalCompra();
   }

   public int getId_compra() {return id_compra;}
   public String getData_compra() {return data_compra;}
   public Livro getItem() {return item;}
   public int getQuantidade() {return quantidade;}
   public float getValor_compra() {return valor_compra;}
  
   private int geraID() //Cria um ID aleatório para o pedido
   {
      Random random = new Random();
      return random.nextInt(10000);
   }
  
    public float calculaTotalCompra() //calcula o valor total da compra 
    {
      return item.getPreco() * quantidade;
    }
}
