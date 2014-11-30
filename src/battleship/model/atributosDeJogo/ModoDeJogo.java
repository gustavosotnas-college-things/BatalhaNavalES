package battleship.model.atributosDeJogo;

import battleship.model.elementos.Tabuleiro;

/**
 * Define uma família de algoritmos que têm um comportamento diferente 
 * de acordo com o modo de jogo escolhido - Modo Tradicional ou Modo PQQD (padrão Strategy).
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public interface ModoDeJogo {

    /**
     * Função abstrata que obtém a quantidade de bombas sinalizadoras e explosivas 
     * desejadas pelo usuário, tendo portanto nada implementado para essa função 
     * na classe ModoTradicional, apenas na ModoPQQD (padrão Strategy).
     */
    public void setMunicaoInicial();

    /**
     * Função abstrata que faz chamadas para a sequência de turnos do Batalha Naval.
     * 
     * @param tabuleiro  o tabuleiro do jogador oponente
     */
    public void comecarTurno(Tabuleiro tabuleiro);

    /**
     * Função abstrata que faz verificação das condições de fim de jogo do Batalha Naval, 
     * de acordo com a lógica específica de cada classe implementadora (padrão Strategy).
     * 
     * @param tabuleiro  o tabuleiro do jogador a ser verificada as condições
     */
    public void verificaGameOver(Tabuleiro tabuleiro);
}
