package br.edu.up.teste.views;

import java.util.Scanner;

/**
 * TesteView
 * @param scanner
 */
public class TesteView {

    public static void iniciar(Scanner scanner) {
        int op;

        do {
        System.out.println("#############################");
        System.out.println("#         TesteList         #");
        System.out.println("#############################");
        System.out.println("0 - SAIR");
        System.out.println("1 - Listar");
        System.out.println("2 - Cadastrar");
        System.out.println("3 - Alterar");
        System.out.println("4 - Remover");

        op = scanner.nextInt();
        }while(op != 0);
    }
}