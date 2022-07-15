import java.util.ArrayList;

public class Channel implements Subject{

    private final ArrayList<Observer> observers = new ArrayList<>();

    /**
     * this method get a refrence of an observer and add it to collection of observers of a observable object.
     * @param newObserver : refrence of a new observer.
     */
    public void attach(Observer newObserver){
        //We should avoid a follower follow a channel more than one time :
        if(check(newObserver))
            System.out.println("You followed this channel before.");
        else {
            observers.add(newObserver);
            System.out.println("Channel followed successfully.");
        }
    }

    /**
     * this method remove an observer from observer's collection of observable object.
     * @param deletedObserver : refrence of observer who should remove.
     */
    public void detach(Observer deletedObserver){
        //We should check deletedObserver followed channel before and then remove him/her :
        if(check(deletedObserver)) {
            observers.remove(deletedObserver);
            System.out.println("Unfollowed successfully.\n");
        }
        else
            System.out.println("You did not follow this group before.\n");
    }

    /**
     * this method is used to send new news to observers.
     * @param newMessage : refrence of new news.
     */
    public void notify(Message newMessage){
        for(Observer x : observers)
            x.update(newMessage);
    }

    /**
     * This method is used when we want to check that a person follow this channel or not.
     * @param follower : refrence of person who we want check he/she followed this channel or not.
     * @return : true if person follow this channel and false if he/she did not follow this channel.
     */
    private boolean check(Observer follower){
        for(Observer x : observers){
            if(x.equals(follower))
                return true;
        }
        return false;
    }
}
