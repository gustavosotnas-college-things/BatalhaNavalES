package battleship.model.elementos;

public class BombaExplosiva extends Fogo {

    public BombaExplosiva(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String whoami() {
        return tabuleiro.whoami() + "*";
    }
}
