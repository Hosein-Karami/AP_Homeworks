/**
 * this class runs the game and call different methods and connect with other classes.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package App;

import Characters.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    private static final ArrayList<Player> players = new ArrayList<>();//declare players static because we want access to them without make an object of this class.
    private final ArrayList<Player> winPlayers = new ArrayList<>();//Save players who won the game.
    private final ArrayList<Player> playersWithAbility = new ArrayList<>();//Save players who can use his/her ability.
    private final ArrayList<Player> deadPlayers = new ArrayList<>();//collection of dead players.

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    /**
     * this method get access to players of this class.
     * @return : collection of players.
     */
    public static ArrayList<Player> getPlayers(){
        return players;
    }

    /**
     * this method runs the game.
     */
    void startGame() throws InterruptedException {

        int randomNumber;
        Card selectedPlayerCard;//Save refrence of player's card that choose randomly by robot.
        addPlayersAndGetCards();
        //Game's loop :
        for(int round = 1;round <= 10;round++){
            System.out.println("Round " + round + "  Light is green and players are running.Wait 2 seconds :");
            TimeUnit.SECONDS.sleep(2);//Delay 2 seconds
            System.out.println("Now light is red :");
            //run players and check expiration ability of Strong man and Old man :
            for(Player x : players){
                x.getCard().run();
                if(x.getCard() instanceof OldmanAndStrongman)
                    ((OldmanAndStrongman) x.getCard()).checkAbilityExpiration(round);
            }

            //Choose a player randomly to damage:
            randomNumber = random.nextInt(0, players.size());
            selectedPlayerCard = players.get(randomNumber).getCard();
            //Strong man has a special ability and we should check he use his ability or not :
            if( ! ( (selectedPlayerCard instanceof StrongMan) && ((StrongMan) selectedPlayerCard).getUseAbility() ) ) {
                System.out.println("Computer hits " + selectedPlayerCard.getName());
                selectedPlayerCard.getDamage(25);
            }
            else
                System.out.println("Computer chooses strong man but he runs his ability previous turn.");

            runPlayersAbility(round);//player's ability run.

            //Remove dead players and remove players who can not use his/her ability next turns and print alive players and winnerplayers in this turn:
            Card card;//For save refrence of player's card in loop :
            System.out.print("\nNames of player's card who can run 200 meters and win in this turn and won the game :  ");
            for(Player x : players){
                card = x.getCard();
                if(card.getTravelledDistance() == 200) {
                    System.out.print(card.getName() + "  ");
                    winPlayers.add(x);//Add to wonPlayers.
                }
                if(card.getHealth() <= 0)
                    deadPlayers.add(x);
            }
            System.out.println();//Go to next line.
            removeWinAndDeadPlayers();
            if(players.size() == 0){
                finish();
                return;//Return from game function.
            }

            updatePlayersWithAbility();//Remove players who can not run his/her ability more.
        }
    }

    /**
     * this method is used to make card refrence by with help of random numbers and add players to the collection of players.
     */
    private void addPlayersAndGetCards(){
        players.clear();//clear the players because when we want to play again after the first time,we should add new players and remove the old players.
        int temp;//for save numbers which make randomly.
        int i = 1;//For check loop.
        Card newCard;
        Player newPlayer;
        ArrayList<Integer> randomNumbers = new ArrayList<>();//For save random numbers which make object by them to avoid give a character twice to players.
        while(i <= 5){
            temp = random.nextInt(1,6);

            //Check that temp doesn't exist in randomNumbers :
            if(randomNumbers.contains(temp))
                continue;

            randomNumbers.add(temp);//add temp to arraylist of made numbers.
            //Make card's refrence according to random numbers.
            if(temp == 1)
                newCard = new StrongMan();
            else if(temp == 2)
                newCard = new YoungWoman();
            else if(temp == 3)
                newCard = new AngryMan();
            else if(temp == 4)
                newCard = new OldMan();
            else
                newCard = new IntelligenceMan();

            newPlayer = new Player(newCard);//Make a player object.
            players.add(newPlayer);//add newPlayer to the collection of players.
            playersWithAbility.add(newPlayer);//add newPlayer to the collection of players that can use ability.
            i++;//Update the i.
        }
    }

    /**
     * this method is used to select a player randomly and run his/her ability if she/he want.
     * @param round : number of present round of game.
     */
    void runPlayersAbility(int round){
        int randomNumber;
        Card selectedPlayerCard;//Save refrence of player's card that choose randomly by robot.
        //Choose a player to run his/her ability randomly :
        if(playersWithAbility.size() != 0){
            randomNumber = random.nextInt(0, playersWithAbility.size());
            selectedPlayerCard = playersWithAbility.get(randomNumber).getCard();
            System.out.print("Player who has " + selectedPlayerCard.getName() + " Can use ability.(1 = I want to use my card's ability,0 = I don't want to use my card's ability) : ");
            int choose;
            //Check input :
            while (true){
                choose = scanner.nextInt();
                if(choose == 0 || choose == 1)
                    break;
                System.out.print("Invalid input.Choose between 0 and 1 : ");
            }
            if(choose == 1){
                if(selectedPlayerCard instanceof OldmanAndStrongman)
                    ((OldmanAndStrongman) selectedPlayerCard).setAbilityRound(round);
                selectedPlayerCard.doSpecialAbility();
            }
        }
        else
            System.out.println("Nobody can run his/her ability :/\n");
    }

    /**
     * this method is used to remove players who won the game or dead,from collection of normal players of the game an at end print the alive players.
     */
    void removeWinAndDeadPlayers(){
        //Remove players who won the game :
        for(Player x : winPlayers) {
            players.remove(x);
            playersWithAbility.remove(x);//this player can not play and therefore can not run his/her ability.
        }

        //Remove dead players :
        for(Player x : deadPlayers) {
            players.remove(x);
            playersWithAbility.remove(x);//this player can not play and therefore can not run his/her ability.
        }

        //Print the alive players with their speed and health:
        if(players.size() != 0){
            Card playersCard;//Save card of players in loop.
            System.out.println("Alive players :");
            for(Player x : players) {
                playersCard = x.getCard();
                System.out.println(playersCard.getName() + "  Speed : " + playersCard.getSpeed() + "  Health : " + playersCard.getHealth() + "  Travelled distance : " + playersCard.getTravelledDistance());
            }

            System.out.println("\nIf undrestand,press enter :");
            scanner.nextLine();
            scanner.nextLine();//Wait until user press enter.
        }
    }

    /**
     * this method updates the collection of players who can run his/her ability.
     */
    void updatePlayersWithAbility(){
        ArrayList<Player> delete = new ArrayList<>();
        //We can not remove in for-each loop,then :
        for(Player x : playersWithAbility){
            if(x.getCard().getAbilityCount() == 0)
                delete.add(x);
        }
        //now remove :
        for (Player x : delete)
            playersWithAbility.remove(x);
    }

    /**
     * this method is used to finish the game and print results :
     */
    void finish(){
        System.out.println("***** Game is finished *****");
        if(winPlayers.size() == 0){
            System.out.println("Nobody won this game :/");
            return;//Return from function and don't continue.
        }
        int temp = 1;
        System.out.println("Players who won the game : ");
        for(Player x : winPlayers){
            System.out.println(temp + ")" + x.getCard().getName());
            temp++;
        }
    }

}
