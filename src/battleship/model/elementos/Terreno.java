package battleship.model.elementos;

public class Terreno extends Celula {
    
    public Terreno(){
        whoami = "#";
    }

    @Override
    public String getNome() {
        return "Terreno";
    }
}
