public interface Subject {

    /**
     * this method get a refrence of an observer and add it to collection of observers of a observable object.
     * @param newObserver : refrence of a new observer.
     */
    void attach(Observer newObserver);

    /**
     * this method remove an observer from observer's collection of observable object.
     * @param deletedObserver : refrence of observer who should remove.
     */
    void detach(Observer deletedObserver);

    /**
     * this method is used to send new news to observers.
     * @param newMessage : refrence of new news.
     */
    void notify(Message newMessage);

}
