package battleship.model.elementos.iteratorJogo;

import battleship.model.atributosDeJogo.DifFacil;
import battleship.model.atributosDeJogo.ModoDeJogo;
import battleship.model.elementos.Celula;
import java.util.Iterator;

public class TabuleiroIterator implements Iterator {

    private Celula[][] colecao;
    int x = 0, y = 0;

    TabuleiroIterator(Celula[][] colecao) {
        this.colecao = colecao;
    }

    @Override
    public boolean hasNext() {
        if (x * y >= colecao.length || colecao[x][y] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Celula celula = colecao[x][y];
        if (y == colecao.length / 2 || colecao[x][y] == null) {
            x++;
            y = 0;
            return celula;
        }
        y++;
        return celula;
    }
}
