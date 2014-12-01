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

/**
 * Responsavel por todas as operações que auxiliam na execução do jogo como esperara tantos segundos, etc.
 * @author Renan O
 * @author Gustavo Moraes
 */
public class BattleshipHelper {

    private static final int PAGE_SIZE = 50; //variável para saber quanto de tamanho de tela é preciso pular linha

    /**
     * Menu que permite a escolha entre os tipos de Modo de Jogo.
     *
     * @param opcao a opção digitada pelo usuário.
     * @return a interface do manipulação de modo de jogo.
     * @throws BattleshipMenuException lançado quando o usuário digita alguma
     * opção nao listada.
     */
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

    /**
     * Permite a escolha entre os tipos de dificuldades.
     *
     * @param opcao representa a opcao escolhida pelo usuario.
     * @return a interface de dificuldade de jogo.
     * @throws BattleshipMenuException usuário digita uma opcao incorreta.
     */
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

    /**
     * Permite a escolha entre os tipos de distribuição das embarcações.
     *
     * @param opcao representa a opcao escolhida pelo usuario.
     * @return a interface de distibuicao do jogo.
     * @throws BattleshipMenuException usuário digita uma opcao incorreta.
     */
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

    /**
     * Permite executar funções relacionadas a escolha do tipo de bomba.
     *
     * @param opcao tipo de bomba.
     * @param alvo celula a ser atingida.
     * @param pqqd modo de jogo.
     * @return objeto bomba explosiva.
     * @throws BattleshipException quando nao entra em nenhum tipo de bomba
     * listada.
     */
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

    /**
     *
     * Ler a opção digitada pelo usuário.
     *
     * @return opção desejada.
     * @throws BattleshipMenuException o tipo da vaiavel.
     */
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

    /**
     * Função para pausar o programa até o usuário apertar ENTER (forma
     * semelhante ao "getchar" do C).
     */
    public static void getchar() {

        System.out.print("Aperte ENTER para continuar.");
        new Scanner(System.in).nextLine();
    }

    /**
     * Possibilita um pause de certo tempo escolhido.
     *
     * @param tempoEmSegundos tempo desejado de espera
     */
    public static void sleep(int tempoEmSegundos) {
        try {
            Thread.sleep(tempoEmSegundos * 1000);
        } catch (InterruptedException ex) {
            // faça nada
        }
    }

    /**
     * Limpa a tela.
     */
    public static void clearScreen() {
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.println();
        }
    }

    /**
     * Verifica o inicio do jogo.
     *
     * @param param objeto que verifica seu conteudo.
     * @throws BattleshipMenuException nao houver nada no param.
     */
    public static void verificaParamJogo(Object param) throws BattleshipMenuException {
        if (param == null) {
            throw new BattleshipMenuException("Jogo não foi iniciado");
        }
    }

    /**
     * verifica o que tem antes da decoração aqua. se tiver embarcação,logo,
     * submarino --.
     */
    public static void detonaBomba() {

    }

    /**
     * Transforma um inteiro em uma string do tipo de orientação.
     *
     * @param opcao desejada pelo usuário.
     * @return tipo de orientacao
     * @throws BattleshipGameException nao for nenhum tipo de orientação
     * listada.
     */
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

    /**
     * Verifica se um conteudo a ser colocado na celula ja existe.
     *
     * @param conteudo valor de uma celula.
     * @throws BattleshipGameException conteudo ja exitente.
     */
    public static void verificaSobreposicao(Celula conteudo) throws BattleshipGameException {

        if (!(conteudo.whoami().substring(conteudo.whoami().length() - 1).contains("~"))) //se já tem tal elemento decorado anteriormente em dada posicao
        {
            throw new BattleshipGameException("Nesta posição já existe um " + conteudo.getNome());
        }
    }
}
