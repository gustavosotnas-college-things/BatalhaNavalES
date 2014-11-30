package battleship.model.atributosDeJogo;

/**
 * Classe implementadora de DificuldadeDoJogo, define apenas o tamanho do tabuleiro como 15x15
 * e o getter para ele.
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class DifDificil implements DificuldadeDoJogo {

    private final int tamanhoTabuleiro = 15; 

    public int getTamanhoTabuleiro() {
        return tamanhoTabuleiro;
    }

}
