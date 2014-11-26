package battleship.model.elementos.embarcacoes;

import battleship.model.elementos.Embarcacao;
import battleship.model.elementos.Celula;

public class NavioTamanho3 extends Embarcacao{
    
    Celula tabuleiro;
    private final String nome = "Navio de 3 partes";

    public NavioTamanho3(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    @Override
    public String whoami() {
        return tabuleiro.whoami() + "3";
    }

    @Override
    public String getNome() {
        return nome;
    }
}
