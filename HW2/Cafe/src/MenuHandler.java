/**
 * this is menu class to show diffrent menu and actually this is the interface of our app.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */

public class MenuHandler {
    private final Cafe cafe;//use for print informations of clients and admins of cafe and access to caffe informations.
    private final String[] firstMenu = {"Signup","Login Client","Login Admin","Exit"};
    private final String[] clientMenu = {"Order drink","Cancel order","Log out"};

    MenuHandler(Cafe cafe){
        this.cafe = cafe;//set cafe of menu to cafe which is used in inputHandler class to access cafe information for printing methods.
    }

    //Print first menu for get user input to start :
    void printFirstMenu(){
        for(String x : firstMenu)
            System.out.println(x);
    }
    //if user sign in with client_id,this method runs to show what he/she can do :
    void printClientMenu(){
        for(String x : clientMenu)
            System.out.println(x);
    }
    //if user sign in with admin_id,this method runs to show clients and their orders :
    void printAdminMenu(){
        printClients();
        System.out.println("1)back");
    }
    //if we want to show a clinet orders with client_id,this method run,for example when client want to cancel an order :
    void printClientAllOrders(String id){
        Client client = cafe.getClient(id);
        Accessor_To_DrinkedLinkedlist printTemp = new Accessor_To_DrinkedLinkedlist();
        printTemp.print(client.getOrders());
        System.out.println("back");
    }
    //print all clients with their orders for admin.
    void printClients() {
        ClientsLinkedList tempclients = cafe.getClients();
        DrinkLinkedList drinks;
        for (int i = 1; i <= cafe.getCounterOfClients(); i++) {
            System.out.print(tempclients.getInformations() + ":\n        [");

            for (drinks = tempclients.getValue().getOrders(); drinks != null; drinks = drinks.getNext()) {
                System.out.print(drinks.getDrinkName() + "  ");
            }

            System.out.println("]");

            tempclients = tempclients.getNext();
        }

        //if an admin order at least one drink should drink and if did not order anything not print :
        tempclients = cafe.getAdmins();
        for (int j = 1; j <= cafe.getCounterOfAdmins(); j++) {
            //if didnt order,continue the loop :
            if (tempclients.getValue().getOrders() != null) {
                System.out.print(tempclients.getInformations() + ":\n        [");
                for (drinks = tempclients.getValue().getOrders(); drinks != null; drinks = drinks.getNext()) {
                    System.out.print(drinks.getDrinkName() + "  ");
                }

                System.out.println("]");
            }
            tempclients = tempclients.getNext();
        }
    }
}
