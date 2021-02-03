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

public class LawnTest {

    private Lawn lawn;

    @Before
    public void createLawn(){
        Position topRightCornerPosition = new Position(5,5);
        lawn = new Lawn(topRightCornerPosition);
    }

    @Test
    public void validPosition(){
        Position lawnmowerPosition = new Position(1,2);

        assertTrue(lawn.isValidPosition(lawnmowerPosition));
    }

    @Test
    public void lawnmowerAbsInf0(){
        Position lawnmowerPosition = new Position(-1,2);

        assertFalse(lawn.isValidPosition(lawnmowerPosition));
    }

    @Test
    public void lawnmowerOrdInf0(){
        Position lawnmowerPosition = new Position(1,-2);

        assertFalse(lawn.isValidPosition(lawnmowerPosition));
    }

    @Test
    public void lawnmowerAbsSupAbsTopRight(){
        Position lawnmowerPosition = new Position(8,2);

        assertFalse(lawn.isValidPosition(lawnmowerPosition));
    }

    @Test
    public void lawnmowerOrdSupOrdTopRight(){
        Position lawnmowerPosition = new Position(2,8);

        assertFalse(lawn.isValidPosition(lawnmowerPosition));
    }

    @Test
    public void putLawnmowerOnLawn(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);

        List<Lawnmower>lawnmowers = new ArrayList<>();
        lawnmowers.add(lawnmower);

        assertTrue(lawn.putLawnmowerOnLawn(lawnmowers));
    }

    @Test
    public void lawnmowerOutOfLawn(){
        Position lawnmowerPosition = new Position(8,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);

        List<Lawnmower>lawnmowers = new ArrayList<>();
        lawnmowers.add(lawnmower);

        assertFalse(lawn.putLawnmowerOnLawn(lawnmowers));
    }


    @Test
    public void alreadyLawnmowerOnPosition(){
        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);

        List<Lawnmower>lawnmowers = new ArrayList<>();
        lawnmowers.add(lawnmower);
        assertTrue(lawn.putLawnmowerOnLawn(lawnmowers));

         lawnmowerPosition = new Position(2,2);

        assertFalse(lawn.isValidPosition(lawnmowerPosition));
    }


    @Test
    public void addForbiddenPosition(){
        List<Lawnmower>lawnmowers = new ArrayList<>();

        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        lawnmowerPosition = new Position(1,1);
        lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        assertTrue(lawn.putLawnmowerOnLawn(lawnmowers));

        Position position = new Position(3,3);
        lawn.addForbiddenPosition(position);
        assertEquals(3,lawn.getForbiddenPositions().size());
    }

    @Test
    public void addBadForbiddenPosition(){
        List<Lawnmower>lawnmowers = new ArrayList<>();

        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        lawnmowerPosition = new Position(1,1);
        lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        assertTrue(lawn.putLawnmowerOnLawn(lawnmowers));

        Position position = new Position(8,3);
        lawn.addForbiddenPosition(position);
        assertNotEquals(3,lawn.getForbiddenPositions().size());
    }

    @Test
    public void removeForbiddenPosition(){
        List<Lawnmower>lawnmowers = new ArrayList<>();

        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        lawnmowerPosition = new Position(1,1);
        lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        assertTrue(lawn.putLawnmowerOnLawn(lawnmowers));

        Position position = new Position(2,2);
        lawn.removeForbiddenPosition(position);
        assertEquals(1,lawn.getForbiddenPositions().size());
    }

    @Test
    public void removeUnknownForbiddenPosition(){
        List<Lawnmower>lawnmowers = new ArrayList<>();

        Position lawnmowerPosition = new Position(2,2);
        Lawnmower lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        lawnmowerPosition = new Position(1,1);
        lawnmower = new Lawnmower(lawnmowerPosition, Orientation.S);
        lawnmowers.add(lawnmower);

        assertTrue(lawn.putLawnmowerOnLawn(lawnmowers));

        Position position = new Position(4,4);
        lawn.removeForbiddenPosition(position);
        assertEquals(2,lawn.getForbiddenPositions().size());
    }




}
