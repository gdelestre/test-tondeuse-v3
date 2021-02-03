package fr.publicis.helper;

import java.util.List;

public interface ValidFormatInterface {

     static boolean validFormatData(List<String> allDataFromTxt){
        if(allDataFromTxt.size() > 0){

            String regex;
            for(int i = 0; i < allDataFromTxt.size(); i++){
                //La première ligne contient les coordonnées du coin supérieure de la pelouse
                if(i == 0){
                    regex = "^[0-9][ ][0-9]$";
                    //Ensuite, les lignes impairs correspondent aux coordonnées et orientation de la tondeuse
                }else if (i%2 != 0){
                    regex="^[0-9][ ][0-9][ ][NSWE]$";
                    //Et les lignes pairs correspondent aux séries d'instructions
                }else{
                    regex = "^[ADG]+$";
                }

                if(!allDataFromTxt.get(i).matches(regex)){
                    System.out.println("Données invalides en ligne: "+(i+1));
                    return false;
                }

            }
            //Si la taille de la liste des données est pair, il manque une instruction pour la dernière tondeuse
            if(allDataFromTxt.size()%2 == 0){
                return false;
            }
        }
        return true;
    }

}
