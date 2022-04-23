/**
 * this class is used to save information of Angry man and declare some function for run this character tasks.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Characters;

import App.Game;
import App.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class AngryMan extends Card{

    //Constructor :
    public AngryMan() {
        super("Angry Man",75,20,1,true);
    }

    /**
     * this method runs ability of this character and get damage 50 unit to a card that its distance from this card in less than 10 meters.
     */
    @Override
    public void doSpecialAbility() {
        ArrayList<Player> gamePlayers = Game.getPlayers();//Collection of players in the game.
        ArrayList<Player> targetPlayers = new ArrayList<>();//Collection of players whose distance from Angry Man is less than 10 meters.
        for(Player x : gamePlayers) {
            //We should not add Angry Man itself to the targetPlayers :
            if (x.getCard().getName().equals("Angry Man"))
                continue;

            //Check distance :
            if ((Math.abs(((x.getCard().getTravelledDistance())) - (this.getTravelledDistance())) <= 10))
                targetPlayers.add(x);

        }
        if (targetPlayers.size() == 0) {
            System.out.println("\n*****There is no proper player for damage and he can not use his ability*****\n");
            return;//Return from function.
        }
        //Print target players :
        int temp = 1;
        System.out.println("\nPlayers you can damage them(Nearer than 10 meters to you) :");
        for(Player y : targetPlayers){
            System.out.println(temp + ")" + y.getCard().getName());
            temp++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose number of card that you want to damage : ");
        //Check input :
        while (true){
            temp = scanner.nextInt();
            if(1 <= temp && temp <= targetPlayers.size())
                break;
            System.out.print("Invalid input.Choose from 1 to " + targetPlayers.size() + " : ");
        }
        Card damagedCard = targetPlayers.get(temp - 1).getCard();
        damagedCard.setHealth(-50);//damage
        setAbilityCount();//decrease one of his time that he can use his ability.
    }

}
