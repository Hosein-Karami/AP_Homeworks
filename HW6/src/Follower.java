public class Follower implements Observer{

    private final String username;
    private final String password;

    //Constructor :
    Follower(String username,String password){
        this.username = username;
        this.password = password;
    }

    /**
     * this method is used to show the new news in console.
     * @param newMessage : refrence of new news.
     */
    public void update(Message newMessage){
        System.out.println("\n***** New message for " + username + " *****");
        System.out.println(newMessage.toString() + "\n");
    }

    /**
     * this method is used to get access to username of follower.
     * @return : username of username.
     */
    String getUsername(){
        return username;
    }

    String getPassword(){
        return password;
    }
}
