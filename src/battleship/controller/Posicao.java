/*
 * Classe que serve apenas para armazenar "x" e "y" do Tabuleiro ("Struct")
 */
package battleship.controller;

import battleship.model.Jogo;

/**
 * Classe responsavel por verificar se os valores de posição são validas
 * e possibilitar retorna-las.
 * @author Renan O
 */
public class Posicao {
    private final int x;
    private final int y;
    
    /**
     *
     * @param x posição da linha de matriz.
     * @param y posição da coluna de matriz.
     * @throws BattleshipGameException as posições nao sao validas.
     */
    public Posicao (int x, int y) throws BattleshipGameException {
        if (isPosicaoTabuleiroValida(x) && isPosicaoTabuleiroValida(y)){
            this.x = x;
            this.y = y;
        } else
            throw new BattleshipGameException ("Posição digitada inválida! Tente novamente.\n");
    }
    
    /**
     * Verifica se o n é um numero valido.
     * @param n inteiro qualquer.
     * @return booleano que mostra se a variavel é valida.
     */
    public static boolean isPosicaoTabuleiroValida (int n) {
        return n >= 0 && n < Jogo.getDificuldadeDoJogo().getTamanhoTabuleiro();
    }

    /**
     * Retorna valor recebido por y.
     * @return valor de y.
     */
    public int getX() {
        return x;
    }

    /**
     * Retornar o valor recebido por x.
     * @return conteudo de x.
     */
    public int getY() {
        return y;
    }
}
