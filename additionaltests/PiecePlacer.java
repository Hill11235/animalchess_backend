package additionaltests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import animalchess.Cat;
import animalchess.Game;
import animalchess.Player;
import animalchess.Square;
import animalchess.Piece;
import animalchess.PromotablePiece;

/**
 * Unit testing for Player.dropPiece(Piece, Square) as experienced difficulty with this.
 */
public class PiecePlacer {

    private Game myGame;
    private Player p0;
    private Player p1;
    private Piece terry;

    /**
     * Sets up Players, Game and Piece needed for test.
     */
    @Before
    public void setup() {
        p0 = new Player("Michael", 0);
        p1 = new Player("Oz", 1);
        myGame = new Game(p0, p1);
        terry = new Cat(p1, myGame.getSquare(3, 4));
    }

    /**
     * Test case for dropPiece method.
     * Primarily checking that all class variables are set properly after.
     */
    @Test
    public void testDropPiece() {
        Square mySquare = myGame.getSquare(3, 4);
        assertNotNull(mySquare.getPiece());
        assertNotNull(mySquare);
        assertEquals(mySquare.getPiece(), terry);
        terry.move(myGame.getSquare(2, 3));
        assertEquals(p1.getHand().size(), 1);
        Piece chicken = p1.getHand().get(0);
        p1.dropPiece(chicken, mySquare);
        assertEquals(chicken, mySquare.getPiece());
        assertNotNull(chicken.getSquare());
        assertEquals(chicken.getSquare(), mySquare);

    }

}
