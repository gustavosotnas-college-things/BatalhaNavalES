package battleship.controller;

public class BattleshipException extends Exception
{
    public BattleshipException (String mensagem)
    {
        super(mensagem);
    }
    //sobrecarga
    public BattleshipException ()
    {
        super("EXCEÇÃO: Operação Inválida no Batalha Naval.");
    }
}
