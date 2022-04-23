/**
 * this class is used to save information of admins and get access to them.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Users;

import Films.Film;
import java.util.ArrayList;

public class VipUser extends User {

    //Constructor :
    public VipUser(String userName,String password){
        super(userName,password);
    }

    /**
     * This method is used when we transfer a normal user to vip user,and we want set the films which user score them before.
     * @param scoredFilms : Collection of films which user score them.
     */
    public void setUserScoredFilms(ArrayList<Film> scoredFilms){
        this.scoredFilms = scoredFilms;
    }

}
