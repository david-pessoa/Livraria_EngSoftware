package com.example;

import java.time.LocalDate;
import java.util.Date;

public class Compra 
{
    private int id_compra; //número de identificação ID da compra
    private float valor_compra; //valor da compra
    private String data_compra; //data da compra
    // itens da compra
    // quantidade de itens
    // valor de cada item
    // Cliente que comprou os livros
    //...

  //Cosntrutor com parâmetros
   public Compra(int id_compra, float valor_compra){
     this.id_compra = id_compra;
     this.valor_compra = valor_compra;
     this.data_compra = LocalDate.now().toString();
   } 
  
    public float calculaTotalCompra(){
      return valor_compra;
    }
}
