package battleship.model;

public class CelulaEmbarcacao extends DecoradorTabuleiro{
    
    public CelulaEmbarcacao (Tabuleiro tabuleiro){
        super(tabuleiro);
        status = "pedaco de embarcacao";
    }
}
