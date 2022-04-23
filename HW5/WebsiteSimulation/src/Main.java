/**
 * Main class.Start the website.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

import java.util.Scanner;

public class Main {

    /**
     * this method is used to get correct input from user and control his/her inputs.he/she can choose between 1 and max.
     * @param max : max number which user can choose.
     * @return : a valid input of user.
     */
    private static int getInput(int max){
        Scanner scanner = new Scanner(System.in);
        int choose;
        //Check input :
        while (true){
            choose = scanner.nextInt();
            if(1 <= choose && choose <= max)
                return choose;
            System.out.print("Invalid input.Please choose from " + 1 + " to " + max + " : ");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Website website = new Website();

        System.out.println("***** Welcome to this website *****\n");
        int choose;//get user inputs.
        while (true){
            System.out.println("1)Sign up\n2)Sign in\n3)Exit");
            System.out.print("Enter your choice number : ");
            choose = getInput(3);
            if(choose == 3) {
                System.out.println("\nHave a nice day,Goodbye :)");
                break;
            }
            else if(choose == 1){
                System.out.println("1)As user\n2)As admin");
                System.out.print("Enter your choice : ");
                choose = getInput(2);
                website.addUser(choose);
            }

            else{
                System.out.println("1)As user\n2)As admin");
                System.out.print("Enter your choice : ");
                choose = getInput(2);
                website.signInUser(choose);
            }

        }
    }
}
