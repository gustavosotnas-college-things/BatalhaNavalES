package battleship.model.elementos;

public abstract class Fogo extends DecoradorElemento{
    Celula tabuleiro;

    @Override
    public abstract String whoami();
}
