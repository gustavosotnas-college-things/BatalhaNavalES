package battleship.model.elementos;

/**
 * Classe base de um tabuleiro de batalha naval.
 * @author Renan O
 */
public class Terreno extends Celula {
    private final String nome = "Navio de 2 partes";
    
    /**
     * seta whoami com simbolo #.
     */
    public Terreno(){
        whoami = "#";
    }

    @Override
    public String getNome() {
        return "Terreno";
    }
}
