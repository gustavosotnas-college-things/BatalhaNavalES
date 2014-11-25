package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Tabuleiro;

public class PortaAvioes extends Embarcacao {
    
    Tabuleiro tabuleiro;
    public PortaAvioes(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "P";
    }
}
