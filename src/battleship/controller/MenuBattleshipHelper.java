/* Classe genérica para colocar funções relacionadas ao controle do jogo, 
pode alterar o nome ou colocar mais classes dentro desse pacote depois */

package battleship.controller;

import battleship.view.Main;

public class MenuBattleshipHelper {
    
    public static void processarOpcaoMainMenu (int opcao) throws BattleshipException
    {
        switch (opcao)
        {
            case 1:
                Main.menuModoTradicional();
                break;
            case 2:
                Main.menuModoPQQD();
                break;
            case 0:
                Main.finalizarPrograma();
                break;
        }
    }
}
