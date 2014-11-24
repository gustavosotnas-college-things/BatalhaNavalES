package battleship.model.elementos;

public class Embarcacao extends DecoradorTabuleiro {
    Tabuleiro tabuleiro;
    
    public Embarcacao (Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + " decorado com Embarcacao";
    }
}
