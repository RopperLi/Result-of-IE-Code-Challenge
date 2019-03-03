package processor;

public class Pacman {

    private Position position;

    public Pacman() {
    }

    public Pacman(Position position) {
        this.position = position;
    }

   /**
        * Set position to boolean
     */
    public boolean setPosition(Position position) {
        if (position == null)
            return false;

        this.position = position;
        return true;
    }
    
   public Position getPosition() {
        return this.position;
    }


    public boolean move(Position newPosition) {
        if (newPosition == null)
            return false;

        this.position = newPosition;
        return true;
    }


    /**
     * Rotate pacman 90 degrees to left
     */
    public boolean rotateLeft() {
        if (this.position.orientation == null)
            return false;
        this.position.orientation = this.position.orientation.leftOrientation();
        return true;
    }

    /**
     * Rotate pacman 90 degrees to right
     */
    public boolean rotateRight() {
        if (this.position.orientation == null)
            return false;
        this.position.orientation = this.position.orientation.rightOrientation();
        return true;
    }

}
