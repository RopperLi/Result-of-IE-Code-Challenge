package processor;

public class Board implements Interface {

    int rows;
    int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
  /**
     * Implements the interface
     */
    @Override
    public boolean ValidPosition(Position position) {
        return !(
                position.getX() > this.columns || position.getX() < 0 ||
                        position.getY() > this.rows || position.getY() < 0
        );
    }
}
