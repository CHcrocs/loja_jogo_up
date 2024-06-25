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
    private static final Logger logger = LogManager.getLogger(Principal.class);

    public static void main(String[] args) {
        logger.info("Sistema iniciado");

        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        // Primeiro menu para selecionar tipo de usuário
        do {
            try {
                System.out.println(" ");
                System.out.println("[1] - Logar como Cliente");
                System.out.println("[2] - Logar como Administrador");
                System.out.println("[0] - Sair");
                System.out.print("Escolha uma opção: ");
                resposta = scanner.nextInt();
                scanner.nextLine();
                System.out.println(" ");

                switch (resposta) {
                    case 1:
                        Usuario cliente = criarUsuario(scanner, "Cliente");
                        if (cliente != null && ((Autenticavel) cliente).autenticar(obterSenha(scanner))) {
                            logger.info("Cliente autenticado com sucesso");
                            MenuCliente.menuCliente((Cliente) cliente, scanner, args);
                        } else {
                            System.out.println("Autenticação falhou.");
                        }
                        break;
                    case 2:
                        Usuario administrador = criarUsuario(scanner, "Administrador");
                        if (administrador != null && ((Autenticavel) administrador).autenticar(obterSenha(scanner))) {
                            logger.info("Administrador autenticado com sucesso");
                            MenuAdministrador.menuAdministrador((Administrador) administrador, scanner, args);
                        } else {
                            System.out.println("Autenticação falhou.");
                        }
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Certifique-se de digitar um número.");
                scanner.nextLine(); // Consumir a entrada inválida
            }
        } while (resposta != 0);

        logger.info("Fim da aplicação");
    }

    private static Usuario criarUsuario(Scanner scanner, String tipoUsuario) {
        System.out.print("Informe o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a senha do usuário: ");
        String senha = scanner.nextLine();

        if (tipoUsuario.equals("Cliente")) {
            double saldoInicial = ContaController.lerSaldo(id);
            Conta conta = new Conta(id, saldoInicial);
            return new Cliente(id, nome, senha, conta);
        } else if (tipoUsuario.equals("Administrador")) {
            return new Administrador(id, nome, senha);
        }

        return null;
    }

    private static String obterSenha(Scanner scanner) {
        System.out.print("Informe a senha para autenticação: ");
        return scanner.nextLine();
    }
}
