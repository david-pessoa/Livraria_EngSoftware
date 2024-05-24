public class Main {
  public static void main(String[] args) {
    Controller controller = new Controller();
    System.out.println("catalogo: ");
    controller.buscaTodosLivros();
    
    System.out.println("\n2\n");
    String[] carrinho = controller.verCarrinho();
    for (int i = 0; i < carrinho.length; i++){
      System.out.println(carrinho[i]);
    }
    System.out.println("\n3\n");
    controller.adicionarNoCarrinho(1,1);
    controller.adicionarNoCarrinho(2,1);
    carrinho = controller.verCarrinho();
    for (int i = 0; i < carrinho.length; i++){
      System.out.println(carrinho[i]);
    }
    System.out.println("\n4\n");
    controller.editarCarrinho(1,3);
    carrinho = controller.verCarrinho();
    for (int i = 0; i < carrinho.length; i++){
      System.out.println(carrinho[i]);
    }
    System.out.println("\n5\n");
    controller.removerDoCarrinho(2);
    carrinho = controller.verCarrinho();
    for (int i = 0; i < carrinho.length; i++){
      System.out.println(carrinho[i]);
    }
  }
}