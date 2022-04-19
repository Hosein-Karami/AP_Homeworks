/**
 * this class is used to unify animals,and with this class we can gather each animal without use inheritance.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

import Animals.*;

public class Cards {
    private final int animalType;//each animal type has unique animalType.
    private final Object animal;

    Cards(int animalType){
        this.animalType = animalType;

        if(animalType == 1)
            animal = new Lion();
        else if(animalType == 2)
            animal = new Bear();
        else if(animalType == 3)
            animal = new Tiger();
        else if(animalType == 4)
            animal = new vulture();
        else if(animalType == 5)
            animal = new Fox();
        else if(animalType == 6)
            animal = new Elephant();
        else if(animalType == 7)
            animal = new Wolf();
        else if(animalType == 8)
            animal = new Hog();
        else if(animalType == 9)
            animal = new Hippopotamus();
        else if(animalType == 10)
            animal = new Cow();
        else if(animalType == 11)
            animal = new Rabbit();
        else
            animal = new Turtle();
    }

    /**
     * this method is used to return type of animals.
     * @return : type of animal.
     */
    int getAnimalType(){
        return animalType;
    }
    /**
     * this method is used to return animal's name with cast animal variable by animaltype.
     * @return : name of animal.
     */
    String getName(){
        if(animalType == 1)
            return ((Lion) animal).getName();
        else if(animalType == 2)
            return ((Bear) animal).getName();
        else if(animalType == 3)
            return ((Tiger) animal).getName();
        else if(animalType == 4)
            return ((vulture) animal).getName();
        else if(animalType == 5)
            return ((Fox) animal).getName();
        else if(animalType == 6)
            return ((Elephant) animal).getName();
        else if(animalType == 7)
            return ((Wolf) animal).getName();
        else if(animalType == 8)
            return ((Hog) animal).getName();
        else if(animalType == 9)
            return ((Hippopotamus) animal).getName();
        else if(animalType == 10)
            return ((Cow) animal).getName();
        else if(animalType == 11)
            return ((Rabbit) animal).getName();
        else
            return ((Turtle) animal).getName();
    }

    /**
     * return hit value of a particular animal.
     * @param number : it is important when our animal have both normal and powerfull hit and show player want which hit.
     * @return : value of hit of wishes animal.
     */
    int getHit(int number){
        if(animalType == 1)
            return ((Lion) animal).getHit(number);
        if(animalType == 2)
            return ((Bear) animal).getHit(number);
        if(animalType == 3)
            return ((Tiger) animal).getHit(number);
        if(animalType == 4)
            return ((vulture) animal).getHit();
        if(animalType == 5)
            return ((Fox) animal).getHit();
        if(animalType == 6)
            return ((Elephant) animal).getHit(number);
        if(animalType == 7)
            return ((Wolf) animal).getHit();
        if(animalType == 8)
            return ((Hog) animal).getHit();
        if(animalType == 9)
            return ((Hippopotamus) animal).getHit();
        if(animalType == 10)
            return ((Cow) animal).getHit(number);
        if(animalType == 11)
            return ((Rabbit) animal).getHit();
        else
            return ((Turtle) animal).getHit();
    }

    /**
     * this method get access to energy of animal.
     * @return : energy of a animal.
     */
    int getEnergy(){
        if(animalType == 1)
            return ((Lion) animal).getEnergy();
        if(animalType == 2)
            return ((Bear) animal).getEnergy();
        if(animalType == 3)
            return ((Tiger) animal).getEnergy();
        if(animalType == 4)
            return ((vulture) animal).getEnergy();
        if(animalType == 5)
            return ((Fox) animal).getEnergy();
        if(animalType == 6)
            return ((Elephant) animal).getEnergy();
        if(animalType == 7)
            return ((Wolf) animal).getEnergy();
        if(animalType == 8)
            return ((Hog) animal).getEnergy();
        if(animalType == 9)
            return ((Hippopotamus) animal).getEnergy();
        if(animalType == 10)
            return ((Cow) animal).getEnergy();
        if(animalType == 11)
            return ((Rabbit) animal).getEnergy();
        else
            return ((Turtle) animal).getEnergy();
    }

    /**
     * this method get access to a particular animal's health.
     * @return : health of a particular animal.
     */
    int getHealth(){
        if(animalType == 1)
            return ((Lion) animal).getHealth();
        if(animalType == 2)
            return ((Bear) animal).getHealth();
        if(animalType == 3)
            return ((Tiger) animal).getHealth();
        if(animalType == 4)
            return ((vulture) animal).getHealth();
        if(animalType == 5)
            return ((Fox) animal).getHealth();
        if(animalType == 6)
            return ((Elephant) animal).getHealth();
        if(animalType == 7)
            return ((Wolf) animal).getHealth();
        if(animalType == 8)
            return ((Hog) animal).getHealth();
        if(animalType == 9)
            return ((Hippopotamus) animal).getHealth();
        if(animalType == 10)
            return ((Cow) animal).getHealth();
        if(animalType == 11)
            return ((Rabbit) animal).getHealth();
        else
            return ((Turtle) animal).getHealth();
    }

    /**
     * this method is used to get access to energy of an animal at start point of the game.
     * @return : value of energy of this animal at start point of the game.
     */
    int getFullEnergyValue(){
        if(animalType == 1)
            return ((Lion) animal).getFullEnergyValue();
        if(animalType == 2)
            return ((Bear) animal).getFullEnergyValue();
        if(animalType == 3)
            return ((Tiger) animal).getFullEnergyValue();
        if(animalType == 4)
            return ((vulture) animal).getFullEnergyValue();
        if(animalType == 5)
            return ((Fox) animal).getFullEnergyValue();
        if(animalType == 6)
            return ((Elephant) animal).getFullEnergyValue();
        if(animalType == 7)
            return ((Wolf) animal).getFullEnergyValue();
        if(animalType == 8)
            return ((Hog) animal).getFullEnergyValue();
        if(animalType == 9)
            return ((Hippopotamus) animal).getFullEnergyValue();
        if(animalType == 10)
            return ((Cow) animal).getFullEnergyValue();
        if(animalType == 11)
            return ((Rabbit) animal).getFullEnergyValue();
        else
            return ((Turtle) animal).getFullEnergyValue();
    }
    /**
     * this method is used to make a card's energy full.
     */
    void setAnimalEnergyFull(){
        if(animalType == 1)
            ((Lion) animal).setEnergyFull();
        else if(animalType == 2)
            ((Bear) animal).setEnergyFull();
        else if(animalType == 3)
            ((Tiger) animal).setEnergyFull();
        else if(animalType == 4)
            ((vulture) animal).setEnergyFull();
        else if(animalType == 5)
            ((Fox) animal).setEnergyFull();
        else if(animalType == 6)
            ((Elephant) animal).setEnergyFull();
        else if(animalType == 7)
            ((Wolf) animal).setEnergyFull();
        else if(animalType == 8)
            ((Hog) animal).setEnergyFull();
        else if(animalType == 9)
            ((Hippopotamus) animal).setEnergyFull();
        else if(animalType == 10)
            ((Cow) animal).setEnergyFull();
        else if(animalType == 11)
            ((Rabbit) animal).setEnergyFull();
        else
            ((Turtle) animal).setEnergyFull();
    }

    /**
     * this method is used to change an animal's health.
     * @param newHealth : new health of animal
     */
    void setAnimalHealth(int newHealth){
        if(animalType == 1)
            ((Lion) animal).setHealth(newHealth);
        else if(animalType == 2)
            ((Bear) animal).setHealth(newHealth);
        else if(animalType == 3)
            ((Tiger) animal).setHealth(newHealth);
        else if(animalType == 4)
            ((vulture) animal).setHealth(newHealth);
        else if(animalType == 5)
            ((Fox) animal).setHealth(newHealth);
        else if(animalType == 6)
            ((Elephant) animal).setHealth(newHealth);
        else if(animalType == 7)
            ((Wolf) animal).setHealth(newHealth);
        else if(animalType == 8)
            ((Hog) animal).setHealth(newHealth);
        else if(animalType == 9)
            ((Hippopotamus) animal).setHealth(newHealth);
        else if(animalType == 10)
            ((Cow) animal).setHealth(newHealth);
        else if(animalType == 11)
            ((Rabbit) animal).setHealth(newHealth);
        else
            ((Turtle) animal).setHealth(newHealth);
    }

    /**
     * this method is used to change an animal's energy.
     * @param newEnergy : new energy of animal.
     */
    void setAnimalEnergy(int newEnergy){
        if(animalType == 1)
            ((Lion) animal).setEnergy(newEnergy);
        else if(animalType == 2)
            ((Bear) animal).setEnergy(newEnergy);
        else if(animalType == 3)
            ((Tiger) animal).setEnergy(newEnergy);
        else if(animalType == 4)
            ((vulture) animal).setEnergy(newEnergy);
        else if(animalType == 5)
            ((Fox) animal).setEnergy(newEnergy);
        else if(animalType == 6)
            ((Elephant) animal).setEnergy(newEnergy);
        else if(animalType == 7)
            ((Wolf) animal).setEnergy(newEnergy);
        else if(animalType == 8)
            ((Hog) animal).setEnergy(newEnergy);
        else if(animalType == 9)
            ((Hippopotamus) animal).setEnergy(newEnergy);
        else if(animalType == 10)
            ((Cow) animal).setEnergy(newEnergy);
        else if(animalType == 11)
            ((Rabbit) animal).setEnergy(newEnergy);
        else
            ((Turtle) animal).setEnergy(newEnergy);
    }
}
