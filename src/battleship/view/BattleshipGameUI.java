package battleship.view;

import battleship.controller.*;
import battleship.model.Jogo;
import battleship.model.atributosDeJogo.ModoDeDistribuicao;
import battleship.model.atributosDeJogo.ModoDeJogo;
import battleship.model.elementos.*;

public class BattleshipGameUI {

    public static void exibeTabuleiro(Tabuleiro tabuleiro) {

        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {
                System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
            }
            System.out.println("\n");
        }
    }

    public static void exibeTabuleiroFiltrado(Tabuleiro tabuleiro) throws BattleshipGameException {

        boolean aconteceuAlgo = false;
        String descricaoAcontecimento = null;
        Posicao posAtual;

        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {

                posAtual = new Posicao(i, j);

/*1º IF*/       if((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-1).contains("*"))
                    && (!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-2).contains("~")))
                        {
                            //A bomba explodiu uma embarcação
                            System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
                            
                            if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                            {
                                aconteceuAlgo = true;
                                descricaoAcontecimento = "A bomba explodiu um " + aliasNomeEmbarcacao(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2));
                                BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                            }
                            posAtual = null; //pra desalocar memória (o Garbage Collector poder coletar ele)
                        }
/*2º IF*/       else if((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-1).contains("*"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-2).contains("~")))
                        {
                            //A bomba errou o alvo
                            System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String

                            if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                            {
                                aconteceuAlgo = true;
                                descricaoAcontecimento = "A bomba errou o alvo! Tente novamente na próxima vez.";
                                BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                            }
                            posAtual = null; //pra desalocar memória (o Garbage Collector poder coletar ele)
                        }
/*3º IF*/       else if((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-1).contains("!"))
                        && (!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-2).contains("~")))
                        {
                            //A bomba encontrou um navio
                            System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
                            
                            if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                            {
                                aconteceuAlgo = true;
                                descricaoAcontecimento = "A bomba sinalizadora encontrou um " + aliasNomeEmbarcacao(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 2));
                                BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                            }
                            posAtual = null; //pra desalocar memória (o Garbage Collector poder coletar ele)
                        }
/*4º IF*/       else if((tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-1).contains("!"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-2).contains("~")))
                        {
                            //A bomba sinalizadora errou o alvo
                            System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
                            
                            if (BattleshipLogger.consultaPosicaoLog(posAtual)) //verifica se aquela posição já foi escolhida antes (já foi adicionado no log)
                            {
                                aconteceuAlgo = true;
                                descricaoAcontecimento = "A bomba sinalizadora encontrou nada nessa posição. Tente novamente na próxima vez.";
                                BattleshipLogger.adicionaLog(posAtual, descricaoAcontecimento);
                            }
                            posAtual = null; //pra desalocar memória (o Garbage Collector poder coletar ele)
                        }
/*5º IF*/       else if((!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-1).contains("~"))
                        && (tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length()-2).contains("~")))
                        {
                            //Nessa posição existe um navio e não foi explodido
                            System.out.print("[ ]\t"); //imprime "[ ]" = névoa (para esconder)
                        }
/*ELSE*/        else //Naquela posição tem só água
                    System.out.print("[ ]\t"); //imprime "[ ]" = névoa (para esconder)
            }
            System.out.println("\n");
        }
        if (aconteceuAlgo) {
            System.out.println(descricaoAcontecimento); //imprime o que aconteceu por último no tabuleiro
            aconteceuAlgo = false;
        }
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

    public static void menuFazerDistribuicaoTabuleiro
        (int numJogador, Tabuleiro tabuleiro, ModoDeJogo definidorDeBombas, ModoDeDistribuicao distribuidor) throws BattleshipException {

        BattleshipHelper.clearScreen();

        BattleshipMenuUI.menuHeaderBattleship();
        System.out.println("\nJOGADOR "+numJogador+" - DISTRIBUIÇÃO DE EMBARCAÇÕES " + aliasModoDeJogo() + "\n");

        exibeTabuleiro(tabuleiro);
        legendaTabuleiro();

        definidorDeBombas.setMunicaoInicial();

        distribuidor.distribuirEmbarcacoes(tabuleiro);

        System.out.println("\nTabuleiro do jogador "+numJogador+" com embarcações escondidas:\n");
        exibeTabuleiroFiltrado(tabuleiro);
        System.out.println("Tabuleiro a mostra (EH TESTE!):");
        exibeTabuleiro(tabuleiro);
        legendaTabuleiro();
    }

    private static String aliasModoDeJogo()
    {
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

    private static String aliasNomeEmbarcacao(String simbolo)
    {
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

    public static Posicao menuDistribuirEmbarcacoes(int i, String tipoEmbarcacao) throws BattleshipException {
        System.out.print("\nDigite a linha que queres colocar o "+ (i+1) +" "+ tipoEmbarcacao + ": ");
        int x = BattleshipHelper.lerOpcao();
        System.out.print("Digite a coluna que queres colocar o "+ (i+1) +" "+ tipoEmbarcacao + ": ");
        int y = BattleshipHelper.lerOpcao();
        return new Posicao(x, y);
    }
}
