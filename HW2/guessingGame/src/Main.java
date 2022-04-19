/**
 * this class is for give the user guess and compare with random numner which is made in GusseingGame class and show the result.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/02/2022
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GuessingGame guessingGame = new GuessingGame();
        System.out.println("Enter a number between 1 and 100:");
        //Game loop :
        boolean result = false;//for check win or loose.
        int guessNumber;
        int computerNumber = guessingGame.getNumber();

        for(int counter = 1;counter <= 7;counter++){
            guessNumber = scanner.nextInt();
            if(guessNumber == computerNumber){
                result = true;
                break;
            }
            else if(guessNumber > computerNumber)
                System.out.println("Your guess is too high.");
            else
                System.out.println("Your guess is too low.");
        }

        if(result)
            System.out.println("You guessed the number!");
        else
            System.out.println("You have used up all your guesses.");
    }
}
