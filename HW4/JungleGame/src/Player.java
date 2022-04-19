/**
 * this class is used to save information's of gamers and get access to them.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;

public class Player {

    private LinkedList<Cards> cards = new LinkedList<>();
    private LinkedList<Cards> eachTurnCards = new LinkedList<>();//collection of cards that gamer want to game with them in each turn.
    private int makeFullEnergy = 3;//counter of times that a player can make one of his/her card's energy full.

    /**
     * this method is used to set player's cards(30 cards) with random numbers at first.
     */
    void setCards(){
        RandomCards randomCards = new RandomCards(this);
        randomCards.setCards();
    }

    /**
     * this method is used to set player's cards with new collection of cards.
     * @param newCards : refrence of new cards collection.
     */
    void setCards(LinkedList<Cards> newCards){
        cards = newCards;
    }

    /**
     * this method is used when a player want to make his/her card's energy full and decrease one of his ability to do this work.
     */
    void setMakeFullEnergy(){
        makeFullEnergy--;
    }

    /**
     * set each turn cards after each turn.
     * @param eachTurnCards : new selected cards.
     */
    void setEachTurnCards(LinkedList<Cards> eachTurnCards){
        this.eachTurnCards = eachTurnCards;
    }

    /**
     * this method is used to get a refrence of player's cards.
     * @return : cards of gamer.
     */
    LinkedList<Cards> getCards(){
        return cards;
    }

    /**
     * this method give us access to cards which player want to play with them in a turn.
     * @return : cards which player want to play with them in a turn.
     */
    LinkedList<Cards> getEachTurnCards(){
        return eachTurnCards;
    }

    /**
     * this method return an int value which show how much time player can make one of his/her card's energy full.
     * @return : counter of times that a player can make his/her card's energy full.
     */
    int getMakeFullEnergy(){
        return makeFullEnergy;
    }

    /**
     * this method is used to select 10 cards from 30 cards.
     */
    void chooseCards(){
        SelectTenCards select = new SelectTenCards(this);
        select.printCards();
        cards = select.choose();
    }

    /**
     * this method is used to add an animal to cards of gamer.
     * @param animalType : type of new animal.
     */
    void addCard(int animalType){
        Cards newCard = new Cards(animalType);
        cards.add(newCard);
    }

    /**
     * this method is used to clear all selected cards which select in each turn.
     */
    void clearSelectedCards(){
        eachTurnCards.clear();
    }

}
