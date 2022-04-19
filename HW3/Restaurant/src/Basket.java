/**
 * this class is used to save a Person orders with their prices.
 * @author Hosein Karami
 * @since 3/11/2022
 * @version 1.0
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Basket {

      private final ArrayList<Product> products = new ArrayList<>();
      private double tax;//all taxes that a client should pay.
      private float net;//product's price without tax.

      DecimalFormat decimalFormat = new DecimalFormat();

      Basket(){
            tax = 0;
            net = 0;
            decimalFormat.setMaximumFractionDigits(2);//for print tax up to 2 decimal number
      }

      /**
       * this method is used to add a product in client basket and sum net with product's price and update tax.
       * @param newProduct : new order product
       */
      void addProduct(Product newProduct){
            products.add(newProduct);
            net += newProduct.getPrice();
            if(newProduct.getCategory().equals("Food"))
                  tax += (0.10 * newProduct.getPrice());
            else if(newProduct.getCategory().equals("Drink"))
                  tax += (0.35 * newProduct.getPrice());
            else
                  tax += (0.20 * newProduct.getPrice());
      }

      /**
       * this method is used to return products which client bought them before.
       * @return products in basket.
       */
      ArrayList<Product> getProducts(){
            return products;
      }
      /**
       * give access to number of a client orders.
       * @return counter of a client orders.
       */
      int getCounterOfOrders(){
            return products.size();
      }

      /**
       * this method is used to remove an order from basket of client and update net and tax of client's basket.
       * @param index : index of order which client want to remove.
       */
      void removeProduct(int index){
            Product temp = products.get(index - 1);
            products.remove(temp);
            net -= temp.getPrice();
            if(temp.getCategory().equals("Food"))
                  tax -= (0.10 * temp.getPrice());
            else if(temp.getCategory().equals("Drink"))
                  tax -= (0.35 * temp.getPrice());
            else
                  tax -= (0.20 * temp.getPrice());
      }
      /**
       * this method is used to return all prices of products with tax which are in clients basket when they want to checkout.
       * @return a client products prices.
       */
      double getprices(){
            return tax + net;
      }

      /**
       * this method is used when a client checkout and want to go out from restaurant.
       */
      void checkout(){
            products.clear();
            tax = 0;
            net = 0;
      }

      @Override
      public String toString() {
            return "tax = " + decimalFormat.format(tax) +
                    "  net = " + net;
      }
}
