package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipHelper;
import battleship.controller.BattleshipMenuException;
import battleship.model.elementos.Celula;
import battleship.view.BattleshipGameUI;

public class ModoPQQD implements ModoDeJogo{
    private int qtdBombasSinalizadoras;
    private int qtdBombasExplosivas;

    @Override
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
    
    @Override
    public void comecarTurno(Celula[][] tabuleiro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
