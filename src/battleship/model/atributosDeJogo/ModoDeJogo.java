package battleship.model.atributosDeJogo;

import battleship.controller.BattleshipException;
import battleship.model.elementos.Tabuleiro;

public interface ModoDeJogo {

    public void setMunicaoInicial(/*int qtdBombasSinalizadoras, int qtdBombasExplosivas*/);

    public void comecarTurno(Tabuleiro tabuleiro, int quantidade) throws BattleshipException;
}
