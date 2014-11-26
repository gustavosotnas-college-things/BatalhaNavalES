package battleship.model.elementos;

public class Agua extends DecoradorElemento{
    Celula tabuleiro;
    
    public Agua (Celula tabuleiro){
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + "~";
    }
}
