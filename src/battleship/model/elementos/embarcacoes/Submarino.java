package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Celula;

public class Submarino extends Embarcacao{
    
    Celula tabuleiro;
    private final String nome = "Submarino";
    
    public Submarino(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "S";
    }

    @Override
    public String getNome() {
        return nome;
    }
}
