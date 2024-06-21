package br.edu.up.projeto.models;

import java.util.Collections;
import java.util.List;

public class JogoSingleplayer extends Jogo {

    public JogoSingleplayer(String nome, String genero, String classificacao, Boolean online) {
        super(nome, genero, classificacao, online);

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

    public static void listarJogos(List<JogoSingleplayer> jogosSingleplayer) {
        if (!jogosSingleplayer.isEmpty()) {
            // Ordena a lista de entradas em ordem alfabética
            Collections.sort(jogosSingleplayer, (e1, e2) -> {
                String nome1 = e1.getNome();
                String nome2 = e2.getNome();
                if (nome1 == null) {
                    return (nome2 == null) ? 0 : -1;
                }
                if (nome2 == null) {
                    return 1;
                }
                return nome1.compareTo(nome2);
            });
            System.out.println(
                    "-------------------------------------------jogos singleplayes-------------------------------------------");
            for (JogoSingleplayer jogoSingleplayer : jogosSingleplayer) {
                System.out.println(jogoSingleplayer);
            }
            System.out.println();
        }
    }

    public void procurarJogo() {
    }

    public void comprarJogo(String nome, Double preco) {

    }

    @Override
    public String toString() {
        return "nome = '" + nome + '\'' +
                ", genero = '" + genero + '\'' +
                ", classificacao = '" + classificacao + '\'' +
                ", online = " + online;
    }
}
