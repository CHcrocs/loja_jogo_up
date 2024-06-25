package br.edu.up.projeto.models;

public class Cliente extends Usuario implements Autenticavel {
    private Conta conta;

    public Cliente(int id, String nome, String senha, Conta conta) {
        super(id, nome, senha);
        this.conta = conta;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Cliente: " + nome + ", Saldo: " + conta.getSaldo());
    }

    public Conta getConta() {
        return conta;
    }
}
