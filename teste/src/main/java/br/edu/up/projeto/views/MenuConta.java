package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.controller.ContaController;
import br.edu.up.projeto.models.Conta;

public class MenuConta {
    public static void main(String[] args) {

        Conta conta = new Conta(ContaController.lerSaldo());

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        do {
            System.out.println("[1] - ver saldo");
            System.out.println("[2] - adicionar saldo");
            System.out.println("[3] - ver biblioteca de jogos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();

            switch (resposta) {
                case 1:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 2:
                    ContaController.adicionarSaldo(conta);
                    break;
                case 3:
                    ContaController.verBiblioteca();
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
