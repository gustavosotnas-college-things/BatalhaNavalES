package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.BattleshipHelper;
import battleship.controller.BattleshipMenuException;
import battleship.controller.Posicao;
import battleship.model.elementos.Celula;
import battleship.model.elementos.Tabuleiro;
import battleship.view.BattleshipGameUI;
import battleship.view.BattleshipMenuUI;

public class ModoPQQD implements ModoDeJogo {

    private int qtdBombasSinalizadoras;
    private int qtdBombasExplosivas;

    public void setMunicaoInicial(/*int qtdBombasSinalizadoras, int qtdBombasExplosivas*/) {
        int[] bomb = null;
        try {
            bomb = BattleshipGameUI.menuSetarMunicaoPQQD();
        } catch (BattleshipMenuException bmex) {
            System.err.println(bmex.getMessage());
            BattleshipHelper.sleep(1); //pausa de 1 segundo
        }
        this.qtdBombasSinalizadoras = bomb[0];
        this.qtdBombasExplosivas = bomb[1];
    }

    public void comecarTurno(Tabuleiro tabuleiro, int quantidade) throws BattleshipException {

        while (quantidade == 0) {
            System.out.println("Vez do jogador 1...");
            BattleshipGameUI.exibeTabuleiro(tabuleiro);
            BattleshipMenuUI.MenuTipoBomba(); //pede para escolher qual tipo de bomba
            BattleshipGameUI.menuDetonaBomba();
            
        }
    }

    public int getQtdBombasSinalizadoras() {
        return qtdBombasSinalizadoras;
    }

    public void setQtdBombasSinalizadoras(int qtdBombasSinalizadoras) {
        this.qtdBombasSinalizadoras = qtdBombasSinalizadoras;
    }

    public int getQtdBombasExplosivas() {
        return qtdBombasExplosivas;
    }

    public void setQtdBombasExplosivas(int qtdBombasExplosivas) {
        this.qtdBombasExplosivas = qtdBombasExplosivas;
    }

}
