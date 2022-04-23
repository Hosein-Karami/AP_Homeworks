/**
 * this class is used to save information of AnimationMovie and get access to its information and methods.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Films;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimationMovie extends Film implements Movie{

    private String time;//Time of the movie.

    //Constructor :
    public AnimationMovie(String name, String summary,FilmsGenre genre, String directorName, ArrayList<String> actorsName, AgeRange ageRange){
        super(name,summary,genre,directorName,actorsName,ageRange);
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
     * this method is used when user want to download a film which is Animation.
     */
    @Override
    public void download() {
        Scanner scanner = new Scanner(System.in);
        int choose;//For save user's choose.
        System.out.print("Do you want to check that this animation is proper for your age or not(1 = Yes,2 = No)? ");
        //Check input :
        while (true){
            choose = scanner.nextInt();
            if(choose == 1 || choose == 2)
                break;
            System.out.print("Invalid input.Choose between 1 and 2 : ");
        }
        if(choose == 2)
            System.out.println(getName() + " downloaded successfully,we wish you enjoy the film :)");
        else{
            System.out.print("Enter your age : ");
            //Check input not negative :
            while (true){
                choose = scanner.nextInt();
                if(choose >= 0)
                    break;
                System.out.print("Invalid age.Choose non-negative age : ");
            }
            boolean check = checkAge(choose);
            if(check)
                System.out.println(getName() + " downloaded successfully,we wish you enjoy the film :)");
            else{
                System.out.print("Do you want to cancel download(1 = Yes,2 = No)? ");
                //Check input :
                while (true){
                    choose = scanner.nextInt();
                    if(choose == 1 || choose == 2)
                        break;
                    System.out.print("Invalid input.Choose between 1 and 2 : ");
                }
                if(choose == 2)
                    System.out.println(getName() + " downloaded successfully,we wish you enjoy the film :)");
                else
                    System.out.println("Download canceled.\n");
            }
        }
    }

    /**
     * this method is used to check an animation is proper for user's age or not.
     * @param age : age of user.
     * @return : if animation is proper,return true,else return false.
     */
    public boolean checkAge(int age) {
        if(AgeRange.getAgeRangeOfAnAge(age) == getAgeRange()) {
            System.out.println("This animation is proper for you.");
            return true;
        }
        else {
            System.out.println("\nThis animation is not proper for your age.");
            return false;
        }
    }

    /**
     * this method set the time of movie.
     * @param time : time of the movie that admin inputs.
     */
    @Override
    public void setTime(String time) {
        this.time = time;
    }

}
