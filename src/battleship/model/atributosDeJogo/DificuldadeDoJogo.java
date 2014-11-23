package battleship.model.atributosDeJogo;

import battleship.model.elementos.Celula;
import java.util.ArrayList;

public abstract class DificuldadeDoJogo {
    
        private int tamanhoTabuleiro; //variável abstrata
        
        public Object InicializaTabuleiro() {
        Celula[][] listaTabuleiro = new Celula[tamanhoTabuleiro][tamanhoTabuleiro];

        for (int i = 0; i < tamanhoTabuleiro; i++) {
            for(int j = 0; j < tamanhoTabuleiro; j++){
                Celula celula = new Celula();
                listaTabuleiro[i][j] = celula;
            }
            
        }
        return listaTabuleiro;
    }
}
