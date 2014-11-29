package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.controller.Posicao;
import battleship.model.elementos.BombaExplosiva;
import battleship.model.elementos.Tabuleiro;
import battleship.view.BattleshipGameUI;

public class ModoTradicional implements ModoDeJogo {

    @Override
    public void setMunicaoInicial() {
        //faça nada
    }

    public void comecarTurno(Tabuleiro tabuleiro) throws BattleshipException {

            //System.out.println("Vez do jogador 1...");
            BattleshipGameUI.exibeTabuleiro(tabuleiro);
            Posicao posicao = BattleshipGameUI.menuDetonaBomba();
            tabuleiro.setElemento(new BombaExplosiva(tabuleiro.getElemento(posicao)), posicao);
            BattleshipGameUI.exibeTabuleiroFiltrado(tabuleiro);
    }

}
