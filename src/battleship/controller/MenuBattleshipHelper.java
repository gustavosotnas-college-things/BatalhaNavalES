/* Classe genérica para colocar funções relacionadas ao controle do jogo, 
 pode alterar o nome ou colocar mais classes dentro desse pacote depois */
package battleship.controller;

import battleship.view.BattleshipMenuUI;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.Celula;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuBattleshipHelper {

    public static ModoDeJogo processarOpcaoMainMenu(int opcao) throws BattleshipMenuException {
        ModoDeJogo modoDeJogo = null;
        switch (opcao) {
            case 1:
                modoDeJogo = new ModoTradicional();
                break;
            case 2:
                modoDeJogo = new ModoPQQD();

                break;
            case 0:
                BattleshipMenuUI.setFinished(BattleshipMenuUI.finalizarPrograma());
                break;
            default:
                throw new BattleshipMenuException("EXCEÇÃO: Opção inválida. Escolha apenas uma das opções listadas.");
        }
        return modoDeJogo;
    }

    public static DificuldadeDoJogo processarOpcaoMenuDificuldade(int opcao) throws BattleshipMenuException {
        DificuldadeDoJogo dificuldade = null;
        switch (opcao) {
            case 1:
                dificuldade = new DifFacil();

                break;
            case 2:
                dificuldade = new DifIntermediario();

                break;
            case 3:
                dificuldade = new DifDificil();
                break;
            case 0:
                BattleshipMenuUI.setFinished(BattleshipMenuUI.voltarMenuPrincipal());
                break;
            default:
                throw new BattleshipMenuException("EXCEÇÃO: Opção inválida. Escolha apenas uma das opções listadas.");
        }

        return dificuldade;
    }

    public static ModoDeDistribuicao processarMenuModoDistribuicao(int opcao) throws BattleshipMenuException {

        ModoDeDistribuicao distribuicao = null;
        switch (opcao) {

            case 1:

                distribuicao = new ModoDistribAuto();
                break;

            case 2:

                distribuicao = new ModoDistribManual();
                break;

            case 0:
                BattleshipMenuUI.setFinished(BattleshipMenuUI.voltarMenuPrincipal());
                break;
            default:
                throw new BattleshipMenuException("EXCEÇÃO: Opção inválida. Escolha apenas uma das opções listadas.");
        }

        return distribuicao;
    }

    public static void sleep(int tempoEmSegundos) {
        try {
            Thread.sleep(tempoEmSegundos * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MenuBattleshipHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void verificaModoJogo(Object mode) throws BattleshipMenuException {
        if (mode == null) {
            throw new BattleshipMenuException("EXCEÇÂO: Jogo não inicializado");
        }
    }
}
