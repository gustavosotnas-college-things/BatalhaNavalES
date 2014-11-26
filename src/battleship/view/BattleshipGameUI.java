package battleship.view;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipMenuException;
import battleship.controller.BattleshipHelper;
import battleship.model.Jogo;
import battleship.controller.Posicao;
import battleship.controller.QtdEmbarcacoes;
import battleship.model.elementos.*;
import battleship.model.elementos.embarcacoes.*;

public class BattleshipGameUI {

    public static void exibeTabuleiro(Tabuleiro tabuleiro) {

        for (int i = 0; i < tabuleiro.getTamanho(); i++) {
            for (int j = 0; j < tabuleiro.getTamanho(); j++) {
                System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
            }
            System.out.println("\n");
        }
    }
    
    public static void exibeTabuleiroFiltrado(Tabuleiro tabuleiro) {
        
        for (int i = 0; i < Jogo.getDificuldadeDoJogo().getTamanhoTabuleiro(); i++) {
            for (int j = 0; j < Jogo.getDificuldadeDoJogo().getTamanhoTabuleiro(); j++) {
                if(!tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1).contains("~"))
                    System.out.print("[ ]\t"); //imprime somente o último caractere da String
                else
                    System.out.print(tabuleiro.getTabuleiro()[i][j].whoami().substring(tabuleiro.getTabuleiro()[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
            }
            System.out.println("\n");
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
        (int numJogador, Tabuleiro tabuleiro) throws BattleshipException {
        BattleshipHelper.clearScreen();

        BattleshipMenuUI.menuHeaderBattleship();
        System.out.println("\nJOGADOR "+numJogador+" - DISTRIBUIÇÃO DE EMBARCAÇÕES " + aliasModoDeJogo() + "\n");
        
        exibeTabuleiro(tabuleiro);
        legendaTabuleiro();
        
        

        // ESSE FOR TEM QUE SER DESACOPLADO!

        
        System.out.println("\nTabuleiro do jogador "+numJogador+" com embarcações escondidas:\n");
        exibeTabuleiroFiltrado(tabuleiro);
        //System.out.println("Tabuleiro a mostra:");
        //exibeTabuleiro(tabuleiro);
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
