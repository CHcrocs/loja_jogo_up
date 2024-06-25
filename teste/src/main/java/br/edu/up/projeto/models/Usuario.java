package br.edu.up.projeto.models;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected String senha;

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public abstract void exibirDetalhes();
}
