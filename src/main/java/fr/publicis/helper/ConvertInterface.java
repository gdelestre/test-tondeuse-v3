package fr.publicis.helper;

import fr.publicis.Model.Lawnmower;
import fr.publicis.Model.Orientation;
import fr.publicis.Model.Position;

public interface ConvertInterface {

    static Lawnmower stringToLawnmower(String lawnmowerInformations){
        //Format: ^abscissa ordinate orientation$
        String[] informations = lawnmowerInformations.split(" ");
        Position lawnmowerPosition = new Position(Integer.parseInt(informations[0]), Integer.parseInt(informations[1]));
        Orientation lawnmowerOrientation = Orientation.valueOf(informations[2]);
        return new Lawnmower(lawnmowerPosition, lawnmowerOrientation);
    }

    static Position stringToPosition(String positionInfo){
        //Format: ^abscissa ordinate$
        String[] informations = positionInfo.split(" ");
        return new Position(Integer.parseInt(informations[0]), Integer.parseInt(informations[1]));
    }
}
