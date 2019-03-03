package game;


import processor.*;
import exception.PacmanExecption;
        
public class Game {
        Interface board;
        Pacman pacman;

    public Game(Interface board, Pacman pacman) {
        this.board = board;
        this.pacman = pacman;
    }
     public boolean placeToyRobot(Position position) throws PacmanExecption {

        if (board == null)
            throw new PacmanExecption("Invalid board object");

        if (position == null)
            throw new PacmanExecption("Invalid position object");

        if (position.getOrientation() == null)
            throw new PacmanExecption("Invalid orientation value");

        if (!board.ValidPosition(position))
            return false;

        pacman.setPosition(position);
        return true;
    }

   
    public String eval(String inputString) throws PacmanExecption {
        String[] args = inputString.split(" ");
        Command command;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new PacmanExecption("Invalid command");
        }
        if (command == Command.PLACE && args.length < 2) {
            throw new PacmanExecption("Invalid command");
        }

        String[] params;
        int x = 0;
        int y = 0;
        Orientation commandOrientation = null;
        if (command == Command.PLACE) 
        {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandOrientation = Orientation.valueOf(params[2]);
            } catch (Exception e) {
                throw new PacmanExecption("Invalid command");
            }
        }
        
        String output;

        switch (command) {
            case PLACE:
                output = String.valueOf(placeToyRobot(new Position(x, y, commandOrientation)));
                break;
            case MOVE:
                Position newPosition = pacman.getPosition().getNextPosition();
                if (!board.ValidPosition(newPosition))
                    output = String.valueOf(false);
                else
                    output = String.valueOf(pacman.move(newPosition));
                break;
            case LEFT:
                output = String.valueOf(pacman.rotateLeft());
                break;
            case RIGHT:
                output = String.valueOf(pacman.rotateRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new PacmanExecption("Invalid command");
        }

        return output;
    }

  
    public String report() {
        if (pacman.getPosition() == null)
            return null;

        return pacman.getPosition().getX() + "," + pacman.getPosition().getY() + "," + pacman.getPosition().getOrientation().toString();
    }
}
