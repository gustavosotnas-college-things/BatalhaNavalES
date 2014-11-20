package battleship.model.elementos;

public class Fogo extends DecoradorTabuleiro{
    
    public Fogo (Tabuleiro tabuleiro){
        super(tabuleiro);
        status = "fogo";
    }
}
