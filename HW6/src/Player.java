public class Player{

    private final String firstname;
    private final String lastname;
    private final int age;
    private final String nationalNumber;

    //Constructor :
    public Player(String firstname,String lastname,int age,String nationalNumber){
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.nationalNumber = nationalNumber;
    }

    /**
     * this method get access  to full name  of player.
     * @return : full name of player.
     */
    String getName(){
        return firstname + " " + lastname;
    }
}
