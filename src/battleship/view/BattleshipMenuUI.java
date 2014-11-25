package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.*;

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
        MenuBattleshipHelper.verificaParamJogo(modoDeJogo);

        DificuldadeDoJogo dificuldadeDoJogo = menuDificuldadeJogo();
        MenuBattleshipHelper.verificaParamJogo(dificuldadeDoJogo);

        ModoDeDistribuicao modoDeDistribuicao = modoDistribuicaoJogo();
        MenuBattleshipHelper.verificaParamJogo(modoDeDistribuicao);

        Jogo novoJogo = new Jogo(modoDeJogo, dificuldadeDoJogo, modoDeDistribuicao);
        return novoJogo;
    }

    public static ModoDeJogo menuModoJogo() throws BattleshipMenuException {
        MenuBattleshipHelper.clearScreen(); //"limpa a tela"
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
                modo = MenuBattleshipHelper.processarOpcaoMainMenu(MenuBattleshipHelper.lerOpcao()); //lê a entrada do usuário (teclado)
                setFinished(true);

            } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
            {
                System.err.println(bmex.getMessage());
                MenuBattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }
        return modo;
    }

    public static DificuldadeDoJogo menuDificuldadeJogo() throws BattleshipMenuException {
        MenuBattleshipHelper.clearScreen(); //"limpa a tela"
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
                dificuldade = MenuBattleshipHelper.processarOpcaoMenuDificuldade(MenuBattleshipHelper.lerOpcao()); //lê a entrada do usuário (teclado)
                setFinished(true);
            } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
            {
                System.err.println(bmex.getMessage());
                MenuBattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }
        return dificuldade;
    }

    public static ModoDeDistribuicao modoDistribuicaoJogo() throws BattleshipMenuException {
        MenuBattleshipHelper.clearScreen(); //"limpa a tela"
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
                distribuicao = MenuBattleshipHelper.processarMenuModoDistribuicao(MenuBattleshipHelper.lerOpcao()); //lê a entrada do usuário (teclado)
                setFinished(true);
            } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
            {
                System.err.println(bmex.getMessage());
                MenuBattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }

        return distribuicao;
    }

    public static boolean finalizarPrograma() {
        System.out.println("\nFinalizando programa.\n");
        return true;
    }

}
