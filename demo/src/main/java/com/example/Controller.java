package com.example;

public class Controller 
{
    //------------------------------------------------- Atributos -------------------------------------------------------------
    private Cliente cliente_logado;
    private Catalogo catalogo;
    private Cliente[] lista_clientes;

    //------------------------------------------------- Construtor -------------------------------------------------------------

    public Controller(boolean NaoEhTeste) //Construtor popula a lista de clientes e o catálogo
    {  
        this.catalogo = new Catalogo(NaoEhTeste); //NaoEhTeste informa se o objeto controller está sendo executado no App.java ou nos testes
        this.cliente_logado = new Cliente();
        this.lista_clientes = cliente_logado.setUpCadastro(NaoEhTeste);
        if(!NaoEhTeste)
            this.cliente_logado = lista_clientes[0];
    }

    //------------------------------------------------- Métodos relativos a classe Cliente -------------------------------------------------------------

    public boolean validaAcesso(String nome, String senha) //Valida o Acesso
    {
        for (int i = 0; i < lista_clientes.length; i++)
        {
            if(lista_clientes[i].ValidaAcesso(nome, senha))
            {
                cliente_logado = lista_clientes[i];
                return true;
            }          
        }
        return false;
    }

    public void showCarrinho() //Mostra o carrinho do cliente
    {
        cliente_logado.showCarrinho();
    }

    public void showCompras() //Mostra os pedidos do cliente
    {
        cliente_logado.showCompras();
    }

    public void addNoCarrinho(String livro_str, int qtde) //Adiciona um livro no carrinho pelo nome
    {
        if (qtde <= 0) 
        {
            System.out.println("Valor para quantidade de livros inválido!");
        }
        else
        {
            Livro livro = catalogo.buscaLivroNome(livro_str); //busca o livro no catálogo
            if(livro != null)
            {
                cliente_logado.addNoCarrinho(livro, qtde);
                System.out.println("Livro adicionado com sucesso!");
            }
        }
    }

    public void removeDoCarrinho(int index) //remove um livro do carrinho pelo índice na lista do carrinho
    {
        if (index <= 0) 
            System.out.println("Índice inválido!");
        else
            cliente_logado.removeDoCarrinho(index);
    }

    public void CompraItemDoCarrinho(int index)
    {
        cliente_logado.CompraItemDoCarrinho(index);
    }

    public void CompraCarrinho()
    {
        cliente_logado.CompraCarrinho();
    }

    public void realizaCompra(String livro_str, int qtde)
    {
        Livro livro = catalogo.buscaLivroNome(livro_str); //busca o livro no catálogo
        if(livro != null)
        {
            cliente_logado.realizaCompra(livro, qtde);
            System.out.println("Compra realizada com sucesso!");
        }
        
    }

    //------------------------------------------------- Métodos relativos a classe Livro e Catálogo -------------------------------------------------------------

    public void MaisInfoLivro(String livro_str) 
    {
        Livro livro = catalogo.buscaLivroNome(livro_str);
        if(livro != null)
        {
            System.out.println("Mais informações sobre o livro: ");
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Autor " + livro.getAutor());
            System.out.println("Categoria: " + livro.getCategoria());
            System.out.printf("Preço: R$%.2f %n", livro.getPreco());
            if(livro.getDisponibilidade())
                System.out.println("Disponibilidade: Disponível");
            else
            System.out.println("Disponibilidade: Indisponível");
        }
    }

    public String buscaLivroNome(String nome)
    {
        Livro livro1 = catalogo.buscaLivroNome(nome);
        if(livro1 == null)
            return null;
        else
            return livro1.getNome();
    }

    public String buscaLivroAutor(String nome)
    {   
        Livro livro1 = catalogo.buscaLivroAutor(nome);
        if(livro1 == null)
            return null;
        else
            return livro1.getNome();
    }

    public boolean getDisponibilidadeLivro(String livro_str)
    {
        Livro livro = catalogo.buscaLivroNome(livro_str);
        if(livro != null)
        {
            return livro.getDisponibilidade();
        }
        else
            return false;
    }

    public void showCatalogo()
    {
        catalogo.showCatalogo();
    }

    public float getPrecoLivro(String nome)
    {
        return catalogo.buscaLivroNome(nome).getPreco();
    }

    // Método para realizar uma reserva
    public void reservarLivro(String livro_str, int qtde) {
        if (qtde <= 0) {
            System.out.println("Valor para quantidade de livros inválido!");
        } else {
            Livro livro = catalogo.buscaLivroNome(livro_str); // busca o livro no catálogo
            if (livro != null) {
                cliente_logado.reservarLivro(livro, qtde);
                System.out.println("Livro reservado com sucesso!");
            }
        }
    }

    // Método para exibir reservas feitas pelo cliente
    public void showReservas() {
        cliente_logado.showReservas();
    }

    public void cancelaPedido(int index)
    {
        cliente_logado.cancelaPedido(index);
    }

    //------------------------------------------------- Outros métodos -------------------------------------------------------------

    public void sleep() //Dorme por 1,5s
    {
        try 
                    {
                      Thread.sleep(1500);
                    } catch(InterruptedException e) 
                    {
                      System.out.println("Erro!");
                    }
    }

    public void clearScreen() {System.out.print("\033[H\033[2J");} //Limpar a tela quando retornar ao menu

    public Cliente getCliente_logado() {return cliente_logado;}
    public Cliente[] getLista_clientes() {return lista_clientes;}
    public Catalogo getCatalogo() {return catalogo;}
}

