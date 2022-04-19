/**
 * In this class we make our own linkedlist and do not use from LinkedList package of java.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */
public class ClientsLinkedList {
    private Client value = null;
    private ClientsLinkedList next = null;

    //return ID of client :
    String getId(){
        return value.getId();
    }
    //return refrence of next member :
    ClientsLinkedList getNext(){
        return next;
    }
    //return name and id of a client :
    String getInformations(){
        return value.getInformations();
    }
    //return refrence of a client :
    Client getValue(){
        return value;
    }
    //set the client refrence :
    void setValue(Client value){
        this.value = value;
    }
    //set next member refrence :
    void setNext(ClientsLinkedList next){
        this.next = next;
    }
    //add a client to list :
    void addClient(Client client){
        Access_To_ClientsLinkedlist addTemp = new Access_To_ClientsLinkedlist();
        addTemp.addClient(this,client);
    }
    //remove a client from list :
    void removeClient(Client targetClient){
        Access_To_ClientsLinkedlist removeTemp = new Access_To_ClientsLinkedlist();
        removeTemp.removeClient(this,targetClient);
    }
}
