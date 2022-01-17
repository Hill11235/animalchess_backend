package animalchess;

import java.util.ArrayList;

/**
 * Abstract class to represent all pieces in the game.
 * Contains all logic, attributes and methods common to all pieces.
 * Extended by specific Piece types.
 */
public abstract class Piece {

    private Player owner;
    private Square square;

    /**
     * Constructor for Piece.
     * Sets class variables and then calls Square.placePiece(square) to ensure that the Piece and Square are associated.
     * @param owner Player who owns the Piece.
     * @param square Square where the Piece is situated.
     */
    public Piece(Player owner, Square square) {
        this.owner = owner;
        this.square = square;
        square.placePiece(this);
    }

    /**
     * For a given Piece, loops through all surrounding Squares and determines whether the Piece can legally move to each.
     * Performs three checks.
     * Checks a given square isn't occupied by a Piece with the same owner.
     * Checks if by a specific Piece's movement rules it can access this Square.
     * Catches cases when Piece has a null instance variable and legal moves can't be found.
     * Catches cases when trying to check a Square that exceeds board dimensions.
     * @return ArrayList<Square> ArrayList containing all of the possible Squares this Piece could legally move to.
     */
    public ArrayList<Square> getLegalMoves() {

        ArrayList<Square> possibleMoves = new ArrayList<Square>();
        try {
            Square currSquare = this.getSquare();
            Game currGame = currSquare.getGame();
            Player currSquareOwner = this.getOwner();
            int row = currSquare.getRow();
            int col = currSquare.getCol();

            //Determines boundaries for looping.
            //In case of edge Square these bounds ensure that no non-existent squares are picked up.
            int rowLowerBound = Math.max(0, row - 1);
            int rowUpperBound = Math.min(Game.HEIGHT - 1, row + 1);
            int colLowerBound = Math.max(0, col - 1);
            int colUpperBound = Math.min(Game.WIDTH - 1, col + 1);

            for (int i = rowLowerBound; i <= rowUpperBound; i++) {
                for (int j = colLowerBound; j <= colUpperBound; j++) {
                    Square toSquare = currGame.getSquare(i, j);
                    Piece toSquarePiece = toSquare.getPiece();
                    Player toSquareOwner = null;
                    if (toSquarePiece != null) {
                        toSquareOwner = toSquarePiece.getOwner();
                    }

                    //checks toSquare doesn't have the same owner, also ensures current Square isn't captured
                    if (toSquareOwner != currSquareOwner) {

                        //Piece specific movement logic check
                        if (this.validSquare(currSquareOwner, toSquare)) {
                            possibleMoves.add(toSquare);
                        }
                    }
                }
            }

            return possibleMoves;

        } catch (IndexOutOfBoundsException iob) {
            System.err.println("getSquare() is trying to find a Square which exceeds board dimensions");
        } catch (NullPointerException npe) {
            System.err.println("Piece isn't currently linked to either a Player, Square or Game or multiple");
        }
        return null;
    }

    /**
     * Method which checks if a Piece can move to a given Square based on the game's rules.
     * To be overwritten in all subclasses except for Lion.
     * @param player owner of piece that is being checked.
     * @param toSquare square that the piece may move to, being checked if valid.
     * @return boolean indicating whether or not based on the rules this Piece can move to the provided space.
     */
    public boolean validSquare(Player player, Square toSquare) {
        return true;
    }

    /**
     * Moves Piece to a different Square and adjusts instance variables on each as needed.
     * If Square occupied by other Player then their Piece is captured.
     * If placePiece throws an IllegalArgumentException it gets handled
     * @param toSquare Square that the Piece is to move to.
     */
    public void move(Square toSquare) {
        try {
            Piece destinationPiece = toSquare.getPiece();
            if (destinationPiece != null) {
                Player captor = this.getOwner();
                destinationPiece.beCaptured(captor);
                destinationPiece.setSquare(null);
                destinationPiece.setOwner(captor);
                toSquare.removePiece();
            }
            toSquare.placePiece(this);
            this.getSquare().removePiece();
            this.setSquare(toSquare);
        } catch (IllegalArgumentException iae) {
            System.err.println("Square already occupied");
        }
    }

    /**
     * Changes owner of captured Piece and adds it to the captor's hand.
     * @param capturer Player capturing the Piece.
     */
    public void beCaptured(Player capturer) {
        this.setOwner(capturer);
        capturer.addPieceToHand(this);

    }

    /**
     * Getter method for instance variable square.
     * @return Square that this Piece is on.
     */
    public Square getSquare() {
        return this.square;
    }

    /**
     * Getter method for instance variable owner.
     * @return Player who owns this Piece.
     */
    public Player getOwner() {
        return this.owner;
    }

    /**
     * Setter method for instance variable owner.
     * @param player Player that is new owner.
     */
    public void setOwner(Player player) {
        this.owner = player;
    }

    /**
     * Setter method for instance variable square.
     * @param square new Square that the Piece is on.
     */
    public void setSquare(Square square) {
        this.square = square;
    }

}
