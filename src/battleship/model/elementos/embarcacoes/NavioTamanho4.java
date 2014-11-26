package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Celula;

public class NavioTamanho4 extends Embarcacao{
    
    Celula tabuleiro;
    private final String nome = "Navio de 4 partes";
    
    public NavioTamanho4(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "4";
    }

    @Override
    public String getNome() {
        return nome;
    }
}
