package br.edu.up.teste.utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Util {

    private static final Logger logger = LogManager.getLogger(Util.class);

    public static int lerOpcao(Scanner scanner){
        logger.info("Iniciando o processo de leitura do menu");
        try {
            int opcao = scanner.nextInt();
            return opcao;
        } catch (InputMismatchException e) {
            logger.error("Usuário informou um vaqlor invalido", e);
            scanner.next();
            return 99;
        }
    }
}