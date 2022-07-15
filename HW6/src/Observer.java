public interface Observer {

    /**
     * this method is used to show the new news in console.
     * @param newMessage : refrence of new news.
     */
    void update(Message newMessage);

}
