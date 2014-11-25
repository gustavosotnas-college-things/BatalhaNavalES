/* Classe genérica para colocar funções relacionadas ao controle do jogo, 
 pode alterar o nome ou colocar mais classes dentro desse pacote depois */

package battleship.controller;

import battleship.model.Posicao;
import battleship.model.atributosDeJogo.DificuldadeDoJogo;

public class GameBattleshipHelper {
    
    public static Posicao setarCoordenadasTabuleiro(int x, int y, DificuldadeDoJogo difJogo) throws BattleshipGameException {
        return new Posicao(x, y, difJogo);
    }
}
