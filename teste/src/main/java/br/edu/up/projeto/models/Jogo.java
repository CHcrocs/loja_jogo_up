package br.edu.up.projeto.models;

abstract public class Jogo {

    private String nome;
    private String genero;
    private String classificacao;
    private Double preco;
    private int contaId; // Chave estrangeira

    public Jogo(String nome, String genero, String classificacao, Double preco, int contaId) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.preco = preco;
        this.contaId = contaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }
}
