/**
 * this class is used to save information of a person and get access to them.
 * @author Hosein Karami
 * @since 3/11/2022
 * @version 1.0
 */

import java.util.ArrayList;

public class Person {
    private final String name;
    private final String username;
    private float balance;
    private final Basket basket;

    //Constructor
    Person(String name,String userName,float balance){
        this.name = name;
        this.username = userName;
        this.balance = balance;
        basket = new Basket();
    }

    /**
     * this method is used to change person balance.
     * @param balance : new balance of person.
     */
    void setCash(float balance){
        this.balance = balance;
    }

    /**
     * this method is used to decrease the client balance after checkout.
     * @param prices : sumation of products prices that client want to buy.
     */
    void setBalance(double prices){
        balance -= prices;
    }

    /**
     * this method is used to add a ordred product to clients basket.
     * @param ordredProduct : product which client want to buy.
     */
    void addProduct(Product ordredProduct){
        basket.addProduct(ordredProduct);
    }

    /**
     * this method return username of a person.
     * @return username of a person
     */
    String getUserName(){
        return username;
    }
    /**
     * this method return name of a person.
     * @return name of a person.
     */
    String getName(){
        return name;
    }
    /**
     * used to return all balance of a client.
     * @return balance of a client.
     */
    float getBalance(){
        return balance;
    }
    /**
     * give access to sumation of clients products prices when client want to checkout.
     * @return sumation of clients products prices.
     */
    double getPricesOfProducts(){
        return basket.getprices();
    }

    /**
     * this method connect toString in basket class and Main class.
     * @return : informations from toString method in basket.
     */
    String toStringBasket(){
        return basket.toString();
    }
    /**
     * this method is used to return products which client bought them before.
     * @return products in basket.
     */
    ArrayList<Product> getproducts(){
        return basket.getProducts();
    }
    /**
     * give access to number of a client orders.
     * @return counter of a client orders.
     */
    int counterOfOrders(){
        return basket.getCounterOfOrders();
    }
    /**
     * this method is used to remove an order from basket of client.
     * @param index : index of order which client want to remove.
     */
    void removeOrder(int index){
        basket.removeProduct(index);
    }
    /**
     * this method is used when a client checkout and want to go out from restaurant.
     */
    void checkout(){
        basket.checkout();
    }
    @Override
    public String toString() {
        return
                "name= '" + name + '\'' +
                "  username= '" + username + '\'' +
                "  balance= " + balance ;
    }
}
