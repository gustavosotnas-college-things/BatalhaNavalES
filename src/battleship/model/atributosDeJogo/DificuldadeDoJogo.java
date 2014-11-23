package battleship.model.atributosDeJogo;

import battleship.model.elementos.Celula;
import java.util.ArrayList;

public abstract class DificuldadeDoJogo {
    
        private int tamanhoTabuleiro; //variável abstrata
        
        public ArrayList InicializaTabuleiro() {
        ArrayList listaTabuleiro = new ArrayList();

        for (int i = 0; i < tamanhoTabuleiro; i++) {
            Celula celula = new Celula();
            listaTabuleiro.add(celula);
        }
        return listaTabuleiro;
    }
}
