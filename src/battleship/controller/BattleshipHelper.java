/* Classe genérica para colocar funções relacionadas ao controle do menu do jogo, 
 pode alterar o nome ou colocar mais classes dentro desse pacote depois */
package battleship.controller;

import battleship.view.BattleshipMenuUI;
import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.BombaExplosiva;
import battleship.model.elementos.BombaSinalizadora;
import battleship.model.elementos.Celula;
import battleship.model.elementos.Fogo;
import battleship.model.elementos.Tabuleiro;
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

    public static Fogo processarMenuTipoBombaPQQD(int opcao, Celula alvo, ModoPQQD pqqd) throws BattleshipException {

        Fogo retorno = null;
        switch (opcao) {
            case 1:
                if (!(alvo.getNome().equals("Bomba Explosiva"))) {
                    retorno = new BombaExplosiva(alvo);
                    pqqd.setQtdBombasExplosivas(pqqd.getQtdBombasExplosivas() - 1);
                } else {
                    throw new BattleshipGameException("Opção inválida. Já existe uma " + alvo.getNome() + " nesta posição.");
                }
                break;
            case 2:
                if (!((alvo.getNome().equals("Bomba Sinalizadora")) || (alvo.getNome().equals("Bomba Explosiva")))) {

                    retorno = new BombaSinalizadora(alvo);
                    pqqd.setQtdBombasSinalizadoras(pqqd.getQtdBombasSinalizadoras() - 1);
                } else {
                    throw new BattleshipGameException("Opção inválida. Já existe uma " + alvo.getNome() + " nesta posição.");
                }
                break;
            default:
                throw new BattleshipMenuException("Opção inválida. Escolha apenas uma das opções listadas.");
        }
        return retorno;
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

    //Função para pausar o programa até o usuário apertar ENTER (forma semelhante ao "getchar" do C).
    public static void getchar() {

        System.out.print("Aperte ENTER para continuar.");
        new Scanner(System.in).nextLine();
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

    public static void verificaParamJogo(Object param) throws BattleshipMenuException {
        if (param == null) {
            throw new BattleshipMenuException("Jogo não foi iniciado");
        }
    }

    public static void detonaBomba() {
        //verifica o que tem antes da decoração aqua
        // se tiver embarcação,logo, submarino --;
    }

    public static String processarMenuDistribuicaoOrientacao(int opcao) throws BattleshipGameException {
        String retorno = null;
        switch (opcao) {
            case 1:
                retorno = "horizontal";
                break;
            case 2:
                retorno = "vertical";
                break;
            default:
                throw new BattleshipGameException("Opção inválida. Escolha apenas uma das opções listadas.");
        }
        return retorno;
    }

    public static boolean verificaSobreposicao(Tabuleiro tabuleiro, Celula conteudo, int x, int y) throws BattleshipGameException {
        
        if (conteudo.getNome().equals(tabuleiro.tabuleiro[x][y].getNome())) {
            System.out.println("Nesta posição já existe um" + conteudo.getNome());
            return true;
        }
        return false;
    }
}
