package animalchess;

/**
 * Chick class, extends PromotablePiece and contains Chick specific logic.
 */
public class Chick extends PromotablePiece {

    /**
     * Constructor for Chick class.
     * @param owner player who owns Chick.
     * @param square Square where Chick is situated.
     */
    public Chick(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Used to check if a move is valid based on Chick move logic.
     * Calls validSquare from superclass if Chick is promoted.
     * @param player owner of piece that is being checked.
     * @param toSquare square that the piece may move to, being checked if valid.
     * @return boolean indicating whether or not based on the rules a Chick can move to the provided space.
     */
    @Override
    public boolean validSquare(Player player, Square toSquare) {
        if (super.getIsPromoted()) {
            return super.validSquare(player, toSquare);
        } else {
            int playerNum = player.getPlayerNumber();
            Square currSquare = super.getSquare();
            int fromRow = currSquare.getRow();
            int fromCol = currSquare.getCol();
            int toRow = toSquare.getRow();
            int toCol = toSquare.getCol();

            if (fromCol == toCol) {
                if ((playerNum == 0) && (toRow == fromRow + 1)) {
                    return true;
                } else if ((playerNum == 1) && (toRow == fromRow - 1)) {
                    return true;
                }
            }

            return false;
        }
    }
}
