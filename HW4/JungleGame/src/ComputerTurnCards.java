/**
 * in this class computer player choose cards which it want to play with them in a turn with random numbers.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Random;

public class ComputerTurnCards {

    private final Player player;//refrence of player.
    private final LinkedList<Cards> selectedCards = new LinkedList<>();//selected cards.
    private final LinkedList<Cards> playerCards;//10 cards of player.

    Random random = new Random();

    //Constructor
    ComputerTurnCards(Player player) {
        this.player = player;
        playerCards = player.getCards();
    }

    /**
     * used to get computer's selected cards.
     * @return : collection of selected cards.
     */
    LinkedList<Cards> selectTurnCards() {
        LinkedList<Cards> playerCards = player.getCards();
        int choose, answer;

        while (true) {
            choose = chooseIndex();//get index of wish card.
            selectedCards.add(playerCards.get(choose - 1));
            //check computer want to add another card or not :
            answer = random.nextInt(0,2);
            if (answer == 0)
                break;
        }
        System.out.println();//go to next line.
        return selectedCards;
    }

    /**
     * this method is used to get card's index from computer by random numbers.
     * @return : index of selected card in computer's cards.
     */
    int chooseIndex() {
        int index;
        while (true) {
            index = random.nextInt(1, (playerCards.size() + 1));
            //check that selected card did not choose before :
            if (checkChoose(playerCards.get(index - 1)))
                return index;
        }
    }

    /**
     * this method is used to check that computer do not add a card more than one time.
     * @param selectedCard : card which should check.
     * @return : false if new cards contains selected card and true if does not contain.
     */
    boolean checkChoose(Cards selectedCard) {
        if (selectedCards.contains(selectedCard))
            return false;
        return true;
    }
}

