package battleship.model.elementos;

public class Agua extends DecoradorElemento{
    Tabuleiro tabuleiro;
    
    public Agua (Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + "~";
    }
}
