package battleship.controller;

public class BattleshipMenuException extends BattleshipException {

    public BattleshipMenuException(String mensagem) {
        super(mensagem);
    }

    //sobrecarga (mensagem default)
    public BattleshipMenuException() {
        super("EXCEÇÃO: Opção inválida.");
    }
}
