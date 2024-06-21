package br.edu.up.projeto.models;

abstract public class Jogo {

    public String nome;
    public String genero;
    public String classificacao;
    public Boolean online;

    public Jogo(String nome, String genero, String classificacao, Boolean online) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.online = online;
    }

    abstract void comprarJogo(String nome, Double preco);

}