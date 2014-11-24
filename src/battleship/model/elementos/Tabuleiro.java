package battleship.model.elementos;

import battleship.model.atributosDeJogo.DificuldadeDoJogo;

public abstract class Tabuleiro {

    private Celula[][] componentesTabuleiro;

    public Celula[][] getComponentesTabuleiro() {
        return componentesTabuleiro;
    }

    public void setComponentesTabuleiro(Celula[][] componentesTabuleiro) {
        this.componentesTabuleiro = componentesTabuleiro;
    }
    
    /*public Tabuleiro (DificuldadeDoJogo param) {
        componentesTabuleiro = new Celula[param.getTamanhoTabuleiro()][param.getTamanhoTabuleiro()];
        for (int i = 0; i < param.getTamanhoTabuleiro(); i++) {
            for (int j = 0; j < param.getTamanhoTabuleiro(); j++) {
                Celula celula = new Celula();
                componentesTabuleiro[i][j] = celula;
            }
        }
    }*/ //não pode ter essa função no Tabuleiro porque construtor de classe 
//  abstrata de Decorator não pode ter parâmetros
}
