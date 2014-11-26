package battleship.model.elementos;

public class BombaExplosiva extends Fogo {

    public BombaExplosiva(Celula tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + "*";
    }
}
