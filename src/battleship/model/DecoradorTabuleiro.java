package battleship.model;

public class DecoradorTabuleiro extends Tabuleiro {

    Tabuleiro tabuleiro;

    public DecoradorTabuleiro(Tabuleiro umTabuleiro) {
        umTabuleiro = tabuleiro;
    }
    
}
