package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.ModoDeDistribuicao;
import battleship.model.atributosDeJogo.ModoDeJogo;
import battleship.model.elementos.*;

public class BattleshipGameUI {

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

    public static boolean exibeTabuleiroFiltrado(Tabuleiro tabuleiro) throws BattleshipGameException {

        boolean aconteceuAlgo = false;
        String descricaoAcontecimento = null;
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

                    if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        aconteceuAlgo = true;
                        descricaoAcontecimento = "A bomba explodiu um " + aliasNomeEmbarcacao(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2));
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                    }
                } else if ((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("*"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //A bomba errou o alvo
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String

                    if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        aconteceuAlgo = true;
                        descricaoAcontecimento = "A bomba errou o alvo! Tente novamente na próxima vez.";
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                    }
                } else if ((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("!"))
                        && (!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //A bomba encontrou um navio
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String

                    if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        aconteceuAlgo = true;
                        descricaoAcontecimento = "A bomba sinalizadora encontrou um " + aliasNomeEmbarcacao(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2));
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                    }
                } else if ((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("!"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //A bomba sinalizadora errou o alvo
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
                    if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                    {
                        aconteceuAlgo = true;
                        descricaoAcontecimento = "A bomba sinalizadora encontrou nada nessa posição. Tente novamente na próxima vez.";
                        BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                    }
                } else if ((!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("~"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2).contains("~"))) {

                    //Nessa posição existe um navio e não foi explodido
                    System.out.print("[ ]\t"); //imprime "[ ]" = névoa (para esconder)
                } else //Naquela posição tem só água 
                {
                    System.out.print("[ ]\t"); //imprime "[ ]" = névoa (para esconder)
                }
                posAtual = null; //pra desalocar memória (o Garbage Collector poder coletar ele)
            }
            System.out.println("\n");
        }
        if (aconteceuAlgo) {
            System.out.println(descricaoAcontecimento); //imprime o que aconteceu por último no tabuleiro
        } else {
            aconteceuAlgo = false;
        }
        return aconteceuAlgo;
    }

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

    public static void menuFazerDistribuicaoTabuleiro(Tabuleiro tabuleiro, ModoDeJogo definidorDeBombas, ModoDeDistribuicao distribuidor) throws BattleshipException {

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

    private static String aliasNomeEmbarcacao(String simbolo) {
        String alias = null;
        switch (simbolo) {
            case "S":
                alias = "Submarino";
                break;
            case "2":
                alias = "Navio de 2 partes";
                break;
            case "3":
                alias = "Navio de 3 partes";
                break;
            case "4":
                alias = "Navio de 4 partes";
                break;
            case "P":
                alias = "Porta Aviões (T)";
                break;
        }
        return alias;
    }

    public static int[] menuSetarMunicaoPQQD() throws BattleshipMenuException { //é vetor só pra retornar duas variaveis pro ModoPQQD
        int[] result = new int[2];
        System.out.print("\nQuantas bombas sinalizadoras?: ");
        result[0] = BattleshipHelper.lerOpcao();
        System.out.print("Quantas bombas explosivas?: ");
        result[1] = BattleshipHelper.lerOpcao();

        return result;
    }

    public static Posicao menuDistribuicaoLinhaColuna(int i, String tipoEmbarcacao) throws BattleshipException {
        System.out.print("\nDigite a linha que queres colocar o " + (i + 1) + " " + tipoEmbarcacao + ": ");
        int x = BattleshipHelper.lerOpcao();
        System.out.print("Digite a coluna que queres colocar o " + (i + 1) + " " + tipoEmbarcacao + ": ");
        int y = BattleshipHelper.lerOpcao();
        return new Posicao(x, y);
    }

    public static String menuDistribuicaoOrientacao(int i) {
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
            } catch (BattleshipException bgex) {
                System.err.println(bgex.getMessage());
            }
        }
        return orientacao;
    }

    public static Posicao menuDetonaBomba() throws BattleshipException {
        System.out.println("\nDigite a linha da embarcação alvo: ");
        int x = BattleshipHelper.lerOpcao();
        System.out.println("Digite a coluna da embarcação alvo: ");
        int y = BattleshipHelper.lerOpcao();
        return new Posicao(x, y);
    }
}
