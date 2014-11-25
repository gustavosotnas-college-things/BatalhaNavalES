package battleship.view;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipGameException;
import battleship.controller.BattleshipMenuException;
import battleship.controller.MenuBattleshipHelper;
import battleship.model.Posicao;
import battleship.model.QtdEmbarcacoes;
import battleship.model.atributosDeJogo.DificuldadeDoJogo;
import battleship.model.atributosDeJogo.ModoDeDistribuicao;
import battleship.model.atributosDeJogo.ModoDeJogo;
import battleship.model.elementos.*;
import battleship.model.elementos.embarcacoes.*;

public class BattleshipGameUI {

    public static void exibeTabuleiro(Tabuleiro[][] tabuleiro, DificuldadeDoJogo dificuldadeDoJogo) {

        for (int i = 0; i < dificuldadeDoJogo.getTamanhoTabuleiro(); i++) {
            for (int j = 0; j < dificuldadeDoJogo.getTamanhoTabuleiro(); j++) {
                System.out.print(tabuleiro[i][j].whoami().substring(tabuleiro[i][j].whoami().length() - 1) + "\t"); //imprime somente o último caractere da String
            }
            System.out.println("\n");
        }
    }
    public static void legendaTabuleiro() {
        System.out.println("LEGENDA:");
        System.out.println("~ --> Água\n"
                         + "S --> Submarino\n"
                         + "2 --> Navio de 2 posições\n"
                         + "3 --> Navio de 3 posições\n"
                         + "4 --> Navio de 4 posições\n"
                         + "P --> Porta Aviões\n"
                         + "! --> Bomba sinalizadora\n"
                         + "* --> Bomba explosiva\n");
    }
    
    public static void menuFazerDistribTabuleiro
        (int numJogador, Tabuleiro[][] tabuleiro, ModoDeJogo modoDeJogo, DificuldadeDoJogo dificuldadeDoJogo, 
                ModoDeDistribuicao modoDeDistribuicao) throws BattleshipException {

        BattleshipMenuUI.menuHeaderBattleship();
        System.out.print("\nJOGADOR "+numJogador+" - DISTRIBUIÇÃO DE EMBARCAÇÕES");

        switch (modoDeJogo.getClass().getSimpleName()) {
            case "ModoTradicional":
                System.out.println(" MODO TRADICIONAL\n");
                break;
            case "ModoPQQD":
                System.out.println(" MODO PQQD\n");
                break;
        }

        for (int i = 0; i < QtdEmbarcacoes.getQtdSubmarino(); i++)
        {
            Posicao coordenada = menuDistribuirEmbarcacoes(i, dificuldadeDoJogo, "submarino");
            tabuleiro[coordenada.getX()][coordenada.getY()] = new Submarino(tabuleiro[coordenada.getX()][coordenada.getY()]);
        }
        
        exibeTabuleiro(tabuleiro, dificuldadeDoJogo);
        legendaTabuleiro();
    }
    
    private static Posicao menuDistribuirEmbarcacoes(int i, DificuldadeDoJogo difJogo, String tipoEmbarcacao) throws BattleshipException {
        System.out.print("Digite a linha que queres colocar o "+ i + tipoEmbarcacao + ": ");
        int x = MenuBattleshipHelper.lerOpcao();
        System.out.print("\nDigite a coluna que queres colocar o "+ i + tipoEmbarcacao + ": ");
        int y = MenuBattleshipHelper.lerOpcao();
        return new Posicao(x, y, difJogo);
    }
}
