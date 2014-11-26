package battleship.model.elementos;

import battleship.model.Posicao;

public class Tabuleiro {
    
    private Celula[][] tabuleiro;
    private final int numeroJogador;
    private final int tamanho;
    
    public Tabuleiro(int player, int tamanho){
        this.tabuleiro = new Celula[tamanho][tamanho];
        this.numeroJogador = player;
        this.tamanho = tamanho;
        inicializarCelulas();
    }
    
    private void inicializarCelulas(){
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
    
    public Celula getElemento(Posicao coord){
        return tabuleiro[coord.getX()][coord.getY()];
    }

    public void setElemento(Celula conteudo,Posicao coord) {
        tabuleiro[coord.getX()][coord.getY()] = conteudo;
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public int getTamanho() {
        return tamanho;
    }
}
