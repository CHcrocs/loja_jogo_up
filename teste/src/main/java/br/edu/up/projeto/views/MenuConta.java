package br.edu.up.projeto.views;

import java.util.Scanner;
import br.edu.up.projeto.controller.ContaController;
import br.edu.up.projeto.models.Conta;

public class MenuConta {
    // Método que exibe o menu de conta e processa as escolhas do usuário
    public static void menuDeConta(Conta conta) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do usuário

        int resposta = -1; // Variável para armazenar a opção escolhida pelo usuário

        // Laço para exibir o menu até que o usuário escolha a opção de sair (0)
        do {
            // Exibe o menu de opções
            System.out.println(" ");
            System.out.println("[1] - ver saldo"); // Opção para visualizar o saldo atual
            System.out.println("[2] - adicionar saldo"); // Opção para adicionar saldo à conta
            System.out.println("[3] - ver biblioteca de jogos"); // Opção para visualizar a biblioteca de jogos
            System.out.println("[0] - Sair"); // Opção para sair do menu
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Consome a nova linha
            System.out.println(" ");

            // Processa a opção escolhida pelo usuário
            switch (resposta) {
                case 1:
                    // Exibe o saldo atual da conta
                    System.out.println(" ");
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    System.out.println(" ");
                    break;
                case 2:
                    // Chama o método para adicionar saldo à conta
                    ContaController.adicionarSaldo(conta);
                    break;
                case 3:
                    // Chama o método para visualizar a biblioteca de jogos
                    ContaController.verBiblioteca(conta);
                    break;
                case 0:
                    // Mensagem de saída
                    System.out.println("Saindo...");
                    break;
                default:
                    // Mensagem de opção inválida
                    System.out.println("Opção inválida");
            }
        } while (resposta != 0); // Continua exibindo o menu até que a opção de sair seja escolhida
    }
}
