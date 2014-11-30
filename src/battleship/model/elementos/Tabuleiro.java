package battleship.model.elementos;

import battleship.controller.BattleshipGameException;
import battleship.controller.Posicao;
import battleship.controller.QtdEmbarcacoes;

public class Tabuleiro {

    public Celula[][] tabuleiro;
    private final int numeroJogador;
    private final int tamanho;
    private QtdEmbarcacoes qtdEmbarcacoes;

    public Tabuleiro(int player, int tamanho) {
        this.tabuleiro = new Celula[tamanho][tamanho];
        this.numeroJogador = player;
        this.tamanho = tamanho;
        this.qtdEmbarcacoes = new QtdEmbarcacoes();
        inicializarCelulas();
    }

    private void inicializarCelulas() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                Celula celula = new Terreno();
                celula = new Agua(celula);
                tabuleiro[i][j] = celula;
            }
        }
    }

    public Celula[][] getTabuleiro() {
        return tabuleiro;
    }

    public Celula getElemento(Posicao coord) {
        return tabuleiro[coord.getX()][coord.getY()];
    }

    public void setElementoDistrib(Celula conteudo, Posicao coord) throws BattleshipGameException {
       
        tabuleiro[coord.getX()][coord.getY()] = conteudo;
       
    }

    public void setElementoGame(Celula conteudo, Posicao coord) throws BattleshipGameException {
        if (conteudo.getNome().equals(tabuleiro[coord.getX()][coord.getY()].getNome())) //se já tem tal elemento decorado anteriormente em dada posicao
        {
            throw new BattleshipGameException("Nesta posição já existe um " + conteudo.getNome());
        } else {
            tabuleiro[coord.getX()][coord.getY()] = conteudo;
            registrarExplosao(tabuleiro[coord.getX()][coord.getY()]);
        }
    }

    private void registrarExplosao(Celula celula) {
        switch (celula.whoami().substring(celula.whoami().length() - 1)) {
            case "1":
                qtdEmbarcacoes.decrementarSubmarino();
                break;
            case "2":
                qtdEmbarcacoes.decrementarNavioTamanho2();
                break;
            case "3":
                qtdEmbarcacoes.decrementarNavioTamanho3();
                break;
            case "4":
                qtdEmbarcacoes.decrementarNavioTamanho4();
                break;
            case "P":
                qtdEmbarcacoes.decrementarPortaAvioes();
                break;
        }
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public int getTamanho() {
        return tamanho;
    }

    public QtdEmbarcacoes getQtdEmbarcacoes() {
        return qtdEmbarcacoes;
    }
}
