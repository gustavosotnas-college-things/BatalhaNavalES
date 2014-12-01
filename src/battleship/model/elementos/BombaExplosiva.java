package battleship.model.elementos;

/**
 * Decoração de classe base.
 * @author Renan O
 * @author Gusstavo Moraes
 */
public class BombaExplosiva extends Fogo {

    /**
     * a variavel tabuleiro recebe a celula como parametro.
     * @param tabuleiro celula de tabuleiro.
     */
    public BombaExplosiva(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + "*";
    }

    @Override
    public String getNome() {
        return "Bomba Explosiva";
    }
}
