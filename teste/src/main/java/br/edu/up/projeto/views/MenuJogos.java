package br.edu.up.projeto.views;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.up.projeto.controller.ContaController;
import br.edu.up.projeto.controller.JogoController;
import br.edu.up.projeto.models.Conta;

public class MenuJogos {
    private static final Logger logger = LogManager.getLogger(MenuJogos.class);

    public static void menuDeJogos(Conta conta) {
        logger.info("Menu de jogos iniciado");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
    

        int resposta = -1;

        do {
            System.out.println(" ");
            System.out.println("[1] - listar jogos");
            System.out.println("[2] - procurar jogo");
            System.out.println("[3] - comprar jogo");
            System.out.println("[0] - voltar");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" ");

            switch (resposta) {
                case 1:
                    JogoController.listarJogos();
                    break;
                case 2:
                    JogoController.BuscarJogo();
                    break;
                case 3:
                    ContaController.comprarJogo(conta);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (resposta != 0);
        logger.info("Menu de jogos finalizado");
    }
}
