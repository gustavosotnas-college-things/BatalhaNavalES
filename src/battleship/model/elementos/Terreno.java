package battleship.model.elementos;

public class Terreno extends Celula {
    private final String nome = "Navio de 2 partes";
    
    public Terreno(){
        whoami = "#";
    }

    @Override
    public String getNome() {
        return "Terreno";
    }
}
