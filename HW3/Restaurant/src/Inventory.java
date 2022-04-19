/**
 * this class is used to save the restaurants products with their stock.
 * @author Hosein Karami
 * @since 3/11/2022
 * @version 1.0
 */

import java.util.HashMap;

public class Inventory {
    private final HashMap<Product,Integer> products = new HashMap<>();
    private final String password = "ceit-2022";

    /**
     * this method is used to change a prodect's amount in stock.
     * @param newAmount : new amount of a product.
     * @param product : product which we want to change it's stock.
     */
    void setNewStock(int newAmount,String product){
        for(Product x : products.keySet()){
            if(x.getName().equals(product)){
                products.replace(x,products.get(x),newAmount);
                return;
            }
        }
    }

    /**
     * this method is used to add a product in inventory with its stock.
     * @param newProduct : refrence of new product which we want to add in inventory.
     * @param stock : stock of new product.
     */
    void addProduct(Product newProduct,int stock){
        products.put(newProduct,stock);
    }

    /**
     * this method is used to print products with their information :
     */
    void print(){
        for(Product x : products.keySet()){
            System.out.println(x.toString() + " inStock: " + products.get(x));
        }
    }

    /**
     * this method is used to return the number of a product in inventory.
     * @param product : name of food which we want to check its existence and stock.
     * @return number of this product in inventory and if this product does not exist in inventory,return -1.
     */
    int checkStock(String product){
        for(Product x : products.keySet()){
            if(x.getName().equals(product))
                return products.get(x);
        }
        return -1;
    }
    /**
     * this method is used to return a refrence of product which client want to buy.
     * @param ordredProduct : product which client want to buy.
     * @return a refrence of ordred product.
     */
    Product getProduct(String ordredProduct){
        for(Product x : products.keySet()){
            if(x.getName().equals(ordredProduct)){
                products.replace(x, products.get(x), products.get(x) - 1);//we should decrease number of this product 1 number because of order.
                return x;
            }
        }
        return null;
    }

    /**
     * this method get access to password of inventory when we want to compare it with input.
     * @return password of inventory.
     */
    String getPassword(){
        return password;
    }

    /**
     * this method is used when user want to remove a food from menu.
     * @param foodName : Name of food which user want to delete from menu.
     */
    void removeFood(String foodName){
        for(Product x : products.keySet()){
            if(x.getName().equals(foodName)){
                products.remove(x);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "products=" + products +
                '}';
    }
}
