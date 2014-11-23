package battleship.model.elementos;

import battleship.model.elementos.iteratorJogo.Tabuleiro;

public class DecoradorTabuleiro extends Tabuleiro {

    Tabuleiro tabuleiro;

    public DecoradorTabuleiro(Tabuleiro umTabuleiro) {
        umTabuleiro = tabuleiro;
    }

}
