/**
 * in this class player choose cards which he/she want to play with them in a turn.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Scanner;

public class PersonTurnCards {

    private final Player player;//refrence of player.
    private final LinkedList<Cards> selectedCards = new LinkedList<>();//selected cards.
    private final LinkedList<Cards> playerCards;//10 cards of player.

    Scanner scanner = new Scanner(System.in);

    //Constructor
    PersonTurnCards(Player player){
        this.player = player;
        playerCards = player.getCards();
    }

    /**
     * used to get gamer's selected cards.
     * @return : collection of selected cards.
     */
    LinkedList<Cards> selectTurnCards(){
        LinkedList<Cards> playerCards = player.getCards();
        int choose,answer;
        System.out.println("Enter number of your cards which you want fight with them,for example enter 2 for choose second card.\n");

        while (true){
            System.out.print("Enter your wish card number which you want to add to your attacker cards : ");
            choose = chooseIndex();
            selectedCards.add(playerCards.get(choose - 1));
            System.out.print("Do you want to choose another card?(1 = Yes,0 = No)? ");
            //check answer :
            while(true){
                answer = scanner.nextInt();
                if(answer == 0 || answer == 1)
                    break;
                System.out.print("Choose between 0 and 1 : ");
            }
            if(answer == 0)
                break;
        }
        System.out.println();//go to next line.
        return selectedCards;
    }
    /**
     * this method is used to get card's index from player.
     * @return : index of selected card in player's cards.
     */
    int chooseIndex(){
        int index;
        while (true){
            index = scanner.nextInt();
            if(1 <= index && index <= playerCards.size()){
                if(checkChoose(playerCards.get(index - 1)))
                    return index;
                else
                    System.out.print("This card is used before,choose another : ");
            }
            else
                System.out.print("Choose between 1 to " + playerCards.size() + " : ");
        }
    }
    /**
     * this method is used to check that gamer do not add a card more than one time.
     * @param selectedCard : card which should check.
     * @return : false if new cards contains selected card and true if does not contain.
     */
    boolean checkChoose(Cards selectedCard){
        if(selectedCards.contains(selectedCard))
            return false;
        return true;
    }
}
