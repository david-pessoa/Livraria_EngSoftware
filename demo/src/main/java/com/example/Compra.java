package com.example;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Compra 
{
    private int id_compra; //número de identificação ID da compra
    private float valor_compra; //valor da compra
    private String data_compra; //data da compra
    private Livro item;
    private int quantidade;
    // quantidade de itens
    // valor de cada item
    // Cliente que comprou os livros
    //...

  //Cosntrutor
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
  
   private int geraID()
   {
      Random random = new Random();
      return random.nextInt(10000);
   }
  
    public float calculaTotalCompra()
    {
      return item.getPreco() * quantidade;
    }
}
