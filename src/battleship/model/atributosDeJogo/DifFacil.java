package battleship.model.atributosDeJogo;

/**
 * Classe implementadora de DificuldadeDoJogo, define apenas o tamanho do tabuleiro como 9x9
 * e o getter para ele.
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class DifFacil implements DificuldadeDoJogo {

    private final int tamanhoTabuleiro = 9;

    public int getTamanhoTabuleiro() {
        return tamanhoTabuleiro;
    }

}
