/* Classe genérica para colocar funções relacionadas ao controle do menu do jogo, 
 pode alterar o nome ou colocar mais classes dentro desse pacote depois */
package battleship.controller;

import battleship.view.BattleshipMenuUI;
import battleship.model.atributosDeJogo.*;
import java.util.Scanner;

public class BattleshipHelper {

    private static final int PAGE_SIZE = 50; //variável para saber quanto de tamanho de tela é preciso pular linha

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
                throw new BattleshipMenuException("Opção inválida. Escolha apenas uma das opções listadas.");
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
                BattleshipMenuUI.setFinished(BattleshipMenuUI.finalizarPrograma());
                break;
            default:
                throw new BattleshipMenuException("Opção inválida. Escolha apenas uma das opções listadas.");
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
                BattleshipMenuUI.setFinished(BattleshipMenuUI.finalizarPrograma());
                break;
            default:
                throw new BattleshipMenuException("Opção inválida. Escolha apenas uma das opções listadas.");
        }
        return distribuicao;
    }
    
    public static int lerOpcao() throws BattleshipMenuException {
        Scanner leitor = new Scanner(System.in);
        int opcao;
        try {
            opcao = Integer.parseInt(leitor.nextLine().trim());
        } catch (NumberFormatException ex) {
            throw new BattleshipMenuException("Opção inválida. Digite apenas números!");
        }
        return opcao;
    }

    public static void sleep(int tempoEmSegundos) {
        try {
            Thread.sleep(tempoEmSegundos * 1000);
        } catch (InterruptedException ex) {
            // faça nada
        }
    }
    
    public static void clearScreen() {
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.println();
        }
    }

    public static void verificaParamJogo (Object param) throws BattleshipMenuException {
        if (param == null) {
            throw new BattleshipMenuException("Jogo não foi iniciado");
        }
    }
    
    public static void DetonaBomba(){
        //verifica o que tem antes da decoração aqua
        // se tiver embarcação,logo, submarino --;
    }
}
