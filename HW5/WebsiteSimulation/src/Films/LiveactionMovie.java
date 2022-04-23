/**
 * this class is used to save information of LiveactionMovie and get access to its information and methods.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Films;

import java.util.ArrayList;
import java.util.Scanner;

public class LiveactionMovie extends Film implements Movie{

    private String time;//Time of the movie.

    //Constructor :
    public LiveactionMovie(String name, String summary,FilmsGenre genre, String directorName, ArrayList<String> actorsName,AgeRange ageRange){
        super(name,summary,genre,directorName,actorsName,ageRange);
    }

    /**
     * this method set the time of movie.
     * @param time : time of the movie that admin inputs.
     */
    @Override
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * this method is used to return a string which contain the movie's time.
     * @return : a string which contain the movie's time.
     */
    @Override
    String specialProperty() {
        return ("Time of the movie : " + time);
    }

    /**
     * this method is used when user want to download a film which is Liveaction.
     */
    @Override
    public void download() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        System.out.println("Download options :");
        System.out.println("1)Main language\n2)Translate form\n3)With subtitle");
        System.out.print("Enter your choice : ");
        //Check inputs :
        while (true){
            choose = scanner.nextInt();
            if(1 <= choose && choose <= 3)
                break;
            System.out.print("Invalid input.Choose from 1 to 3 : ");
        }
        if(choose == 1)
            mainLanguageDownload();
        else if(choose == 2)
            translateDownload();
        else
            withSubtitleDownload();
    }

    /**
     * used when user download main language film.
     */
    private void mainLanguageDownload() {
        System.out.println(getName() + " downloaded in main language format.We wish you enjoy it :)");
    }

    /**
     * used when user download translated film.
     */
    private void translateDownload() {
        System.out.println(getName() + " downloaded translated film.We wish you enjoy it :)");
    }

    /**
     * used when user download film with it's subtitle.
     */
    private void withSubtitleDownload() {
        System.out.println(getName() + " downloaded with it's subtitle.We wish you enjoy it :)");
    }

}
