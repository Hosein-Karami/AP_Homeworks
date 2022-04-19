/**
 * this is Client class to save client information and get access to them for other classes.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */
public class Client {
    private String name;
    private String id;
    private DrinkLinkedList order;
    private int currentOfDrinks = 0;

    //add a order to client Drinks linkedlist :
    void orderDrink(Drink newOrder){
        if(currentOfDrinks == 0)
            order = new DrinkLinkedList();//this is the start refrence of our Linkedlist.
        order.addDrink(newOrder);
        currentOfDrinks++;
    }
    //remove cancled order from linkedlist.
    void cancelOrder(Drink targetOrder){
        order.removeDrink(targetOrder);
        currentOfDrinks--;
    }
    //if cancled drinked is first member of linkedlist and set second member as first member :
    void cancelFirstMember(){
        order = order.getNext();//Garbage collector remove older order from memory.
        currentOfDrinks--;
    }
    //get access to client orders :
    DrinkLinkedList getOrders(){
        return order;
    }
    //set information of a client :
    void setInformations(String name,String id){
        this.name = name;
        this.id = id;
    }
    //get access to Id of a client :
    String getId(){
        return id;
    }
    //get name :
    String getName(){
        return name;
    }
    //get access to information of a client :
    String getInformations(){
        return name + " - " + id;
    }
    //return current of a client orders :
    int getCurrentOfOrders(){
        return currentOfDrinks;
    }
}
