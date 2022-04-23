/**
 * this class is used to save player's information and give other classes access to information.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */


package App;

import Characters.Card;

public class Player {

    private final Card card;

    //Constructor :
    Player(Card card){
        this.card = card;
    }

    /**
     * this method get access to card of player.
     * @return : refrence of player's card.
     */
    public Card getCard() {
        return card;
    }

}