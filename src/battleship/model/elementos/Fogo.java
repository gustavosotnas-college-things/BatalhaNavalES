package battleship.model.elementos;

public abstract class Fogo extends DecoradorTabuleiro{
    Tabuleiro tabuleiro;

    @Override
    public abstract String whoami();
}
