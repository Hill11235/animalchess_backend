package animalchess;

/**
 * PromotablePiece abstract class, extends Piece.
 * Contains logic, attributes and methods common to PromotablePieces.
 */
public abstract class PromotablePiece extends Piece {

    private boolean isPromoted;

    /**
     * Constructor for class.
     * @param owner Player owns the Piece.
     * @param square Square where the Piece sits.
     */
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * Getter method for boolean isPromoted instance variable.
     * @return boolean isPromoted for a given Piece.
     */
    public boolean getIsPromoted() {
        return this.isPromoted;
    }

    /**
     * Sets boolean isPromoted instance variable to true.
     */
    public void promote() {
        this.isPromoted = true;
    }

    /**
     * Used to check if a move is valid based on a promoted Piece's move logic.
     * Once promoted, Cats and Chicks move the same way, so can define and use this for both.
     * @param player owner of piece that is being checked.
     * @param toSquare square that the piece may move to, being checked if valid.
     * @return boolean indicating whether or not based on the rules this PromotablePiece can move to the provided space.
     */
    @Override
    public boolean validSquare(Player player, Square toSquare) {
        int playerNum = player.getPlayerNumber();
        Square currSquare = super.getSquare();
        int fromRow = currSquare.getRow();
        int fromCol = currSquare.getCol();
        int toRow = toSquare.getRow();
        int toCol = toSquare.getCol();

        if ((toCol == fromCol - 1) || (toCol == fromCol + 1)) {
            if ((playerNum == 0) && (toRow == fromRow - 1)) {
                return false;
            } else if ((playerNum == 1) && (toRow == fromRow + 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Used to move Piece to new square.
     * Calls method in superclass and then checks to see if the new square is a promotion zone.
     * If it is the piece is then promoted.
     * @param toSquare Square that the piece is to move to.
     */
    @Override
    public void move(Square toSquare) {
        super.move(toSquare);
        if (toSquare.isPromotionZone(super.getOwner())) {
            this.promote();
        }
    }

    /**
     * Calls superclass method beCaptured().
     * Demotes the piece upon capture in line with the rules of the game.
     * @param capturer Player this Piece is being captured by.
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        this.demote();
    }

    /**
     * Sets boolean isPromoted instance variable to false.
     */
    public void demote() {
        this.isPromoted = false;
    }
}
