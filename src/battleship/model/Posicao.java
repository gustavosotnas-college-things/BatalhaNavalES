/*
 * Classe que serve apenas para armazenar "x" e "y" do Tabuleiro ("Struct")
 */
package battleship.model;

import battleship.controller.BattleshipGameException;
import battleship.model.atributosDeJogo.DificuldadeDoJogo;

public class Posicao {
    private final int x;
    private final int y;
    
    public Posicao (int x, int y, DificuldadeDoJogo difJogo) throws BattleshipGameException {
        if (x >= 0 && x < difJogo.getTamanhoTabuleiro())
            this.x = x;
        else
            throw new BattleshipGameException ("Posição digitada inválida! Tente novamente.");
        if (y >= 0 && y < difJogo.getTamanhoTabuleiro())
            this.y = y;
        else
            throw new BattleshipGameException ("Posição digitada inválida! Tente novamente.");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
