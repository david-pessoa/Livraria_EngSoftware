package com.example;
import java.util.LinkedList;
import java.util.Scanner;

public class App //App == Boundary
{
    public static void main( String[] args )
    {
        
      /*
      Menu:
      1) Cadastro de clientes
      2) Logar na conta do cliente
      3) Comprar livro do carrinho
      4) Cancelar pedido
      5) Realizar reserva
      6) Cliente gerencia carrinho
        6.1) Cliente adiciona itens ao carrinho
        6.2) Cliente remove itens do carrinho
        6.3) Cliente compra todos (ou alguns) livros do carrinho
      */
      Scanner s = new Scanner(System.in);
      Controller c = new Controller();
      boolean acesso_valido = false;
      String username = "", senha;

      while(acesso_valido == false)
      {
        System.out.println("\t\t Livraria.com\n");

        System.out.print("Insira seu nome de usuário: ");
        username = s.nextLine();

        System.out.print("Insira sua senha: ");
        senha = s.nextLine();
        acesso_valido = c.validaAcesso(username, senha);
        if(acesso_valido == false)
          System.out.println("\nNome de usuário ou senha incorretos!\n");
      }
      
      int choice;
      System.out.println("\nBem vindo, " + username + "!\n");
      c.setUpCatalogo();
      while(acesso_valido == true)
      {
        //Limpar a tela quando retornar ao menu
        System.out.println("Menu:");
        System.out.println("1) Buscar Livro no catálogo"); //3) Compra
        System.out.println("2) Visualizar todos os livros do catálogo"); //3) Compra
        System.out.println("3) Acessar meu carrinho");
        System.out.println("4) Acessar meus pedidos");
        System.out.println("5) Acessar reservas feitas");
        System.out.print("Escolha uma opção: ");
        choice = s.nextInt(); s.nextLine();

        switch (choice) 
        {
          case 1:
          { String fica_no_loop = "";
            while(true)
            {
              System.out.println("\nPara voltar ao menu pressione 0\n");
              System.out.print("\nDigite o nome do livro ou autor que deseja pesquisar: ");
              String nome = s.nextLine();
              System.out.println("Resultado da busca:");
              String resultado = c.buscaLivroNome(nome);
              if(nome.equals("0"))
              {
                break;
              }
              else if(resultado == null)
              {
                System.out.println("Não foi possível encontrar nenhum livro ou autor com este nome no catálogo");
                System.out.print("Aperte Enter para tentar pesquisar novamente ");
              }
              else
              {
                System.out.println(resultado + "\t" + "R$" + c.getPrecoLivro(resultado));
                System.out.print("\nDigite 2 para obter mais informações sobre ele ou 0 para retornar ao menu: ");
              }
              fica_no_loop = s.nextLine();

              if(fica_no_loop.equals("0"))
              {
                break;
              }
              else if(fica_no_loop.equals("2"))
              {
                c.MaisInfoLivro(resultado);
                //Colocar opção de comprar ...
              }
            }
            break;
          }
        
          default:
          {
            System.out.println("\nEscolha inválida!\n");
            break;
          }
        }

      }

      




    }
}
