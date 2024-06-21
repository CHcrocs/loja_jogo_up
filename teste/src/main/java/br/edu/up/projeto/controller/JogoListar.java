package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JogoListar {
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
