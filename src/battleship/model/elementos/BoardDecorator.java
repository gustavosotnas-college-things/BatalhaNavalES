package battleship.model.elementos;

public class BoardDecorator extends Board {

    Board board;

    public BoardDecorator(Board umTabuleiro) {
        umTabuleiro = board;
    }
}
