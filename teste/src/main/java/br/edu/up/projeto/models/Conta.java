package br.edu.up.projeto.models;

public class Conta {

    private double saldo;

    public Conta() {
    }

    public Conta(Double saldo) {
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

}
