package battleship.model;

public class Agua extends DecoradorTabuleiro{
    
    public Agua (Tabuleiro tabuleiro){
        super(tabuleiro);
        status = "agua";
    }
}
