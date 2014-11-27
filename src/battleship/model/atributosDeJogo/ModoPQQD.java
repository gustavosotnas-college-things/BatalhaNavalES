package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.model.Jogo;
import battleship.model.Posicao;
import battleship.model.QtdEmbarcacoes;
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

}
