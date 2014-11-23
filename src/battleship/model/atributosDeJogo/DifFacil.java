package battleship.model.atributosDeJogo;

import battleship.model.elementos.Celula;
import java.util.ArrayList;

public class DifFacil implements DificuldadeDoJogo {

    private int tamanhoTabuleiro = 9; //9 x 9

    public ArrayList InicializaTabuleiro() {

        ArrayList listaTabuleiro = new ArrayList();

        for (int i = 0; i < tamanhoTabuleiro; i++) {
            Celula celula = new Celula();
            listaTabuleiro.add(celula);
        }
        return listaTabuleiro;
    }
}
