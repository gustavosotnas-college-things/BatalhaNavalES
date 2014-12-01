package battleship.controller;

public class BattleshipMenuException extends BattleshipException {

    /**
     *invoca o contrutor da classe pai dessa exceção de menu.
     * @param mensagem mensagem de erro
     */
    public BattleshipMenuException(String mensagem) {
        super(mensagem);
    }

    //sobrecarga (mensagem default)

    /**
     * Exceção quando uma opção não é permitida.
     */
        public BattleshipMenuException() {
        super("EXCEÇÃO: Opção inválida.");
    }
}
