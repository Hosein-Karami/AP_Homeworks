/**
 * this is the class that game happens here when player want to play with computer.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PlayWithComputer {

    private final Player personGamer = new Player();
    private final Player computerGamer = new Player();

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    /**
     * this method manages the game.
     */
    void runGame() throws InterruptedException {
        setPlayersCards();
        chooseCards();

        //Show computer's cars :
        System.out.println("Cards of computer player :");
        printCards(computerGamer);
        System.out.print("If undrestand,press enter :");
        scanner.nextLine();//Wait until user press enter.
        System.out.println("\n");//Go to next lines.

        while(true){
            //a player can make his/her card's energy full or fight :

            personDecide();

            if(computerGamer.getCards().size() == 0){
                System.out.println("********** Person player wins **********");
                break;
            }

            System.out.println("**Computer is deciding what to do,wait.**");
            TimeUnit.SECONDS.sleep(3);//make delay for computer decision.
            System.out.println();//Go to next line.
            computerDecide();
            System.out.println("Your cards after computer's action :");
            printCards(personGamer);

            if(personGamer.getCards().size() == 0){
                System.out.println("********** Computer wins **********");
                break;
            }

        }
    }

    /**
     * In this method person player decide that he/she want to attack or want to make one of his/her card's energy full.
     */
    void personDecide(){
        //a player can make one of his/her card's energy full or fight :
        int makeFullEnergy = 1;

        //Check that player can make one of his/her card's energy or not(at most 3 time) :
        if(personGamer.getMakeFullEnergy() != 0)
            makeFullEnergy = wantMakeFullEnergy();//check which action that player want to do.

        while(true) {
            if (makeFullEnergy == 1) {
                printCards(personGamer);
                personAttack();
                break;
            }
            else {
                LinkedList<Cards> animalsWithIncompleteEnergy = getAnimalsWithIncompleteEnergy(personGamer);
                //Check that player has card with incomplete energy or not :
                if(animalsWithIncompleteEnergy.size() == 0) {
                    System.out.println("*****You do not have any card with incomplete energy.You should fight.*****");
                    makeFullEnergy = 1;//make player to fight.
                }
                else {
                    personGamer.setMakeFullEnergy();//decrease times of player can do this work.
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
     * In this method computer player decide that want to attack or want to make one of it's card's energy full.
     */
    void computerDecide(){
        //a player can make one of his/her card's energy full or fight :
        int makeFullEnergy = 1;

        //Check that player can make one of his/her card's energy or not(at most 3 time) :
        if(computerGamer.getMakeFullEnergy() != 0)
            makeFullEnergy = random.nextInt(0,2);//check which action that computer want to do(1=fight,2=make energy full).

        while(true) {
            if (makeFullEnergy == 1) {
                computerAttack();
                break;
            }

            else {
                LinkedList<Cards> animalsWithIncompleteEnergy = getAnimalsWithIncompleteEnergy(computerGamer);
                //Check that player has card with incomplete energy or not :
                if(animalsWithIncompleteEnergy.size() == 0)
                    makeFullEnergy = 1;//make player to fight.

                else {
                    computerGamer.setMakeFullEnergy();//decrease times of player can do this work.
                    //computer choose a card randomly :
                    int choose = random.nextInt(1,(animalsWithIncompleteEnergy.size() + 1));
                    animalsWithIncompleteEnergy.get(choose - 1).setAnimalEnergyFull();
                    break;
                }
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
     * this method is used to start the attack when computer player is attacker.
     */
    void computerAttack(){
        boolean repeatAttack;//for check attack should repeat or not(because of lack of energy).
        ComputerTurnCards computerTurnCards = new ComputerTurnCards(computerGamer);
        computerGamer.setEachTurnCards(computerTurnCards.selectTurnCards());//set this turn cards.
        ComputerAttack attack = new ComputerAttack(computerGamer,personGamer);
        //check attack should repeat or not :
        while(true){
            repeatAttack = attack.run();
            if(repeatAttack){
                System.out.println();
                computerGamer.clearSelectedCards();
                computerGamer.setEachTurnCards(computerTurnCards.selectTurnCards());//set cards again.
            }
            else {
                computerGamer.clearSelectedCards();
                break;
            }
        }
    }

    /**
     * this method is used to start the attack when person player is attacker.
     */
    void personAttack(){
        boolean repeatAttack;//for check attack should repeat or not(because of lack of energy).
        PersonTurnCards chooseTurnCards = new PersonTurnCards(personGamer);
        personGamer.setEachTurnCards(chooseTurnCards.selectTurnCards());//set this turn cards.
        //Print rival's cards :
        System.out.println("Computer cards : ");
        printCards(computerGamer);
        Attack attack = new Attack(personGamer,computerGamer);
        //check attack should repeat or not :
        while(true){
            repeatAttack = attack.run();
            if(repeatAttack){
                System.out.println();
                personGamer.clearSelectedCards();
                personGamer.setEachTurnCards(chooseTurnCards.selectTurnCards());//set cards again.
            }
            else {
                personGamer.clearSelectedCards();
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
            System.out.print("Choose between 1 and 0 : ");
        }
        return answer;
    }

    /**
     * this method is used to set the players' cards and then players should select 10 cards from 30 cards.
     */
    void setPlayersCards(){
        personGamer.setCards();
        computerGamer.setCards();
    }

    /**
     * used to choose 10 from 30 cards.
     */
    void chooseCards(){
        System.out.println("Now choose 10 cards from 30 cards : ");
        System.out.println();
        personGamer.chooseCards();
        System.out.println();
        ChooseTenCardsForComputer randomChoose = new ChooseTenCardsForComputer(computerGamer);
        randomChoose.choose();//choose 10 cards from 30 cards for computer with random numbers.
    }


    /**
     * is used to print cards of a particular gamer with their health and energy.
     * @param player : show that cards of which player should print.
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
