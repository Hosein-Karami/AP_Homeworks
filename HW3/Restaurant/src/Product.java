/**
 * this class is used to save information of a food and get access to them like:name,price,type and etc.
 * @author Hosein Karami
 * @since 3/11/2022
 * @version 1.0
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {
    private String name;
    private String Category;
    private float price;
    private LocalDateTime manufactureDate;
    private LocalDateTime expirationDate;

    Product(String name,float price,String type,LocalDateTime dateMfManufacture,LocalDateTime expirationDate){
        //We should check that manufacturedate is before from expiration date :
        if(dateMfManufacture.isAfter(expirationDate))
            System.out.println("ERROR : Manufacturedate should be before from expirationdate.");
        else {
            this.name = name;
            this.Category = type;
            this.price = price;
            this.manufactureDate = dateMfManufacture;
            this.expirationDate = expirationDate;
        }
    }

    /**
     * this method is used to return name of a product.
     * @return name of a product.
     */
    String getName(){
        return name;
    }

    /**
     * used to access to the type of products.
     * @return a products category.
     */
    String getCategory(){
        return Category;
    }
    /**
     * used to return price of products.
     * @return price.
     */
    float getPrice(){
        return price;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");//format of Localdate variable.
        return
                "name= '" + name + '\'' +
                "  Category= '" + Category + '\'' +
                "  price= " + price +
                "  manufactureDate= " + manufactureDate.format(formatter) +
                "  expirationDate= " + expirationDate.format(formatter);
    }
}
