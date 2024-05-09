import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Controller controller = new Controller();
    String[] catalogo = controller.buscaTodosLivros();
    for (int i = 0; i < catalogo.length; i++){
      System.out.println(catalogo[i]+"\n");
    }
    System.out.println("\n2\n");
    String[] carrinho = controller.verCarrinho();
    for (int i = 0; i < carrinho.length; i++){
      System.out.println(carrinho[i]);
    }
    System.out.println("\n3\n");
    controller.adicionarNoCarrinho("Livro 2");
    carrinho = controller.verCarrinho();
    for (int i = 0; i < carrinho.length; i++){
      System.out.println(carrinho[i]);
    }
    System.out.println("\n4\n");
    controller.removerDoCarrinho("Livro 1");
    carrinho = controller.verCarrinho();
    for (int i = 0; i < carrinho.length; i++){
      System.out.println(carrinho[i]);
    }
  }
}