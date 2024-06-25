package br.edu.up.projeto.models;

// Classe que representa um administrador, que é um tipo de usuário e implementa a interface Autenticavel
public class Administrador extends Usuario implements Autenticavel {

    // Construtor para inicializar um administrador com ID, nome e senha
    public Administrador(int id, String nome, String senha) {
        super(id, nome, senha);
    }

    // Método sobrescrito para autenticar o administrador com base na senha
    @Override
    public boolean autenticar(String senha) {
        // Verifica se a senha fornecida corresponde à senha do administrador
        return this.senha.equals(senha);
    }

    // Método sobrescrito para exibir detalhes do administrador
    @Override
    public void exibirDetalhes() {
        // Exibe o nome do administrador
        System.out.println("Administrador: " + nome);
    }

    // Método para gerenciar jogos (implementação futura)
    public void gerenciarJogos() {
        // Mensagem indicando que a lógica de gerenciamento de jogos será implementada
        System.out.println("Gerenciando jogos...");
        // Implementar lógica de gerenciamento de jogos aqui
    }
}
