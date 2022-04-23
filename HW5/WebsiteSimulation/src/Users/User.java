/**
 * this class is used to save information that is common between normal users and vip users and get access to them.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Users;

import Films.Film;
import java.util.ArrayList;

public abstract class User extends GeneralUser{

    protected ArrayList<Film> scoredFilms;//Save films which user score it.

    //Constructor :
    protected User(String userName,String password){
        super(userName,password);
        scoredFilms = new ArrayList<>();
    }

    /**
     * this method is used to get access to the list which consist films which user score them.
     * @return : collection of films which user score them.
     */
    public ArrayList<Film> getScoredFilms() {
        return scoredFilms;
    }

    /**
     * this method is used when user score a film and we should add film to scoredFilms of user.
     * @param scoredFilm : film which user score it.
     */
    public void addScoredFilm(Film scoredFilm){
        scoredFilms.add(scoredFilm);
    }
}
