package fr.publicis.Model;

import fr.publicis.helper.ConvertInterface;

import java.util.ArrayList;
import java.util.List;

public class Lawn implements ConvertInterface {

    private final Position positionTopRightCorner;
    private List<Position> forbiddenPositions;

    public Lawn(Position positionTopRightCorner) {
        this.positionTopRightCorner = positionTopRightCorner;
        this.forbiddenPositions = new ArrayList<>();
    }

    public List<Position> getForbiddenPositions() {
        return forbiddenPositions;
    }

    public boolean putLawnmowerOnLawn(List<Lawnmower> allLawnmowers){
        for(Lawnmower lawnmower : allLawnmowers){
            Position lawnmowerPosition = lawnmower.getPosition();

            if(isValidPosition(lawnmowerPosition)){
                forbiddenPositions.add(lawnmowerPosition);
            }else{
                System.out.println("Une tondeuse n'a pas pu être placée sur la pelouse.\n" +
                                    "Vérifiez le fichier d'entrée");
                return false;
            }
        }
        return true;
    }

    public boolean isValidPosition(Position lawnmowerPosition){
        return lawnmowerPosition.getAbscissa() >= 0 &&
                lawnmowerPosition.getOrdinate() >= 0 &&
                lawnmowerPosition.getAbscissa() <= positionTopRightCorner.getAbscissa() &&
                lawnmowerPosition.getOrdinate() <= positionTopRightCorner.getOrdinate() &&
                !this.forbiddenPositions.contains(lawnmowerPosition);
    }

    public void addForbiddenPosition(Position position){
        if(isValidPosition(position))
            this.forbiddenPositions.add(position);
    }

    public void removeForbiddenPosition(Position position){
        this.forbiddenPositions.remove(position);
    }


}
