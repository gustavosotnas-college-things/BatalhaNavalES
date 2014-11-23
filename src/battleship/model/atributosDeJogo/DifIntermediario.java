package battleship.model.atributosDeJogo;

import battleship.model.elementos.Celula;
import java.util.ArrayList;

public class DifIntermediario implements DificuldadeDoJogo {
    private int tamanhoTabuleiro = 12; //12 x 12

    public ArrayList InicializaTabuleiro() {
        ArrayList listaTabuleiro = new ArrayList();

        for (int i = 0; i < tamanhoTabuleiro; i++) {
            Celula celula = new Celula();
            listaTabuleiro.add(celula);
        }
        return listaTabuleiro;
    }
}
