public class Message {

    private final String title;
    private final String text;

    //Constructor :
    public Message(String title,String text){
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return "title : " + title + '\n' +
                "text : " + text;
    }

}
