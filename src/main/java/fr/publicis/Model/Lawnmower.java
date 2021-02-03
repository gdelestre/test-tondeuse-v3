package fr.publicis.Model;

public class Lawnmower {

    private Position position;
    private Orientation orientation;

    public Lawnmower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void changeDirection(char direction) {
        this.orientation = switch(orientation){
            case N -> (direction == 'D') ? Orientation.E : Orientation.W;
            case E -> (direction == 'D') ? Orientation.S : Orientation.N;
            case S -> (direction == 'D') ? Orientation.W : Orientation.E;
            case W -> (direction == 'D') ? Orientation.N : Orientation.S;
        };
    }

    public void move(Lawn lawn) {
        if(canMove(lawn)) {
            switch (orientation) {
                case N -> this.position.moveTowardNorth();
                case E -> this.position.moveTowardEst();
                case S -> this.position.moveTowardSouth();
                case W -> this.position.moveTowardWest();
            }
        }
    }

    public boolean canMove(Lawn lawn){
        Position positionAfterMove = new Position(this.position.getAbscissa(), this.position.getOrdinate());
        switch (orientation){
            case N -> positionAfterMove.moveTowardNorth();
            case E -> positionAfterMove.moveTowardEst();
            case S -> positionAfterMove.moveTowardSouth();
            case W -> positionAfterMove.moveTowardWest();
        }
        return lawn.isValidPosition(positionAfterMove);
    }

    @Override
    public String toString() {
        return this.position.toString()+" "+this.orientation;
    }




}
