package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import br.edu.up.projeto.models.Conta;

public class ContaController {

    public static void adicionarSaldo(Conta conta) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        do {
            System.out.println(" ");
            System.out.println("Escolha o valor que deseja adicionar: ");
            System.out.println("[1] - 10R$ ");
            System.out.println("[2] - 20R$ ");
            System.out.println("[3] - 50R$ ");
            System.out.println("[4] - 100R$ ");
            System.out.println("[0] - Voltar");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            System.out.println(" ");

            switch (resposta) {
                case 1:
                    conta.setSaldo(conta.getSaldo() + 10.0);
                    System.out.println(" ");
                    System.out.println("10R$ adicionados com sucesso!");
                    System.out.println(" ");
                    salvarSaldo(conta);
                    break;
                case 2:
                    conta.setSaldo(conta.getSaldo() + 20.0);
                    System.out.println("Adicionando 20R$...");
                    salvarSaldo(conta);
                    break;
                case 3:
                    conta.setSaldo(conta.getSaldo() + 50.0);
                    System.out.println("Adicionando 50R$...");
                    salvarSaldo(conta);
                    break;
                case 4:
                    conta.setSaldo(conta.getSaldo() + 100.0);
                    System.out.println("Adicionando 100R$...");
                    salvarSaldo(conta);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (resposta != 0);
    }

    public static void verSaldo(Conta conta) {
        System.out.println("Saldo atual: " + conta.getSaldo());
    }

    public static double lerSaldo(int contaId) {
        String arquivo = "saldo_" + contaId + ".txt";
        File file = new File(arquivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
                try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, false))) {
                    pw.println("0.0");
                }
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo de saldo: " + e.getMessage());
                return 0.0;
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            if (linha != null) {
                return Double.parseDouble(linha);
            } else {
                return 0.0;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao ler saldo do arquivo: " + e.getMessage());
            return 0.0;
        }
    }

    // Método para salvar o saldo em um arquivo de texto
    private static void salvarSaldo(Conta conta) {
        String arquivo = "saldo_" + conta.getId() + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, false))) {
            pw.println(conta.getSaldo());
        } catch (IOException e) {
            System.out.println("Erro ao salvar saldo no arquivo: " + e.getMessage());
        }
    }

    public static void verBiblioteca(Conta conta) {
        String arquivo = "biblioteca_" + conta.getId() + ".txt";
        File file = new File(arquivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo de biblioteca: " + e.getMessage());
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean temJogo = false;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
                temJogo = true;
            }
            if (!temJogo) {
                System.out.println("");
                System.out.println("-----A biblioteca está vazia-----");
                System.out.println("");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler biblioteca de jogos: " + e.getMessage());
        }
    }

    public static void comprarJogo(Conta conta) {
        String arquivo = "jogos.txt";
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

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

        System.out.print("Informe o nome do jogo que deseja comprar: ");
        String busca = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrado = false;
            StringBuilder detalhesJogo = new StringBuilder();

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":", 2);
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();

                    if (chave.equalsIgnoreCase("Nome") && valor.equalsIgnoreCase(busca)) {
                        encontrado = true;
                    }

                    if (encontrado) {
                        detalhesJogo.append(chave).append(": ").append(valor).append("\n");
                        if (linha.isEmpty()) {
                            break;
                        }
                    }
                }
            }

            if (encontrado) {
                System.out.print("Deseja comprar o jogo '" + busca + "'? Digite [s] para sim ou [n] para não: ");
                String resposta = scanner.nextLine().trim();

                if (resposta.equalsIgnoreCase("s")) {
                    double precoJogo = obterPrecoDoJogo(detalhesJogo.toString());
                    if (conta.getSaldo() >= precoJogo) {
                        conta.setSaldo(conta.getSaldo() - precoJogo);
                        salvarSaldo(conta);
                        adicionarJogoABiblioteca(conta, detalhesJogo.toString());
                        System.out.println("Jogo comprado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para comprar o jogo.");
                    }
                } else {
                    System.out.println("Compra cancelada.");
                }
            } else {
                System.out.println("Jogo '" + busca + "' não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obter o preço do jogo a partir dos detalhes do jogo
    private static double obterPrecoDoJogo(String detalhesJogo) {
        for (String linha : detalhesJogo.split("\n")) {
            if (linha.startsWith("Preco:")) {
                try {
                    double preco = Double.parseDouble(linha.split(":")[1].trim());
                    return preco;
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao ler o preço do jogo: " + e.getMessage());
                }
            }
        }
        return 0.0; // Retorne 0 se não conseguir encontrar o preço
    }

    // Método para adicionar o jogo à biblioteca de jogos
    private static void adicionarJogoABiblioteca(Conta conta, String detalhesJogo) {
        String arquivo = "biblioteca_" + conta.getId() + ".txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, true))) {
            pw.println(detalhesJogo);
            pw.println(); // Adiciona uma linha em branco entre as entradas de jogos
        } catch (IOException e) {
            System.out.println("Erro ao adicionar jogo à biblioteca: " + e.getMessage());
        }
    }
}
