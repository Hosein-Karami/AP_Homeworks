/**
 * this class is used to make a random number for play game.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/02/2022
 */
import java.util.Random;

public class GuessingGame {

    private final int Number;

    //constructor :
    GuessingGame(){
        Random random = new Random();
        Number = random.nextInt(1,101);
    }

    /**
     * this method is for return the number which computer made before in constructor.
     * @return Number
     */
    int getNumber(){
        return Number;
    }
}
