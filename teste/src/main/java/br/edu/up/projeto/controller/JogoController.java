package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JogoController {

    // Método para buscar um jogo específico pelo nome
    public static void BuscarJogo() {
        String arquivo = "jogos.txt";
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o nome do jogo que deseja encontrar
        System.out.print("Informe o nome do jogo que deseja encontrar: ");
        String busca = scanner.nextLine().trim();
        System.out.println(" ");

        // Tenta ler o arquivo de jogos e buscar pelo nome informado
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrado = false;

            // Lê o arquivo linha por linha
            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(":", 2); // Divide a linha em chave e valor
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();

                    // Verifica se o valor corresponde à busca do usuário
                    if (valor.equalsIgnoreCase(busca)) {
                        encontrado = true;
                    }

                    // Se o jogo for encontrado, imprime as informações
                    if (encontrado) {
                        System.out.println(chave + ": " + valor);
                        if (!linha.contains(":")) {
                            break; // Interrompe a leitura se a linha não contiver ":"
                        }
                    }
                } else {
                    if (encontrado) {
                        break; // Interrompe a leitura se as partes não contiverem chave e valor válidos
                    }
                }
            }
            if (!encontrado) {
                System.out.println("Informação '" + busca + "' não encontrada.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Trata exceções de IO
        }
    }

    // Método para listar todos os jogos disponíveis no arquivo
    public static void listarJogos() {
        String arquivo = "jogos.txt";

        // Tenta ler o arquivo de jogos e listar todas as entradas
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Divide a linha em chave e valor
                String[] partes = linha.split(":", 2);

                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();

                    // Formata e imprime a chave e o valor
                    System.out.println(chave + ": " + valor);
                } else {
                    System.out.println(linha); // Imprime a linha caso não contenha chave e valor válidos
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Trata exceções de IO
        }
    }
}
