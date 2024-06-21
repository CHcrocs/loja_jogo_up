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
        line = line.replace("Nome: ", "").replace("Senha: ", "").replace("Saldo: ", "").trim();

        String[] parts = line.split(",");

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        String nome = parts[0];
        String senha = parts[1];
        double saldo = Double.parseDouble(parts[2]);

        return new Conta(nome, senha, saldo);
    }
}
