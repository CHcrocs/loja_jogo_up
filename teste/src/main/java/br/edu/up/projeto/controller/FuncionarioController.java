package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FuncionarioController {
    public static void adicionarJogo(Scanner scanner) {
        // Reconhe informações do jogo
        String nome = "";
        String genero = "";
        String classificacao = "";
        double preco = 0.0;

        try {
            System.out.println("Digite o nome do jogo: ");
            nome = scanner.nextLine();

            System.out.println("Digite o gênero do jogo: ");
            genero = scanner.nextLine();

            System.out.println("Digite a classificação indicativa do jogo: ");
            classificacao = scanner.nextLine();

            System.out.println("Digite o preço do jogo: ");
            preco = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha restante

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de digitar o preço corretamente.");
            scanner.nextLine(); // Consumir a entrada inválida
            return; // Saia do método em caso de erro
        }

        // Escrever no arquivo
        try (FileWriter fw = new FileWriter("jogos.txt", true);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Nome: " + nome);
            pw.println("Genero: " + genero);
            pw.println("Classificacao: " + classificacao);
            pw.println("Preco: " + preco);
            pw.println(); // Adicionar uma linha em branco para separar os jogos
            System.out.println("Jogo adicionado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar jogo no arquivo: " + e.getMessage());
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

        System.out.println("Lista de Jogos Disponíveis:");

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            String nome = null;
            String preco = null;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome: ")) {
                    nome = linha; // Captura a linha do nome
                } else if (linha.startsWith("Preco: ")) {
                    preco = linha; // Captura a linha do preço
                }

                // Quando nome e preço foram capturados, exibe-os
                if (nome != null && preco != null) {
                    String precoValor = preco.split(": ")[1]; // Captura o valor do preço
                    if (precoValor.equals("0")) {
                        System.out.println(nome + " | " + preco + " (Grátis)");
                    } else {
                        System.out.println(nome + " | " + preco);
                    }
                    nome = null; // Reseta o nome para capturar o próximo jogo
                    preco = null; // Reseta o preço para capturar o próximo jogo
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de jogos: " + e.getMessage());
        }

        // Reconhe informações do jogo
        System.out.println(" ");
        System.out.println("Digite o nome do jogo que deseja remover: ");
        String busca = scanner.nextLine();
        System.out.println(" ");

        // Remover o jogo da lista
        boolean jogoRemovido = false;
        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).contains("Nome: " + busca)) {
                // Remover as linhas correspondentes ao jogo
                for (int j = 0; j < 4; j++) { // Supondo que cada jogo tem 4 linhas (Nome, Gênero, Classificação e preco
                                              // )
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
            System.out.println(" ");
            System.out.println("Jogo removido com sucesso!");
            System.out.println(" ");
        } else {
            System.out.println("Jogo não encontrado.");
        }
    }

    // método para atualizar valor do jogo
    public static void alterarInfo(Scanner scanner) {
        String arquivo = "jogos.txt";
        System.out.println("Lista de Jogos Disponíveis:");

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            String nome = null;
            String preco = null;

            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome: ")) {
                    nome = linha; // Captura a linha do nome
                } else if (linha.startsWith("Preco: ")) {
                    preco = linha; // Captura a linha do preço
                }

                // Quando nome e preço foram capturados, exibe-os
                if (nome != null && preco != null) {
                    String precoValor = preco.split(": ")[1]; // Captura o valor do preço
                    if (precoValor.equals("0")) {
                        System.out.println(nome + " | " + preco + " (Grátis)");
                    } else {
                        System.out.println(nome + " | " + preco);
                    }
                    nome = null; // Reseta o nome para capturar o próximo jogo
                    preco = null; // Reseta o preço para capturar o próximo jogo
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de jogos: " + e.getMessage());
        }
        // Solicitar o nome do jogo que terá o preço alterado
        System.out.print("\nDigite o nome do jogo que deseja alterar o preço: ");
        String nomeJogo = scanner.nextLine().trim();

        // Solicitar o novo preço
        System.out.print("Digite o novo preço para o jogo: ");
        double novoPreco;
        try {
            novoPreco = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido para o preço. A alteração foi cancelada.");
            return;
        }
        boolean jogoEncontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("temp.txt")))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Nome: " + nomeJogo)) {
                    pw.println("Nome: " + nomeJogo);
                    pw.println(br.readLine()); // Gênero
                    pw.println(br.readLine()); // Classificação
                    pw.println("Preco: " + novoPreco);
                    br.readLine(); // Ler linha em branco
                    jogoEncontrado = true;
                    System.out.println("Preço do jogo alterado com sucesso!");
                } else {
                    pw.println(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao realizar a alteração no arquivo de jogos: " + e.getMessage());
            return;
        }
        // caso o jogo seja encontrado
        if (jogoEncontrado) {
            try {
                if (java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(arquivo))) {
                    java.nio.file.Files.move(java.nio.file.Paths.get("temp.txt"), java.nio.file.Paths.get(arquivo));
                }
            } catch (IOException e) {
                System.out.println("Erro ao renomear o arquivo temporário: " + e.getMessage());
            }
        } else {
            System.out.println("Jogo não encontrado. Nenhuma alteração realizada.");
        }
    }

}
