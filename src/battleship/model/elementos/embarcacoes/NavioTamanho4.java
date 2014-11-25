package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Tabuleiro;

public class NavioTamanho4 extends Embarcacao{
    Tabuleiro tabuleiro;
    public NavioTamanho4(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "4";
    }
}
