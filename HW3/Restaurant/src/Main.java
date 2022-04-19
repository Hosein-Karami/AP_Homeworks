import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        //print first menu
        System.out.println("[ add.p  balance  people  menu  order checkout  basket  remove.b  inventory(remove & change)  exit  ]");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");//for set format of Localdate variable.

        //add first foods and drinks.
        Product product = new Product("Pizza",19.99f,"Food",LocalDateTime.parse("2022-04-05 21:00",formatter),LocalDateTime.parse("2022-05-09 21:00",formatter));
        store.addProduct(product,10);
        product = new Product("Steak",100f,"Food",LocalDateTime.parse("2022-03-06 21:30",formatter),LocalDateTime.parse("2022-03-09 00:00",formatter));
        store.addProduct(product,5);
        product = new Product("Burger",15.75f,"Food",LocalDateTime.parse("2022-03-03 08:30",formatter),LocalDateTime.parse("2022-03-03 20:30",formatter));
        store.addProduct(product,100);
        product = new Product("Coffee",8.50f,"Drink",LocalDateTime.parse("2022-03-01 13:20",formatter),LocalDateTime.parse("2022-03-01 15:20",formatter));
        store.addProduct(product,50);
        product = new Product("Chocolate",17.99f,"Snack",LocalDateTime.parse("2022-01-12 10:50",formatter),LocalDateTime.parse("2023-01-12 10:30",formatter));
        store.addProduct(product,15);
        product = new Product("Snack",3.49f,"Snack",LocalDateTime.parse("2022-01-14 16:30",formatter),LocalDateTime.parse("2022-01-14 16:30",formatter));
        store.addProduct(product,12);
        product = new Product("Soda",7f,"Drink",LocalDateTime.parse("2022-03-11 15:30",formatter),LocalDateTime.parse("2022-06-11 15:30",formatter));
        store.addProduct(product,80);
        product = new Product("Noodle",35f,"Food",LocalDateTime.parse("2022-02-28 13:20",formatter),LocalDateTime.parse("2022-04-01 00:00",formatter));
        store.addProduct(product,40);

        String choose;//give user wishes.
        while(true){
            choose = scanner.next();
            choose = choose.toLowerCase();//avoid user error in lowercase and uppercase.

            if(choose.equals("exit")) {
                System.out.println("Have a nice day, chief.");
                break;//go out from loop.
            }

            else if(choose.equals("add.p")){
                Person person;
                String name = scanner.next();
                String userName = scanner.next();
                float balance = scanner.nextFloat();
                scanner.nextLine();//avoid ignore scanner.next() in continue.
                //check that username exist or not :
                if( store.checkExistUsernames(userName))
                    System.out.println("This username already exist!");
                else{
                    person = new Person(name, userName, balance);
                    store.addUsers(person);
                    System.out.println("Successfully added user.");
                }
            }

            else if(choose.equals("balance")){
                String userName = scanner.next();
                float newBalance = scanner.nextFloat();
                scanner.nextLine();//avoid ignore scanner.next() in continue.
                if( ! store.checkExistUsernames(userName))
                    System.out.println("Invalid username.");
                else if(newBalance < 0)
                    System.out.println("New balance should not negetive.");
                else{
                    Person person = store.getPerson(userName);
                    person.setCash(newBalance);
                    System.out.println("Successfully transmitted.");
                }
            }

            else if(choose.equals("people")){
                HashSet<Person> people = store.getPeople();
                if(people.size() == 0)
                    System.out.println("There is no one here.");
                else{
                    int counter = 1;
                    for(Person x : people){
                        System.out.println(counter + ". " + x.toString());
                        counter++;
                    }
                }
            }

            else if(choose.equals("menu"))
                store.printPoducts();

            else if(choose.equals("order")){
                String userName = scanner.next();
                String productName = scanner.next();
                if( ! store.checkExistUsernames(userName))
                    System.out.println("Invalid username.");
                else if(store.searchFoodStock(productName) == 0)
                    System.out.println("Out of stack.");
                else if(store.searchFoodStock(productName) == -1)
                    System.out.println("Invalid food (hint that input should exactly like menu).");
                else{
                    Product orderedProduct = store.ordredProduct(productName);
                    Person client = store.getPerson(userName);
                    client.addProduct(orderedProduct);
                    System.out.println("Successfully added to your basket.");
                }
            }

            else if(choose.equals("checkout")){
                String userName = scanner.next();
                if( ! store.checkExistUsernames(userName))
                    System.out.println("Invalid username.");
                else{
                    Person client = store.getPerson(userName);
                    if(client.getPricesOfProducts() > client.getBalance())
                        System.out.println("You cant afford your bill.");
                    else{
                        double total = client.getPricesOfProducts();
                        DecimalFormat format = new DecimalFormat();
                        format.setMaximumFractionDigits(2);//Print total price up to 2 decimal number.
                        System.out.println(client.getName() +"'s bill = " + format.format(total) + "\n" + client.toStringBasket());

                        client.checkout();//make empty the basket of clients.
                        client.setBalance(total);//decrease the client balance.

                        System.out.println("Your new balance= "+ client.getBalance() +"\nHave a good day.");
                    }
                }
            }

            else if(choose.equals("basket")){
                String userName = scanner.next();
                if( ! store.checkExistUsernames(userName))
                    System.out.println("Invalid username.");
                else{
                    Person client = store.getPerson(userName);
                    ArrayList<Product> products = client.getproducts();
                    System.out.println(client.getName() + "'s Basket:");
                    int counter = 1;
                    for(Product x : products){
                        System.out.println(counter + ". " + x.getName() + "  " + x.getCategory() + "  " + x.getPrice() + "$");
                        counter++;
                    }
                }
            }

            else if(choose.equals("remove.b")){
                String userName = scanner.next();
                int index = scanner.nextInt();
                scanner.nextLine();//avoid ignore scanner.next() in continue.
                if( ! store.checkExistUsernames(userName))
                    System.out.println("Invalid username.");
                else{
                    Person person = store.getPerson(userName);
                    if( 0 < index && index <= person.counterOfOrders()){
                        person.removeOrder(index);
                        System.out.println("Successfully removed.");
                    }
                    else
                        System.out.println("Invalid index.");
                }
            }

            else if(choose.equals("inventory")){
                String password = scanner.next();
                String task = scanner.next();
                task = task.toLowerCase();//avoid user error in lowercase and uppercase.

                if(task.equals("remove")){
                    String foodName = scanner.next();
                    if(password.equals(store.getPassword())){
                         if(store.searchFoodStock(foodName) == -1)
                             System.out.println("Invalid food (hint that input should exactly like menu).");
                         else {
                             store.removeFood(foodName);
                             System.out.println("Successfully removed.");
                         }
                    }
                    else
                        System.out.println("Invalid password.");
                }

                else if(task.equals("change")){
                    String food = scanner.next();
                    int newAmount = scanner.nextInt();
                    scanner.nextLine();//avoid ignore scanner.next() in continue.

                    if(password.equals(store.getPassword())) {
                        if (store.searchFoodStock(food) == -1)
                            System.out.println("Invalid food (hint that input should exactly like menu).");
                        else if (newAmount < 0)
                            System.out.println("New amount should not negetive.");
                        else if (newAmount > store.searchFoodStock(food))
                            System.out.println("Greater than available amount in stock");
                        else{
                            store.setProductsStock(newAmount,food);
                            System.out.println("Successfully changed the amount.");
                        }
                    }
                    else
                        System.out.println("Invalid password.");
                }
                else
                    System.out.println("Invalid request.");
            }

            else
                System.out.println("Invalid input.");
        }
    }
}
