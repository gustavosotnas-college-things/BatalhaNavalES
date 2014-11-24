package battleship.model.elementos.iteratorJogo;

import battleship.model.elementos.Celula;

public class Tabuleiro {

    private Celula[][] componentesTabuleiro;

    public Celula[][] getComponentesTabuleiro() {
        return componentesTabuleiro;
    }

    public void setComponentesTabuleiro(Celula[][] componentesTabuleiro) {
        this.componentesTabuleiro = componentesTabuleiro;
    }
}
