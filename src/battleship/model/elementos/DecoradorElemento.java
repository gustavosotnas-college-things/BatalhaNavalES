package battleship.model.elementos;

/**
 * Classe que permite a decoração de um objeto base em tempo de execução.
 * @author Renan O
 * @author Gustavo Moraes
 */
public abstract class DecoradorElemento extends Celula {
    public abstract String whoami();
    public abstract String getNome();
}
