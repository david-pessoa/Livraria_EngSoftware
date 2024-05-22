package com.example;
import java.util.LinkedList;
import java.util.Scanner;

public class App //App == Boundary
{
    public static void main( String[] args )
    {
      Scanner s = new Scanner(System.in);
      Controller c = new Controller();
      boolean acesso_valido = false;
      String username = "", senha;

      while(acesso_valido == false)
      {
        System.out.println("\t\t Livraria.com\n");

        System.out.print("Insira seu nome de usuário: "); //Login de nome de usuário e senha
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
        c.clearScreen(); //Limpar a tela quando retornar ao menu

        System.out.println("Menu:");
        System.out.println("1) Buscar Livro no catálogo");
        System.out.println("2) Visualizar todos os livros do catálogo");
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
            { c.clearScreen(); //Limpa a tela
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
                System.out.printf(resultado + "\t" + "R$%.2f %n", c.getPrecoLivro(resultado));
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
                System.out.println("Para adicionar o livro ao carrinho, aperte 3");
                if(c.getDisponibilidadeLivro(resultado))
                {
                  System.out.println("Para comprar o livro, aperte 2");
                  int escolhe_add = s.nextInt(); s.nextLine();

                  System.out.print("Digite a quantidade que deseja adicionar: ");
                  int num_livros = s.nextInt(); s.nextLine();
                  if(escolhe_add == 2)
                  {
                    c.realizaCompra(resultado, num_livros);
                    c.sleep();
                    break;
                  }
                  else if(escolhe_add == 3)
                  {
                    c.addNoCarrinho(resultado, num_livros);
                    c.sleep();
                    break;
                  }
                }
                else
                {
                  System.out.println("Livro indisponível. Para reservá-lo, digite 5");
                  System.out.print("Digite a quantidade que deseja adicionar: ");
                  int num_livros = s.nextInt(); s.nextLine();
                  // Adiciona na reserva...
                  c.sleep();
                  break;
                }       
              }
            }
            break;
          }
          
          case 2:
          {
            c.showCatalogo();
            System.out.println("\nAperte Enter para voltar ao Menu");
            s.nextLine();
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
