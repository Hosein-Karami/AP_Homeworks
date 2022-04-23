/**
 * this class is used to save information of Young woman and declare some function for run this character tasks.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Characters;

import App.Game;
import App.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class YoungWoman extends Card{

    //Constructors :
    public YoungWoman(){
        super("Young Woman",75,25,1,true);
    }

    /**
     * this method is used to run ability of this card and damage a card 25 unit.
     */
    @Override
    public void doSpecialAbility() {
        ArrayList<Player> targetPlayers = Game.getPlayers();
        if(targetPlayers.size() == 0){
            System.out.print("There is no player except you in game.\n");
            return;
        }
        int temp = 1;
        //Print players except Young Woman itself :
        for(Player x : targetPlayers){
            if(x.getCard().getName().equals("YoungWoman"))
                continue;
            System.out.println(temp + ")" + x.getCard().getName());
            temp++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose number of card that you want to damage : ");
        //Control input :
        while (true){
            temp = scanner.nextInt();
            if(1 <= temp && temp <= targetPlayers.size()){
                //Player shouldn't choose herself/himself :
                if( ! (targetPlayers.get(temp - 1).getCard().equals(this)))
                    break;
                System.out.print("You can not choose yourself.Choose another number : ");
            }
            else
                System.out.print("Invalid input.Choose from 1 to " + targetPlayers.size() + " : ");
        }
        Card targetCard = targetPlayers.get(temp - 1).getCard();
        targetCard.setHealth(-25);//damage card.
        setAbilityCount();//decrease one of her time that she can use her ability.
    }

}
