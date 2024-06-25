package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.Principal;
import br.edu.up.projeto.models.Cliente;
import br.edu.up.projeto.models.Conta;

public class MenuCliente {
    public static void menuCliente(Cliente cliente, Scanner scanner, String[] args) {
        Conta conta = cliente.getConta();  // Obtenha a conta do cliente
        
        int resposta = -1;
        do {
            try {
                System.out.println(" ");
                System.out.println("[1] - ver menu de jogos");
                System.out.println("[2] - ver Conta");
                System.out.println("[0] - Sair");
                System.out.print("Escolha uma opção: ");
                resposta = scanner.nextInt();
                scanner.nextLine();
                System.out.println(" ");

                switch (resposta) {
                    case 1:
                        MenuJogos.menuDeJogos(conta);
                        break;
                    case 2:
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
