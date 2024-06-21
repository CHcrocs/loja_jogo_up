package br.edu.up.projeto.models;

abstract public class Jogo {

    public String nome;
    public String genero;
    public String classificacao;
    public Double preco;

    public Jogo(String nome, String genero, String classificacao, Double preco) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.preco = preco;
    }

}