/**
 * this is Drink class and saves drinks price and name.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */

public class Drink {
    private final String name;
    private final double price;

    Drink(String name,double price){
         this.name = name;
         this.price = price;
    }
    //get access to name of drinks.
    String getName(){
        return name;
    }
    String ToString(){
        return name + " " + (int)price;
    }
}
