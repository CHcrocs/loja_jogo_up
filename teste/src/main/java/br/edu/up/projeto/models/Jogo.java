package br.edu.up.projeto.models;

// Classe que representa um jogo
public class Jogo {

    private String nome; // Nome do jogo
    private String genero; // Gênero do jogo
    private String classificacao; // Classificação etária do jogo
    private Double preco; // Preço do jogo
    private int contaId; // Chave estrangeira associando o jogo a uma conta

    // Construtor para inicializar um jogo com nome, gênero, classificação, preço e ID da conta
    public Jogo(String nome, String genero, String classificacao, Double preco, int contaId) {
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.preco = preco;
        this.contaId = contaId;
    }

    // Método getter para obter o nome do jogo
    public String getNome() {
        return nome;
    }

    // Método setter para definir o nome do jogo
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter o gênero do jogo
    public String getGenero() {
        return genero;
    }

    // Método setter para definir o gênero do jogo
    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Método getter para obter a classificação etária do jogo
    public String getClassificacao() {
        return classificacao;
    }

    // Método setter para definir a classificação etária do jogo
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    // Método getter para obter o preço do jogo
    public Double getPreco() {
        return preco;
    }

    // Método setter para definir o preço do jogo
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Método getter para obter o ID da conta associada ao jogo
    public int getContaId() {
        return contaId;
    }

    // Método setter para definir o ID da conta associada ao jogo
    public void setContaId(int contaId) {
        this.contaId = contaId;
    }
}
