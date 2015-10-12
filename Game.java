import java.util.Scanner;

/**
 * Created by wlafleur on 10/10/15.
 */
public class Game {
    public static void main(String[] args) {
      Game s = new Game();
      s.startScreen();
    }

    public void startScreen() {
           Location start = new Location();
           Scanner in = new Scanner(System.in);
           String s;
           System.out.println("Welcome to [Untitled Game]! Below are the controls for the game:");
           System.out.println("w - North");
           System.out.println("a - West");
           System.out.println("s - South");
           System.out.println("d - East");
           System.out.println("quit OR exit - Exits the game");
           System.out.println("Ready? Type 'start' without the single quotes to enter the world of [empty]!");
        while (true) {
           s = in.nextLine();
           if (s.equalsIgnoreCase("start")) {
               start.square1();
               break;
           } else {
               System.out.println("What? I did not understand your response.");
           }
       }
       in.close();
    }
}
