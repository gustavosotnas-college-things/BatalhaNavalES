package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;

public class Main {

    public static void main(String[] args) {
        try {

            Jogo jogo = BattleshipMenuUI.menuBattleship();
            System.out.println(jogo.toString());

        } catch (BattleshipException bex) { //esse catch é para exceptions que terminam o programa
            System.err.println(bex.getMessage());
        }
    }
}
