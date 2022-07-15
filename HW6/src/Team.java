import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    private String name;
    private String password;

    private final ArrayList<Match> matches = new ArrayList<>();
    private final ArrayList<Player> players = new ArrayList<>();

    private final Channel clubChannel = new Channel();
    private final Channel matchesNews = new Channel();
    private final Channel playersNews = new Channel();

    //Constructor :
    Team(String name,String password){
        this.name = name;
        this.password = password;
    }

    /**
     * this method is used to get valid input from user.
     * @return : choose of user.
     */
    int controlInput(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        while(true){
            choose = scanner.nextInt();
            if(choose == 0 || choose == 1)
                return choose;
            System.out.print("Invalid input.Choose between 1 and 0 : ");
        }
    }

    /**
     * ths method get access to name of team.
     * @return : name of this team.
     */
    String getName(){
        return name;
    }

    /**
     * ths method get access to password of team.
     * @return : password of this team.
     */
    String getPassword(){
        return password;
    }

    /**
     * this method is used to add a new player to player's list.
     * @param newPlayer : refrence of new player.
     */
    void addPlayer(Player newPlayer){
        players.add(newPlayer);
        System.out.println("Player added successfully.");
    }

    /**
     * this method is used to add a new match to match's list.
     * @param newMatch : refrence of new match.
     */
    void addMatch(Match newMatch){
        matches.add(newMatch);
    }

    /**
     * this method is used to attach followers to channels.
     * @param follower : refrence of follower.
     */
    void follow(Observer follower){
        int choose;
        System.out.print("Do you want to follow club's channel(1 = Yes,0 = No)? ");
        choose = controlInput();
        if(choose == 1)
            clubChannel.attach(follower);//Add follower to channel.
        System.out.print("Do you want to follow match's news channel(1 = Yes,0 = No)? ");
        choose = controlInput();
        if(choose == 1)
            matchesNews.attach(follower);
        System.out.print("Do you want to follow player's news channel(1 = Yes,0 = No)? ");
        choose = controlInput();
        if(choose == 1)
            playersNews.attach(follower);
    }


    void unfollow(Follower follower){
        System.out.println("1)Unfollow club's channel\n2)Unfollow match's channel\n3)Unfollow player's channel");
        System.out.print("Enter your choice number : ");
        Scanner scanner = new Scanner(System.in);
        int choose;
        //Check input :
        while (true){
            choose = scanner.nextInt();
            if(1 <= choose && choose <= 3)
                break;
            System.out.print("Invalid input,Choose from 1 to 3 : ");
        }
        if(choose == 1)
            clubChannel.detach(follower);
        else if(choose == 2)
            matchesNews.detach(follower);
        else
            playersNews.detach(follower);
    }

    /**
     * this method is used when admin of team want to send message in channels.
     * @param channelType : determine which channel that admin want to send message(1 = club channel,2 = channel of match's news,3 = channel of player's news.
     */
    void send(int channelType){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title of message : ");
        String title = scanner.nextLine();
        System.out.print("Enter text of message : ");
        String text = scanner.nextLine();
        Message message = new Message(title,text);
        if(channelType == 1)
            clubChannel.notify(message);
        else if(channelType == 2)
            matchesNews.notify(message);
        else
            playersNews.notify(message);
    }

    /**
     * This method is used to show all players in team.
     */
    void showPlayers(){
        System.out.println();
        if(players.size() == 0)
            System.out.println("There is no player in this team.\n");
        else{
            System.out.println("Players :");
            int temp = 1;
            for(Player x : players){
                System.out.println(temp + ")" + x.getName());
                temp++;
            }
        }
        System.out.println();
    }

    /**
     * This method is used to show all matchs.
     */
    void showMatch(){
        if(matches.size() == 0)
            System.out.println("No match arrange for this team.\n");
        else{
            System.out.println("Matchs :");
            int temp = 1;
            for(Match x : matches){
                System.out.println(temp + ")" + x.toString());
                temp++;
            }
        }
    }

}
