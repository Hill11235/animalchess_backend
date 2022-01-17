package animalchess;

/**
 * Cat class, extends PromotablePiece and contains Cat specific logic.
 */
public class Cat extends PromotablePiece {

    /**
     * Constructor for Cat class.
     * @param owner player who owns Cat.
     * @param square Square where Cat is situated.
     */
    public Cat(Player owner, Square square) {
        super(owner, square);
    }

    //Create unit test
    /**
     * Used to check if a move is valid based on Cat move logic.
     * Calls validSquare from superclass if Cat is promoted.
     * @param player owner of piece that is being checked.
     * @param toSquare square that the piece may move to, being checked if valid.
     * @return boolean indicating whether or not based on the rules a Cat can move to the provided space.
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

            //unpromoted Cats cannot move laterally
            if (toRow == fromRow) {
                return false;
            } else {

                //dependent on player and direction of play, returns false if space behind cat
                //as this is not a valid move
                if (toCol == fromCol) {
                    if ((playerNum == 0) && (toRow == fromRow - 1)) {
                        return false;
                    } else if ((playerNum == 1) && (toRow == fromRow + 1)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
