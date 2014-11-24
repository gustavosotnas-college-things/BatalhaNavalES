package battleship.model.elementos.iteratorJogo;

import battleship.model.atributosDeJogo.ModoDeJogo;
import battleship.model.elementos.Celula;
import java.util.Iterator;

public class TabuleiroConcreto extends Tabuleiro{

    protected Celula[][] colecao;

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
    public Iterator createIterator(){
        return new TabuleiroIterator(colecao);
    }
    
    
}
