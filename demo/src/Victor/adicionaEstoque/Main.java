import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();
    // ver se coloca uma fornecedora aqui ou no controller
    controller.adicionaFornecedora("Fornecedora 3", "456789123", "ghi@mail.com", "senha", new Produtos[] {
        new Produtos(new Livro(4, "Livro 4", 40.0f, "Autor 4", "Categoria 1"), 15),
        new Produtos(new Livro(5, "Livro 5", 50.0f, "Autor 5", "Categoria 2"), 12),
        new Produtos(new Livro(6, "Livro 6", 60.0f, "Autor 1", "Categoria 3"), 8),
        new Produtos(new Livro(7, "Livro 7", 100.0f, "Autor 2", "Categoria 3"), 20),
        new Produtos(new Livro(8, "Livro 8", 10.0f, "Autor 5", "Categoria 4"), 9) }, "987.654.123-00");

  // começo da boundary
  boolean flag_login = false;
  while(true)
  {
    String nome = "", senha = "";
    System.out.println("1. Entrar como Fornecedor\n2. listar Estoque\n3. Adicionar no Estoque\n4. Sair");
    System.out.print("escolha: ");
    int input = scanner.nextInt();
    scanner.nextLine();
    if (input == 1) {
      while (!nome.equals("EXIT") && !senha.equals("EXIT")) {
        System.out.print("nome: ");
        nome = scanner.nextLine();
        System.out.print("senha: ");
        senha = scanner.nextLine();
        System.out.println(controller.validaAcesso(nome, senha));
        if (controller.validaAcesso(nome, senha)) {
          flag_login = true;
          break;
        }
      }
    }
    if (input == 2) {
      if (flag_login) {
        System.out.println(controller.listaEstoque());
      } else {
        System.out.println("Você não está logado");
      }
    }
    if (input == 3) {
      if (flag_login) {
        System.out.println("1.adicionar novo produto\n2.adicionar produto existente");
        System.out.print("escolha: ");
        int input2 = scanner.nextInt();
        scanner.nextLine();
        if (input2 == 1) {
          int id = (int) Math.random() * 1000; // id do livro (talvez seja necessário um gerador de id correto)
          System.out.print("nome: ");
          String nome_livro = scanner.nextLine();
          System.out.print("preco: ");
          float preco = scanner.nextFloat();
          scanner.nextLine();
          System.out.print("autor: ");
          String autor = scanner.nextLine();
          System.out.print("categoria: ");
          String categoria = scanner.nextLine();
          System.out.print("quantidade: ");
          int quant = scanner.nextInt();
          scanner.nextLine();
          System.out.print("data de envio: ");
          String data_envio = scanner.nextLine();
          System.out.print("data de recebimento: ");
          String data_recebimento = scanner.nextLine();
          if (controller.addNoEstoque(id, nome_livro, preco, autor, categoria, quant, data_envio, data_recebimento)) {
            System.out
                .println("\nmudança de estoque realizada com sucesso!\ncomprovante de compra foi enviada pelo email\n\n");
          } else {
            System.out.println("\nnão foi possivel adicionar o produto\n\n");
          }

        } else if (input2 == 2) {
          System.out.print("nome: ");
          String nome_livro = scanner.nextLine();
          System.out.print("quantidade: ");
          int quant = scanner.nextInt();
          scanner.nextLine();
          System.out.print("data de envio: ");
          String data_envio = scanner.nextLine();
          System.out.print("data de recebimento: ");
          String data_recebimento = scanner.nextLine();
          if (controller.addNoEstoque(nome_livro, quant, data_envio, data_recebimento)) {
            System.out
                .println("\nmudança de estoque realizada com sucesso!\ncomprovante de compra foi enviada pelo email\n\n");
          } else {
            System.out.println("\nnão foi possivel adicionar o produto\n\n");
          }
        }
      } else {
        System.out.println("Você não está logado");
      }
    }
    if (input == 4) {
      break;
    }
  }
}}