package battleship.model;

import battleship.model.elementos.Tabuleiro;
//import battleship.controller.BattleshipMenuException;

import battleship.model.atributosDeJogo.*;

public class Jogo {

    private final ModoDeJogo modoDeJogo;
    private final DificuldadeDoJogo dificuldadeDoJogo;
    private final ModoDeDistribuicao modoDeDistribuicao;
    private Tabuleiro tabuleiro;

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    //Construtor
    public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) /*throws BattleshipMenuException*/ {

        this.modoDeJogo = modoDeJogo;
        this.dificuldadeDoJogo = dificuldadeDoJogo;
        this.modoDeDistribuicao = modoDeDistribuicao;
    }

}
