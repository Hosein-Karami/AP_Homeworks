/**
 * this class is used when gamer should select 10 cards from 30 cards which make in RandomCards class for computer gamer.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Random;

public class ChooseTenCardsForComputer {
    private final Player computerGamer;//refrence of computer gamer.
    private final LinkedList<Cards> computerCards;//refrence of computer's 30 cards.
    private final LinkedList<Cards> newCards = new LinkedList<>();//10 selected cards of computer's gamer.

    Random random = new Random();

    //Constructor
    ChooseTenCardsForComputer(Player computerGamer){
        this.computerGamer = computerGamer;
        computerCards = computerGamer.getCards();
    }

    /**
     * this method is used to check that gamer do not add a card more than one time.
     * @param selectedCard : card which should check.
     * @return : false if new cards contains selected card and true,if does not contain.
     */
    boolean checkChoose(Cards selectedCard){
        if(newCards.contains(selectedCard))
            return false;
        return true;
    }

    /**
     * this method is used to get card's index with random class.
     * @return : index of selected card in computer's cards.
     */
    int chooseIndex(){
        int index;
        while (true){
            index = random.nextInt(1,31);

            if(checkChoose(computerCards.get(index - 1)))
                return index;
        }
    }

    /**
     * in this method set computer's 10 cards with use random class.
     */

    void  choose(){
        int choose;

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        choose = chooseIndex();
        newCards.add(computerCards.get(choose - 1));

        computerGamer.setCards(newCards);

    }
}
