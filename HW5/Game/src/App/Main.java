/**
 * this class is Main class and is used to call the startGame method in Game class.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */


package App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        System.out.println("***** Hello,Welcome to this game *****\n");
        while (true){
            game.startGame();
            //ask from gamer that he/she want to game again or not :
            System.out.print("Do you want to play again(1 = Yes,0 = No)? ");
            int choose;
            //Check input :
            while (true){
                choose = scanner.nextInt();
                if(choose == 1 || choose == 0)
                    break;
                System.out.print("Invalid input.Choose between 0 and 1 : ");
            }
            System.out.println();//Go to next line.
            if(choose == 0)
                break;//Break from loop and end the game.
        }
        System.out.print("\nHave a nice day.Goodbye :)");
    }
}
