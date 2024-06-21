package br.edu.up.projeto.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FuncionarioController {
    // método para adicionar jogos
    public static void adicionarJogo(Scanner scanner) {

        // reconhe informações do jogo
        System.out.println("Digite o nome do jogo: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o gênero do jogo: ");
        String genero = scanner.nextLine();

        System.out.println("Digite a classificação indicativa do jogo: ");
        String classificacao = scanner.nextLine();

        // gravar arquivos no txt
        try (FileWriter fw = new FileWriter("jogos.txt", true);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Nome: " + nome);
            pw.println("Gênero: " + genero);
            pw.println("Classificação: " + classificacao);
            pw.println();
            System.out.println("Jogo adicionado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar jogo no arquivo" + e.getMessage());
        }
    }

    // método para remover jogos
    public static void removerJogo(Scanner scanner) {

    }
}
