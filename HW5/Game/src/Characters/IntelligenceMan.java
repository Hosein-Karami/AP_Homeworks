/**
 * this class is used to save information of Intelligence man and declare some function for run this character tasks.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Characters;

public class IntelligenceMan extends Card{

    //Constructor :
    public IntelligenceMan(){
        super("Intelligence Man",75,20,2,false);
    }

    /**
     * this method runs his special ability and increase his health 25 unit.
     */
    @Override
    public void doSpecialAbility() {
        setHealth(25);
        setAbilityCount();//decrease one of his time that he can use his ability.
    }

}
