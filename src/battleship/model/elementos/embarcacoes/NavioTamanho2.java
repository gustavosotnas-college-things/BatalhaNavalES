package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Celula;

public class NavioTamanho2 extends Embarcacao{
    
    Celula tabuleiro;
    private final String nome = "Navio de 2 partes";
    
    public NavioTamanho2(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "2";
    }

    @Override
    public String getNome() {
        return nome;
    }
}
