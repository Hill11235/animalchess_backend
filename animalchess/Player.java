package animalchess;

import java.util.ArrayList;

/**
 * Player class, contains Player data and Player related methods.
 */
public class Player {

    private String name;
    private int playerNumber;
    private ArrayList<Piece> hand;
    private boolean hasWon = false;

    /**
     * Constructor for Player. Adds name and playerNumber and creates an empty hand for the Player.
     * @param name Name of player.
     * @param playerNumber number assigned to Player.
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.hand = new ArrayList<Piece>();
    }

    /**
     * Getter method for instance variable name.
     * @return what this Player's name is.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for instance variable playerNumber.
     * @return what this Player's number is.
     */
    public int getPlayerNumber() {
        return this.playerNumber;
    }

    /**
     * Getter method for instance variable hand.
     * @return Player's hand.
     */
    public ArrayList<Piece> getHand() {
        return this.hand;
    }

    /**
     * Piece from board is added to Player's hand.
     * @param piece Piece to be added to hand.
     */
    public void addPieceToHand(Piece piece) {
        Square oldSquare = piece.getSquare();
        oldSquare.removePiece();
        hand.add(piece);
        piece.setSquare(null);
        piece.setOwner(this);
    }

    /**
     * Places Piece from Player's hand onto board.
     * @param piece Piece to be placed.
     * @param square Square to be placed on.
     */
    public void dropPiece(Piece piece, Square square) {
        hand.remove(piece);
        square.placePiece(piece);
        piece.setSquare(square);
    }

    /**
     * Sets hasWon instance variable to true, indicating this Player has won.
     */
    public void winGame() {
        this.hasWon = true;
    }

    /**
     * Getter method for instance variable hasWon.
     * @return boolean hasWon instance variable.
     */
    public boolean hasWon() {
        return hasWon;
    }
}
