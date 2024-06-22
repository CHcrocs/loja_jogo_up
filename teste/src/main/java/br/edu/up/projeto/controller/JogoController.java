package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JogoController {

    public static void BuscarJogo() {
        String arquivo = "jogos.txt";
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do jogo que deseja encontrar: ");
        String busca = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrado = false;

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(":", 2);
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();

                    if (valor.equalsIgnoreCase(busca)) {
                        encontrado = true;
                    }

                    if (encontrado) {
                        System.out.println(chave + ": " + valor);
                        if (!linha.contains(":")) {
                            break;
                        }
                    }
                } else {
                    if (encontrado) {
                        break;
                    }
                    System.out.println(" ");
                }
            }
            if (!encontrado) {
                System.out.println("Informação '" + busca + "' não encontrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarJogos() {
        String arquivo = "jogos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Separar a linha no caractere ':' para obter chave e valor
                String[] partes = linha.split(":", 2);

                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();

                    // Formatar a visualização
                    System.out.println(chave + ": " + valor);
                } else {
                    System.out.println(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
