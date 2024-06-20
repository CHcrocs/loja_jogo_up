package br.edu.up.projeto.models;

import java.util.Collections;
import java.util.List;

public class JogoMultiplayer extends Jogo {
    public Integer numeroControles;
    public Double preco;

    public JogoMultiplayer(String nome, String genero, String classificacao, Integer numeroControles, Boolean online, Double preco){
        super(nome, genero, classificacao, online);
        this.numeroControles = numeroControles;
        this.online = online;
        this.preco = preco;
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

    public Integer getnumeroControles() {
        return numeroControles;
    }

    public void setnumeroControles(Integer numeroControles) {
        this.numeroControles = numeroControles;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public static void listarJogos(List<JogoMultiplayer> jogosMultiplayer){
        if (!jogosMultiplayer.isEmpty()) {
            // Ordena a lista de entradas em ordem alfabética
            Collections.sort(jogosMultiplayer, (e1, e2) -> {
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
            System.out.println("-------------------------------------------jogos multiplayer-------------------------------------------");
            for (JogoMultiplayer jogoMultiplayer : jogosMultiplayer) {
                System.out.println(jogoMultiplayer);
            }
            System.out.println();
        }
    }

    public void procurarJogo(){}

    public void comprarJogo(String nome, Double preco){

    }

    @Override
    public String toString() {
        return 
                "nome = '" + nome + '\'' +
                ", genero = '" + genero + '\'' +
                ", classificacao = '" + classificacao + '\'' +
                ", numeroControles = " + numeroControles +
                ", online = " + online +
                ", preco = " + preco;
    }
}
