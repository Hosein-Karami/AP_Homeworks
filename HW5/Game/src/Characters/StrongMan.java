/**
 * this class is used to save information of Strong man and declare some function for run this character tasks.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Characters;

public class StrongMan extends Card implements OldmanAndStrongman{

    private boolean useAbility = false;//This variable show that this card use his ability or not.
    private int abilityRound = -3;//Saves number of last round which this card runs its ability and initialize with -3.

    //Constructor :
    public StrongMan(){
        super("Strong Man",100,20,2,false);
    }

    /**
     * this method get access to useAbility variable of this card.
     * @return : value of useAbility.
     */
    public boolean getUseAbility(){
        return useAbility;
    }

    /**
     * this method runs this card's ability and set useAbility true.
     */
    @Override
    public void doSpecialAbility() {
        System.out.println("Ability successfully run and nobody can damage you next turn.");
        useAbility = true;
        setAbilityCount();//decrease one of his time that he can use his ability.
    }

    /**
     * this method is used to set useAbility false to avoid this card use his ability more than 1 round.
     * @param presentRound : number of present round of game.
     */
    @Override
    public void checkAbilityExpiration(int presentRound) {
        //If (presentRound - abilityRound) equals 2 means ability should expire.
        if((presentRound - abilityRound) == 2){
            useAbility = false;
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
