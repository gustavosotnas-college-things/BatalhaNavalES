package battleship.model.atributosDeJogo;

import battleship.model.Jogo;
import battleship.model.elementos.*;
import battleship.view.*;

public class ModoPQQD implements ModoDeJogo {

    private int qtdBombasSinalizadoras;
    private int qtdBombasExplosivas;

    @Override
    public void setMunicao(int qtdBombasSinalizadoras, int qtdBombasExplosivas) {
        this.qtdBombasSinalizadoras = qtdBombasSinalizadoras;
        this.qtdBombasExplosivas = qtdBombasExplosivas;
    }

    public void comecarTurno(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2) {

       /* while (embarcacao == 0) {
            System.out.println("Vez do jogador 1...");
            BattleshipGameUI.exibeTabuleiro(tabuleiro2);
            BattleshipMenuUI.MenuTipoBomba();
        }*/
    }
}
