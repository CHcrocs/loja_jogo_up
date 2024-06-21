package br.edu.up.projeto;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.up.projeto.views.MenuFuncionario;
import br.edu.up.projeto.views.MenuUsuario;

public class Principal {
    private static final Logger logger = LogManager.getLogger(Principal.class);

    public static void main(String[] args) {
        logger.info("Sistema iniciado");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        // Primeiro menu para selecionar tipo de usuário
        do {
            System.out.println("[1] - Logar como Usuário");
            System.out.println("[2] - Logar como Funcionário");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();
            scanner.nextLine();

            switch (resposta) {
                case 1:
                    // Menu para Usuário
                    MenuUsuario.menuUsuario(scanner, args);
                    break;
                case 2:
                    // chama o método menuFuncionario da classe MenuFuncionario
                    if (MenuFuncionario.verifica_senha(scanner)){
                        MenuFuncionario.menuFuncionario(scanner, args);
                    } else{
                        System.out.println("Senha incorreta");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (resposta != 0);

        logger.info("Fim da aplicação");
    }

    

}
