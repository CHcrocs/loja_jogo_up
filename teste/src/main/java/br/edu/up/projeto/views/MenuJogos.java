package br.edu.up.projeto.views;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import br.edu.up.projeto.controller.ContaController;
import br.edu.up.projeto.controller.JogoController;
import br.edu.up.projeto.models.Conta;

public class MenuJogos {
    // Logger para registrar informações sobre a execução do programa
    private static final Logger logger = LogManager.getLogger(MenuJogos.class);

    // Método que exibe o menu de jogos e processa as escolhas do usuário
    public static void menuDeJogos(Conta conta) {
        logger.info("Menu de jogos iniciado"); // Registro de início do menu

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário

        int resposta = -1; // Variável para armazenar a opção escolhida pelo usuário

        // Laço para exibir o menu até que o usuário escolha a opção de voltar (0)
        do {
            // Exibe o menu de opções
            System.out.println(" ");
            System.out.println("[1] - listar jogos"); // Opção para listar todos os jogos
            System.out.println("[2] - procurar jogo"); // Opção para procurar um jogo específico
            System.out.println("[3] - comprar jogo"); // Opção para comprar um jogo
            System.out.println("[0] - voltar"); // Opção para voltar ao menu anterior
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Consome a nova linha
            System.out.println(" ");

            // Processa a opção escolhida pelo usuário
            switch (resposta) {
                case 1:
                    JogoController.listarJogos(); // Chama o método para listar todos os jogos
                    break;
                case 2:
                    JogoController.BuscarJogo(); // Chama o método para procurar um jogo específico
                    break;
                case 3:
                    ContaController.comprarJogo(conta); // Chama o método para comprar um jogo, passando a conta do usuário
                    break;
                case 0:
                    System.out.println("Voltando..."); // Mensagem de retorno ao menu anterior
                    break;
                default:
                    System.out.println("Opção inválida"); // Mensagem de opção inválida
            }

        } while (resposta != 0); // Continua exibindo o menu até que a opção de voltar seja escolhida
        logger.info("Menu de jogos finalizado"); // Registro de finalização do menu
    }
}
