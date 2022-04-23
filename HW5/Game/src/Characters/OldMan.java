/**
 * this class is used to save information of Old man and declare some function for run this character tasks.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Characters;

public class OldMan extends Card implements OldmanAndStrongman{

    private int abilityRound = -3;//Saves number of last round which this card runs its ability and initialize with -3.
    private int speedBeforeAbility;//This method saves last speed of this card before card's ability runs.

    //Constructors :
    public OldMan(){
        super("Old Man",75,20,2,false);
    }

    @Override
    public void doSpecialAbility() {
        speedBeforeAbility = getSpeed();//Save present speed.
        setSpeed((2 * speedBeforeAbility));//Set new speed.
        setAbilityCount();//decrease one of his time that he can use his ability.
    }

    /**
     * this method is used to change speed of this character after his speed change because of his ability.
     * @param presentRound : number of present round of game.
     */
    @Override
    public void checkAbilityExpiration(int presentRound) {
        //If (presentRound - abilityRound) equals 2 means ability should expire.
        if((presentRound - abilityRound) == 2){
            setSpeed((speedBeforeAbility - 2));//Set new speed value.
        }
    }

    /**
     * this method is used to save the round which card's ability runs.
     * @param abilityRound : number of round which card's ability runs.
     */
    @Override
    public void setAbilityRound(int abilityRound) {
        this.abilityRound = abilityRound;
    }
}
