package battleship.model;

import battleship.model.atributosDeJogo.*;

public class Jogo
{
    private ModoDeJogo modoDeJogo;
    private DificuldadeDoJogo dificuldadeDoJogo;
    private ModoDeDistribuicao modoDeDistribuicao;

    //Construtor
    public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) {
        this.modoDeJogo = modoDeJogo;
        this.dificuldadeDoJogo = dificuldadeDoJogo;
        this.modoDeDistribuicao = modoDeDistribuicao;
    }
}
