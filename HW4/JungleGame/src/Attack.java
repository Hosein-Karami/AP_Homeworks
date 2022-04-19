/**
 * this class is used to start the attack of attacker player.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Attack {

    private final Player attacker;
    private final Player defender;
    private final LinkedList<Cards> attackerCards;
    private final LinkedList<Cards> defenderCards;
    private Cards defendAnimal;
    Scanner scanner = new Scanner(System.in);

    //Constructor :
    Attack(Player attacker,Player defender){
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
        boolean repeatAttack = false;//for check that attack should repeat(Because loss of energy) or not.
        for(Cards x : attackerCards){
            if((x.getEnergy() - temp) < 0){
                repeatAttack = true;
                break;
            }
        }
        if(repeatAttack){
            System.out.println("Your animals have not enough energy for this attack,choose another attack.\n");
            return true;
        }
        else{
            if((defendAnimal.getHealth() - damages) <= 0)
                defenderCards.remove(defendAnimal);
            else
                defendAnimal.setAnimalHealth(defendAnimal.getHealth() - damages);
            for(Cards x : attackerCards)
                x.setAnimalEnergy(x.getEnergy() - temp);
            System.out.println();
            return false;
        }
    }

    /**
     * this method is used to sum all hits and return it for run method.
     * @return : Sumation of hits.
     */
    int startAttack(){
        //attacker should choose one of rival's cards and attack to it :
        System.out.print("Choose one of rival's card which you want to attack to it(enter number of it,for example if you want attack to first card,enter 1) : ");
        int choose;

        //control input :
        while(true){
            choose = scanner.nextInt();
            if(1 <= choose && choose <= defenderCards.size())
                break;
            else
                System.out.println("invalid number.");
        }

        defendAnimal = defenderCards.get(choose - 1);

        int sumHits = 0,animalType;
        for(Cards x : attackerCards){
            animalType = x.getAnimalType();
            //If our animal has two hits type :
            if(animalType == 1 || animalType == 2 || animalType == 3 || animalType == 6 || animalType == 10){
                System.out.print("Do you want to use powerfull hit of " + x.getName() + "(1 = Yes,0 = No)? ");
                //control input :
                while(true){
                    choose = scanner.nextInt();
                    if(choose == 0 || choose == 1)
                        break;
                    System.out.print("Choose between 0 and 1 : ");
                }
                sumHits += x.getHit(choose);
            }

            else
                sumHits += x.getHit(0);
        }
        return sumHits;
    }
}
