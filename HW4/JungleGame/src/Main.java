/**
 * this is Main class game.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********* Hi,Welcome to jungle game *********\n");
        int choose;
        //Menu :
        while (true) {
            System.out.println("1)Play with person       2)Play with computer\n");
            System.out.print("Enter your choice : \n");
            //Controll input :
            while (true) {
                choose = scanner.nextInt();
                if (choose == 1 || choose == 2)
                    break;
                System.out.print("Choose 1 or 2 : ");
            }

            if (choose == 1) {
                PlayWithPerson play = new PlayWithPerson();
                play.runGame();
            }
            else {
                PlayWithComputer play = new PlayWithComputer();
                play.runGame();
            }

            //check player want to play again or want to exit :
            System.out.print("\n\n\nDo you want to exit from game(1 = Yes,0 = No)? ");
            while (true) {
                choose = scanner.nextInt();
                if (choose == 1 || choose == 0)
                    break;
                System.out.print("Choose 0 or 1 : ");
            }
            if(choose == 1)
                break;
        }
    }
}
