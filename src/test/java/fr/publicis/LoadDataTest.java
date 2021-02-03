package fr.publicis;

import fr.publicis.helper.LoadDataInterface;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;


public class LoadDataTest implements LoadDataInterface {

    private final List<String> goodData = List.of("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
    private final List<String> badData = List.of("B 1", "-1 9 N", "ABCDEF", "1O 9 S", "dgaggad", "-2 P E", "AGDR");

    @Test
    public void succesLoadData() {
        String dataName = "dataForTest.txt";
        List<String> allDataFromTxt = LoadDataInterface.loadAllData(dataName);
        assertTrue(allDataFromTxt.size() > 0);
    }

    @Test
    public void failLoadData() {
        String dataName = "data";
        List<String> allDataFromTxt = LoadDataInterface.loadAllData(dataName);
        assertTrue(allDataFromTxt.isEmpty());
    }

    @Test
    public void loadGoodLawnmowersPositions() {
        List<String> positions = LoadDataInterface.loadAllLawnmowersInformations(goodData);
        assertTrue(positions.size() > 0);
    }

    @Test
    public void loadBadLawnmowersPositions() {
        List<String> positions = LoadDataInterface.loadAllLawnmowersInformations(badData);
        assertTrue(positions.isEmpty());
    }

    @Test
    public void loadGoodLawnmowersInstructions() {
        List<String> instructions = LoadDataInterface.loadAllLawnmowersInstructions(goodData);
        assertTrue(instructions.size() > 0);
    }

    @Test
    public void loadBadLawnmowersInstructions() {
        List<String> instructions = LoadDataInterface.loadAllLawnmowersInstructions(badData);
        assertTrue(instructions.isEmpty());
    }


}
