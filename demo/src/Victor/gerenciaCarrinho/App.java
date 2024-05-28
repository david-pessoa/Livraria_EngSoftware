// fiz isso aqui porque tava dificil ver os colchetes no app original como meu caso é o 3
case 3: // 3) Acessar meu carrinho
{
    while (true)
    {
        c.clearScreen(); // Limpa a tela
        System.out.println("Carrinho de compras:");
        c.showCarrinho();
        System.out.println("\nOpções:");
        System.out.println("0) Voltar ao menu principal");
        System.out.println("1) Adicionar item ao carrinho");
        System.out.println("2) Remover item do carrinho");
        System.out.println("3) Finalizar compra");

        System.out.print("Escolha uma opção: ");
        int carrinhoChoice = s.nextInt();
        s.nextLine();

        if (carrinhoChoice == 0)
        {
            break; // Volta ao menu principal
        } 
        else if (carrinhoChoice == 1)
        {
            System.out.print("Digite o nome do livro que deseja adicionar: ");
            String livroAdicionar = s.nextLine();
            System.out.print("Digite a quantidade que deseja adicionar: ");
            int quantidadeAdicionar = s.nextInt();
            s.nextLine();
            if (c.buscaLivroNome(livroAdicionar) != null){
              c.addNoCarrinho(c.buscaLivroNome(livroAdicionar), quantidadeAdicionar);
            } else {
              System.out.println("Livro não encontrado");
            }
            
        } 
        else if (carrinhoChoice == 2)
        {
            System.out.print("Digite o nome do livro que deseja remover: ");
            String livroRemover = s.nextLine();
            if (c.buscaLivroNome(livroRemover) != null){
              c.removerDoCarrinho(livroRemover);
            } else {
              System.out.println("Livro não encontrado");
            }
        }
        else if (carrinhoChoice == 3)
        {
            c.realizaCompra();
            System.out.println("Compra finalizada com sucesso!");
            c.sleep();
            break; // Volta ao menu principal após finalizar a compra
        } 
        else
        {
            System.out.println("Opção inválida!");
        }
    }
    break;
}
