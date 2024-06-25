package br.edu.up.projeto.views;

import java.util.Scanner;

import br.edu.up.projeto.Principal;
import br.edu.up.projeto.models.Cliente;
import br.edu.up.projeto.models.Conta;

public class MenuCliente {
    // Método que exibe o menu do cliente e processa as escolhas do usuário
    public static void menuCliente(Cliente cliente, Scanner scanner, String[] args) {
        Conta conta = cliente.getConta();  // Obtém a conta do cliente a partir do objeto Cliente
        
        int resposta = -1; // Variável para armazenar a opção escolhida pelo usuário
        do {
            try {
                System.out.println(" ");
                System.out.println("[1] - ver menu de jogos"); // Opção para visualizar o menu de jogos
                System.out.println("[2] - ver Conta"); // Opção para visualizar a conta do cliente
                System.out.println("[0] - Sair"); // Opção para sair do menu
                System.out.print("Escolha uma opção: ");
                resposta = scanner.nextInt(); // Lê a opção escolhida pelo usuário
                scanner.nextLine(); // Consome a nova linha
                System.out.println(" ");

                // Processa a opção escolhida pelo usuário
                switch (resposta) {
                    case 1:
                        MenuJogos.menuDeJogos(conta); // Chama o método para exibir o menu de jogos
                        break;
                    case 2:
                        MenuConta.menuDeConta(conta); // Chama o método para exibir o menu da conta
                        break;
                    case 0:
                        System.out.println("Saindo..."); // Mensagem de saída
                        break;
                    default:
                        System.out.println("Opção inválida"); // Mensagem de opção inválida
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage()); // Captura e exibe qualquer exceção que ocorra
            }
        } while (resposta != 0); // Continua exibindo o menu até que a opção de sair seja escolhida
        Principal.main(args); // Após sair do menu, chama o método principal da classe Principal
    }
}
