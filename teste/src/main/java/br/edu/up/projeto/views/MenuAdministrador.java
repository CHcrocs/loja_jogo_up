package br.edu.up.projeto.views;

import java.util.Scanner;
import br.edu.up.projeto.models.Administrador;
import br.edu.up.projeto.controller.FuncionarioController;

public class MenuAdministrador {

    private static final String senhaUsuario = "123"; // Senha fixa para acesso administrativo

    // Método para verificar a senha do usuário
    public static boolean verificaSenha(Scanner scanner) {
        System.out.print("Digite a senha de acesso: ");
        String senha = scanner.nextLine(); // Lê a senha digitada pelo usuário
        return senhaUsuario.equals(senha); // Compara a senha digitada com a senha fixa
    }

    // Método que exibe o menu administrativo e processa as escolhas do usuário
    public static void menuAdministrador(Administrador administrador, Scanner scanner, String[] args) {
        int resposta = -1; // Variável para armazenar a opção escolhida pelo usuário

        // Laço para exibir o menu até que o usuário escolha a opção de sair (0)
        do {
            System.out.println(" ");
            System.out.println("[1] - Adicionar Jogo"); // Opção para adicionar um novo jogo
            System.out.println("[2] - Remover Jogo"); // Opção para remover um jogo existente
            System.out.println("[3] - Alterar Informações de Jogos"); // Opção para alterar informações de um jogo
            System.out.println("[0] - Sair"); // Opção para sair do menu
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Consome a nova linha
            System.out.println(" ");

            // Processa a opção escolhida pelo usuário
            switch (resposta) {
                case 1:
                    FuncionarioController.adicionarJogo(scanner); // Chama o método para adicionar jogo
                    break;
                case 2:
                    FuncionarioController.removerJogo(scanner); // Chama o método para remover jogo
                    break;
                case 3:
                    FuncionarioController.alterarInfo(scanner); // Chama o método para alterar informações do jogo
                    break;
                case 0:
                    System.out.println("Saindo..."); // Mensagem de saída
                    break;
                default:
                    System.out.println("Opção inválida"); // Mensagem de opção inválida
            }
        } while (resposta != 0); // Continua exibindo o menu até que a opção de sair seja escolhida
    }
}
