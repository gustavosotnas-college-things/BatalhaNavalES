package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipHelper;
import battleship.controller.BattleshipMenuException;
import battleship.model.elementos.Celula;
import battleship.view.BattleshipGameUI;

public class ModoPQQD implements ModoDeJogo {

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

    public void comecarTurno(Tabuleiro tabuleiro, int quantidade) throws BattleshipException {

        while (quantidade == 0) {
            System.out.println("Vez do jogador 1...");
            BattleshipGameUI.exibeTabuleiro(tabuleiro);
            BattleshipMenuUI.MenuTipoBomba(); //pede para escolher qual tipo de bomba
            Posicao posicao = BattleshipGameUI.menuDetonaBomba();
            // funcao de ataque a celula;
            // função que verifica se foi atingido;
            /*if(verifica == false)
                return quantidade--;
            */
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
