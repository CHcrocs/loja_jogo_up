package br.edu.up.projeto.models;

import java.util.List;
import java.util.Scanner;

public class jogoBuscar {

    public static void BuscarJogo(List<JogoMultiplayer> jogosMultiplayer, List<JogoSingleplayer> jogosSingleplayer) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o nome do jogo que deseja buscar: ");
        String itemBuscado = scanner.nextLine();

        Boolean exist = false;

        // Verifica se o jogo está presente no catálogo de jogos multiplayer
        for (JogoMultiplayer jogoMultiplayer : jogosMultiplayer) {
            if (jogoMultiplayer.getNome().equalsIgnoreCase(itemBuscado)) {
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Jogo encontrado!");
                System.out.println(jogoMultiplayer);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println();
                exist = true;
                break;
            }
        }

        // Verifica se o jogo está presente no catálogo de jogos singleplayer
        if (!exist) {
            for (JogoSingleplayer jogoSingleplayer : jogosSingleplayer) {
                if (jogoSingleplayer.getNome().equalsIgnoreCase(itemBuscado)) {
                    System.out.println();
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Jogo encontrado!");
                    System.out.println(jogoSingleplayer);
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println();
                    exist = true;
                    break;
                }
            }
        }

        // Caso o jogo não seja encontrado em nenhum dos catálogos
        if (!exist) {
            System.out.println();
            System.out.println("################################################################################");
            System.out.println("Jogo '" + itemBuscado + "' não encontrado em nenhum dos catálogos de jogos!");
            System.out.println("################################################################################");
            System.out.println();
        }
    }
}
