package fr.publicis.helper;

import fr.publicis.Model.Lawn;
import fr.publicis.Model.Lawnmower;
import fr.publicis.Model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class StartProgHelper implements LoadDataInterface, ValidFormatInterface, ConvertInterface{

    private static final Scanner keyboard = new Scanner(System.in);
    private static List<String> allData = new ArrayList<>();
    private static Lawn lawn;
    private static List<Lawnmower> lawnmowers;

    public static void loadAllDataFromTxt(){
        String dataName = "";
        while (allData.isEmpty()){
            dataName = askForName();
            allData = LoadDataInterface.loadAllData(dataName);
        }
        System.out.println("Données chargées");
        keyboard.close();
    }

    public static String askForName(){
        System.out.println("Le fichier doit être au même niveau que le programme");
        System.out.println("Indiquer le nom du fichier avec l'extention");
        return keyboard.nextLine();
    }

    public static boolean validDataFormat(){
        return ValidFormatInterface.validFormatData(allData);
    }

    public static boolean createItems(){
        Position positionTopRightCorner = ConvertInterface.stringToPosition(allData.get(0));
        lawn = new Lawn(positionTopRightCorner);

        lawnmowers = LoadDataInterface.loadAllLawnmowersInformations(allData)
                    .stream()
                    .map(ConvertInterface::stringToLawnmower)
                    .collect(Collectors.toList());

        return lawn.putLawnmowerOnLawn(lawnmowers);
    }

    public static void startLawnmower(){
        List<String> lawnmowersInstructions = LoadDataInterface.loadAllLawnmowersInstructions(allData);
        Lawnmower lawnmower = null;
        for(int i = 0; i<lawnmowersInstructions.size(); i++){
            for(int j = 0; j<lawnmowersInstructions.get(i).length(); j++){

                lawnmower = lawnmowers.get(i);
                //La tondeuse démarre, sa position initiale n'est pas occupée
                lawn.removeForbiddenPosition(lawnmower.getPosition());

                if(lawnmowersInstructions.get(i).charAt(j) == 'A'){
                    lawnmower.move(lawn);
                }else{
                    lawnmower.changeDirection(lawnmowersInstructions.get(i).charAt(j));
                }
            }

            //La tondeuse a finie sa série d'instruction.
            //Sa position ne peut être occupée par une autre tondeuse
            lawn.addForbiddenPosition(lawnmower.getPosition());
            System.out.println(lawnmower.toString());
        }
    }







}
