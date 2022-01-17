package animalchess;

/**
 * Class for the game. Contains two players, dimensions, winner and board.
 */
public class Game {

    /** Number of rows in the game board. */
    public static final int HEIGHT = 6;

    /** Nomber of columns in the game board. */
    public static final int WIDTH = 5;
    private Player p0;
    private Player p1;
    private Player winner;
    private Square[][] board;

    /**
     * Constructor for Game. Sets instance variables for each Player.
     * Creates game board based on dimensions and add pieces in correct Squares for each Player.
     * @param p0 first Player to be associated with the Game.
     * @param p1 second Player to be associated with the Game.
     */
    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;

        //initialise board based on dimensions
        board = new Square[HEIGHT][WIDTH];

        //loops through board and adds Squares and Pieces in correct locations
        for (int i = 0; i < HEIGHT; i++) {

            Player placePlayer = p0;
            if (i > 2) {
                placePlayer = p1;
            }

            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = new Square(this, i, j);
                if ((i == 0) || (i == 5)) {

                    //cat placement
                    if ((j == 0) || (j == 4)) {
                        new Cat(placePlayer, this.getSquare(i, j));
                    }

                    //giraffe placement
                    if ((j == 1) || (j == 3)) {
                        new Giraffe(placePlayer, this.getSquare(i, j));
                    }

                    //lion placement
                    if (j == 2) {
                        new Lion(placePlayer, this.getSquare(i, j));
                    }
                }

                //chick placement
                if ((i == 2) || (i == 3)) {
                    if ((j != 0) && (j != 4)) {
                        new Chick(placePlayer, this.getSquare(i, j));
                    }
                }
            }
        }
    }

    /**
     * Given a Player object, returns what number they are in this game.
     * If number supplied is not associated with one of the two Players then exception thrown.
     * This isn't handled anywhere as this method is not called anywhere except automated tests.
     * @param playerNumber number of Player in this Game.
     * @return Player corresponding to that number.
     * @throws IllegalArgumentException thrown when number that is not associated with a Player supplied.
     */
    public Player getPlayer(int playerNumber) throws IllegalArgumentException {

        if (playerNumber == 0) {
            return this.p0;
        } else if (playerNumber == 1) {
            return this.p1;
        } else {
            throw new IllegalArgumentException("There are only two players, provided number not associated with a Player");
        }
    }

    /**
     * Checks each Player to determine whether or not either has won.
     * Sets winner instance variable to winner if there is one.
     * @return Player who has won if there is a winner and null otherwise.
     */
    public Player getWinner() {

        if (p0.hasWon()) {
            winner = p0;
        } else if (p1.hasWon()) {
            winner = p1;
        }
        return winner;
    }

    /**
     * Gets Square from the board array of Squares based on supplied coordinates.
     * @param row row of Square to be returned.
     * @param col column of Square to be returned.
     * @return Square at given coordinates.
     * @throws IndexOutOfBoundsException thrown when given row and/or column exceed board dimensions.
     */
    public Square getSquare(int row, int col) throws IndexOutOfBoundsException {
        try {
            return board[row][col];
        } catch (IndexOutOfBoundsException iob) {
            throw new IndexOutOfBoundsException("Coordinates exceed dimensions of game board");
        }

    }
}
