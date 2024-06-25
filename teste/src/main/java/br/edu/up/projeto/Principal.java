package br.edu.up.projeto;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.up.projeto.controller.ContaController;
import br.edu.up.projeto.models.*;
import br.edu.up.projeto.views.MenuCliente;
import br.edu.up.projeto.views.MenuAdministrador;

public class Principal {
    // Logger para registrar informações sobre a execução do programa
    private static final Logger logger = LogManager.getLogger(Principal.class);

    public static void main(String[] args) {
        // Log inicializando o sistema
        logger.info("Sistema iniciado");

        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        // Loop do menu principal para selecionar o tipo de usuário
        do {
            try {
                // Exibe as opções de login para o usuário
                System.out.println(" ");
                System.out.println("[1] - Logar como Cliente");
                System.out.println("[2] - Logar como Administrador");
                System.out.println("[0] - Sair");
                System.out.print("Escolha uma opção: ");
                resposta = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
                System.out.println(" ");

                // Switch para tratar a escolha do usuário
                switch (resposta) {
                    case 1:
                        // Cria e autentica o usuário cliente
                        Usuario cliente = criarUsuario(scanner, "Cliente");
                        if (cliente != null && ((Autenticavel) cliente).autenticar(obterSenha(scanner))) {
                            logger.info("Cliente autenticado com sucesso");
                            MenuCliente.menuCliente((Cliente) cliente, scanner, args);
                        } else {
                            System.out.println("Autenticação falhou.");
                        }
                        break;
                    case 2:
                        // Cria e autentica o usuário administrador
                        Usuario administrador = criarUsuario(scanner, "Administrador");
                        if (administrador != null && ((Autenticavel) administrador).autenticar(obterSenha(scanner))) {
                            logger.info("Administrador autenticado com sucesso");
                            MenuAdministrador.menuAdministrador((Administrador) administrador, scanner, args);
                        } else {
                            System.out.println("Autenticação falhou.");
                        }
                        break;
                    case 0:
                        // Encerra a aplicação
                        System.out.println("Saindo...");
                        break;
                    default:
                        // Trata a escolha inválida
                        System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                // Captura e trata entrada inválida do usuário
                System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número.");
                scanner.nextLine(); // Consome a entrada inválida
            }
        } while (resposta != 0);

        // Log finalizando o sistema
        logger.info("Fim da aplicação");
    }

    // Método para criar um usuário com base no tipo (Cliente ou Administrador)
    private static Usuario criarUsuario(Scanner scanner, String tipoUsuario) {
        // Solicita o ID do usuário
        System.out.print("Informe o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        // Solicita o nome do usuário
        System.out.print("Informe o nome do usuário: ");
        String nome = scanner.nextLine();

        // Solicita a senha do usuário
        System.out.print("Informe a senha do usuário: ");
        String senha = scanner.nextLine();

        // Cria um Cliente ou Administrador com base no tipo de usuário
        if (tipoUsuario.equals("Cliente")) {
            double saldoInicial = ContaController.lerSaldo(id);
            Conta conta = new Conta(id, saldoInicial);
            return new Cliente(id, nome, senha, conta);
        } else if (tipoUsuario.equals("Administrador")) {
            return new Administrador(id, nome, senha);
        }

        return null; // Retorna null se o tipo de usuário for inválido
    }

    // Método para obter a senha do usuário para autenticação
    private static String obterSenha(Scanner scanner) {
        System.out.print("Informe a senha para autenticação: ");
        return scanner.nextLine(); // Retorna a senha informada pelo usuário
    }
}
