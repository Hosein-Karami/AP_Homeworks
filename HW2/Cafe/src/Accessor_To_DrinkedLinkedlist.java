/**
 * this class is used to do different work with our linkedlist.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */
public class Accessor_To_DrinkedLinkedlist {

    //print Drinks:
    void print(DrinkLinkedList firstMember){
        DrinkLinkedList temp = firstMember;
        while(true){
            if(temp == null)
                break;
            System.out.println(temp.getDrinkName());
            temp = temp.getNext();
        }
    }
    //print Drinks with their price :
    void printWithPrice(DrinkLinkedList firstMember){
        DrinkLinkedList temp = firstMember;
        while(true){
            if(temp == null)
                break;
            System.out.println(temp.getValue().ToString());
            temp = temp.getNext();
        }
    }
    //add a drink to our linkedlist :
    void addDrink(DrinkLinkedList firstMemeber,Drink drink){
        //Check first member of linkedlist
        if(firstMemeber.getValue() == null)
            firstMemeber.setValue(drink);

        else{
            DrinkLinkedList temp;
            for(temp = firstMemeber; temp.getNext() != null;temp = temp.getNext());
            DrinkLinkedList next = new DrinkLinkedList();
            next.setValue(drink);
            temp.setNext(next);
        }
    }

    //delete a drink from linkedlist :
    void removeDrink(DrinkLinkedList firstMember,Drink targetDrink){
        DrinkLinkedList temp;
        for(temp = firstMember; temp.getNext().getValue() != targetDrink; temp = temp.getNext());
        DrinkLinkedList temp_2 = temp.getNext().getNext();
        temp.setNext(temp_2);//Garbagecollector remove temp.next from memory.
    }

    //return a particular Drink refrence with its index in list :
    Drink getValueWithIndex(DrinkLinkedList firstMember,int index){
        DrinkLinkedList temp = firstMember;
        for(int i = 1; i < index; i++,temp = temp.getNext());
        return temp.getValue();
    }
}
