package animalchess;

/**
 * Class for Giraffe, extends Piece and contains Giraffe specific logic and methods.
 */
public class Giraffe extends Piece {

    /**
     * Constructor for Giraffe, calls superclass constructor.
     * @param owner Player who owns Piece.
     * @param square Square that the Piece is on.
     */
    public Giraffe(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Determines whether or not a given Square is a valid move for a Giraffe.
     * Giraffes can only move orthogonally.
     * @param player Player who owns Piece to be moved.
     * @param toSquare Square that Piece may move to.
     * @return boolean indicating whether or not this Square is a valid move.
     */
    @Override
    public boolean validSquare(Player player, Square toSquare) {
        Square currSquare = super.getSquare();
        int fromRow = currSquare.getRow();
        int fromCol = currSquare.getCol();
        int toRow = toSquare.getRow();
        int toCol = toSquare.getCol();

        if ((toRow == fromRow) || (toCol == fromCol)) {
            return true;
        }

        return false;
    }
}
