package battleship.model.elementos;

import battleship.model.elementos.iteratorJogo.Tabuleiro;

public class BombaSinalizadora extends Fogo{

    //Sugestão do NetBeans criar o Construtor (parece que ele já sabe que a gnt vai fazer o decorator kkkk)
    public BombaSinalizadora(Tabuleiro tabuleiro) {
        super(tabuleiro);
    }
    
}
