/**
 * this is Cafe class to save cafe information and get access to its information for other classes.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */

public class Cafe {
    private final ClientsLinkedList clients = new ClientsLinkedList();
    private final ClientsLinkedList admins = new ClientsLinkedList();
    private final DrinkLinkedList drinks = new DrinkLinkedList();
    private int counterOfClients = 0;
    private int counterOfAdmins = 0;

    Cafe(){
        //Make objects of cafe.
        Drink[] drink = new Drink[5];
        drink[0] = new Drink("Tea",45000);
        drink[1] = new Drink("Milk",38000);
        drink[2] = new Drink("Coffee",99990);
        drink[3] = new Drink("Shake",81000);
        drink[4] = new Drink("Watermelon juice",16000);
        for(int i = 0;i < 5;i++)
            drinks.addDrink(drink[i]);
    }
    //this method runs when a client register,and add client to cafe clients linkedlist.
    void addClient(Client newClient){
        clients.addClient(newClient);
        counterOfClients++;
    }
    //this method runs when an admin register,and add client to cafe admins linkedlist.
    void addAdmin(Client newAdmin){
        admins.addClient(newAdmin);
        counterOfAdmins++;
    }
    //this method remove a client from clients_list :
    void removeClient(Client targetClient){
        clients.removeClient(targetClient);
    }
    //find a particular client or admin with his/her id and if did not register return null:
    Client getClient(String clientId){
        ClientsLinkedList serchtemp = clients;
        for(int i = 1;i <= counterOfClients;i++){
            if(serchtemp.getId().equals(clientId))
                return serchtemp.getValue();
            serchtemp = serchtemp.getNext();
        }
        //admins can login as a client too :
        serchtemp = admins;
        for(int i = 1;i <= counterOfAdmins;i++){
            if(serchtemp.getId().equals(clientId))
                return serchtemp.getValue();
            serchtemp = serchtemp.getNext();
        }
        return null;
    }
    //find an admin with his/her id and if did not register return null:
    Client getAdmin(String adminId){
        ClientsLinkedList serchtemp = admins;
        for(int i = 1;i <= counterOfAdmins;i++){
            if(serchtemp.getId().equals(adminId))
                return serchtemp.getValue();
            serchtemp = serchtemp.getNext();
        }
        return null;
    }
    //return all clients who register in the cafe :
    ClientsLinkedList getClients(){
        return clients;
    }
    //return all admins who register in the cafe :
    ClientsLinkedList getAdmins(){
        return admins;
    }
    //return size of clients :
    int getCounterOfClients(){
        return counterOfClients;
    }
    //return size of admins :
    int getCounterOfAdmins(){
        return counterOfAdmins;
    }
    //show menu of drinks that exist in cafe for client :
    void showCafeMenu(){
         Accessor_To_DrinkedLinkedlist tempPrint = new Accessor_To_DrinkedLinkedlist();
         tempPrint.printWithPrice(drinks);
    }
    //make an id :
    String idMaker(){
        return "" + (counterOfClients + counterOfAdmins + 1);
    }
}
