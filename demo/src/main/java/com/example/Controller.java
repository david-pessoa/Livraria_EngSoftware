package com.example;
import java.io.*;
import java.util.LinkedList;

public class Controller 
{
    private Cliente cliente_logado;
    private Catalogo catalogo;
    private Cliente[] lista_clientes;

    public Controller()
    {
        lista_clientes[0] = new Cliente("João", "9999999", "exemplo@gmail.com", "senha");
        lista_clientes[1] = new Cliente("Zé", "777777777", "zezinho@gmail.com", "pandas");
    }
    

    public Catalogo setUpCatalogo() //Extrai informações dos livros contidas no arquivo binário livros.bin
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
                
                // Criar objeto Livro e adicionar à linked list
                Livro livro = new Livro(titulo, preco, autor, categoria);
                listaLivros.add(livro);
            }
            
            // Fechar o fluxo de entrada
            dataInput.close();
            fileInput.close();
            
            Catalogo catalogo = new Catalogo(listaLivros);
            return catalogo;
        } 
        catch (IOException e) 
        {
            System.out.println("Ocorreu um erro ao ler o arquivo binário: " + e.getMessage());
            return null;
        }
    }

    public boolean validaAcesso(String nome, String senha) //testar
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

    public void showCarrinho() //testar
    {
        cliente_logado.showCarrinho();
    }

    public void addNoCarrinho(String livro_str, int qtde) //testar
    {
        Livro livro = catalogo.buscaLivroNome(livro_str);
        cliente_logado.addNoCarrinho(livro, qtde);
    }

    public void removeDoCarrinho(String livro_str) //testar
    {
        Livro livro = catalogo.buscaLivroNome(livro_str);
        cliente_logado.removeDoCarrinho(livro);
    }




}

