package battleship.model.elementos;

import battleship.model.elementos.iteratorJogo.Tabuleiro;

public abstract class Fogo extends DecoradorTabuleiro{
    
    public Fogo (Tabuleiro tabuleiro){
        super(tabuleiro);
    }
}
