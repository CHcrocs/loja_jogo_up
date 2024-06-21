package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.controller.FuncionarioController;

public class MenuFuncionario {

    public static void menuFuncionario(Scanner scanner, String[] args) {
        int resposta;

        do {
            System.out.println("[1] - Adicionar Jogo");
            System.out.println("[2] - Remover jogo");
            System.out.println("[3] - Gerenciar contas");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();

            switch (resposta) {
                case 1:
                    // Chama método adicionarJogo
                    FuncionarioController.adicionarJogo(scanner);
                    break;
                case 2:
                    // Chama método removerJogo
                    FuncionarioController.removerJogo(scanner);
                    break;
                case 3:
                    // Chama método ou classe para gerenciar contas
                    System.out.println("Gerenciamento de contas - WIP...");
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
