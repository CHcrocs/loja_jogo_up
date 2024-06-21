package br.edu.up.projeto.models;

public class Conta {

    private String nome;
    private String senha;
    private double saldo;

    public Conta() {
    }

    public Conta(Double saldo) {
        this.saldo = saldo;
    }

    public Conta(String nome, String senha, double saldo) {
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Senha: " + senha + ", Saldo: " + saldo;
    }

    public static Conta fromString(String line) {
        String[] parts = line.split(", ");

        if (parts.length == 1) {
            // Formato: Nome: Pisca
            parts = line.split(": ");
            String chave = parts[0].trim();
            String valor = parts[1].trim();

            switch (chave) {
                case "Nome":
                    return new Conta(valor, null, 0.0);
                case "Senha":
                    return new Conta(null, valor, 0.0);
                case "Saldo":
                    return new Conta(null, null, Double.parseDouble(valor));
                default:
                    return null; // Trate isso conforme sua lógica de erro
            }
        } else if (parts.length == 3) {
            // Formato: Nome: Login2, Senha: 1233, Saldo: 200.0
            String nome = parts[0].split(": ")[1].trim();
            String senha = parts[1].split(": ")[1].trim();
            double saldo = Double.parseDouble(parts[2].split(": ")[1].trim());

            return new Conta(nome, senha, saldo);
        } else {
            // Trate isso conforme sua lógica de erro
            return null;
        }
    }
}
