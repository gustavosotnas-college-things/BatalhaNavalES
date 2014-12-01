package battleship.model.elementos;

/**
 * decoração essencial para o tabuleiro.
 * @author Renan O
 * @author Gustavo Moraes
 */
public abstract class Celula {
    
    String whoami = "Tabuleiro genérico";

    /**
     *  Registra componetes da celula.
     * @return simbolo componente decorado.
     */
    public String whoami() { //getter
        return whoami;
    }
    
    /**
     * Retorna o nome da classe
     * @return nome da classe.
     */
    public String getNome(){
        return whoami;
    }
}
