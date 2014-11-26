package battleship.model.elementos;

import battleship.controller.BattleshipGameException;
import battleship.controller.Posicao;

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

    public void setElemento(Celula conteudo,Posicao coord) throws BattleshipGameException {
        if(conteudo.getNome().equals(tabuleiro[coord.getX()][coord.getY()].getNome())) //se já tem tal elemento decorado anteriormente em dada posicao
        {    System.out.println(conteudo.getClass().getSimpleName());
            System.out.println(tabuleiro[coord.getX()][coord.getY()].getClass().getSimpleName());
            throw new BattleshipGameException("Nesta posição já existe um " + conteudo.getNome());
        }else
            tabuleiro[coord.getX()][coord.getY()] = conteudo;
    }

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public int getTamanho() {
        return tamanho;
    }
}
