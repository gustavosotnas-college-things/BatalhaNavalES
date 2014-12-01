package battleship.controller;

/**
 * Responsavel por gerenciar as exceções ocorridas por operações invalidadas.
 * @author Renan O
 * @author Gustavo Moraes
 */
public class BattleshipException extends Exception
{
    public BattleshipException (String mensagem)
    {
        super(mensagem);
    }
    //sobrecarga (mensagem default)

    /**
     * Exceção quanda há uma operação invalida.
     */
        public BattleshipException ()
    {
        super("EXCEÇÃO: Operação Inválida no Batalha Naval.");
    }
}
