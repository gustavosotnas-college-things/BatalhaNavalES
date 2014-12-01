package battleship.controller;

/**
 * Responsavel pela gerencia de todas as exceções geradas por problemas ocorridos durante a execução do programa.
 * @author Renan O
 * @author Gustavo Moraes
 */
public class BattleshipGameException extends BattleshipException {

    /**
     *Invoca o contrutor da classe pai.
     * @param mensagem mensagem de erro.
     */
    public BattleshipGameException(String mensagem) {
        super(mensagem);
    }

    //sobrecarga (mensagem default)

    /**
     * Exceção quando ocorre algum problema na execução de um jogo.
     */
        public BattleshipGameException() {
        super("EXCEÇÃO: Algum problema aconteceu durante a execução do jogo.");
    }
}
