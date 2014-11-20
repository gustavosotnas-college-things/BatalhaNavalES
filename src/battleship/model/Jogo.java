package battleship.model;

import battleship.model.atributosDeJogo.*;

public class Jogo
{
    //private int modoDeJogo; //1 para "Modo Tradicional" e 2 para "Modo PQQD"
    private ModoDeJogo modoDeJogo;
    //private int dificuldadeDoJogo; //1 para "Fácil (9x9)", 2 para "Intermediário (12x12)" e 3 para "Difícil (15x15)"
    private DificuldadeDoJogo dificuldadeDoJogo;
    private int modoDeDistribuicao; //1 para Distribuição da frota "Automática" e 2 para Distribuição da frota "Manual"
    
    //OBS.: depois temos que terminar de aplicar o Strategy para um desses campos, igual o problema do pato.

    public int getModoDeJogo() {
        return modoDeJogo;
    }

    public void setModoDeJogo(int modoDeJogo) {
        this.modoDeJogo = modoDeJogo;
    }

    public int getDificuldadeDoJogo() {
        return dificuldadeDoJogo;
    }

    public void setDificuldadeDoJogo(int dificuldadeDoJogo) {
        this.dificuldadeDoJogo = dificuldadeDoJogo;
    }

    public int getModoDeDistribuicao() {
        return modoDeDistribuicao;
    }

    public void setModoDeDistribuicao(int modoDeDistribuicao) {
        this.modoDeDistribuicao = modoDeDistribuicao;
    }
}
