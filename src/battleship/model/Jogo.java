package battleship.model;

import battleship.model.elementos.Tabuleiro;
//import battleship.controller.BattleshipMenuException;

import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.*;

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
    
    public void comecarJogo() {
        // implementação só pra teste do Decorator
        tabuleiro = new Celula();
        tabuleiro = new Agua(tabuleiro); //decorando celula com agua
        tabuleiro = new Embarcacao(tabuleiro); //decorando celula com embarcacao
        tabuleiro = new BombaSinalizadora(tabuleiro); //decorando celula com bomba sinalizadora
        System.out.println(tabuleiro.whoami());
    }
}
