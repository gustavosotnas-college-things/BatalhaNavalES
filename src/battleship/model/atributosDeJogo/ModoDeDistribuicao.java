package battleship.model.atributosDeJogo;

import battleship.model.elementos.Tabuleiro;

/**
 * Define uma família de algoritmos que têm um comportamento diferente 
 * de acordo com o modo de distribuição escolhido - Distribuição Automática ou Manual (padrão Strategy).
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public interface ModoDeDistribuicao {

    /**
     * Função abstrata que faz a distribuição das embarcações segundo o implementado pela 
     * classe implementadora instanciada (padrão Strategy).
     * 
     * @param tabuleiro o tabuleiro a ser manipulado.
     */
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro);
    
}
