package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Celula;

public class PortaAvioes extends Embarcacao {
    
    Celula tabuleiro;
    private final String nome = "Porta Aviões (T)";
    
    public PortaAvioes(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "P";
    }

    @Override
    public String getNome() {
        return nome;
    }
}
