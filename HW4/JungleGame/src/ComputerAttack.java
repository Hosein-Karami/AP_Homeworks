/**
 * this class is used when computer want to attack.make choice with random numbers.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Random;

public class ComputerAttack {

    private final Player attacker;
    private final Player defender;
    private final LinkedList<Cards> attackerCards;
    private final LinkedList<Cards> defenderCards;
    private Cards defendAnimal;

    Random random = new Random();

    ComputerAttack(Player attacker,Player defender){
        this.attacker = attacker;
        this.defender = defender;
        this.attackerCards = attacker.getEachTurnCards();
        this.defenderCards = defender.getCards();
    }

    /**
     * run attack and shows attack should repeat(because of loss of energy) or not.
     * @return : a boolean that shows attack should repeat(because of loss of energy) or not.
     */
    boolean run(){
        int damages = startAttack();
        int temp = (damages / attackerCards.size());//value of energy that should be reduced from each attacker animals.
        //Check that each attacker animal has enough energy :
        boolean repeatAttack = false;
        for(Cards x : attackerCards){
            if((x.getEnergy() - temp) < 0){
                repeatAttack = true;
                break;
            }
        }

        if(repeatAttack)
            return true;

        else{
            if((defendAnimal.getHealth() - damages) <= 0)
                defenderCards.remove(defendAnimal);
            else
                defendAnimal.setAnimalHealth(defendAnimal.getHealth() - damages);
            for(Cards x : attackerCards)
                x.setAnimalEnergy(x.getEnergy() - temp);
            return false;
        }

    }

    /**
     * this method is used to sum all hits and return it for run method.
     * @return : Sumation of hits.
     */
    int startAttack(){

        int choose = random.nextInt(1,(defenderCards.size() + 1));//choose defended animal that we should attack to it.

        defendAnimal = defenderCards.get(choose - 1);

        int sumHits = 0,animalType;
        for(Cards x : attackerCards){
            animalType = x.getAnimalType();
            //If our animal has two hits :
            if(animalType == 1 || animalType == 2 || animalType == 3 || animalType == 6 || animalType == 10){
                choose = random.nextInt(0,2);//choose between normal hit and powerfull hit.
                sumHits += x.getHit(choose);
            }
            else
                sumHits += x.getHit(0);
        }
        return sumHits;
    }
}
