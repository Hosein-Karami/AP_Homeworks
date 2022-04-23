/**
 * this class is used to manage the website and get input from user and do the tasks.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

import Films.*;
import Users.Admin;
import Users.NormalUser;
import Users.User;
import Users.VipUser;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Website {

    private final ArrayList<Admin> admins = new ArrayList<>();//admin collection
    private final ArrayList<User> users = new ArrayList<>();//user collection
    private final ArrayList<Film> films = new ArrayList<>();//film collection

    Scanner scanner = new Scanner(System.in);

    /**
     * this method is used to get correct input from user and control his/her inputs.he/she can choose between 1 and max.
     * @param max : max number which user can choose.
     * @return : a valid input of user.
     */
    private int getInput(int max){
        Scanner scanner = new Scanner(System.in);
        int choose;
        //Check input :
        while (true){
            choose = scanner.nextInt();
            if(1 <= choose && choose <= max)
                return choose;
            System.out.print("Invalid input.Please choose from " + 1 + " to " + max + " : ");
        }
    }

    /**
     * this method add a user to website's users.
     * @param userType : show type of user.1 = admin,2 = normal user.
     */
    void addUser(int userType){
        //Get information :
        System.out.print("Enter username : ");
        //we should check that new username does not exist in list before :
        String userName;
        while(true){
            userName = scanner.nextLine();
            if(userType == 1){
                //Search users :
                if(getUserWithUsername(userName) == null)
                    break;
            }
            else{
                //Search admins :
                if(getAdminWithUsername(userName) == null)
                    break;
            }
            System.out.print("This username register before,choose another : ");
        }
        String password,confirmPassword;
        //We should check that password and confirmPassword are same :
        while (true){
            System.out.print("Enter password : ");
            password = scanner.nextLine();
            System.out.print("Confirm password : ");
            confirmPassword = scanner.nextLine();
            if(password.equals(confirmPassword))
                break;
            System.out.println("Password and confirmation are not same.Try again.");
        }

        if(userType == 1){
            NormalUser newNormalUser = new NormalUser(userName,password);
            users.add(newNormalUser);//add user.
            System.out.println("Normal user account created successfully.You can update your account to VIP by sign in to your profile and enter VIP code.");
        }
        else{
            Admin newAdmin = new Admin(userName,password);
            admins.add(newAdmin);//add admin.
            System.out.println("Admin account created successfully!");
        }

    }

    /**
     * this method is used when user want to sign in.
     * @param userType : show type of user.1 = admin,2 = normal user.
     */
    void signInUser(int userType) throws InterruptedException {
        System.out.print("Enter your username : ");
        String userName = scanner.nextLine();
        if(userType == 1) {
            User selectedUser = getUserWithUsername(userName);//Get user refrence by username.
            if(selectedUser == null)
                System.out.println("This username did not exist.\n");
            else{
                System.out.print("Enter password : ");
                String password = scanner.nextLine();
                if(selectedUser.getPassword().equals(password))
                    userMenu(selectedUser);
                else
                    System.out.println("Incorrect password.\n");
            }
        }
        else{
            Admin selectedAdmin = getAdminWithUsername(userName);//Get admin refrence by username.
            if(selectedAdmin == null)
                System.out.println("This username did not exist.\n");
            else{
                System.out.print("Enter password : ");
                String password = scanner.nextLine();
                if(selectedAdmin.getPassword().equals(password))
                    adminMenu();
                else
                    System.out.println("Incorrect password.\n");
            }
        }

    }

    /**
     * this class is used to show user menu and get inputs from user.
     * @param user : refrence of user who log in.
     * @throws InterruptedException : Exception because of use TimeUnit.SECONDS.sleep()
     */
    private void userMenu(User user) throws InterruptedException {
        int choose;//save user choices.
        while(true){
            System.out.println("1)List films by genre\n2)Download film\n3)Upgrade to VIP account\n4)Score films\n5)Sign out");
            System.out.print("Enter your choice number : ");
            choose = getInput(5);
            if(choose == 1)
                showFilmsByGenre();
            else if(choose == 2){
                System.out.print("Enter the film's name : ");
                String name = scanner.nextLine();
                Film selectedFilm = searchFilmByName(name);//get refrence of selected film.
                if(selectedFilm == null)
                    System.out.println("There is no film with this name in website.\n");
                else{
                    //Check the numbers of download of normal user :
                    if((user instanceof NormalUser)){
                        if(((NormalUser) user).getDownloadCounter() == 5)
                            System.out.println("You can not download more than 5 videos.Upgrade your account to VIP and try again.");
                        else {
                            System.out.println("You are normal user and should wait 10 seconds for download :");
                            TimeUnit.SECONDS.sleep(10);//Wait 10 seconds for normal users.
                            download(selectedFilm);
                            ((NormalUser) user).download();//increase user's downloadCounter
                        }
                    }
                    else
                        download(selectedFilm);
                }
            }

            else if(choose == 3) {
                //Check user not VIP user :
                if (user instanceof VipUser)
                    System.out.println("You are VIP user and do not need do this work.\n");
                else {
                    System.out.print("Please enter the VIP code : ");
                    String VIP = scanner.nextLine();//Get VIP code
                    //Check VIP code :
                    if (VIP.equals("AUTAP")) {
                        //Make new vip user refrence with normal user information and add to list and delete the old account.
                        VipUser newVip = new VipUser(user.getUserName(), user.getPassword());
                        newVip.setUserScoredFilms(user.getScoredFilms());
                        users.remove(user);//Delete old account.
                        users.add(newVip);//add new VIP account.
                        System.out.println("\n*****You are VIP user from now.Please sign in to your account from main menu.*****\n");
                        return;//Return to main menu and user sign in to vip's account.
                    }
                    else
                        System.out.println("Invalid VIP code.\n");
                }
            }

            else if(choose == 4) {
                //Check size of films in website :
                if(films.size() == 0)
                    System.out.println("There is no film in this website.\n");
                else
                    scoreFilms(user);
            }
            else
                break;
        }
    }

    /**
     * this method run when an admin login and want to do some work.
     */
    private void adminMenu(){
        int choose;//save admin choices.
        while (true){
            System.out.println("1)Add film\n2)Delete film\n3)List films by genre\n4)Sign out");
            System.out.print("Enter your choice number : ");
            choose = getInput(4);
            if(choose == 1)
                addFilm(films);
            else if(choose == 2) {
                System.out.print("Enter name of the film which you want to delete : ");
                String name = scanner.nextLine();//Get name of the film.
                deleteFilm(films,name);
            }
            else if(choose == 3)
                showFilmsByGenre();
            else
                break;
        }
    }

    /**
     * this method is used to add a film to website's films.
     * @param films : List of films that exist in website.
     */
    private void addFilm(ArrayList<Film> films){
        System.out.println("Enter information of new film :");
        System.out.print("Name : ");
        String name;
        //Check admin do not add a film more than one time :
        while(true){
            name = scanner.nextLine();
            if(searchFilmByName(name) == null)
                break;
            System.out.print("This film added before,Choose another Name : ");
        }
        System.out.print("Summary : ");
        String summary = scanner.nextLine();//get summary.
        System.out.print("Name of director : ");
        String directorName = scanner.nextLine();//get name of director.
        ArrayList<String> actorsName = new ArrayList<>();
        System.out.println("Enter name of actors in this film :");
        String actorName;
        int choose;//ask user want to continue add actor's name or not.
        while(true){
            System.out.print("Actor's name : ");
            actorName = scanner.nextLine();
            actorsName.add(actorName);
            System.out.print("Do you want to add another actor(1 = Yes,2 = No)? ");
            choose = getInput(2);
            if(choose == 2)
                break;
        }
        System.out.println("Enter age range of this film :\n1)0-5\n2)10-15\n3)15-18\n4)above 18");
        System.out.print("Enter your choice number : ");
        choose = getInput(4);//get age range.
        AgeRange ageRange;
        if(choose == 1)
            ageRange = AgeRange.A;
        else if(choose == 2)
            ageRange = AgeRange.B;
        else if(choose == 3)
            ageRange = AgeRange.C;
        else
            ageRange = AgeRange.D;
        System.out.println("1)Documentary\n2)Drama\n3)Action\n4)Comedy\n5)Adventure");
        System.out.print("Enter the film's genre number : ");
        choose = getInput(5);//get genre.
        FilmsGenre genre = FilmsGenre.getGenre(choose);//get proper genre.
        //get types of this film :
        int firstType,secondType;
        System.out.print("What is film's type(1 = Movie,2 = Series)? ");
        firstType = getInput(2);
        System.out.print("What is film's second type(1 = Animation,2 = Liveaction)? ");
        secondType = getInput(2);
        //Making film according it's types :
        if(firstType == 1){
            if(secondType == 1){
                AnimationMovie film = new AnimationMovie(name,summary,genre,directorName,actorsName,ageRange);
                setMoviesTime(film);//Set it's time.
                films.add(film);
            }
            else{
                LiveactionMovie film = new LiveactionMovie(name,summary,genre,directorName,actorsName,ageRange);
                setMoviesTime(film);//Set it's time.
                films.add(film);
            }
        }
        else{
            if(secondType == 1){
                AnimationSeries film = new AnimationSeries(name,summary,genre,directorName,actorsName,ageRange);
                setCountOfChaptersAndSections(film);//Set it's information.
                films.add(film);
            }
            else{
                LiveactionSeries film = new LiveactionSeries(name,summary,genre,directorName,actorsName,ageRange);
                setCountOfChaptersAndSections(film);//Set it's information.
                films.add(film);
            }
        }

    }

    /**
     * this method is used to delete a film from website's list.
     * @param films : collection of site's films.
     */
    private void deleteFilm(ArrayList<Film> films,String name){
        int index = -1;//Index of selected film.
        int temp = 0;
        //Search :
        for(Film x : films){
            if(x.getName().equals(name)){
                index = temp;
                break;
            }
            temp++;
        }
        //If index = -1,the film does not exist in list.
        if(index == -1)
            System.out.println("There is no video with this name.\n");
        else{
            films.remove(films.get(index));
            System.out.println("Video successfully removed.\n");
        }
    }

    /**
     * this method is used to show films of a particular genre.
     */
    private void showFilmsByGenre(){

        System.out.println("1)Documentary\n2)Drama\n3)Action\n4)Comedy\n5)Adventure\n6)All genres");
        System.out.print("Enter your choice number : ");
        int choose = getInput(6);
        boolean allGenre = false;//Show user want to see all genres or not.
        FilmsGenre genre = null;
        if(1 <= choose && choose <= 5)
            genre = FilmsGenre.getGenre(choose);//Get proper genre.
        else
            allGenre = true;
        int temp = 1;//For show films.
        if(allGenre){
            System.out.println("\nList of all films :\n");
            for(Film x : films){
                System.out.println(temp + ")" + x.toString() + "\n");
                temp++;
            }
        }
        else{
            System.out.println("\nList of films by " + genre + " genre :\n");
            for(Film x : films){
                if(x.getGenre() == genre){
                    System.out.println(temp + ")" + x.toString() + "\n");
                    temp++;
                }
            }
        }
        System.out.print("If undrestand,press enter :");
        scanner.nextLine();
    }

    /**
     * This method is used to set the movie's time.
     * @param film : refrence of the film.
     */
    private void setMoviesTime(Film film){
        System.out.print("Enter time of this movie in minute(for example if it's time is 2 hours,input 120) : ");
        String time = scanner.nextLine();
        ((Movie) film).setTime(time);
        System.out.println("Film added successfully.\n");
    }

    /**
     * this method is used to set number of chapters and each chapter's section in a series.
     * @param film : refrence of series.
     */
    private void setCountOfChaptersAndSections(Film film){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of this film's chapter : ");
        int chapterCount;
        //Check inputs :
        while(true){
            chapterCount = scanner.nextInt();
            if(chapterCount > 0)
                break;
            System.out.print("Invalid input.number of chapters should bigger than zero.Try again : ");
        }
        System.out.print("Enter number of each chapter's sections : ");
        int sectionCount;
        //Check inputs :
        while(true){
            sectionCount = scanner.nextInt();
            if(sectionCount > 0)
                break;
            System.out.print("Invalid input.number of sections should bigger than zero.Try again : ");
        }
        ((Series) film).setChapterAndSections(chapterCount,sectionCount);
        System.out.println("Film added successfully.\n");
    }

    /**
     * this method is used to download a particular film.
     * @param film : refrence of selected film.
     */
    void download(Film film){
        film.download();//Download the film.
        //Show 5 films which have similarity with downloaded film :
        CheckSimilarities check  = new CheckSimilarities();
        check.checkSimilarities(films,film);//Check and print.
    }

    /**
     * this method is used when user want to score films from 1 to 5.
     * @param user : refrence of user.
     */
    void scoreFilms(User user){
        System.out.println("\nFilms in this website :");
        int temp = 1;
        for(Film x : films){
            System.out.println(temp + ")" + x.getName());
            temp++;
        }
        int score;
        Film scoredFilm;
        while(true) {
            System.out.print("Choose the film number which you want to score it : ");
            temp = getInput(films.size());//Select a film.
            scoredFilm = films.get(temp - 1);
            //Check that user did not score this film before :
            if(user.getScoredFilms().contains(scoredFilm)) {
                System.out.print("You score this film before.Do you want choose another(1 = Yes,2 = No)? ");
                temp = getInput(2);
                if(temp == 2)
                    break;
            }
            else {
                System.out.print("Enter score from 1 to 5 : ");
                score = getInput(5);//enter his/her score to film.
                scoredFilm.sumScore(score);
                user.addScoredFilm(scoredFilm);//Add the scoredFilm to scoredFilms list of user.
                System.out.print("Score saved.Do you want to score another films(1 = Yes,2 = No)? ");
                temp = getInput(2);
                if (temp == 2)
                    break;
            }
        }
    }

    /**
     * this method is used to search a particular user with his/her username.
     * @param userName : username of admin who we want to find him/her.
     * @return : if user exist in list,return refrence of it and if does not exist,return null.
     */
    private User getUserWithUsername(String userName){
        for(User x : users){
            if(x.getUserName().equals(userName))
                return x;
        }
        return null;
    }

    /**
     * this method is used to search a particular admin with his/her username.
     * @param userName : username of admin who we want to find him/her.
     * @return : if admin exist in list,return refrence of it and if does not exist,return null.
     */
    private Admin getAdminWithUsername(String userName){
        for(Admin x : admins){
            if(x.getUserName().equals(userName))
                return x;
        }
        return null;
    }

    /**
     * this method is used to return a particular film by it's name.
     * @param name : name of the selected film.
     * @return : refrence of the film and if film does not exist in website,return null.
     */
    private Film searchFilmByName(String name){
        for(Film x : films){
            if(x.getName().equals(name))
                return x;
        }
        return null;
    }

}
