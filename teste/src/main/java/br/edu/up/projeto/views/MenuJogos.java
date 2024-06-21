package br.edu.up.projeto.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.up.projeto.models.JogoMultiplayer;
import br.edu.up.projeto.models.JogoSingleplayer;
import br.edu.up.projeto.Principal;
import br.edu.up.projeto.controller.JogoBuscar;

public class MenuJogos {
    private static final Logger logger = LogManager.getLogger(MenuJogos.class);

    public static void main(String[] args) {
        logger.info("Menu de jogos iniciado");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        List<JogoMultiplayer> jogosMultiplayers = new ArrayList<>();

        JogoMultiplayer cs = new JogoMultiplayer("Counter Strike", "FPS", "16 anos", 10, true, 60.0);
        JogoMultiplayer minecraft = new JogoMultiplayer("Minecraft", "Sandbox", "Livre", 10, true, 120.0);

        jogosMultiplayers.add(cs);
        jogosMultiplayers.add(minecraft);

        List<JogoSingleplayer> jogosSingleplayers = new ArrayList<>();
        JogoSingleplayer gta = new JogoSingleplayer("GTA saandreas", "Ação", "18 anos", false);
        JogoSingleplayer theWitcher = new JogoSingleplayer("The Witcher", "RPG", "18 anos", false);

        jogosSingleplayers.add(gta);
        jogosSingleplayers.add(theWitcher);

        int resposta = -1;

        do {
            System.out.println("[1] - listar jogos");
            System.out.println("[2] - procurar jogo");
            System.out.println("[3] - comprar jogo");
            System.out.println("[0] - voltar");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1:  
                    JogoSingleplayer.listarJogos(jogosSingleplayers);
                    JogoMultiplayer.listarJogos(jogosMultiplayers);
                    break;
                case 2:
                    JogoBuscar.BuscarJogo(jogosMultiplayers, jogosSingleplayers);
                    break;
                case 3:
                    // Adicione lógica para comprar jogo
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (resposta != 0);
        logger.info("Menu de jogos finalizado");
        Principal.main(args);
    }

}
