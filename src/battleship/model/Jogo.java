package battleship.model;

import battleship.model.elementos.Tabuleiro;
//import battleship.controller.BattleshipMenuException;
import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.*;
import battleship.model.elementos.embarcacoes.Submarino;
import battleship.view.BattleshipGameUI;

public class Jogo {

    private final ModoDeJogo modoDeJogo;
    private final DificuldadeDoJogo dificuldadeDoJogo;
    private final ModoDeDistribuicao modoDeDistribuicao;
    private Tabuleiro[][] tabuleiro;

    public Tabuleiro[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    //Construtor
    public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) /*throws BattleshipMenuException*/ {

        this.modoDeJogo = modoDeJogo;
        this.dificuldadeDoJogo = dificuldadeDoJogo;
        this.modoDeDistribuicao = modoDeDistribuicao;
    }

    public void comecarJogo() {

        tabuleiro = new Tabuleiro[dificuldadeDoJogo.getTamanhoTabuleiro()][dificuldadeDoJogo.getTamanhoTabuleiro()];
        for (int i = 0; i < dificuldadeDoJogo.getTamanhoTabuleiro(); i++) {
            for (int j = 0; j < dificuldadeDoJogo.getTamanhoTabuleiro(); j++) {
                Tabuleiro celula = new Celula();
                celula = new Agua(celula);
                tabuleiro[i][j] = celula;
            }
        }
        
        //EH TESTE!!
        BattleshipGameUI.exibeTabuleiro(tabuleiro, dificuldadeDoJogo);
    }
}
