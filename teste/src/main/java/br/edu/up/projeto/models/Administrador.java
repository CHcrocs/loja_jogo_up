package br.edu.up.projeto.models;

public class Administrador extends Usuario implements Autenticavel {

    public Administrador(int id, String nome, String senha) {
        super(id, nome, senha);
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Administrador: " + nome);
    }

    public void gerenciarJogos() {
        System.out.println("Gerenciando jogos...");
        // Implementar lógica de gerenciamento de jogos aqui
    }
}