package com.example;

public class Compra 
{
    private int id_compra;
    private float valor_compra;
    private int data_compra;
  
   public Compra(int id_compra, float valor_compra, int data_compra){
     this.id_compra = id_compra;
     this.valor_compra = valor_compra;
     this.data_compra = data_compra;
   } 
  
    public void setDataCompra(int data_compra){
      this.data_compra = data_compra;
    }
  
    public float calculaTotalCompra(){
      return valor_compra;
    }
}
