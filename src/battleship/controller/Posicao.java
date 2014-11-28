/*
 * Classe que serve apenas para armazenar "x" e "y" do Tabuleiro ("Struct")
 */
package battleship.controller;

import battleship.controller.BattleshipGameException;
import battleship.model.Jogo;

public class Posicao {
    private final int x;
    private final int y;
    
    public Posicao (int x, int y) throws BattleshipGameException {
        if (isPosicaoTabuleiroValida(x) && isPosicaoTabuleiroValida(y)){
            this.x = x;
            this.y = y;
        } else
            throw new BattleshipGameException ("Posição digitada inválida! Tente novamente.");
    }
    
    public static boolean isPosicaoTabuleiroValida (int n) {
        return n >= 0 && n < Jogo.getDificuldadeDoJogo().getTamanhoTabuleiro();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
