package fr.publicis;

import fr.publicis.Model.Lawn;
import fr.publicis.Model.Lawnmower;
import fr.publicis.Model.Orientation;
import fr.publicis.Model.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LawnmowerTest {

    private Lawn lawn;

    @Before
    public void createLawn(){
        Position topRightCornerPosition = new Position(5,5);
        lawn = new Lawn(topRightCornerPosition);

        Position lawnmowerPosition = new Position(5,0);
        Lawnmower lawnmowerOnLawn = new Lawnmower(lawnmowerPosition, Orientation.S);

        List<Lawnmower> allLawnmowers = new ArrayList<>();
        allLawnmowers.add(lawnmowerOnLawn);

        lawn.putLawnmowerOnLawn(allLawnmowers);
    }

    @Test
    public void changeDirectionFromNorthToEast(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.N);
        lawnmower.changeDirection('D');

        assertEquals(Orientation.E, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromNorthToWest(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.N);
        lawnmower.changeDirection('G');

        assertEquals(Orientation.W, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromWestToSouth(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.W);
        lawnmower.changeDirection('G');

        assertEquals(Orientation.S, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromWestToNorth(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.W);
        lawnmower.changeDirection('D');

        assertEquals(Orientation.N, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromSouthToEast(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmower.changeDirection('G');

        assertEquals(Orientation.E, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromSouthToWest(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmower.changeDirection('D');

        assertEquals(Orientation.W, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromEastToSouth(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.E);
        lawnmower.changeDirection('D');

        assertEquals(Orientation.S, lawnmower.getOrientation());
    }

    @Test
    public void changeDirectionFromEastToNorth(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.E);
        lawnmower.changeDirection('G');

        assertEquals(Orientation.N, lawnmower.getOrientation());
    }

    @Test
    public void canMove(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.E);

        assertTrue(lawnmower.canMove(lawn));
    }

    @Test
    public void lawnmowerPositionMaxTopOrientationNorth(){
        Position lawnmowerPosition = new Position(2,5);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.N);

        assertFalse(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(2, 5);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerPositionMaxTopOrientationEast(){
        Position lawnmowerPosition = new Position(2,5);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.E);

        assertTrue(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(3, 5);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerPositionMaxBotOrientationSouth(){
        Position lawnmowerPosition = new Position(2,0);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);

        assertFalse(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(2, 0);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerPositionMaxBotOrientationWest(){
        Position lawnmowerPosition = new Position(2,0);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.W);

        assertTrue(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(1, 0);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerPositionMaxLeftOrientationWest(){
        Position lawnmowerPosition = new Position(0,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.W);

        assertFalse(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(0, 2);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerPositionMaxLeftOrientationNorth(){
        Position lawnmowerPosition = new Position(0,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.N);

        assertTrue(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(0, 3);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerPositionMaxRightOrientationEast(){
        Position lawnmowerPosition = new Position(5,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.E);

        assertFalse(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(5, 2);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerPositionMaxRightOrientationSouth(){
        Position lawnmowerPosition = new Position(5,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);

        assertTrue(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(5, 1);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerOnLawnAndOnTheWay(){
        Position lawnmowerPosition = new Position(5,1);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);

        assertFalse(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(5, 1);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

    @Test
    public void lawnmowerOnLawnAndNotOnTheWay(){
        Position lawnmowerPosition = new Position(5,1);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.N);

        assertTrue(lawnmower.canMove(lawn));

        lawnmower.move(lawn);
        Position expectedPosition = new Position(5, 2);
        assertEquals(expectedPosition, lawnmower.getPosition());
    }

}
