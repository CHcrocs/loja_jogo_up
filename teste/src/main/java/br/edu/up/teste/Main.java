package br.edu.up.teste;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.up.teste.utils.Util;
import br.edu.up.teste.views.TesteView;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        int op;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("#############################");
            System.out.println("#           Menu            #");
            System.out.println("#############################");
            System.out.println("0 - SAIR");
            System.out.println("1 - Lista");

            op = Util.lerOpcao(scanner);
            exibirView(scanner, op);

        } while (op != 0);
        
        logger.info("Hello world!");
    }

    private static void exibirView(Scanner scanner, int op) {
        switch (op) {
            case 0 -> System.out.println("Até mais");
            case 1 -> TesteView.iniciar(scanner);
            case 99 -> System.out.println("Informe Um valor Valido");
            default -> System.out.println("Opção Invalida!");
        }
    }
    
}