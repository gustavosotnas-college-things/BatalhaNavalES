package battleship.model.elementos;

import battleship.model.elementos.iteratorJogo.Tabuleiro;
import java.util.Iterator;

public class DecoradorTabuleiro extends Tabuleiro {

    Tabuleiro tabuleiro;

    public DecoradorTabuleiro(Tabuleiro umTabuleiro) {
        umTabuleiro = tabuleiro;
    }

}
