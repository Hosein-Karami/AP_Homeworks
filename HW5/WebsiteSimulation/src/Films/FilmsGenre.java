/**
 * this enum is used to attach a genre to each film.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Films;

public enum FilmsGenre {

    DOCUMENTARY,DRAMA,ACTION,COMEDY,ADVENTURE;

    /**
     * this method is used to return proper genre according to user's choice.
     * @param choose : show genre which user choose in Integer format.
     * @return : genre proper for choose which user input.
     */
    public static FilmsGenre getGenre(int choose){
        if(choose == 1)
            return DOCUMENTARY;
        else if(choose == 2)
            return DRAMA;
        else if(choose == 3)
            return ACTION;
        else if(choose == 4)
            return COMEDY;
        else
            return ADVENTURE;
    }

}
