package battleship.model.elementos;

public abstract class Celula {
    
    String whoami = "Tabuleiro genérico";

    public String whoami() { //getter
        return whoami;
    }
    
    public abstract String getNome();
}
