package br.edu.up.projeto.models;

import java.util.List;

public class Conta {

    private int id; // Identificador único para a conta
    private double saldo;
    private List<Jogo> biblioteca; // Lista de jogos

    public Conta(int id, Double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Jogo> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(List<Jogo> biblioteca) {
        this.biblioteca = biblioteca;
    }
}
