package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;

/**
 * Classe principal do BatalhaNavalES. É criado um novo jogo e dado comando 
 * para dar início a ele.
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class Main {

    /**
     * Função inicial do BatalhaNaval. É feita uma chamada para começar o menu
     * criando um novo Jogo e executando o mesmo.
     * 
     * @param args argumentos de CLI (não usado)
     */
    public static void main(String[] args) {
        try {

            Jogo jogo = BattleshipMenuUI.menuBattleship();
            jogo.comecarJogo();

        } catch (BattleshipException bex) { //esse catch é para exceptions que terminam o programa
            System.err.println(bex.getMessage());
        }
    }
}
