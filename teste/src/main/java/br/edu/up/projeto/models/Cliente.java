package br.edu.up.projeto.models;

// Classe que representa um cliente, que é um tipo de usuário e implementa a interface Autenticavel
public class Cliente extends Usuario implements Autenticavel {
    private Conta conta; // Conta associada ao cliente

    // Construtor para inicializar um cliente com ID, nome, senha e conta
    public Cliente(int id, String nome, String senha, Conta conta) {
        super(id, nome, senha);
        this.conta = conta; // Inicializa a conta do cliente
    }

    // Método sobrescrito para autenticar o cliente com base na senha
    @Override
    public boolean autenticar(String senha) {
        // Verifica se a senha fornecida corresponde à senha do cliente
        return this.senha.equals(senha);
    }

    // Método sobrescrito para exibir detalhes do cliente
    @Override
    public void exibirDetalhes() {
        // Exibe o nome do cliente e o saldo da conta associada
        System.out.println("Cliente: " + nome + ", Saldo: " + conta.getSaldo());
    }

    // Método para obter a conta associada ao cliente
    public Conta getConta() {
        return conta; // Retorna a conta do cliente
    }
}
