/**
 * this class is used to do different work with our linkedlist.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */

public class Access_To_ClientsLinkedlist {

    //add client to our linkedlist :
    void addClient(ClientsLinkedList firstMemeber,Client client){
        //Check first member of linkedlist
        if(firstMemeber.getValue() == null)
            firstMemeber.setValue(client);

        else{
            ClientsLinkedList temp;
            for(temp = firstMemeber; temp.getNext() != null;temp = temp.getNext());
            ClientsLinkedList next = new ClientsLinkedList();
            next.setValue(client);
            temp.setNext(next);
        }
    }

    //remove client from our linkedlist :
    void removeClient(ClientsLinkedList firstMember,Client targetClient){
        ClientsLinkedList temp;
        for(temp = firstMember; temp.getNext().getValue() != targetClient; temp = temp.getNext());
        ClientsLinkedList temp_2 = temp.getNext().getNext();
        temp.setNext(temp_2);//Garbagecollector remove temp.next from memory.
    }
}
