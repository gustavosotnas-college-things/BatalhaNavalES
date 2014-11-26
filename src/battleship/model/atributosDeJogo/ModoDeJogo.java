package battleship.model.atributosDeJogo;

import battleship.model.elementos.Celula;

public interface ModoDeJogo {
    public void setMunicao(int qtdBombasSinalizadoras, int qtdBombasExplosivas);
    public void comecarTurno (Celula[][] tabuleiro);
}
