/**
 * this class is used to save information of LiveactionSeries and get access to its information and methods.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Films;

import java.util.ArrayList;
import java.util.Scanner;

public class LiveactionSeries extends Film implements Series{

    private int chapterCount,sectionCount;//Saves number of film's chapters and each chapter sections.

    //Constructor :
    public LiveactionSeries(String name, String summary,FilmsGenre genre, String directorName, ArrayList<String> actorsName,AgeRange ageRange){
        super(name,summary,genre,directorName,actorsName,ageRange);
    }

    /**
     * this method is used to return a string which contain number of chapters and number of section in each chapter.
     * @return : a string which contain number of chapters and number of section in each chapter.
     */
    @Override
    String specialProperty() {
        return ("Number of chapters : " + chapterCount + " ,Number of sections in each chapter : " + sectionCount);
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
     * this method set the number of chapters and each chapter's section according to admin's inputs.
     * @param chapterCount : number of film's chapter.
     * @param sectionCount : numbers of each chapter's sections.
     */
    @Override
    public void setChapterAndSections(int chapterCount, int sectionCount) {
        this.chapterCount = chapterCount;
        this.sectionCount = sectionCount;
    }

    /**
     * used when user download main language film.
     */
    public void mainLanguageDownload() {
        System.out.println(getName() + " downloaded in main language format.We wish you enjoy it :)");
    }

    /**
     * used when user download translated film.
     */
    public void translateDownload() {
        System.out.println(getName() + " downloaded translated film.We wish you enjoy it :)");
    }

    /**
     * used when user download film with it's subtitle.
     */
    public void withSubtitleDownload() {
        System.out.println(getName() + " downloaded with it's subtitle.We wish you enjoy it :)");
    }
}
