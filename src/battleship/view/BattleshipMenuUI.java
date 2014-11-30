package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.*;
import battleship.model.elementos.Tabuleiro;

/**
 * Classe de interface textual do usuário (Text-based user interface - TUI)
 * para os menus do BatalhaNavalES. Todos os métodos são estáticos (static).
 * 
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class BattleshipMenuUI {

    private static boolean finished; //variavel que serve de "flag" para término de loops de menu

    /**
     * Getter da variável booleana de flag de todas as estruturas de repetição dos menus.
     * @return a "flag" que marca o fim dos loops de menu.
     */
    public static boolean isFinished() {
        return finished;
    }

    /**
     * Setter da variável booleana de flag de todas as estruturas de repetição dos menus.
     * @param aFinished a "flag" que marca o fim dos loops de menu.
     */
    public static void setFinished(boolean aFinished) {
        finished = aFinished;
    }

    /**
     * Exibe um cabeçalho com o título do jogo para o usuário.
     */
    public static void menuHeaderBattleship() {
        System.out.println("\n=================================================");
        System.out.println("\t\tBATALHA NAVAL");
        System.out.println("=================================================");
    }

    /**
     * Principal método da classe, faz a chamada de todos os menus em sequência 
     * e cria um novo jogo (objeto).
     * 
     * @return um novo jogo.
     * @throws BattleshipMenuException  quando um parâmetro de Jogo for nulo.
     */
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

    /**
     * Primeiro menu da sequência de menus do Batalha Naval. 
     * É feita a interação do usuário para escolher o modo do jogo desejado.
     * 
     * @return uma interface de modo de jogo instanciada de acordo com a entrada do usuário.
     * @see BattleshipMenuUI#menuBattleship()
     */
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

    /**
     * Segundo menu da sequência de menus do Batalha Naval. 
     * É feita a interação do usuário para escolher a dificuldade do jogo (tamanho do tabuleiro) desejado.
     * 
     * @return uma interface de dificuldade do jogo instanciada de acordo com a entrada do usuário.
     * @see BattleshipMenuUI#menuBattleship()
     */
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

    /**
     * Último menu da sequência de menus do Batalha Naval. 
     * É feita a interação do usuário para escolher o modo de distribuição de embarcações desejado.
     * 
     * @return uma interface de modo de distribuição instanciada de acordo com a entrada do usuário.
     * @see BattleshipMenuUI#menuBattleship()
     */
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

    /**
     * Menu da escolha do tipo de bomba no modo PQQD do Batalha Naval. 
     * É feita a interação do usuário para escolher o tipo de bomba desejado na rodada atual de jogo.
     * 
     * @return um número inteiro com o valor correspondente do tipo de bomba escolhida pelo usuário.
     * @see battleship.model.atributosDeJogo.ModoPQQD#comecarTurno(Tabuleiro)
     */
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

    /**
     * Exibe um texto sinalizando o fim do programa por opção do usuário antes do começo do jogo.
     * @return true para as "flags" de loop em funções que a chamar pararem.
     */
    public static boolean finalizarPrograma() {
        System.out.println("\nFinalizando programa.\n");
        return true;
    }
    
    public static void menuMostraJogador(Tabuleiro tabuleiro){
        System.out.println("É A VEZ DO JOGADOR " + tabuleiro.getTamanho());
        BattleshipHelper.getchar();
    }

}
