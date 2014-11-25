package battleship.model;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipMenuException;
import battleship.model.elementos.Tabuleiro;
import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.*;
import battleship.view.BattleshipGameUI;

public class Jogo {

    private final ModoDeJogo modoDeJogo;
    private final DificuldadeDoJogo dificuldadeDoJogo;
    private final ModoDeDistribuicao modoDeDistribuicao;
    private Tabuleiro[][] tabuleiroP1; //tabuleiro do Jogador 1
    private Tabuleiro[][] tabuleiroP2; //tabuleiro do Jogador 2

    //Construtor
    public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) /*throws BattleshipMenuException*/ {

        this.modoDeJogo = modoDeJogo;
        this.dificuldadeDoJogo = dificuldadeDoJogo;
        this.modoDeDistribuicao = modoDeDistribuicao;
    }

    //Getters e setters
    public Tabuleiro[][] getTabuleiroP1() {
        return tabuleiroP1;
    }

    public void setTabuleiroP1(Tabuleiro[][] tabuleiroP1) {
        this.tabuleiroP1 = tabuleiroP1;
    }
    
    public Tabuleiro[][] getTabuleiroP2() {
        return tabuleiroP2;
    }

    public void setTabuleiroP2(Tabuleiro[][] tabuleiroP2) {
        this.tabuleiroP2 = tabuleiroP2;
    }

    //Métodos
    public void comecarJogo() throws BattleshipException {
        inicializarTabuleiros();
        BattleshipGameUI.menuFazerDistribTabuleiro(1, tabuleiroP1, modoDeJogo, dificuldadeDoJogo, modoDeDistribuicao); //Jogador 1
        //BattleshipGameUI.menuFazerDistribTabuleiro(2, tabuleiroP2, modoDeJogo, dificuldadeDoJogo, modoDeDistribuicao); //Jogador 2
    }

    private void inicializarTabuleiros() {
        tabuleiroP1 = new Tabuleiro[dificuldadeDoJogo.getTamanhoTabuleiro()][dificuldadeDoJogo.getTamanhoTabuleiro()];
        tabuleiroP2 = new Tabuleiro[dificuldadeDoJogo.getTamanhoTabuleiro()][dificuldadeDoJogo.getTamanhoTabuleiro()];
        for (int i = 0; i < dificuldadeDoJogo.getTamanhoTabuleiro(); i++) {
            for (int j = 0; j < dificuldadeDoJogo.getTamanhoTabuleiro(); j++) {
                Tabuleiro celula = new Celula();
                celula = new Agua(celula);
                tabuleiroP1[i][j] = celula;
                tabuleiroP2[i][j] = celula;
            }
        }
    }
}
