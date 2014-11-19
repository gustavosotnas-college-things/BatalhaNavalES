package battleship.controller;

public class BattleshipGameException extends BattleshipException
{
    public BattleshipGameException (String mensagem)
    {
        super(mensagem);
    }
    //sobrecarga (mensagem default)
    public BattleshipGameException ()
    {
        super("EXCEÇÃO: Algum problema aconteceu durante a execução do jogo.");
    }
}
