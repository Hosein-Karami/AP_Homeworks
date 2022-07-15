import java.util.ArrayList;
import java.util.Scanner;

public class MessengerApplication {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Follower> followers = new ArrayList<>();
    ArrayList<Team> teams = new ArrayList<>();

    /**
     * this method is used to get valid input.
     * @param max : max number which user can choose.
     * @return : valid user's input.
     */
    private int controlInput(int max){
        int choose;
        while(true) {
            choose = scanner.nextInt();
            if (1 <= choose && choose <= max)
                return choose;
            System.out.print("Invalid input.Choose from 1 to " + max + " : ");
        }
    }

    /**
     * this method is start of our software.
     */
    void start(){
        while(true){
            System.out.println("1)Sign up follower\n2)Sign in follower\n3)make a club\n4)Manage club\n5)exit");
            System.out.print("Enter your choice number : ");
            int choose = controlInput(5);
            scanner.nextLine();//Avoid ignore scanner.nextLine() in continue.
            if(choose == 5)
                break;
            else if(choose == 1)
                signUpFollower();
            else if(choose == 2){
                Follower follower = signInFollower();
                if(follower == null)
                    System.out.println("Username or password is false or user with this username did not register before.");
                else
                    followerMenu(follower);
            }
            else if(choose == 3){
                String clubName;
                System.out.print("Enter name of team : ");
                //Name of club should unique,and we should check and avoid duplicate club's names.
                clubName = scanner.nextLine();
                if(getParticularTeam(clubName) == null) {
                    System.out.print("Enter password of your club account : ");
                    String clubPassword = scanner.nextLine();
                    Team newTeam = new Team(clubName,clubPassword);
                    teams.add(newTeam);//Add to list.
                    System.out.println("Club account created successfully.\n");
                }
                else
                    System.out.print("This Team added before.");
            }
            else{
                System.out.print("Enter your team's name : ");
                String name = scanner.nextLine();
                Team selectedTeam = getParticularTeam(name);
                if(selectedTeam == null)
                    System.out.println("There is no team with this name.\n");
                else{
                    System.out.print("Enter password : ");
                    String password = scanner.nextLine();
                    //Check password :
                    if(selectedTeam.getPassword().equals(password))
                        clubMenu(selectedTeam);
                    else
                        System.out.println("Invalid password.\n");
                }
            }
        }
    }

    /**
     * this method is used when a new follower want to register in this application.
     */
    private void signUpFollower(){
        System.out.print("Enter username : ");
        String username = getUniqueUsername();
        System.out.print("Enter password : ");
        String password = scanner.nextLine();
        System.out.println("Account created successfully.\n");
        Follower follower = new Follower(username,password);
        followers.add(follower);
    }

    /**
     * this method is used when a user want to sign in and control profile.
     * @return : refrence of selected follower.
     */
    private Follower signInFollower(){
        System.out.print("Enter username : ");
        String username = scanner.nextLine();
        System.out.print("Enter password : ");
        String password = scanner.nextLine();
        //Search follower :
        for(Follower x : followers){
            if(x.getUsername().equals(username)){
                if(x.getPassword().equals(password))
                    return x;
            }
        }
        return null;
    }

    private void clubMenu(Team team){
        System.out.println("Welcome to your account :)");
        while(true){
            System.out.println("1)Add player\n2)Send message to followers\n3)Arrange a match\n4)Players list\n5)Matches list\n6)Sign out");
            System.out.print("Enter your choice number : ");
            int choose = controlInput(6);
            scanner.nextLine();//Avoid ignore scanner.nextLine() in continue.
            if(choose == 6)
                break;
            else if(choose == 1)
                addPlayerToClubs(team);
            else if(choose == 2)
                sendMessage(team);
            else if(choose == 3)
                arrangeMatch(team);
            else if(choose == 4)
                team.showPlayers();
            else
                team.showMatch();
        }
    }

    /**
     * this method is used when a user sign in.
     * @param follower : refrence of user who sign in.
     */
    private void followerMenu(Follower follower){
        System.out.println("Welcome to your account :)");
        while(true) {
            System.out.println("1)Follow a channel\n2)Unfollow a channel\n3)Sign out");
            System.out.print("Enter your choose number : ");
            int choose = controlInput(3);
            scanner.nextLine();//Avoid ignore scanner.nextLine() in continue.
            if(choose == 3)
                break;
            else if(choose == 1){
                System.out.print("Enter your team's name : ");
                String teamName = scanner.nextLine();
                Team selectedTeam = getParticularTeam(teamName);
                if(selectedTeam == null)
                    System.out.println("There is no any team with this name.\n");
                else
                    selectedTeam.follow(follower);
            }
            else{
                System.out.print("Enter your team's name : ");
                String teamName = scanner.nextLine();
                Team selectedTeam = getParticularTeam(teamName);
                if(selectedTeam == null)
                    System.out.println("There is no any team with this name.\n");
                else
                    selectedTeam.unfollow(follower);
            }
        }
    }

    /**
     * this method is used to avoid duplicate usernames in software.
     * @return : a unique string which is not used before in app.
     */
    private String getUniqueUsername(){
        String username;
        boolean unique;//For check a username is unique or not.
        while(true){
            unique = true;
            username = scanner.nextLine();
            for(Follower x : followers){
                if(x.getUsername().equals(username)){
                    unique = false;
                    break;
                }
            }
            if(unique)
                return username;
            System.out.print("This username exist now,Please choose another username : ");
        }
    }

    /**
     * this method is used to return a particular Team with its name.
     * @param teamName : name of team.
     * @return : refrence of team which its name equals teamName.
     */
    private Team getParticularTeam(String teamName){
        for(Team x : teams){
            if(x.getName().equals(teamName))
                return x;
        }
        return null;
    }

    /**
     * this method is used when admin of club want to add a player to club's players.
     * @param team : refrence of team.
     */
    private void addPlayerToClubs(Team team){
        System.out.print("Enter firstname of player : ");
        String firstname = scanner.nextLine();
        System.out.print("Enter lastname of player : ");
        String lastname = scanner.nextLine();
        System.out.print("Enter age of player : ");
        int age;
        //age should bigger than 0 :
        while(true){
            age = scanner.nextInt();
            if(age > 0)
                break;
            System.out.print("Age should bigger than 0,Try again : ");
        }
        scanner.nextLine();//Avoid ignore scanner.nextLine() in continue.
        System.out.print("Enter national number of player : ");
        String nationalNumber = scanner.nextLine();
        Player newPlayer = new Player(firstname,lastname,age,nationalNumber);
        team.addPlayer(newPlayer);
    }

    /**
     * this method is used when admin of club want to arrange a match.
     * @param team : refrence of team.
     */
    private void arrangeMatch(Team team){
        System.out.print("Enter name of rival team : ");
        String rivalName = scanner.nextLine();
        System.out.print("Enter date of match(For example 5/1/2022) : ");
        String date = scanner.nextLine();
        Match newMatch = new Match(team.getName(),rivalName,date);
        team.addMatch(newMatch);
        //If rival team exist in this app,we should add this match to its list of matches :
        Team rivalTeam = getParticularTeam(rivalName);
        if(rivalTeam != null)
            rivalTeam.addMatch(newMatch);
        System.out.println("Match arranged successfully.");
    }

    /**
     * This method is used when admin of club want to send message to observers.
     * @param team : refrence of team.
     */
    private void sendMessage(Team team){
        System.out.println("1)Send message in club's channel\n2)Send message in match's channel\n3)Send message un player's channel");
        System.out.print("Choose your choice number : ");
        int choose = controlInput(3);
        team.send(choose);
    }
}
