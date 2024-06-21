package br.edu.up.projeto;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.up.projeto.models.Funcionario;
import br.edu.up.projeto.views.MenuJogos;

public class Principal {
    private static final Logger logger = LogManager.getLogger(Principal.class);

    public static void main(String[] args) {
        logger.info("Sistema iniciado");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        // Primeiro menu para selecionar tipo de usuário
        do {
            System.out.println("[1] - Logar como Usuário");
            System.out.println("[2] - Logar como Funcionário");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1:
                    // Menu para Usuário
                    menuUsuario(scanner, args);
                    break;
                case 2:
                    // chama o método menuFuncionario da classe Funcionario
                    Funcionario.menuFuncionario(scanner, args);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (resposta != 0);

        logger.info("Fim da aplicação");
    }

    private static void menuUsuario(Scanner scanner, String[] args) {
        int resposta;
        do {
            System.out.println("[1] - Acessar jogos");
            System.out.println("[2] - Acessar passes");
            System.out.println("[3] - Acessar conta");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();

            switch (resposta) {
                case 1:
                    MenuJogos.main(args);
                    break;
                case 2:
                    System.out.println("WIP...");
                    break;
                case 3:
                    System.out.println("WIP...");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (resposta != 0);
    }

}
