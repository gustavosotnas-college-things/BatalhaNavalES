/* Classe genérica para colocar funções relacionadas ao controle do jogo, 
 pode alterar o nome ou colocar mais classes dentro desse pacote depois */
package battleship.controller;

import battleship.view.BattleshipMenuUI;
import battleship.model.atributosDeJogo.*;

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
            // faça nada
        }
    }

    public static void verificaParamJogo (Object param) throws BattleshipMenuException {
        if (param == null) {
            throw new BattleshipMenuException("EXCEÇÂO: Jogo não inicializado");
        }
    }
}
