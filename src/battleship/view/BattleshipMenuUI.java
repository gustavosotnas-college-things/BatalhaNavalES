package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.Tabuleiro;

public class BattleshipMenuUI {

    private static boolean finished; //variavel que serve de "flag" para término de loops de menu

    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean aFinished) {
        finished = aFinished;
    }

    public static void menuHeaderBattleship() {
        System.out.println("\n=================================================");
        System.out.println("\t\tBATALHA NAVAL");
        System.out.println("=================================================");
    }

    public static Jogo menuBattleship() throws BattleshipMenuException {

        ModoDeJogo modoDeJogo = menuModoJogo();
        BattleshipHelper.verificaParamJogo(modoDeJogo);

        DificuldadeDoJogo dificuldadeDoJogo = menuDificuldadeJogo();
        BattleshipHelper.verificaParamJogo(dificuldadeDoJogo);

        ModoDeDistribuicao modoDeDistribuicao = modoDistribuicaoJogo();
        BattleshipHelper.verificaParamJogo(modoDeDistribuicao);

        Jogo novoJogo = new Jogo(modoDeJogo, dificuldadeDoJogo, modoDeDistribuicao);
        return novoJogo;
    }

    public static ModoDeJogo menuModoJogo() {
        BattleshipHelper.clearScreen(); //"limpa a tela"
        setFinished(false); //inicializando com false para entrar no loop

        ModoDeJogo modo = null;
        while (!isFinished()) {
            menuHeaderBattleship();
            System.out.println("\nMENU\n");
            System.out.println("Escolha o modo do jogo: \n");
            System.out.println("1 - Modo Tradicional");
            System.out.println("2 - Modo PQQD");
            System.out.println("0 - Sair\n");
            System.out.print("\nOpção: ");
            try {
                modo = BattleshipHelper.processarOpcaoMainMenu(BattleshipHelper.lerOpcao()); //lê a entrada do usuário (teclado)
                setFinished(true);

            } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
            {
                System.err.println(bmex.getMessage());
                BattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }
        return modo;
    }

    public static DificuldadeDoJogo menuDificuldadeJogo() {
        BattleshipHelper.clearScreen(); //"limpa a tela"
        setFinished(false);

        DificuldadeDoJogo dificuldade = null;
        while (!isFinished()) {
            menuHeaderBattleship();
            System.out.println("\nMENU\n");
            System.out.println("Escolha a dificuldade: \n");
            System.out.println("1 - Fácil");
            System.out.println("2 - Intermediário");
            System.out.println("3 - Difícil");
            System.out.println("0 - Sair");
            System.out.print("\nOpção: ");
            try {
                dificuldade = BattleshipHelper.processarOpcaoMenuDificuldade(BattleshipHelper.lerOpcao()); //lê a entrada do usuário (teclado)
                setFinished(true);
            } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
            {
                System.err.println(bmex.getMessage());
                BattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }
        return dificuldade;
    }

    public static ModoDeDistribuicao modoDistribuicaoJogo() {
        BattleshipHelper.clearScreen(); //"limpa a tela"
        setFinished(false);

        ModoDeDistribuicao distribuicao = null;
        while (!isFinished()) {
            menuHeaderBattleship();
            System.out.println("\nMENU\n");
            System.out.println("Escolha o tipo de distribuição: \n");
            System.out.println("1 - Modo Automático");
            System.out.println("2 - Modo Manual");
            System.out.println("0 - Sair\n");
            System.out.print("\nOpção: ");
            try {
                distribuicao = BattleshipHelper.processarMenuModoDistribuicao(BattleshipHelper.lerOpcao()); //lê a entrada do usuário (teclado)
                setFinished(true);
            } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
            {
                System.err.println(bmex.getMessage());
                BattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }

        return distribuicao;
    }

    public static int MenuTipoBomba() {

        BattleshipHelper.clearScreen(); //"limpa a tela"
        int x = 0;
        menuHeaderBattleship();
        System.out.println("Escolha um dos tipos de bombas: ");
        System.out.println("1. Bomba Explosiva");
        System.out.println("2. Bomba Sinalizadora");
        System.out.print("\nOpção: ");
        try {
            x = BattleshipHelper.lerOpcao(); //lê a entrada do usuário (teclado)
        } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
        {
            System.err.println(bmex.getMessage());
            BattleshipHelper.sleep(1); //pausa de 1 segundo
        }
        return x;
    }

    public static boolean finalizarPrograma() {
        System.out.println("\nFinalizando programa.\n");
        return true;
    }
    
    public static void menuMostraJogador(Tabuleiro tabuleiro){
        System.out.println("É A VEZ DO JOGADOR " + tabuleiro.getTamanho());
    }

}
