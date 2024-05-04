package com.example;
import java.io.*;
import java.util.LinkedList;

public class Controller {
    public static void main(String[] args) {
        LinkedList<Livro> listaLivros = new LinkedList<>();
        
        try {
            // Abrir o arquivo binário para leitura
            FileInputStream fileInput = new FileInputStream("/Users/davidpessoa/Documents/Faculdade/Engenharia de Software/Livraria_EngSoftware/demo/src/main/java/com/example/livros.bin");
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
            
            // Exibir os livros da lista
            for (Livro livro : listaLivros) {
                System.out.println("ID: " + livro.getId());
                System.out.println("Nome: " + livro.getNome());
                System.out.println("Preço: " + livro.getPreco());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Categoria: " + livro.getCategoria());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo binário: " + e.getMessage());
        }
    }
}

