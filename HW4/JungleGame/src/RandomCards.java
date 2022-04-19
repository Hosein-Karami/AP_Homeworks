/**
 * this class is used to set a player cards randomly and each number from 1 to 12 is for particular animal type that are in Cards class.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.Random;

public class RandomCards {

    private final Player Gamer;//refrence of gamer that we should set his/her cards.
    private final int[] counterOfTypes;

    //Constructor
    RandomCards(Player Gamer){
        this.Gamer = Gamer;
        counterOfTypes = new int[12];
    }

    Random random = new Random();

    int loopCount = 1;//for check loop should continue or end.
    int temp;//for save random numbers which is made by computer.

    /**
     * this method set cards with random number and each number from 1 to 12 is for particular animal type that are in Cards class.
     */
    void setCards(){

        while (loopCount <= 30){
            temp = random.nextInt(1,13);

            //Each card type should not more than 5 :
            if(counterOfTypes[temp - 1] == 5)
                continue;

            counterOfTypes[temp - 1]++;
            Gamer.addCard(temp);
            loopCount++;
        }
    }

}
