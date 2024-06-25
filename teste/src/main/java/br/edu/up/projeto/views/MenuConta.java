package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.controller.ContaController;
import br.edu.up.projeto.models.Conta;

public class MenuConta {
    public static void menuDeConta(Conta conta) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        do {
            System.out.println(" ");
            System.out.println("[1] - ver saldo");
            System.out.println("[2] - adicionar saldo");
            System.out.println("[3] - ver biblioteca de jogos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();
            System.out.println(" ");

            switch (resposta) {
                case 1:
                    System.out.println(" ");
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    System.out.println(" ");
                    break;
                case 2:
                    ContaController.adicionarSaldo(conta);
                    break;
                case 3:
                    ContaController.verBiblioteca(conta);
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
