package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.Principal;
import br.edu.up.projeto.controller.ContaController;
import br.edu.up.projeto.models.Conta;

public class MenuUsuario {
    public static void menuUsuario(Scanner scanner, String[] args) {

        System.out.print("Informe o ID da conta: ");
        int contaId = scanner.nextInt();
        scanner.nextLine();
        
        double saldoInicial = ContaController.lerSaldo(contaId);

        Conta conta = new Conta(contaId, saldoInicial);
        
        int resposta = -1;
        do {
            try {
                System.out.println("[1] - Acessar jogos");
                System.out.println("[2] - Acessar passes");
                System.out.println("[3] - Acessar conta");
                System.out.println("[0] - Sair");
                System.out.print("Escolha uma opção: ");
                resposta = scanner.nextInt();
                scanner.nextLine();

                switch (resposta) {
                    case 1:
                        MenuJogos.menuDeJogos(conta);
                        break;
                    case 2:
                        System.out.println("WIP...");
                        break;
                    case 3:
                        MenuConta.menuDeConta(conta);
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
