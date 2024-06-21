package br.edu.up.projeto.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import br.edu.up.projeto.models.Conta;

public class ContaController {

    public static void adicionarSaldo(Conta conta) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int resposta = -1;

        do {
            System.out.println("Escolha o valor que deseja adicionar: ");
            System.out.println("[1] - 10R$ ");
            System.out.println("[2] - 20R$ ");
            System.out.println("[3] - 50R$ ");
            System.out.println("[4] - 100R$ ");
            System.out.println("[0] - Voltar");
            System.out.print("Escolha uma opção: ");
            resposta = scanner.nextInt();

            switch (resposta) {
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
        } while (resposta != 0);
    }

    public static void verSaldo(Conta conta) {
        if (conta != null) {
            System.out.println("Saldo atual: " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
        }

        public static double lerSaldo(Conta conta) {
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return 0.0;
        }

        String arquivo = "usuarios.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
            Conta usuario = Conta.fromString(linha);
            if (usuario.getNome().equals(conta.getNome())) {
                return usuario.getSaldo();
            }
            }
            return 0.0; // Retorne 0.0 se a conta não for encontrada
        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao ler saldo do arquivo: " + e.getMessage());
            return -1;
        }
        }
    // Método para salvar o saldo em um arquivo de texto
    public static void salvarSaldo(Conta conta) {
        String arquivo = "usuarios.txt";
        String nomeConta = conta.getNome();

        // Armazenará as novas linhas
        StringBuilder novasLinhas = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean contaEncontrada = false;

            // Lê todas as linhas do arquivo
            while ((linha = br.readLine()) != null) {
                Conta usuario = Conta.fromString(linha);
                if (usuario.getNome().equals(nomeConta)) {
                    // Encontrou a conta, atualiza o saldo
                    novasLinhas.append("Nome: ").append(usuario.getNome()).append("\n");
                    novasLinhas.append("Senha: ").append(usuario.getSenha()).append("\n");
                    novasLinhas.append("Saldo: ").append(conta.getSaldo()).append("\n");
                    contaEncontrada = true;
                } else {
                    // Mantém as outras linhas como estavam
                    novasLinhas.append(linha).append("\n");
                }
            }

            if (!contaEncontrada) {
                System.out.println("Conta não encontrada para atualizar o saldo.");
                return;
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar saldo no arquivo: " + e.getMessage());
            return; // Sai do método se houver erro
        }

        // Escreve todas as novas linhas de volta para o arquivo (sobrescrevendo o
        // conteúdo antigo)
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.print(novasLinhas.toString());
            System.out.println("Saldo da conta atualizado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar saldo no arquivo: " + e.getMessage());
        }
    }

    public static void verBiblioteca() {
        String arquivo = "biblioteca.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler biblioteca de jogos: " + e.getMessage());
        }
    }

    public static void comprarJogo(Conta conta) {
        String arquivoJogos = "jogos.txt";
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do jogo que deseja comprar: ");
        String busca = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoJogos))) {
            String linha;
            boolean encontrado = false;
            StringBuilder detalhesJogo = new StringBuilder();
            double precoJogo = 0.0;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":", 2);
                if (partes.length == 2) {
                    String chave = partes[0].trim();
                    String valor = partes[1].trim();

                    if (chave.equalsIgnoreCase("Nome") && valor.equalsIgnoreCase(busca)) {
                        encontrado = true;
                    }

                    if (encontrado) {
                        detalhesJogo.append(chave).append(": ").append(valor).append("\n");
                    }

                    if (linha.isEmpty() && encontrado) {
                        break;
                    }
                }
            }

            if (encontrado) {
                System.out.println("Detalhes do jogo encontrado:\n" + detalhesJogo.toString());

                System.out.print("Deseja comprar o jogo '" + busca + "'? Digite [s] para sim ou [n] para não: ");
                String resposta = scanner.nextLine().trim();

                if (resposta.equalsIgnoreCase("s")) {
                    precoJogo = obterPrecoDoJogo(detalhesJogo.toString());

                    if (conta.getSaldo() >= precoJogo) {
                        conta.setSaldo(conta.getSaldo() - precoJogo);
                        salvarSaldo(conta);
                        adicionarJogoABiblioteca(detalhesJogo.toString());
                        System.out.println("Jogo comprado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para comprar o jogo.");
                    }
                } else {
                    System.out.println("Compra cancelada.");
                }
            } else {
                System.out.println("Jogo '" + busca + "' não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo de jogos: " + e.getMessage());
        }
    }

    // Método para obter o preço do jogo a partir dos detalhes do jogo
    private static double obterPrecoDoJogo(String detalhesJogo) {
        // Supondo que o preço esteja na linha "Preço: X", onde X é o valor do preço
        for (String linha : detalhesJogo.split("\n")) {
            if (linha.startsWith("Preco:")) {
                try {
                    double preco = Double.parseDouble(linha.split(":")[1].trim());
                    return preco;
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao ler o preço do jogo: " + e.getMessage());
                }
            }
        }
        return 0.0; // Retorne 0 se não conseguir encontrar o preço
    }

    // Método para adicionar o jogo à biblioteca de jogos
    private static void adicionarJogoABiblioteca(String detalhesJogo) {
        String arquivo = "biblioteca.txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo, true))) {
            pw.println(detalhesJogo);
            pw.println(); // Adiciona uma linha em branco entre as entradas de jogos
        } catch (IOException e) {
            System.out.println("Erro ao adicionar jogo à biblioteca: " + e.getMessage());
        }
    }

    // METODO PARA CADASTRAR USUARIO
    public static void cadastrarUsuario() {
        String arquivo = "usuarios.txt";

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();

        Conta usuario = new Conta(nome, senha, saldo);

        try (FileWriter fw = new FileWriter(arquivo, true);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println(usuario.toString());
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Conta loginUsuario(String nome, String senha) {
        String arquivo = "usuarios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                Conta usuario = Conta.fromString(line);
                if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                    System.out.println("Login bem-sucedido para usuário: " + usuario.getNome());
                    return usuario;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Nome de usuário ou senha incorretos.");
        return null;
    }
}
