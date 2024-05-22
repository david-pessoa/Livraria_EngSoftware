package com.example;
import java.io.*;
import java.util.LinkedList;

public class Controller 
{
    //------------------------------------------------- Atributos -------------------------------------------------------------
    private Cliente cliente_logado;
    private Catalogo catalogo;
    private Cliente[] lista_clientes;
    private static final int MAX_CLIENTES = 100;
    private int num_clientes;

    //------------------------------------------------- Construtor -------------------------------------------------------------

    public Controller() //Construtor inicia o vetor de clientes (talvez isso seja armazenado no arquivo .bin)
    {
        this.lista_clientes = new Cliente[MAX_CLIENTES];
        this.num_clientes = 0;
    }

    //------------------------------------------------- SetUps (Lê arquivos binário) -------------------------------------------------------------

    public void setUpCadastro() //Extrai informações dos livros contidas no arquivo binário livros.bin
    {   
        try {
            // Abrir o arquivo binário para leitura
            FileInputStream fileInput = new FileInputStream("./demo/src/main/java/com/example/usuarios.bin"); //OBS: Mude o caminho se necessário
            DataInputStream dataInput = new DataInputStream(fileInput);
            
            // Ler os dados do arquivo binário e criar objetos Livro
            while (dataInput.available() > 0) {
                dataInput.readUTF();
                String Nome = dataInput.readUTF();

                dataInput.readUTF();
                String CPF = dataInput.readUTF();

                dataInput.readUTF();
                String email = dataInput.readUTF();

                dataInput.readUTF();
                String senha = dataInput.readUTF();
                //Lê disponibilidade
                System.out.println(Nome + ", "+ CPF + ", "+ email + ", "+ senha);
                
                // Criar objeto Livro e adicionar à linked list
                Cliente cliente = new Cliente(Nome, CPF, email, senha);
                this.lista_clientes[this.num_clientes] = cliente;
                this.num_clientes++;
                
            }
            
            // Fechar o fluxo de entrada
            dataInput.close();
            fileInput.close();

        } 
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao ler o arquivo binário usuarios.bin: " + e.getMessage());
        }
    }
    

    public void setUpCatalogo() //Extrai informações dos livros contidas no arquivo binário livros.bin
    {
        LinkedList<Livro> listaLivros = new LinkedList<>();
        
        try {
            // Abrir o arquivo binário para leitura
            FileInputStream fileInput = new FileInputStream("./demo/src/main/java/com/example/livros.bin"); //OBS: Mude o caminho se necessário
            DataInputStream dataInput = new DataInputStream(fileInput);
            
            // Ler os dados do arquivo binário e criar objetos Livro
            while (dataInput.available() > 0) {
                String titulo = dataInput.readUTF();
                float preco = dataInput.readFloat();
                String autor = dataInput.readUTF();
                String categoria = dataInput.readUTF();
                //Lê disponibilidade
                
                // Criar objeto Livro e adicionar à linked list
                Livro livro = new Livro(titulo, preco, autor, categoria);
                listaLivros.add(livro);
            }
            
            // Fechar o fluxo de entrada
            dataInput.close();
            fileInput.close();
            
            this.catalogo = new Catalogo(listaLivros);
        } 
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao ler o arquivo binário livros.bin: " + e.getMessage());
        }
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
            System.out.println("Disponibilidade: " + livro.getDisponibilidade());
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


}

