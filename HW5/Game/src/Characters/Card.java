/**
 * this class is used to save information and declare methods which is common between characters and get access to information.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Characters;

public abstract class Card {

    private final String name;
    private int health;
    private int speed;
    private final boolean isNegative;//Show that a character is negative character or not.
    private int abilityCount;//Show that how many times,a character can use its ability.
    private int travelledDistance;

    //Constructor :
    protected Card(String name,int health,int speed,int abilityCount,boolean isNegative){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.abilityCount = abilityCount;
        this.isNegative = isNegative;
    }

    /**
     * this method change a card's health.
     * @param healthChange : Changed value of card's health.
     */
    public void setHealth(int healthChange){
        health += healthChange;
    }

    /**
     * this method is used when a character uses its ability and we should decrease the times that this card can use its ability.
     */
    protected void setAbilityCount(){
        abilityCount--;
    }

    /**
     * this method set the new speed.
     * @param speed : new speed value.
     */
    protected void setSpeed(int speed){
        this.speed = speed;
    }

    /**
     * this method get access to name of card.
     * @return : name of card.
     */
    public String getName(){
        return name;
    }

    /**
     * this method get access to abilityCount of card.
     * @return : abilityCount of card(times which player can run his/her ability).
     */
    public int getAbilityCount(){
        return abilityCount;
    }

    /**
     * this method get access to health of card.
     * @return : health of card.
     */
    public int getHealth(){
        return health;
    }

    /**
     * this method get access to speed of card.
     * @return : speed of card.
     */
    public int getSpeed(){
        return speed;
    }

    /**
     * this method get access to travelledDistance of card.
     * @return : travelledDistance of card.
     */
    public int getTravelledDistance(){
        return travelledDistance;
    }

    /**
     * this method runs each character own ability.
     */
    public abstract void doSpecialAbility();

    /**
     * this method is used to decrease the card's health.
     * @param damageValue : value pf damage.
     */
    public void getDamage(int damageValue){
        health -= damageValue;
    }

    /**
     * this method is used when light is green and players run.
     */
    public void run(){
        if(travelledDistance + speed >= 200)
            travelledDistance = 200;
        else
            travelledDistance += speed;
    }

}
