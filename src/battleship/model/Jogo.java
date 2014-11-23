package battleship.model;

import battleship.controller.BattleshipMenuException;

import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.*;

public class Jogo {

    private ModoDeJogo modoDeJogo;
    private DificuldadeDoJogo dificuldadeDoJogo;
    private ModoDeDistribuicao modoDeDistribuicao;
    private Tabuleiro tabuleiro;

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    //Construtor
    public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) throws BattleshipMenuException {

        this.modoDeJogo = modoDeJogo;
        this.dificuldadeDoJogo = dificuldadeDoJogo;
        this.modoDeDistribuicao = modoDeDistribuicao;
    }

}
