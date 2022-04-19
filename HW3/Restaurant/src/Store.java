/**
 * this class is used to save store's information and connect main class with other classes and methods.
 * @author Hosein Karami
 * @version 1.0
 *
 */

import java.util.HashSet;

public class Store {
    private final Inventory inventory = new Inventory();
    private final HashSet<Person> people = new HashSet<>();

    /**
     * this method is used to change a prodect's amount in stock.
     * @param newAmount : new amount of a product.
     * @param product : product which we want to change it's stock.
     */
    void setProductsStock(int newAmount,String product){
        inventory.setNewStock(newAmount,product);
    }
    /**
     * this method is used to add a new product to inventory.
     * @param newProduct : refrence of new product which we want to add in store inventory.
     * @param stock : stock of new product.
     */
    void addProduct(Product newProduct,int stock){
        inventory.addProduct(newProduct,stock);
    }

    /**
     * this method is used to add a person in list of people in store.
     * @param newPerson : refrence of new person
     */
    void addUsers(Person newPerson){
        people.add(newPerson);
    }
    /**
     * this method is used to check that new username exist in store or not.
     * @param userName : username of new person
     * @return a boolean value
     */
    boolean checkExistUsernames(String userName){
        for(Person x : people){
            if(x.getUserName().equals(userName))
                return true;
        }
        return false;
    }

    /**
     * this username is used to return a particular person with his/her username.
     * @param userName : username of wanted person.
     * @return : return a refrence of wanted person.
     */
    Person getPerson(String userName){
        for(Person x : people){
            if(x.getUserName().equals(userName))
                return x;
        }
        return null;
    }

    /**
     * this method return people of store.
     * @return all person registred in store.
     */
    HashSet<Person> getPeople(){
        return people;
    }

    /**
     * this method is used to print products with their information :
     */
    void printPoducts(){
        inventory.print();
    }

    /**
     * this method return number of a particular food in inventory.
     * @param product : ordered foods name.
     * @return number of product in inventory.
     */
    int searchFoodStock(String product){
        return inventory.checkStock(product);
    }

    /**
     * this method is used to return a refrence of product which client want to buy.
     * @param ordredProduct : product which client want to buy.
     * @return a refrence of ordred product.
     */
    Product ordredProduct(String ordredProduct){
        return inventory.getProduct(ordredProduct);
    }
    /**
     * this method get access to password of inventory when we want to compare it with input.
     * @return password of inventory.
     */
    String getPassword(){
        return inventory.getPassword();
    }
    /**
     * this method is used when user want to remove a food from menu.
     * @param foodName : Name of food which user want to delete from menu.
     */
    void removeFood(String foodName){
        inventory.removeFood(foodName);
    }

}
