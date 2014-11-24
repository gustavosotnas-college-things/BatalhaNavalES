package battleship.model.elementos;

public class BombaSinalizadora extends Fogo{

    public BombaSinalizadora(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + "decorado com Bomba Sinalizadora";
    }
}
