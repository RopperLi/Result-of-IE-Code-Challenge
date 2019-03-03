package processor;


public class Position {
    int x;
    int y;
    Orientation orientation;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.orientation = position.getOrientation();
    }

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setDirection(Orientation orientation) {
        this.orientation = orientation;
    }

    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    
    /**
        * get the next position
        */
    public Position getNextPosition() { 
        Position newPosition = new Position(this);
            switch (this.orientation){
            case NORTH:
                newPosition.change(0, 1);
                break;
            case EAST:
                newPosition.change(1, 0);
                break;
            case SOUTH:
                newPosition.change(0, -1);
                break;
            case WEST:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }
}