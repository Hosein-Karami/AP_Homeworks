/**
 * this class is an abstract class and has fields and methods that are common between all types of films.
 */

package Films;

import java.util.ArrayList;

public abstract class Film {

    private final String name;
    private final String summary;
    private final FilmsGenre genre;
    private final String directorName;
    private final ArrayList<String> actorsName;
    private final AgeRange ageRange;
    private int scores;//Scores of this video.

    //Constructor :
    protected Film(String name,String summary,FilmsGenre genre,String directorName,ArrayList<String> actorsName,AgeRange ageRange){
        this.name = name;
        this.summary = summary;
        this.genre = genre;
        this.directorName = directorName;
        this.actorsName = actorsName;
        this.ageRange = ageRange;
        scores = 0;
    }

    /**
     * this method get access to name of the film.
     * @return : name of film.
     */
    public String getName(){
        return name;
    }

    /**
     * this method get access to ageRange of this film.
     * @return : ageRange
     */
    public AgeRange getAgeRange(){
        return ageRange;
    }

    /**
     * this method get access to genre of this film.
     * @return : genre
     */
    public FilmsGenre getGenre(){
        return genre;
    }

    /**
     * this method return name of the director of this film.
     * @return : name of the director of this film
     */
    public String getDirectorName(){
        return directorName;
    }

    /**
     * this method get access to list of the actors in this film.
     * @return : list of the actors in this film
     */
    public ArrayList<String> getActorsName() {
        return actorsName;
    }

    /**
     * this method is used to update and sum score of this film when an user score this film.
     * @param score : score which user select.
     */
    public void sumScore(int score){
        scores += score;
    }

    abstract String specialProperty();
    public abstract void download();//this method runs when user want to download this film.

    /**
     * this method returns information of a film in String format to print in console.
     * @return : information of a film in String format.
     */
    @Override
    public String toString() {
        return
                "name = " + name + '\'' +
                ", summary = " + summary +
                "\ngenre = " + genre +
                ", directorName = " + directorName +
                "\nactorsName = " + actorsName +
                "\nageRange = " + ageRange +
                ", scores = " + scores + "\n" + specialProperty();
    }
}
