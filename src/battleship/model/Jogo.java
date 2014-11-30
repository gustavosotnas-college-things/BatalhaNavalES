package battleship.model;

import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.*;
import battleship.view.BattleshipGameUI;
import battleship.view.BattleshipMenuUI;

/**
 * Classe que contém todos os dados necessários para a execução do Batalha Naval.
 * Interliga todas as classes de lógica, regras de negócio e funções do jogo.
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class Jogo {

    private static ModoDeJogo modoDeJogo;
    private static DificuldadeDoJogo dificuldadeDoJogo;
    private static ModoDeDistribuicao modoDeDistribuicao;
    private Tabuleiro tabuleiroP1; //tabuleiro do Jogador 1
    private Tabuleiro tabuleiroP2; //tabuleiro do Jogador 2
    private static boolean gameOver = false;

    /**
     * Getter da variável estática de interface de modo de jogo.
     * ModoDeJogo define uma família de algoritmos que têm um comportamento diferente 
     * de acordo com o modo de jogo escolhido - Modo Tradicional ou Modo PQQD (padrão Strategy).
     * 
     * @return a interface que define os métodos do modo de jogo instanciado anteriormente.
     */
    public static ModoDeJogo getModoDeJogo() {
        return modoDeJogo;
    }

    /**
     * Getter da variável estática de interface de dificuldade do jogo.
     * DificuldadeDoJogo define uma família de algoritmos que têm um comportamento diferente 
     * de acordo com a dificuldade de jogo escolhida - tamanho do tabuleiro (padrão Strategy).
     * 
     * @return a interface que define os métodos de dificuldade do jogo instanciado anteriormente.
     */
    public static DificuldadeDoJogo getDificuldadeDoJogo() {
        return dificuldadeDoJogo;
    }

    /**
     * Getter da variável estática da interface de modo de distribuição de embarcações 
     * no tabuleiro do jogo.
     * ModoDeDistribuicao define uma família de algoritmos que têm um comportamento diferente 
     * de acordo com o modo de distribuição escolhido - Distribuição Automática ou Manual (padrão Strategy).
     * 
     * @return a interface que define os métodos do modo de distribuição instanciado anteriormente.
     */
    public static ModoDeDistribuicao getModoDeDistribuicao() {
        return modoDeDistribuicao;
    }

    /**
     * Getter da variável booleana de flag da estruturas de repetição de turnos de jogo.
     * @return a "flag" que marca o fim do jogo.
     */
    public static boolean isGameOver() {
        return gameOver;
    }

    /**
     * Setter da variável booleana de flag da estruturas de repetição de turnos de jogo.
     * @param aGameOver a "flag" que marca o fim do jogo.
     */
    public static void setGameOver(boolean aGameOver) {
        gameOver = aGameOver;
    }

    /**
     * Cria um novo jogo (objeto) com todos os requisitos (atributos) necessários para 
     * o seu funcionamento (interfaces).
     * 
     * @param modoDeJogo a interface que define os métodos do modo de jogo instanciado anteriormente.
     * @param dificuldadeDoJogo a interface que define os métodos de dificuldade do jogo instanciado anteriormente.
     * @param modoDeDistribuicao a interface que define os métodos do modo de distribuição instanciado anteriormente.
     */
        public Jogo(ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, ModoDeDistribuicao modoDeDistribuicao) /*throws BattleshipMenuException*/ {

        Jogo.modoDeJogo = modoDeJogo;
        Jogo.dificuldadeDoJogo = dificuldadeDoJogo;
        Jogo.modoDeDistribuicao = modoDeDistribuicao;
    }

    /**
     * Principal método da classe, o main que o chama e este método chama 
     * todos os outros métodos em sequência de jogo Batalha Naval.
     * 
     * @see battleship.view.Main#main(java.lang.String[])
     */
    public void comecarJogo(){

        inicializarTabuleiros();
        BattleshipGameUI.menuFazerDistribuicaoTabuleiro(tabuleiroP1, modoDeJogo, modoDeDistribuicao); //Jogador 1
        BattleshipGameUI.menuFazerDistribuicaoTabuleiro(tabuleiroP2, modoDeJogo, modoDeDistribuicao); //Jogador 2
        while (!gameOver) {
            
            BattleshipGameUI.menuMostraJogador(tabuleiroP1.getNumeroJogador());
            modoDeJogo.comecarTurno(tabuleiroP2);
            if (!gameOver) {
                
                BattleshipGameUI.menuMostraJogador(tabuleiroP2.getNumeroJogador());
                modoDeJogo.comecarTurno(tabuleiroP1);
            }
        }
    }

    private void inicializarTabuleiros() {
        tabuleiroP1 = new Tabuleiro(1, dificuldadeDoJogo.getTamanhoTabuleiro());
        tabuleiroP2 = new Tabuleiro(2, dificuldadeDoJogo.getTamanhoTabuleiro());
    }
}
