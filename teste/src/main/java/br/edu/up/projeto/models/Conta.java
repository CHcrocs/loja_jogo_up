package br.edu.up.projeto.models;

import java.util.List;

// Classe que representa uma conta
public class Conta {

    private int id; // Identificador único para a conta
    private double saldo; // Saldo da conta
    private List<Jogo> biblioteca; // Lista de jogos na biblioteca da conta

    // Construtor para inicializar a conta com um ID e saldo
    public Conta(int id, Double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    // Método getter para obter o ID da conta
    public int getId() {
        return id;
    }

    // Método setter para definir o ID da conta
    public void setId(int id) {
        this.id = id;
    }

    // Método getter para obter o saldo da conta
    public double getSaldo() {
        return saldo;
    }

    // Método setter para definir o saldo da conta
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método getter para obter a lista de jogos na biblioteca da conta
    public List<Jogo> getBiblioteca() {
        return biblioteca;
    }

    // Método setter para definir a lista de jogos na biblioteca da conta
    public void setBiblioteca(List<Jogo> biblioteca) {
        this.biblioteca = biblioteca;
    }
}
