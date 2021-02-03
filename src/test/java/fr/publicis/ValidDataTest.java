package fr.publicis;

import fr.publicis.helper.ValidFormatInterface;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.List;

public class ValidDataTest implements ValidFormatInterface {

    @Test
    public void onlyGoodData(){
        List<String> data = List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertTrue(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void badTopRigthCoordSup10(){
        List<String> data = List.of("15 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void badTopRigthCoordMin0(){
        List<String> data = List.of("-1 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void oneBadPositionSup10(){
        List<String> data = List.of("5 5", "10 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void oneBadPositionMin0(){
        List<String> data = List.of("5 5", "-1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void oneBadOrientation(){
        List<String> data = List.of("5 5", "1 2 O", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void lowercaseOrientation(){
        List<String> data = List.of("5 5", "1 2 e", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void oneBadInstruction(){
        List<String> data = List.of("5 5", "1 2 N", "GAGAGAGAAR", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void lowercaseInstruction(){
        List<String> data = List.of("5 5", "1 2 N", "gagagaad", "3 3 E", "AADAADADDA");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void moreLawnmowersThanInstructions(){
        List<String> data = List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

    @Test
    public void instructionsBeforePositions(){
        List<String> data = List.of("5 5", "GAGAGAGAA", "3 3 E");
        assertFalse(ValidFormatInterface.validFormatData(data));
    }

}
