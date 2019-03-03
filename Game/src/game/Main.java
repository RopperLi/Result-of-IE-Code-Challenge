package game;

import processor.Board;
import processor.Pacman;
import exception.PacmanExecption;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Board board = new Board(4, 4);
        Pacman pacman = new Pacman();
        Game game = new Game(board, pacman);

        System.out.println("Welcome to Pacman world");
        System.out.println("Please Enter a command(PLACE X,Y,(SOUTH,NORTH,WEST,EAST) MOVE, LEFT, RIGHT, REPORT, EXIT)");
        boolean flag = true;
        while (flag) {
            try{
            String input = br.readLine();
             // when "EXIT" command is exectued, jump out while loop 
             if ("EXIT".equals(input)) {
                flag = false;
             System.out.println("Successful Exit");  
            }
              else {
                try {
                    String outputVal = game.eval(input);
                    System.out.println(outputVal);
                } catch (PacmanExecption e) {
                    System.out.println(e.getMessage());
                }
            }
            }
           
             catch (IOException e) {
                     e.printStackTrace();
                            }
            
           
           
        }
    }
}
