package battleship.model.elementos;

/**
 * Decoração de classe base.
 * @author Renan O
 * @author Gusstavo Moraes
 */
public class BombaSinalizadora extends Fogo{

    /**
     * a variavel tabuleiro recebe a celula como parametro.
     * @param tabuleiro celula de tabuleiro.
     */
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
