/* Classe genérica para colocar funções relacionadas ao controle do jogo, 
 pode alterar o nome ou colocar mais classes dentro desse pacote depois */
package battleship.controller;

import battleship.view.Main;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuBattleshipHelper {

    public static void processarOpcaoMainMenu(int opcao) throws BattleshipMenuException {
        switch (opcao) {
            case 1:
//                novojogo.setModoDeJogo(1);
                Main.menuModosDeJogo();
                break;
            case 2:
//                novojogo.setModoDeJogo(2);
                Main.menuModosDeJogo();
                break;
            case 0:
                Main.setFinished(Main.finalizarPrograma());
                break;
            default:
                throw new BattleshipMenuException("EXCEÇÃO: Opção inválida. Escolha apenas uma das opções listadas.");
        }
    }

    public static void processarOpcaoMenuModosJogo(int opcao) throws BattleshipMenuException {
        switch (opcao) {
            case 1:
//                Main.setTabuleiro9x9();
                DifFacil modoFacil = new DifFacil();
                modoFacil.InicializaTabuleiro();
                break;
            case 2:
//                Main.setTabuleiro12x12();
                DifIntermediario modoIntermediario = new DifIntermediario();
                modoIntermediario.InicializaTabuleiro();
                break;
            case 3:
//                Main.setTabuleiro15x15();
                DifDificil modoDificil = new DifDificil();
                modoDificil.InicializaTabuleiro();
                break;
            case 0:
                Main.setFinished(Main.voltarMenuPrincipal());
                break;
            default:
                throw new BattleshipMenuException("EXCEÇÃO: Opção inválida. Escolha apenas uma das opções listadas.");
        }
    }

    public static void sleep(int tempoEmSegundos) {
        try {
            Thread.sleep(tempoEmSegundos * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MenuBattleshipHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
