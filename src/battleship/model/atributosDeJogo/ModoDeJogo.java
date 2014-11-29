package battleship.model.atributosDeJogo;

import battleship.model.elementos.Tabuleiro;

public interface ModoDeJogo {

    public void setMunicaoInicial();
    public void comecarTurno(Tabuleiro tabuleiro);
    public void verificaGameOver(Tabuleiro tabuleiro);
}
