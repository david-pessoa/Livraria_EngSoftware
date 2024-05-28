package com.example;
import java.util.Scanner;

public class App //App == Boundary
{
    public static void main( String[] args )
    {
      Scanner s = new Scanner(System.in);
      Controller c = new Controller(true); //Inicia controller
      boolean acesso_valido = false; //Controla o acesso
      String username = "", senha;
      

      while(!acesso_valido)
      {
        System.out.println("\n\t\t Livraria.com\n");

        System.out.print("Insira seu nome de usuário: "); //Login de nome de usuário e senha
        username = s.nextLine();

        System.out.print("Insira sua senha: ");
        senha = s.nextLine();
        acesso_valido = c.validaAcesso(username, senha);
        if(!acesso_valido)
          System.out.println("\nNome de usuário ou senha incorretos!\n");
      }
      
      int choice; //Escolha do menu
      System.out.println("\nBem vindo, " + username + "!\n");

      while(acesso_valido == true)
      {
        c.clearScreen(); //Limpar a tela quando retornar ao menu

        System.out.println("Menu:"); //Menu principal:
        System.out.println("1) Buscar Livro no catálogo");
        System.out.println("2) Visualizar todos os livros do catálogo");
        System.out.println("3) Acessar meu carrinho");
        System.out.println("4) Acessar meus pedidos");
        System.out.println("5) Acessar reservas feitas");
        
        System.out.println("6) Sair");

        System.out.print("Escolha uma opção: ");
        choice = s.nextInt(); s.nextLine();

        switch (choice) 
        {
          case 1: // 1) Buscar Livro no catálogo
        { String fica_no_loop = "";//String que guarda resposta se o usuário quer permanecer na tela de busca de livro (ou não)

            while(true) //Mantém o usuário na tela de busca de livro
            { 
              c.clearScreen(); //Limpa a tela
              System.out.println("\nPara voltar ao menu pressione 0\n");
              System.out.print("\nDigite o nome do livro ou autor que deseja pesquisar: ");
              String nome = s.nextLine();
              System.out.println("Resultado da busca:");
              String resultado = c.buscaLivroNome(nome); //resultado = Nome do livro como está escrito no catálogo

              if(nome.equals("0"))
              {
                break; //Retorna ao menu
              }
              else if(resultado == null) //Não encontrou o livro
              {
                System.out.println("Não foi possível encontrar nenhum livro ou autor com este nome no catálogo");
                System.out.print("Aperte Enter para tentar pesquisar novamente ");
              }
              else //Encontrou um livro
              {
                System.out.printf(resultado + "\t" + "R$%.2f %n", c.getPrecoLivro(resultado));
                System.out.print("\nDigite 2 para obter mais informações sobre ele ou 0 para retornar ao menu: ");
              }

              fica_no_loop = s.nextLine();

              if(fica_no_loop.equals("0"))
              {
                break; //Retorna ao Menu principal
              }
              else if(fica_no_loop.equals("2")) //Obter mais informações sobre o livro
              {
                c.MaisInfoLivro(resultado);
                System.out.println("Para adicionar o livro ao carrinho, aperte 3"); 
                while (true) // Entra na tela de exibição do livro
                {
                  if(c.getDisponibilidadeLivro(resultado)) //Verifica disponibilidade do livro
                  {
                    System.out.println("Para comprar o livro, aperte 2");
                    int escolhe_add = s.nextInt(); s.nextLine(); //Cliente escolhe se deseja comprar livro ou adicionar ao carrinho

                    if(escolhe_add == 2) //Compra o livro
                    {
                      System.out.print("Digite a quantidade que deseja adicionar: ");
                      int num_livros = s.nextInt(); s.nextLine();
                      c.realizaCompra(resultado, num_livros);
                      c.sleep();
                      break;
                    }
                    else if(escolhe_add == 3) //Adiciona ao carrinho
                    {
                      System.out.print("Digite a quantidade que deseja adicionar: ");
                      int num_livros = s.nextInt(); s.nextLine();
                      c.addNoCarrinho(resultado, num_livros);
                      c.sleep();
                      break;
                    }

                    else if(escolhe_add == 0) //Volta ao menu principal
                    {
                      break;
                    }
                    else
                    {
                      System.out.println("Opção inváilida!");
                    }
                  }
                  else //Caso o livro esteja indisponível, poderá ser feita a reserva
                  {
                    System.out.println("Livro indisponível. Para reservá-lo, digite 5");
                    
                    int entrada = s.nextInt();s.nextLine();
                    if (entrada ==5 ){
                      System.out.print("Digite a quantidade que deseja reservar: ");
                      int quatidadeReserva = s.nextInt();s.nextLine();
                      //metodo  de reserva realizar reserva junto do controler
                      int quantidadeReserva = s.nextInt();
                      s.nextLine();
                      c.reservarLivro(resultado, quantidadeReserva); // Chama o método de reserva no controller
                    }
                    c.sleep();
                    break;
                  }
                }       
              }
            }
            break;
          }
          
          case 2: //2) Visualizar todos os livros do catálogo
          {
            c.showCatalogo();
            System.out.println("\nAperte Enter para voltar ao Menu");
            s.nextLine();
            break;
          }

          case 5: // 5) Acessar reservas feitas
                {
                    c.showReservas();
                    System.out.println("\nAperte Enter para voltar ao Menu");
                    s.nextLine();
                    break;
                }


          case 6: // 6) Sair
          {
            System.exit(0);
          }

          default:
          {
            System.out.println("\nEscolha inválida!\n");
            break;
          }
        }

      }

      



      s.close();
    }
}
