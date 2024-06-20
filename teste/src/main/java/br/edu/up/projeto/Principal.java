package br.edu.up.projeto;

import br.edu.up.projeto.views.MenuJogos;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Principal {
    private static final Logger logger = LogManager.getLogger(Principal.class);
    public static void main(String[] args) {
        logger.info("Menu principal iniciado"); 

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;
        do{
            System.out.println("[1] - Acessar jogos");    
            System.out.println("[2] - Acessar passes");    
            System.out.println("[3] - Acessar conta");    
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();

            switch(resposta){
                case 1:
                    MenuJogos.main(args);
                    break;
                case 2:
                    System.out.println("WIP...");
                    break;
                case 3:
                    System.out.println("WIP...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(resposta != 0);

        logger.info("Fim da aplicacao");
    }

}