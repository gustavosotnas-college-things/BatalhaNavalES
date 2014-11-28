package battleship.model;

import battleship.controller.BattleshipException;
import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.*;
import battleship.view.BattleshipGameUI;

public class Jogo {

    private static ModoDeJogo modoDeJogo;
    private static DificuldadeDoJogo dificuldadeDoJogo;
    private static ModoDeDistribuicao modoDeDistribuicao;
    private Tabuleiro tabuleiroP1; //tabuleiro do Jogador 1

    public Tabuleiro getTabuleiroP1() {
        return tabuleiroP1;
    }
    private Tabuleiro tabuleiroP2; //tabuleiro do Jogador 2

    public static ModoDeJogo getModoDeJogo() {
        return modoDeJogo;
    }

    public static DificuldadeDoJogo getDificuldadeDoJogo() {
        return dificuldadeDoJogo;
    }

    public static ModoDeDistribuicao getModoDeDistribuicao() {
        return modoDeDistribuicao;
    }

    //Construtor
    public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) /*throws BattleshipMenuException*/ {

        Jogo.modoDeJogo = modoDeJogo;
        Jogo.dificuldadeDoJogo = dificuldadeDoJogo;
        Jogo.modoDeDistribuicao = modoDeDistribuicao;
    }

    //Métodos
    public void comecarJogo() throws BattleshipException {
        inicializarTabuleiros();
        BattleshipGameUI.menuFazerDistribuicaoTabuleiro(1, tabuleiroP1, modoDeJogo, modoDeDistribuicao); //Jogador 1
        BattleshipGameUI.menuFazerDistribuicaoTabuleiro(2, tabuleiroP2, modoDeJogo, modoDeDistribuicao); //Jogador 2
    }

    private void inicializarTabuleiros() {
        tabuleiroP1 = new Tabuleiro(1, dificuldadeDoJogo.getTamanhoTabuleiro());
        tabuleiroP2 = new Tabuleiro(2, dificuldadeDoJogo.getTamanhoTabuleiro());
    }
}
