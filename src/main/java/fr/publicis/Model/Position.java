package fr.publicis.Model;

import java.util.Objects;

public class Position {

    private int abscissa;
    private int ordinate;

    public Position(int abscissa, int ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public int getAbscissa() {
        return abscissa;
    }

    public int getOrdinate() {
        return ordinate;
    }

    public void moveTowardNorth(){
        this.ordinate++;
    }

    public void moveTowardSouth(){
        this.ordinate--;
    }

    public void moveTowardEst(){
        this.abscissa++;
    }

    public void moveTowardWest(){
        this.abscissa--;
    }

    @Override
    public String toString() {
        return abscissa + " "+ ordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return abscissa == position.abscissa &&
                ordinate == position.ordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abscissa, ordinate);
    }


}
