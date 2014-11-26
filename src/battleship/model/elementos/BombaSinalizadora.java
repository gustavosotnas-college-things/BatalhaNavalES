package battleship.model.elementos;

public class BombaSinalizadora extends Fogo{

    public BombaSinalizadora(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + "!";
    }

    @Override
    public String getNome() {
        return "Bomba Sinalizadora";
    }
}
