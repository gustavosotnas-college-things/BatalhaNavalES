package battleship.model.atributosDeJogo;

/**
 * Define uma família de algoritmos que têm um comportamento diferente 
 * de acordo com a dificuldade de jogo escolhida - tamanho do tabuleiro (padrão Strategy).
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public interface DificuldadeDoJogo {
    //private final int tamanhoTabuleiro; //variável "abstrata"

    /**
     * Função abstrata (getter) que retorna o tamanho do tabuleiro da classe implementadora 
     * instanciada (padrão Strategy).
     * 
     * @return o tamanho do tabuleiro.
     */
    public int getTamanhoTabuleiro();
}
