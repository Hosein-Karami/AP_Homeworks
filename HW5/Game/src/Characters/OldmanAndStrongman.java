/**
 * This interface is used for Strong man and Old man and has a method which explain about in its javadoc.
 */

package Characters;

public interface OldmanAndStrongman {

    /**
     * this method is used to check that ability of these characters should expire or not.
     * @param presentRound : number of present round of game.
     */
    void checkAbilityExpiration(int presentRound);

    /**
     * this method is used to save the round which card's ability runs.
     * @param abilityRound : number of round which card's ability runs.
     */
    void setAbilityRound(int abilityRound);

}
