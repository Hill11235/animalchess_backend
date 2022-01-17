package animalchess;

/**
 * Class for Squares on the board.
 */
public class Square {

    private Game game;
    private Piece piece;
    private int row;
    private int col;

    /**
     * Constructor for the class.
     * @param game the Game the Square is to be associated with.
     * @param row the row of the Square on the board.
     * @param col the column of the Square on the board.
     */
    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
    }

    /**
     * Constructor outlined in UML specification, opted not to use and put logic in isPromotionZone() instead.
     * If this constructor is called it references another constructor.
     * @param game the Game the Square is to be associated with.
     * @param row the row of the Square on the board.
     * @param col the column of the Square on the board.
     * @param promotesPlayer promotion zone for provided Player.
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this(game, row, col);
        //Opted not to use promotesPlayer parameter
    }

    /**
     * Allows a Piece to be placed on this Square.
     * @param piece Piece to be placed on Square.
     * @throws IllegalArgumentException thrown when a Player attempts to place a Piece on an occupied Square.
     */
    public void placePiece(Piece piece) throws IllegalArgumentException {
        if (this.getPiece() != null) {
            throw new IllegalArgumentException("This square is already occupied");
        } else {
            this.piece = piece;
        }
    }

    /**
     * Sets the Piece instance variable to null.
     */
    public void removePiece() {
        this.piece = null;
    }

    /**
     * Determines whether a Square is a promotion zone for a given Player.
     * @param player Player that is moving a Piece to this Square.
     * @return boolean indicating whether the Square is a promotion zone for the Player.
     */
    public boolean isPromotionZone(Player player) {
        int playerNum = player.getPlayerNumber();
        int thisRow = this.getRow();

        //Determines what is a promotion zone based on player number and row number.
        if ((playerNum == 0) && ((thisRow == 4) || (thisRow == 5))) {
            return true;
        } else if ((playerNum == 1) && ((thisRow == 0) || (thisRow == 1))) {
            return true;
        }

        return false;
    }

    /**
     * Getter method for Game that the Square is part of.
     * @return Game that the Square is associated with.
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * Getter method for Piece that is on Square.
     * @return Piece on Square.
     */
    public Piece getPiece() {
        return this.piece;
    }

    /**
     * Getter method for row of Square.
     * @return row of Square.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Getter method for column of Square.
     * @return column of Square.
     */
    public int getCol() {
        return this.col;
    }
}
