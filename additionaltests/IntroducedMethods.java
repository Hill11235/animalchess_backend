package additionaltests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import animalchess.Cat;
import animalchess.Game;
import animalchess.Player;
import animalchess.Square;
import animalchess.Piece;
import animalchess.PromotablePiece;
import animalchess.Lion;
import animalchess.Giraffe;
import animalchess.Chick;

/**
 * Unit tests for introduced methods outside of specification.
 */
public class IntroducedMethods {

    private Game myGame;
    private Player p0;
    private Player p1;
    private Cat frodo;
    private Lion sam;
    private Giraffe merry;
    private Chick pippin;

    /**
     * Sets up Players, Game and Pieces for tests.
     */
    @Before
    public void setup() {
        p0 = new Player("Samantha Wigglesworth", 0);
        p1 = new Player("Gary Hosepipe", 1);
        myGame = new Game(p0, p1);
        frodo = new Cat(p1, myGame.getSquare(3, 4));
        sam = new Lion(p1, myGame.getSquare(4, 0));
        pippin = new Chick(p0, myGame.getSquare(1, 4));
        merry = new Giraffe(p0, myGame.getSquare(1, 0));
    }

    /**
     * Tests whether the introduced setters in Piece are behaving correctly.
     */
    @Test
    public void pieceSetters() {
        assertEquals(frodo.getOwner(), p1);
        frodo.setOwner(p0);
        assertEquals(frodo.getOwner(), p0);
        frodo.setOwner(p1);
        assertEquals(frodo.getSquare(), myGame.getSquare(3, 4));
        frodo.setSquare(myGame.getSquare(1, 1));
        assertEquals(frodo.getSquare(), myGame.getSquare(1, 1));
        frodo.setSquare(myGame.getSquare(3, 4));
    }

    /**
     * Test whether validSquare() and demote() working for both promoted and unpromoted Cats.
     */
    @Test
    public void catValidAndDemote() {
        Square left = myGame.getSquare(3, 3);
        Square leftDiagonalUp = myGame.getSquare(2, 3);
        Square straightUp = myGame.getSquare(2, 4);
        Square leftDiagonalDown = myGame.getSquare(4, 3);
        Square straightDown = myGame.getSquare(4, 4);

        //unpromoted cat checks
        assertFalse(frodo.getIsPromoted());
        assertFalse(frodo.validSquare(p1, left));
        assertTrue(frodo.validSquare(p1, leftDiagonalUp));
        assertTrue(frodo.validSquare(p1, straightUp));
        assertTrue(frodo.validSquare(p1, leftDiagonalDown));
        assertFalse(frodo.validSquare(p1, straightDown));

        //promoted cat checks
        frodo.promote();
        assertTrue(frodo.getIsPromoted());
        assertTrue(frodo.validSquare(p1, left));
        assertTrue(frodo.validSquare(p1, leftDiagonalUp));
        assertTrue(frodo.validSquare(p1, straightUp));
        assertFalse(frodo.validSquare(p1, leftDiagonalDown));
        assertTrue(frodo.validSquare(p1, straightDown));
        frodo.demote();
        assertFalse(frodo.getIsPromoted());
    }

    /**
     * Test whether validSquare() and demote() working for both promoted and unpromoted Chicks.
     */
    @Test
    public void chickValidAndDemote() {
        Square left = myGame.getSquare(1, 3);
        Square leftDiagonalUp = myGame.getSquare(0, 3);
        Square straightUp = myGame.getSquare(0, 4);
        Square leftDiagonalDown = myGame.getSquare(2, 3);
        Square straightDown = myGame.getSquare(2, 4);

        //unpromoted Chick checks
        assertFalse(pippin.getIsPromoted());
        assertFalse(pippin.validSquare(p0, left));
        assertFalse(pippin.validSquare(p0, leftDiagonalUp));
        assertFalse(pippin.validSquare(p0, straightUp));
        assertFalse(pippin.validSquare(p0, leftDiagonalDown));
        assertTrue(pippin.validSquare(p0, straightDown));

        //promoted Chick checks
        pippin.promote();
        assertTrue(pippin.getIsPromoted());
        assertTrue(pippin.validSquare(p0, left));
        assertFalse(pippin.validSquare(p0, leftDiagonalUp));
        assertTrue(pippin.validSquare(p0, straightUp));
        assertTrue(pippin.validSquare(p0, leftDiagonalDown));
        assertTrue(pippin.validSquare(p0, straightDown));
        pippin.demote();
        assertFalse(pippin.getIsPromoted());
    }

    /**
     * Test whether validSquare is working for Lions.
     */
    @Test
    public void lionValid() {
        Square right = myGame.getSquare(4, 1);
        Square rightDiagonalUp = myGame.getSquare(3, 1);
        Square straightUp = myGame.getSquare(3, 0);
        Square rightDiagonalDown = myGame.getSquare(5, 1);
        Square straightDown = myGame.getSquare(5, 0);

        assertTrue(sam.validSquare(p1, right));
        assertTrue(sam.validSquare(p1, rightDiagonalUp));
        assertTrue(sam.validSquare(p1, straightUp));
        assertTrue(sam.validSquare(p1, rightDiagonalDown));
        assertTrue(sam.validSquare(p1, straightDown));
    }

    /**
     * Test whether getValid method works correctly for Giraffes.
     */
    @Test
    public void giraffeValid() {
        Square right = myGame.getSquare(1, 1);
        Square rightDiagonalUp = myGame.getSquare(0, 1);
        Square straightUp = myGame.getSquare(0, 0);
        Square rightDiagonalDown = myGame.getSquare(2, 1);
        Square straightDown = myGame.getSquare(2, 0);

        assertTrue(merry.validSquare(p0, right));
        assertFalse(merry.validSquare(p0, rightDiagonalUp));
        assertTrue(merry.validSquare(p0, straightUp));
        assertFalse(merry.validSquare(p0, rightDiagonalDown));
        assertTrue(merry.validSquare(p0, straightDown));
    }

}
