package battleship.view;

import battleship.model.Jogo;
import battleship.model.atributosDeJogo.DificuldadeDoJogo;
import battleship.model.elementos.*;

public class BattleshipGameUI {

    public static void exibeTabuleiro(Tabuleiro[][] tabuleiro, DificuldadeDoJogo dificuldadeDoJogo) {

        for (int i = 0; i < dificuldadeDoJogo.getTamanhoTabuleiro(); i++) {

            for (int j = 0; j < dificuldadeDoJogo.getTamanhoTabuleiro(); j++) {

                System.out.print(" " + tabuleiro[i][j].whoami() + "  ");
            }
            System.out.println("\n");
        }
    }
}
