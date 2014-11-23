package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.*;
import java.util.Scanner;

public class BattleshipMenuUI {

    private static boolean finished; //variavel que serve de "flag" para término de loops de menu

    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean aFinished) {
        finished = aFinished;
    }

    private static void menuHeaderBattleship() {
        System.out.println("\n=================================================");
        System.out.println("\t\tBATALHA NAVAL");
        System.out.println("=================================================");
        System.out.println("\nMENU\n");
    }

    public static Jogo menuBattleship() throws BattleshipMenuException {

        ModoDeJogo modoDeJogo = mainMenuBattleship();
        MenuBattleshipHelper.verificaModoJogo(modoDeJogo);

        DificuldadeDoJogo dificuldadeDoJogo = menuDificuldadeJogo();
        MenuBattleshipHelper.verificaModoJogo(dificuldadeDoJogo);

        ModoDeDistribuicao modoDeDistribuicao = modoDistribuicaoJogo();
        MenuBattleshipHelper.verificaModoJogo(modoDeDistribuicao);

        Jogo novoJogo = new Jogo(modoDeJogo, dificuldadeDoJogo, modoDeDistribuicao);
        return novoJogo;
    }

    public static ModoDeJogo mainMenuBattleship() throws BattleshipMenuException {
        setFinished(false); //inicializando com false para entrar no loop

        ModoDeJogo modo = null;
        while (!isFinished()) {
            menuHeaderBattleship();
            System.out.println("Escolha o modo do jogo: \n");
            System.out.println("1 - Modo Tradicional");
            System.out.println("2 - Modo PQQD");
            System.out.println("0 - Sair");
            try {
                modo = MenuBattleshipHelper.processarOpcaoMainMenu(lerOpcaoMenu()); //lê a entrada do usuário (teclado)
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
        setFinished(false);

        DificuldadeDoJogo dificuldade = null;
        while (!isFinished()) {
            menuHeaderBattleship();
            System.out.println("Escolha a dificuldade: \n");
            System.out.println("1 - Fácil");
            System.out.println("2 - Intermediário");
            System.out.println("3 - Difícil");
            System.out.println("0 - Voltar ao menu principal");
            try {
                dificuldade = MenuBattleshipHelper.processarOpcaoMenuDificuldade(lerOpcaoMenu()); //lê a entrada do usuário (teclado)
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
        setFinished(false);

        ModoDeDistribuicao distribuicao = null;
        while (!isFinished()) {
            menuHeaderBattleship();
            System.out.println("Escolha o tipo de distribuição: \n");
            System.out.println("1 - Modo Automático");
            System.out.println("2 - Modo Manual");
            System.out.println("0 - Voltar ao menu principal");
            try {
                distribuicao = MenuBattleshipHelper.processarMenuModoDistribuicao(lerOpcaoMenu()); //lê a entrada do usuário (teclado)
                setFinished(true);
            } catch (BattleshipMenuException bmex) //esse catch é para exceptions relacionados a erros por parte do usuário, apenas volta ao menu
            {
                System.err.println(bmex.getMessage());
                MenuBattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }

        return distribuicao;
    }

    private static int lerOpcaoMenu() throws BattleshipMenuException {
        Scanner leitor = new Scanner(System.in);
        int opcao;
        System.out.print("\nOpção: ");
        try {
            opcao = Integer.parseInt(leitor.nextLine().trim());
        } catch (NumberFormatException ex) {
            throw new BattleshipMenuException("EXCEÇÃO: Opção inválida. Digite apenas números!");
        }
        return opcao;
    }

    public static boolean voltarMenuPrincipal() {
        System.out.println("\nVoltando ao menu principal.\n");
        return true;
    }

    public static boolean finalizarPrograma() {
        System.out.println("\nFinalizando programa.\n");
        return true;
    }

}
