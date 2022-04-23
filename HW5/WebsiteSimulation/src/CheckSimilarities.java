/**
 * this class is used to show the films which have most similarity with film which downloaded by user.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

import Films.Film;
import java.util.ArrayList;

public class CheckSimilarities {

    /**
     * this method start check and save similarity of films with downloaded film.
     * @param films : collection of website's films.
     * @param downloadedFilm : refrence of film which downloaded by user.
     */
    void checkSimilarities(ArrayList<Film> films, Film downloadedFilm){

        //Check that there is any film except downloadedFilm in website.
        if(films.size() == 1){
            System.out.println("\nThere is no film that has similarity with downloaded film.\n");
            return;
        }

        int similarity;//for save each film's similarity with downloadedFilm.
        int index = 0;
        Film[] films_2 = new Film[films.size() - 1];//Collection of films except downloadedFilm.
        int[] similarities = new int[films.size() - 1];//collection of each film's similarity with downloadedFilm.
        ArrayList<String> downloadedFilmActorsNames = downloadedFilm.getActorsName();//Collection of actor's names who play in downloadedFilm.

        for(Film x : films){
            similarity = 0;

            //we should not check downloadedFilm itself :
            if(x.equals(downloadedFilm))
                continue;

            if(x.getDirectorName().equals(downloadedFilm.getDirectorName()))
                similarity++;

            if(x.getGenre() == downloadedFilm.getGenre())
                similarity++;

            if(x.getAgeRange() == downloadedFilm.getAgeRange())
                similarity++;

            //Check actors :
            for(String y : x.getActorsName()){
                if(downloadedFilmActorsNames.contains(y))
                    similarity++;
            }

            films_2[index] = x;//Save x to array.
            similarities[index] = similarity;//Save similarity of x with downloadedFilm in array.
            index++;//Update index
        }

        sortAndPrint(films_2,similarities);
    }

    void sortAndPrint(Film[] films,int[] similarities){

        int temp;
        Film filmTemp;
        //Bubble sort according to similarities :
        for(int i = 0;i < films.length - 1;i++){
            for(int j = 0;j < films.length - i - 1;j++){
                if(similarities[j + 1] > similarities[j]){
                    temp = similarities[j + 1];
                    similarities[j + 1] = similarities[j];
                    similarities[j] = temp;
                    filmTemp = films[j + 1];
                    films[j + 1] = films[j];
                    films[j] = filmTemp;
                }
            }
        }

        //if similarity of films equals 0,we should not print them :
        if(similarities[0] == 0) {
            System.out.println("\nThere is no film that has similarity with downloaded film in this website.\n");
            return;
        }

        System.out.println("\nFilms with most similarity with downloaded film:\n");
        temp = 1;//for printing films.

        //If size of films <= 5 :
        if(films.length <= 5) {
            for (int index = 0; index < films.length; index++) {

                //Do not print films which similarity is 0 and if a film's similarity equals 0,we should break the loop:
                if (similarities[index] == 0)
                    break;

                System.out.println(temp + ")" + films[index] + "\n");
                temp++;
            }
        }
        else{
            for (int index = 0; index < 5; index++) {

                //Do not print films which similarity is 0 and if a film's similarity equals 0,we should break the loop:
                if (similarities[index] == 0)
                    break;

                System.out.println(temp + ")" + films[index] + "\n");
                temp++;
            }
        }
        
    }

}
