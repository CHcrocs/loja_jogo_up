package br.edu.up.projeto.models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Funcionario {

    public static void menuFuncionario(Scanner scanner, String[] args) {
        int resposta;
        do {
            System.out.println("[1] - Adicionar Jogo");
            System.out.println("[2] - Remover jogo");
            System.out.println("[3] - Gerenciar contas");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();
            switch (resposta) {
                case 1:
                    // Chama método adicionarJogo
                    adicionarJogo(scanner);
                    break;
                case 2:
                    // Chama método removerJogo
                    removerJogo(scanner);
                    break;
                case 3:
                    // Chama método ou classe para gerenciar contas
                    System.out.println("Gerenciamento de contas - WIP...");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (resposta != 0); 

    }
    
    // método para adicionar jogos
    private static void adicionarJogo(Scanner scanner){
        
        // reconhe informações do jogo
        System.out.println("Digite o nome do jogo: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o gênero do jogo: ");
        String genero = scanner.nextLine();

        System.out.println("Digite a classificação indicativa do jogo: ");
        String classificacao = scanner.nextLine();

        // gravar arquivos no txt
        try(FileWriter fw = new FileWriter("jogos.txt" ,true);
        PrintWriter pw = new PrintWriter(fw)){
            pw.println("Nome: " + nome);
            pw.println("Gênero: " + genero);
            pw.println("Classificação: " + classificacao);
            pw.println(); 
            System.out.println("Jogo adicionado com sucesso!");
        }catch(IOException e){
            System.out.println("Erro ao salvar jogo no arquivo" + e.getMessage());
        }  
    }

    // método para remover jogos
    private static void removerJogo(Scanner scanner){

    }
}
