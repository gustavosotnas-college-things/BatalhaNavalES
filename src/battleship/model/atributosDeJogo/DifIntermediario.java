package battleship.model.atributosDeJogo;

/**
 * Classe implementadora de DificuldadeDoJogo, define apenas o tamanho do tabuleiro como 12x12
 * e o getter para ele.
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class DifIntermediario implements DificuldadeDoJogo {

    private final int tamanhoTabuleiro = 12;

    public int getTamanhoTabuleiro() {
        return tamanhoTabuleiro;
    }
    
}