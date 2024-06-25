package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.models.Administrador;
import br.edu.up.projeto.controller.FuncionarioController;

public class MenuAdministrador {

    private static final String senhaUsuario = "123";

    public static boolean verificaSenha(Scanner scanner) {
        System.out.print("Digite a senha de acesso: ");
        String senha = scanner.nextLine();
        return senhaUsuario.equals(senha);
    }

    public static void menuAdministrador(Administrador administrador, Scanner scanner, String[] args) {
        int resposta = -1;

        do {
            System.out.println(" ");
            System.out.println("[1] - Adicionar Jogo");
            System.out.println("[2] - Remover Jogo");
            System.out.println("[3] - Alterar Informações de Jogos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" ");

            switch (resposta) {
                case 1:
                    FuncionarioController.adicionarJogo(scanner);
                    break;
                case 2:
                    FuncionarioController.removerJogo(scanner);
                    break;
                case 3:
                    FuncionarioController.alterarInfo(scanner);
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
