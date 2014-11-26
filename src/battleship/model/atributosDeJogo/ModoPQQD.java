package battleship.model.atributosDeJogo;

import battleship.model.elementos.Celula;

public class ModoPQQD implements ModoDeJogo{
    private int qtdBombasSinalizadoras;
    private int qtdBombasExplosivas;

    @Override
    public void setMunicao(int qtdBombasSinalizadoras, int qtdBombasExplosivas) {
        this.qtdBombasSinalizadoras = qtdBombasSinalizadoras;
        this.qtdBombasExplosivas = qtdBombasExplosivas;
    }
    
    @Override
    public void comecarTurno(Celula[][] tabuleiro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
