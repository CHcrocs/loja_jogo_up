package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import br.edu.up.projeto.models.Conta;

public class ContaController {

    public static void adicionarSaldo(Conta conta){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Ler saldo atual do arquivo antes de adicionar um novo valor
        double saldoAtual = lerSaldo();
        if (saldoAtual != -1) {
            conta.setSaldo(saldoAtual);
        }

        int resposta = -1;

        do{
            System.out.println("Escolha o valor que deseja adicionar: ");
            System.out.println("[1] - 10R$ ");
            System.out.println("[2] - 20R$ ");
            System.out.println("[3] - 50R$ ");
            System.out.println("[4] - 100R$ ");
            System.out.println("[0] - Voltar");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();

            switch(resposta){
                case 1:
                    conta.setSaldo(conta.getSaldo() + 10.0);
                    System.out.println("Adicionando 10R$...");
                    salvarSaldo(conta);
                    break;
                case 2:
                    conta.setSaldo(conta.getSaldo() + 20.0);
                    System.out.println("Adicionando 20R$...");
                    salvarSaldo(conta);
                    break;
                case 3:
                    conta.setSaldo(conta.getSaldo() + 50.0);
                    System.out.println("Adicionando 50R$...");
                    salvarSaldo(conta);
                    break;
                case 4:
                    conta.setSaldo(conta.getSaldo() + 100.0);
                    System.out.println("Adicionando 100R$...");
                    salvarSaldo(conta);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(resposta != 0);   
    }

    public static void verSaldo(Conta conta){
        double saldo = lerSaldo();
        if (saldo != -1) {
            System.out.println("Saldo atual: " + saldo);
        } else {
            System.out.println("Não foi possível ler o saldo.");
        }
    }

    // Método para salvar o saldo em um arquivo de texto
    private static void salvarSaldo(Conta conta) {
        String arquivo = "saldo.txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, false))) {
            pw.println(conta.getSaldo());
        } catch (IOException e) {
            System.out.println("Erro ao salvar saldo no arquivo: " + e.getMessage());
        }
    }

    // Método para ler o saldo do arquivo de texto
    private static double lerSaldo() {
        String arquivo = "saldo.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha = br.readLine();
            if (linha != null) {
                return Double.parseDouble(linha);
            } else {
                return 0.0;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao ler saldo do arquivo: " + e.getMessage());
            return -1;
        }
    }
}
