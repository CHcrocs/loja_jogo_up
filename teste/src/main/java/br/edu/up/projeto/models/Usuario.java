package br.edu.up.projeto.models;

// Classe abstrata que representa um usuário genérico
public abstract class Usuario {
    protected int id; // Identificador único para o usuário
    protected String nome; // Nome do usuário
    protected String senha; // Senha do usuário

    // Construtor para inicializar um usuário com ID, nome e senha
    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    // Método getter para obter o ID do usuário
    public int getId() {
        return id;
    }

    // Método getter para obter o nome do usuário
    public String getNome() {
        return nome;
    }

    // Método abstrato para exibir detalhes do usuário
    // Este método deve ser implementado pelas subclasses
    public abstract void exibirDetalhes();
}
