package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.model.Posicao;
import battleship.model.elementos.Celula;
import battleship.model.elementos.Tabuleiro;
import battleship.view.BattleshipGameUI;
import battleship.view.BattleshipMenuUI;

public class ModoTradicional implements ModoDeJogo{
    
    @Override
    public void setMunicaoInicial() {
        //faça nada
    }

    public void comecarTurno(Tabuleiro tabuleiro, int quantidade) throws BattleshipException{
        
        while (quantidade == 0) {
            System.out.println("Vez do jogador 1...");
            BattleshipGameUI.exibeTabuleiro(tabuleiro);
            Posicao posicao = BattleshipGameUI.menuDetonaBomba();
            // funcao de ataque a celula;
            // função que verifica se foi atingido;
            //if(verifica ==  true){
            //}
        }
    }

}
