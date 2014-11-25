package battleship.model.elementos;

public abstract class Fogo extends DecoradorElemento{
    Tabuleiro tabuleiro;

    @Override
    public abstract String whoami();
}
