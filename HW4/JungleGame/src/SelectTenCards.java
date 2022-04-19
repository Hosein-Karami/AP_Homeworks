/**
 * this class is used when gamer should select 10 cards from 30 cards which make in RandomCards class.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Scanner;

public class SelectTenCards {

    private final Player Gamer;//refrence of gamer who want to select 10 cards from 30 cards.
    private final LinkedList<Cards> playerCards;//refrence of player's 30 cards.
    private final LinkedList<Cards> newCards = new LinkedList<>();//10 selected cards of player.

    Scanner scanner = new Scanner(System.in);

    //Constructor :
    SelectTenCards(Player Gamer){
        this.Gamer = Gamer;
        playerCards = Gamer.getCards();
    }

    /**
     * print cards with numbers that gamer can choose them with their numbers.
     */
    void printCards(){
        int temp = 1;
        for(Cards x : playerCards){
            System.out.print(temp + ")" + x.getName() + "  ");
            temp++;
            if(temp == 16)
                System.out.println();//go to next line for a better UI
        }
        System.out.println("\n");
    }

    /**
     * this method is used to check that gamer do not add a card more than one time.
     * @param selectedCard : card which should check.
     * @return : false if new cards contains selected card and true if does not contain.
     */
    boolean checkChoose(Cards selectedCard){
        if(newCards.contains(selectedCard))
            return false;
        return true;
    }

    /**
     * this method is used to get card's index from player.
     * @return : index of selected card in player's cards.
     */
    int chooseIndex(){
        int index;
        while (true){
            index = scanner.nextInt();
            if(1 <= index && index <= 30){
                if(checkChoose(playerCards.get(index - 1)))
                    return index;
                else
                    System.out.print("This card is used before,choose another : ");
            }
            else
                System.out.print("Choose between 1 to 30 : ");
        }
    }

    /**
     * in this method gamer enter numbers of 10 numbers that he/she want to play with them.
     * @return : new Linkedlist of gemer's cards.
     */
    LinkedList<Cards> choose(){
        System.out.println("For choose any card,you should enter the number of your wishes card,for example if you want to add the third card,enter 3.\n");
        int choose;

        System.out.print("Enter first card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter second card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter third card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter fourth card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter fifth card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter sixth card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter seventh card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter eighth card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter ninth card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        System.out.print("Enter tenth card number : ");
        choose = chooseIndex();
        newCards.add(playerCards.get(choose - 1));

        scanner.nextLine();//avoid ignore scanner.next or nextLine in continue.
        System.out.println();//go to next line.

        return newCards;
    }

}
