package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.ModoDeDistribuicao;
import battleship.model.atributosDeJogo.ModoDeJogo;
import battleship.model.elementos.*;

/**
 * Classe de interface textual do usuário (Text-based user interface - TUI) para
 * o jogo do BatalhaNavalES. Todos os métodos são estáticos (static).
 *
 * @author Gustavo Moraes
 * @author Renan Ofugi
 */
public class BattleshipGameUI {

    private static boolean aconteceuAlgo;
    private static boolean acabouAvez;

    public static void setAconteceuAlgo(boolean seAconteceuAlgo) {
        if (seAconteceuAlgo)
            aconteceuAlgo = seAconteceuAlgo;
    }

    public static void setAcabouAvez(boolean seAcabouAvez) {
        if(seAcabouAvez)
            acabouAvez = seAcabouAvez;
    }

    /**
     * Exibe uma representação textual do tabuleiro de determinado jogador sem
     * modificações.
     *
     * @param tabuleiro o tabuleiro que é desejado exibir seu conteúdo
     */
    public static void exibeTabuleiro(Tabuleiro tabuleiro) {
        System.out.print("\t");
        for (int x = 0; x < tabuleiro.getTamanho(); x++) {
            System.out.print("[" + x + "]\t");
        }
        System.out.println("\n");
        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            System.out.print("[" + i + "]\t");
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {
                System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
            }
            System.out.println("\n");
        }
    }

    /**
     * Exibe uma representação textual do tabuleiro de determinado jogador de
     * forma a esconder do outro jogador as posições onde o seu oponente colocou
     * as suas embarcações.
     *
     * @param tabuleiro o tabuleiro que é desejado exibir seu conteúdo
     * @return uma "flag" para saber se houve algum evento que modificou o
     * tabuleiro.
     * @throws BattleshipGameException quando é tentado varrer uma Posicao
     * inválida
     */
    public static boolean exibeTabuleiroFiltrado(Tabuleiro tabuleiro) throws BattleshipGameException {

        String descricaoAcontecimento = null;
        aconteceuAlgo = false;
        acabouAvez = false;
        
        Posicao posAtual;

        System.out.print("\t");
        for (int x = 0; x < tabuleiro.getTamanho(); x++) {
            System.out.print("[" + x + "]\t");
        }
        System.out.println("\n");

        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            System.out.print("[" + i + "]\t");
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {

                posAtual = new Posicao(i, j);

                if ((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("*"))
                        && (!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //A bomba explodiu uma embarcação
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String

                    if (!BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        setAconteceuAlgo(true);
                        descricaoAcontecimento = "A bomba explodiu um " + aliasNomeEmbarcacao(tabuleiro.getTabuleiro()[i][j].whoami().charAt(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2)) + " na posicao ["+ posAtual.getX() +"] ["+ posAtual.getY() +"]";
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                        setAcabouAvez(false);
                    }
                    else
                    {
                        aconteceuAlgo = false;
                    }
                } else if ((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("*"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //A bomba errou o alvo
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String

                    if (!BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        setAconteceuAlgo(true);
                        descricaoAcontecimento = "A bomba errou o alvo! Tente novamente na próxima vez.";
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                        setAcabouAvez(true);
                    }
                    else
                    {
                        aconteceuAlgo = false;
                    }
                } else if ((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("!"))
                        && (!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //A bomba encontrou um navio
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String

                    if (!BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        setAconteceuAlgo(true);
                        descricaoAcontecimento = "A bomba sinalizadora encontrou um " + aliasNomeEmbarcacao(tabuleiro.getTabuleiro()[i][j].whoami().charAt(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2)) + " na posicao ["+ posAtual.getX() +"] ["+ posAtual.getY() +"]";
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                        setAcabouAvez(false);
                    }
                    else
                    {
                        aconteceuAlgo = false;
                    }
                } else if ((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("!"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //A bomba sinalizadora errou o alvo
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
                    if (!BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        setAconteceuAlgo(true);
                        descricaoAcontecimento = "A bomba sinalizadora encontrou nada nessa posição. Tente novamente na próxima vez.";
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                        setAcabouAvez(true);
                    }
                    else
                    {
                        aconteceuAlgo = false;
                    }
                } else if ((!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("~"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //Nessa posição existe um navio e não foi explodido
                    System.out.print("[ ]\t"); //imprime "[ ]" = névoa (para esconder)

                    setAconteceuAlgo(false);
                    setAcabouAvez(false);

                } else //Naquela posição tem só água 
                {
                    System.out.print("[ ]\t"); //imprime "[ ]" = névoa (para esconder)

                    setAconteceuAlgo(false);
                    setAcabouAvez(false);

                }
                posAtual = null; //pra desalocar memória (o Garbage Collector poder coletar ele)
            }
            System.out.println("\n");
        }
        if (aconteceuAlgo) {
            System.out.println("ULTIMO STATUS: " + descricaoAcontecimento); //imprime o que aconteceu por último no tabuleiro
        }
        return acabouAvez;
    }

    /**
     * Exibe informações sobre todos os símbolos usados no tabuleiro, a fins de
     * aprendizado do usuário.
     */
    public static void legendaTabuleiro() {
        System.out.println("LEGENDA:");
        System.out.println("~ --> Água\n"
                + "[ ] --> Névoa\n"
                + "S --> Submarino\n"
                + "2 --> Navio de 2 posições\n"
                + "3 --> Navio de 3 posições\n"
                + "4 --> Navio de 4 posições\n"
                + "P --> Porta Aviões\n"
                + "! --> Bomba sinalizadora\n"
                + "* --> Bomba explosiva\n");
    }

    /**
     * Método responsável por fazer a chamada das funções responsáveis pela
     * distribuição de embarcações no jogo.
     *
     * @param tabuleiro o tabuleiro de determinado jogador
     * @param definidorDeBombas a interface de modo de jogo instanciada
     * anteriormente com o usuário
     * @param distribuidor a interface de modo de distribuição instanciada
     * anteriormente com o usuário
     */
    public static void menuFazerDistribuicaoTabuleiro(Tabuleiro tabuleiro, ModoDeJogo definidorDeBombas, ModoDeDistribuicao distribuidor) {

        BattleshipHelper.clearScreen();

        BattleshipMenuUI.menuHeaderBattleship();
        System.out.println("\nTABULEIRO DO JOGADOR " + tabuleiro.getNumeroJogador() + " - DISTRIBUIÇÃO DE EMBARCAÇÕES " + aliasModoDeJogo() + "\n");

        exibeTabuleiro(tabuleiro);
        legendaTabuleiro();

        BattleshipHelper.getchar(); //Aperte ENTER para continuar.

        definidorDeBombas.setMunicaoInicial();
        distribuidor.distribuirEmbarcacoes(tabuleiro);

        BattleshipHelper.clearScreen();

        BattleshipMenuUI.menuHeaderBattleship();
        System.out.println("\nTABULEIRO DO JOGADOR " + tabuleiro.getNumeroJogador() + " A MOSTRA: \n");

        exibeTabuleiro(tabuleiro);
        legendaTabuleiro();

        BattleshipHelper.getchar(); //Aperte ENTER para continuar.
    }

    /**
     * Exibe informações sobre o nome do modo de jogo de forma apresentável ao
     * usuário.
     */
    private static String aliasModoDeJogo() {
        String alias = null;
        switch (Jogo.getModoDeJogo().getClass().getSimpleName()) {
            case "ModoTradicional":
                alias = "MODO TRADICIONAL";
                break;
            case "ModoPQQD":
                alias = "MODO PQQD";
                break;
        }
        return alias;
    }

    /**
     * Exibe informações sobre o nome da embarcação de forma apresentável ao
     * usuário sem criar um objeto do tipo de embarcação e fazer chamada da
     * função "whoami()" dentro dela apenas para isso.
     *
     * @param simbolo o caractere da String whoami que as embarcações tem nas
     * suas decorações
     * @see battleship.model.elementos.Embarcacao#whoami()
     */
    private static String aliasNomeEmbarcacao(char simbolo) {
        String alias = null;
        switch (simbolo) {
            case 'S':
                alias = "Submarino";
                break;
            case '2':
                alias = "Navio de 2 partes";
                break;
            case '3':
                alias = "Navio de 3 partes";
                break;
            case '4':
                alias = "Navio de 4 partes";
                break;
            case 'P':
                alias = "Porta Aviões (T)";
                break;

        }
        return alias;
    }

    /**
     * Menu da escolha da quantidade de bombas de cada tipo no início do modo
     * PQQD do Batalha Naval. É feita a interação do usuário para escolher
     * quantas bombas de cada tipo é desejado para uso no decorrer do jogo.
     *
     * @return um vetor de inteiros sendo: o index [0] a quantidade de bombas
     * sinalizadoras e o index [1] a de bombas explosivas
     * @throws BattleshipMenuException quando o usuário digita algo que não é
     * número
     * @see battleship.model.atributosDeJogo.ModoPQQD#setMunicaoInicial()
     */
    public static int[] menuSetarMunicaoPQQD() throws BattleshipMenuException { //é vetor só pra retornar duas variaveis pro ModoPQQD
        int[] result = new int[2];
        System.out.print("\nQuantas bombas sinalizadoras?: ");
        result[0] = BattleshipHelper.lerOpcao();
        System.out.print("Quantas bombas explosivas?: ");
        result[1] = BattleshipHelper.lerOpcao();

        return result;
    }

    /**
     * Menu da escolha da posição de onde será colocada uma embarcação no
     * tabuleiro. É feita a interação do usuário para escolher a posição do
     * tabuleiro onde o usuário deseja ter uma embarcação na iteração atual de
     * distribuição manual.
     *
     * @param i o iterador de iterações de distribuição de embarcações
     * @param tipoEmbarcacao a string do nome da embarcação para apresentação ao
     * usuário
     * @return um objeto do tipo Posicao contendo a linha e coluna especificada
     * pelo usuário onde é desejada ter uma embarcação
     * @throws BattleshipException quando o usuário digita uma posição (linha e
     * coluna) fora dos limites do tabuleiro ou um número natural inválido
     * @see
     * battleship.model.atributosDeJogo.ModoDistribManual#distribuirEmbarcacoes(Tabuleiro)
     */
    public static Posicao menuDistribuicaoLinhaColuna(int i, String tipoEmbarcacao) throws BattleshipException {
        System.out.print("\nDigite a linha que queres colocar o " + (i + 1) + " " + tipoEmbarcacao + ": ");
        int x = BattleshipHelper.lerOpcao();
        System.out.print("Digite a coluna que queres colocar o " + (i + 1) + " " + tipoEmbarcacao + ": ");
        int y = BattleshipHelper.lerOpcao();
        return new Posicao(x, y);
    }

    /**
     * Menu da escolha da orientação de colocação de uma embarcação no
     * tabuleiro. É feita a interação do usuário para escolher a orientação
     * (horizontal ou vertical) que o usuário deseja ter uma embarcação na
     * iteração atual de distribuição manual.
     *
     * @return a string correspondente com o número da opção digitada pelo
     * usuário
     * @see
     * battleship.model.atributosDeJogo.ModoDistribManual#distribuirEmbarcacoes(Tabuleiro)
     */
    public static String menuDistribuicaoOrientacao() {
        boolean finished;
        String orientacao = null;

        finished = false;
        while (!finished) {

            try {
                System.out.println("Digite a orientação desejada: \n");
                System.out.println("1 - Horizontal");
                System.out.println("2 - Vertical");
                System.out.print("\nOpção: ");
                orientacao = BattleshipHelper.processarMenuDistribuicaoOrientacao(BattleshipHelper.lerOpcao());
                finished = true;
            } catch (BattleshipException bgex) {
                System.err.println(bgex.getMessage());
                BattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }
        return orientacao;
    }

    /**
     * Menu da escolha da posição de onde será "lançada" uma bomba no tabuleiro.
     * É feita a interação do usuário para escolher a posição do tabuleiro onde o usuário deseja "lançar"
     * uma bomba (independentemente do tipo) no turno atual do Batalha Naval.
     * 
     * @return um objeto do tipo Posicao contendo a linha e coluna especificada pelo usuário onde é esperada ter uma embarcação
     */
    public static Posicao menuDetonaBomba() {
        boolean finished = false;
        Posicao posicaoEscolhida = null;

        while (!finished) {

            try {
                System.out.println("\nDigite a linha do alvo: ");
                int x = BattleshipHelper.lerOpcao();
                System.out.println("Digite a coluna do alvo: ");
                int y = BattleshipHelper.lerOpcao();
                posicaoEscolhida = new Posicao(x, y);
                finished = true;
            } catch (BattleshipException bgex) {
                System.err.println(bgex.getMessage());
                BattleshipHelper.sleep(1); //pausa de 1 segundo
            }
        }
        return posicaoEscolhida;
    }

    public static void menuMostraJogador(int x) {
        BattleshipHelper.clearScreen();
        BattleshipMenuUI.menuHeaderBattleship();
        System.out.println("\n É A VEZ DO JOGADOR " + x);
        BattleshipHelper.getchar();
    }

    /**
     * Menu da escolha do tipo de bomba no modo PQQD do Batalha Naval. É feita a
     * interação do usuário para escolher o tipo de bomba desejado na rodada
     * atual de jogo.
     *
     * @return um número inteiro com o valor correspondente do tipo de bomba
     * escolhida pelo usuário.
     * @see battleship.model.atributosDeJogo.ModoPQQD#comecarTurno(Tabuleiro)
     */
    public static int menuTipoBomba() {
        BattleshipHelper.clearScreen();
        int x = 0;
        BattleshipMenuUI.menuHeaderBattleship();
        System.out.println("Escolha um dos tipos de bombas: ");
        System.out.println("1. Bomba Explosiva");
        System.out.println("2. Bomba Sinalizadora");
        System.out.print("\nOp\u00e7\u00e3o: ");
        try {
            x = BattleshipHelper.lerOpcao();
        } catch (BattleshipMenuException bmex) {
            System.err.println(bmex.getMessage());
            BattleshipHelper.sleep(1);
        }
        return x;
    }
}
