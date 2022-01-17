package animalchess;

/**
 * Lion class, contains Lion specific methods and logic.
 */
public class Lion extends Piece {

    /**
     * Constructor, call superclass constructor.
     * @param owner Player who owns Piece.
     * @param square Square that the Piece is on.
     */
    public Lion(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Runs superclass beCaptured() method and then the capturer wins the game.
     * @param capturer Player capturing this Piece.
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        capturer.winGame();
    }
}
