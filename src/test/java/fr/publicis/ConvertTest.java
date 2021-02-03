package fr.publicis;

import fr.publicis.Model.Lawnmower;
import fr.publicis.Model.Orientation;
import fr.publicis.Model.Position;
import fr.publicis.helper.ConvertInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertTest implements ConvertInterface {

    @Test
    public void stringToLawnmower(){
        String lawnmowerInformations = "2 2 S";

        Position expectedPosition = new Position(2,2);
        Lawnmower expectedLawnmower = new Lawnmower(expectedPosition, Orientation.S);
        assertEquals(expectedLawnmower.toString(),
                ConvertInterface.stringToLawnmower(lawnmowerInformations).toString());
    }

    @Test
    public void stringToPosition(){
        String positionInformations = "2 2";

        Position expectedPosition = new Position(2,2);
        assertEquals(expectedPosition,
                ConvertInterface.stringToPosition(positionInformations));
    }
}
