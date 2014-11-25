package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Tabuleiro;

public class Submarino extends Embarcacao{
    Tabuleiro tabuleiro;
    public Submarino(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "1";
    }
}
