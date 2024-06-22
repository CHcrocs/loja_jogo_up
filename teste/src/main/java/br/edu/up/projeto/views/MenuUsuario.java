package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.Principal;

public class MenuUsuario {
    public static void menuUsuario(Scanner scanner, String[] args) {
        int resposta = -1;
        do {
            try {
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
                        MenuConta.main(args);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (resposta != 0);
        Principal.main(args);
    }
}
