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
    private Tabuleiro tabuleiroP2; //tabuleiro do Jogador 2
    private static boolean gameOver = false;

    public static ModoDeJogo getModoDeJogo() {
        return modoDeJogo;
    }

    public static DificuldadeDoJogo getDificuldadeDoJogo() {
        return dificuldadeDoJogo;
    }

    public static ModoDeDistribuicao getModoDeDistribuicao() {
        return modoDeDistribuicao;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean aGameOver) {
        gameOver = aGameOver;
    }

    //Construtor
    public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) /*throws BattleshipMenuException*/ {

        Jogo.modoDeJogo = modoDeJogo;
        Jogo.dificuldadeDoJogo = dificuldadeDoJogo;
        Jogo.modoDeDistribuicao = modoDeDistribuicao;
    }

    //Métodos
    public void comecarJogo() throws BattleshipException {
        boolean verifica;
        gameOver = false;
        inicializarTabuleiros();
        BattleshipGameUI.menuFazerDistribuicaoTabuleiro(tabuleiroP1, modoDeJogo, modoDeDistribuicao); //Jogador 1
        BattleshipGameUI.menuFazerDistribuicaoTabuleiro(tabuleiroP2, modoDeJogo, modoDeDistribuicao); //Jogador 2
        while (!gameOver) {

            verifica = modoDeJogo.comecarTurno(tabuleiroP2);
            if (verifica == false) {
                modoDeJogo.comecarTurno(tabuleiroP1);
            }

        }
    }

    private void inicializarTabuleiros() {
        tabuleiroP1 = new Tabuleiro(1, dificuldadeDoJogo.getTamanhoTabuleiro());
        tabuleiroP2 = new Tabuleiro(2, dificuldadeDoJogo.getTamanhoTabuleiro());
    }
}
