package battleship.model.elementos.iteratorJogo;

import battleship.model.atributosDeJogo.ModoDeJogo;
import battleship.model.elementos.Celula;
import java.util.Iterator;

public class TabuleiroConcreto extends Tabuleiro{

    private Celula[][] colecao;

    public Celula[][] getColecao() {
        return colecao;
    }

    public void setColecao(Celula[][] colecao) {
        this.colecao = colecao;
    }

   /*public TabuleiroConcreto(ModoDeJogo tamanhoTabuleiro) {
        colecao = new Celula[tamanhoTabuleiro.getTamanhoTabuleiro()][tamanhoTabuleiro.getTamanhoTabuleiro()];

        for (int i = 0; i < tamanhoTabuleiro.getTamanhoTabuleiro(); i++) {
            for (int j = 0; j < tamanhoTabuleiro.getTamanhoTabuleiro(); j++) {
                Celula celula = new Celula();
                colecao[i][j] = celula;
            }

        }
    }*/

    @Override
    public Iterator createIterator() {
        return new TabuleiroIterator(colecao);
    }
    
    
}
