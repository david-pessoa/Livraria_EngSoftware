package com.example;
import java.io.*;
import java.util.LinkedList;

public class Controller 
{
    private Cliente cliente_logado;
    private Catalogo catalogo;
    private Cliente[] lista_clientes;
    private static final int MAX_CLIENTES = 100;

    public Controller() //Construtor inicia o vetor de clientes (talvez isso seja armazenado no arquivo .bin)
    {
        this.lista_clientes = new Cliente[MAX_CLIENTES];
        this.lista_clientes[0] = new Cliente("João", "9999999", "exemplo@gmail.com", "senha");
        this.lista_clientes[1] = new Cliente("Zé", "777777777", "zezinho@gmail.com", "pandas");
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
            System.out.println("Ocorreu um erro ao ler o arquivo binário: " + e.getMessage());
        }
    }

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

    public void showCatalogo()
    {
        catalogo.showCatalogo();
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

    public void CompraItemDoCarrinho(int index)
    {
        cliente_logado.CompraItemDoCarrinho(index);
    }

    public void CompraCarrinho()
    {
        cliente_logado.CompraCarrinho();
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

    public float getPrecoLivro(String nome)
    {
        return catalogo.buscaLivroNome(nome).getPreco();
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

    public void sleep()
    {
        try 
                    {
                      Thread.sleep(1500);
                    } catch(InterruptedException e) 
                    {
                      System.out.println("Erro!");
                    }
    }


}

