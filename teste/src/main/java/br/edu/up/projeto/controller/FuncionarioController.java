package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

        System.out.println("Digite se o jogo é online (true/false): ");
        Boolean online = scanner.nextBoolean();

        System.out.println("Digite o preço do jogo: ");
        Double preco = scanner.nextDouble();

        // gravar arquivos no txt
        try (FileWriter fw = new FileWriter("jogos.txt", true);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Nome: " + nome);
            pw.println("Gênero: " + genero);
            pw.println("Classificação: " + classificacao);
            pw.println("Online: " + online);
            pw.println("Preço: " + preco);
            pw.println("; ");
            System.out.println("Jogo adicionado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar jogo no arquivo" + e.getMessage());
        }
    }

   // Método para remover jogos
    public static void removerJogo(Scanner scanner) {
        String arquivo = "jogos.txt";
        List<String> jogos = new ArrayList<>();

        // Ler o arquivo e armazenar o conteúdo em uma lista
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                jogos.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reconhe informações do jogo
        System.out.println("Digite o nome do jogo que deseja remover: ");
        String busca = scanner.nextLine();

        // Remover o jogo da lista
        boolean jogoRemovido = false;
        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).contains("Nome: " + busca)) {
                // Remover as linhas correspondentes ao jogo
                for (int j = 0; j < 4; j++) { // Supondo que cada jogo tem 4 linhas (Nome, Gênero, Classificação e ; )
                    jogos.remove(i);
                }
                jogoRemovido = true;
                break;
            }
        }

        // Reescrever o arquivo com o conteúdo atualizado
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (String jogo : jogos) {
                pw.println(jogo);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar jogo no arquivo: " + e.getMessage());
        }

        if (jogoRemovido) {
            System.out.println("Jogo removido com sucesso!");
        } else {
            System.out.println("Jogo não encontrado.");
        }
    }
}
