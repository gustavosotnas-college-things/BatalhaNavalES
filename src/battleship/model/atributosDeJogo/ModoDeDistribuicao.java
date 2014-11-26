package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.model.elementos.Tabuleiro;

public interface ModoDeDistribuicao {
    public void distribuirEmbarcacoes(Tabuleiro tabuleiro) throws BattleshipException;
    
}
