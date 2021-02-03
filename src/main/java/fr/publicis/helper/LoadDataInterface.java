package fr.publicis.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface LoadDataInterface {

    static List<String> loadAllData(String dataName) {
        List<String> allData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataName))){
            String line;
            while((line = br.readLine()) != null){
                allData.add(line);
            }
            return allData;
        }catch (Exception ex){
            return Collections.emptyList();
        }
    }
    /*static String loadLawnCoordTopRight(List<String> allData){
        return allData.get(0);
    }*/

    static List<String> loadAllLawnmowersInformations(List<String> allData){
        return  allData.stream()
                .filter(data -> data.matches("^[0-9][ ][0-9][ ][NESW]$"))
                .collect(Collectors.toList());
    }

    static List<String> loadAllLawnmowersInstructions(List<String> allData){
        return  allData.stream()
                .filter(data -> data.matches("^[ADG]+$"))
                .collect(Collectors.toList());
    }


}
