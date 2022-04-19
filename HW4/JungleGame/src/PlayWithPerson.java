/**
 * this is the class that game happens here when player want to play with person.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Scanner;

public class PlayWithPerson {

    private final Player firstGamer = new Player();
    private final Player secondGamer = new Player();

    Scanner scanner = new Scanner(System.in);

    /**
     * this method manages the game.
     */
    void runGame() {
        setPlayersCards();
        chooseCards();

        //Show player's cards :
        System.out.println("First player's cards :");
        printCards(firstGamer);
        System.out.println("Second player's cards:");
        printCards(secondGamer);
        System.out.print("If undrestand,press enter :");
        scanner.nextLine();//Wait until user press enter.
        System.out.println("\n");//Go to next lines.

        while(true) {

            System.out.println("First player's turn :");
            playerDecide(firstGamer,secondGamer);

            if(secondGamer.getCards().size() == 0){
                System.out.println("********** First player wins **********");
                break;
            }

            System.out.println("Second player's turn :");
            playerDecide(secondGamer,firstGamer);

            if(firstGamer.getCards().size() == 0){
                System.out.println("********** Second player wins **********");
                break;
            }

        }
    }

    /**
     * In this method player decide that he/she want to attack or want to make one of his/her card's energy full.
     * @param attacker : player who should decide.
     * @param defender : other player.
     */
    void playerDecide(Player attacker,Player defender){
        //a player can make one of his/her card's energy full or fight :
        int makeFullEnergy = 1;

        printCards(attacker);

        //Check that player can make one of his/her card's energy or not(at most 3 time) :
        if(attacker.getMakeFullEnergy() != 0)
            makeFullEnergy = wantMakeFullEnergy();//check which action that player want to do.

        while(true) {
            if (makeFullEnergy == 1) {
                attack(attacker, defender);
                break;
            }
            else {
                LinkedList<Cards> animalsWithIncompleteEnergy = getAnimalsWithIncompleteEnergy(attacker);
                //Check that player has card with incomplete energy or not :
                if(animalsWithIncompleteEnergy.size() == 0) {
                    System.out.println("*****You do not have any card with incomplete energy.You should fight.*****");
                    makeFullEnergy = 1;//make player to fight.
                }
                else {
                    attacker.setMakeFullEnergy();//decrease times of player can do this work.
                    int temp = 1;
                    System.out.println("Your cards with incomplete energy : ");
                    for(Cards x : animalsWithIncompleteEnergy){
                        System.out.println(temp + ") " + x.getName());
                        temp++;
                    }
                    System.out.print("Choose one of the below cards(Cards with incomplete energy) number : ");
                    int choose;
                    //Check input of user :
                    while(true){
                        choose = scanner.nextInt();
                        if(1 <= choose && choose <= animalsWithIncompleteEnergy.size())
                            break;
                        System.out.print("Invalid input.Choose from 1 to " + animalsWithIncompleteEnergy.size() + " : ");
                    }
                    animalsWithIncompleteEnergy.get(choose - 1).setAnimalEnergyFull();
                    break;
                }
                System.out.println("\n");
            }
        }
    }

    /**
     * this method return player's cards which have incomplete energy when player want makes one of his card's energy full.
     * @param player : player who we want check his/her cards.
     * @return : List of player's cards which have incomplete energy.
     */
    LinkedList<Cards> getAnimalsWithIncompleteEnergy(Player player){
        LinkedList<Cards> animalsWithIncompleteEnergy = new LinkedList<>();
        for(Cards x : player.getCards()){
            if(x.getEnergy() != x.getFullEnergyValue())
                animalsWithIncompleteEnergy.add(x);
        }
        return animalsWithIncompleteEnergy;
    }

    /**
     * this method is used to start the attack.
     * @param attacker : refrence of attacker player.
     * @param defender : refrence of defender player.
     */
    void attack(Player attacker,Player defender){
        boolean repeatAttack;//for check attack should repeat or not(because of lack of energy).
        PersonTurnCards chooseTurnCards = new PersonTurnCards(attacker);
        attacker.setEachTurnCards(chooseTurnCards.selectTurnCards());//set this turn cards.
        //Print rival's cards :
        System.out.println("Rival's cards : ");
        printCards(defender);
        Attack attack = new Attack(attacker,defender);
        //check attack should repeat or not :
        while(true){
            repeatAttack = attack.run();
            if(repeatAttack){
                System.out.println();
                attacker.clearSelectedCards();
                attacker.setEachTurnCards(chooseTurnCards.selectTurnCards());//set cards again.
            }
            else {
                attacker.clearSelectedCards();
                break;
            }
        }
    }

    /**
     * this method is used to ask player that he/she want to fight or make one of his/her card's energy full.
     * @return : answer of player
     */
    int wantMakeFullEnergy(){
        int answer;
        System.out.print("Do you want to fight or make one of your card's energy full(1 = fight,2 = make energy full)? : ");
        //control input :
        while(true){
            answer = scanner.nextInt();
            if(answer == 2 || answer == 1)
                break;
            System.out.print("Choose between 1 and 2 : ");
        }
        return answer;
    }

    /**
     * this method is used to set the players' cards and then players should select 10 cards from 30 cards.
     */
    void setPlayersCards(){
        firstGamer.setCards();
        secondGamer.setCards();
    }

    /**
     * used to choose 10 from 30 cards.
     */
    void chooseCards(){
        System.out.println("Now is first gamer turn to choose : ");
        System.out.println();
        firstGamer.chooseCards();
        System.out.println("Now is second gamer turn to choose : ");
        System.out.println();
        secondGamer.chooseCards();
    }

    /**
     * is used to print cards of a particular gamer with their health and energy.
     * @param player : player who his/her cards should print.
     */
    void printCards(Player player){
        int temp = 1;
        for (Cards x : player.getCards()) {
            System.out.println(temp + ")" + x.getName() + " [Health : " + x.getHealth() + "  Energy : " + x.getEnergy() +"]  ");
            temp++;
        }
        System.out.println();//go to next line.
    }
}
