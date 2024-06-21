package br.edu.up.projeto.models;

abstract public class Jogo {

    public String nome;
    public String genero;
    public String classificacao;
    public Boolean online;
    public Double preco;

    public Jogo(String nome, String genero, String classificacao, Boolean online, Double preco) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.online = online;
        this.preco = preco;
    }

}