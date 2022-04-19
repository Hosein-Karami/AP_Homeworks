/**
 * In this class we make our own linkedlist and do not use from LinkedList package of java.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */
public class DrinkLinkedList {

    private Drink value = null;
    private DrinkLinkedList next = null;

    //return drinks name :
    String getDrinkName(){
        return value.getName();
    }
    //return refrence of next member :
    DrinkLinkedList getNext(){
        return next;
    }
    //return refrence of a member :
    Drink getValue(){
        return value;
    }
    //set value refrence :
    void setValue(Drink value){
        this.value = value;
    }
    //set next member refrence :
    void setNext(DrinkLinkedList next){
        this.next = next;
    }
    //add a drink to list :
    void addDrink(Drink drink){
        Accessor_To_DrinkedLinkedlist addTemp = new Accessor_To_DrinkedLinkedlist();
        addTemp.addDrink(this,drink);
    }
    //remove a drink from our list :
    void removeDrink(Drink targetDrink){
        Accessor_To_DrinkedLinkedlist removeTemp = new Accessor_To_DrinkedLinkedlist();
        removeTemp.removeDrink(this,targetDrink);
    }
    //return a drink from DrinkedLinkedList with its index :
    Drink getValueWithIndex(int index){
        Accessor_To_DrinkedLinkedlist serchTemp = new Accessor_To_DrinkedLinkedlist();
        return serchTemp.getValueWithIndex(this,index);
    }
}
