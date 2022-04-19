package Animals;

/**
 * this class is used to save and get access to cow's information.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/5/22
 */

public class Cow {
    private final String name;
    private int energy;
    private int health;
    private final int strongHit;
    private final int normalHit;

    public Cow(){
        name = "Cow";
        energy = 400;
        health = 750;
        strongHit = 100;
        normalHit = 90;
    }

    /**
     * this method is used to return name of animal.
     * @return : Name of animal.
     */
    public String getName(){
        return name;
    }
    /**
     * this method is used to return wishes hit value.
     * @param number : show that player want to hit with strongHit or normalHit.
     * @return : wishes hit value.
     */
    public int getHit(int number){
        if(number == 1)
            return strongHit;
        else
            return normalHit;
    }

    /**
     * this method get access to energy of animal.
     * @return : Energy of animal.
     */
    public int getEnergy(){
        return energy;
    }

    /**
     * this method return animal's health.
     * @return : health of animal.
     */
    public int getHealth(){
        return health;
    }

    /**
     * this method is used to get access to energy of an animal at start point of the game.
     * @return : value of energy of this animal at start point of the game.
     */
    public int getFullEnergyValue(){
        return 400;
    }
    /**
     * this method change animal's health.
     * @param health : new health.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * this method change animal's energy.
     * @param energy : new energy.
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * this method is used to make animal's energy full.
     */
    public void setEnergyFull(){
        energy = 400;
    }

}
