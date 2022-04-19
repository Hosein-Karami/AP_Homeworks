/**
 * this is inputHnandler class to get inputs from users and handle them and call other methods and classes.
 * @author Hosein Karami
 * @since 2022/03/06
 * @version 1.0
 */
import java.util.Scanner;

public class inputHandler {
    private final Cafe cafe = new Cafe();
    private Client client;
    private final MenuHandler menu = new MenuHandler(cafe);

    Scanner scanner = new Scanner(System.in);

    String id;//for give clients id.

    //run programm and show first menu to client choose one of choices :
    void run(){
        menu.printFirstMenu();
        //controll input :
        int choice;
        while(true) {
            choice = scanner.nextInt();
            if(1 <= choice && choice <= 4)
                break;
            System.out.print("Your input is invalid :| try again : ");
        }
        scanner.nextLine();//avoid to ignore scanner.nextline in continue:

        if(choice == 1){
            System.out.println("Enter your name and role:");
            String informations = scanner.nextLine();
            int indexOfComma = informations.indexOf(',');
            String name = informations.substring(0,indexOfComma);
            String role = informations.substring(indexOfComma);
            role = role.replace(",","");//ignore comma.
            role = role.replace(" ","");//ignore spaces.
            role = role.toLowerCase();//make all alphabets lowercase.
            if(role.equals("client")){
                id = cafe.idMaker();
                registerClient(name,id);
            }
            else if(role.equals("admin")){
                id = cafe.idMaker();
                registerAdmin(name,id);
            }
            else {
                System.out.println("Your input is invalid.");
                run();
            }
        }

        else if(choice == 2){
            System.out.println("Enter your ID:");
            id = scanner.nextLine();
            signInClient(id);
        }

        else if(choice == 3){
            System.out.println("Enter your ID:");
            id = scanner.nextLine();
            signInAdmin(id);
        }
    }
    //Sign in clinets with  their id :
    void signInClient(String id){
        client = cafe.getClient(id);
        if(client == null) {
            System.out.println("This client_id did not register before.");
            run();
        }
        else
            doClientWish();
    }
    //Sign in admins with  their id :
    void signInAdmin(String id){
        client = cafe.getAdmin(id);
        if(client == null) {
            System.out.println("This admin_id did not register before.");
            run();
        }
        else {
            menu.printAdminMenu();
            int choose = scanner.nextInt();
            while(choose != 1){
                System.out.print("For back to main menu,you should enter 1 : ");
                choose = scanner.nextInt();
            }
            scanner.nextLine();//avoid ignore scanner.nextline in continue.
            run();
        }
    }
    //register a new client and give him/her an ID :
    void registerClient(String name,String id){
        client = new Client();
        client.setInformations(name,id);
        cafe.addClient(client);
        System.out.println("Welcome " + name + " Jaan!");
        System.out.println("Your id is: " + id);
        run();
    }
    //register a new admin and give him/her an ID :
    void registerAdmin(String name,String id){
        client = new Client();
        client.setInformations(name,id);
        cafe.addAdmin(client);
        System.out.println("Welcome " + name + " Jaan!");
        System.out.println("Your id is: " + id);
        run();
    }
    //this method runs after a client choose a drink,and this method add his order to his Drinklinkedlist :
    void addOrder(int index){
        Drink drink;
        if(index == 1)
            drink = new Drink("Tea",45000);
        else if(index == 2)
            drink = new Drink("Milk",38000);
        else if(index == 3)
            drink = new Drink("Coffee",99990);
        else if(index == 4)
            drink = new Drink("Shake",81000);
        else
            drink = new Drink("Watermelon juice",16000);
        client.orderDrink(drink);
        doClientWish();
    }
    //this method runs when a client sign in and show him/her the client menu to choose what he/she want to do :
    void doClientWish(){
        menu.printClientMenu();
        //Control inputs :
        int choice;
        while(true) {
            choice = scanner.nextInt();
            if(1 <= choice && choice <= 3)
                break;
            System.out.print("Your input is invalid :| try again : ");
        }
        scanner.nextLine();//avoid ignore scanner.nextline in continue.
        //add order :
        if(choice == 1)
            chooseOrder();
        //delete orders :
        else if(choice == 2){
            //if orderlist is empty :
            if(client.getCurrentOfOrders() == 0)
                cancelOrder(-1);

            else {
                menu.printClientAllOrders(id);
                int index = scanner.nextInt();
                scanner.nextLine();//avoid ignore scanner.nextline in continue.
                cancelOrder(index);
                }
        }
        else
            run();
    }
    //this method runs when a client decide to order a drink :
    void chooseOrder(){
        cafe.showCafeMenu();
        //control input :
        int index;
        while(true) {
            index = scanner.nextInt();
            if(1 <= index && index <= 5)
                break;
            System.out.print("Your input is invalid :| try again : ");
        }
        scanner.nextLine();//avoid ignore scanner.nextline in continue.
        addOrder(index);
    }
    //this method runs when a client want to cancel an order :
    void cancelOrder(int index){
        //orderlist is empty :
        if(index == -1)
            System.out.println("You have not any order.");

        else {
            //Delete first member of list :
            if (index == 1) {
                client.cancelFirstMember();
            }
            //delete other members :
            else {
                DrinkLinkedList clientOrders = (client.getOrders());
                if (index <= client.getCurrentOfOrders())//if index bigger than clientorders_size,means user choose back.
                    client.cancelOrder(clientOrders.getValueWithIndex(index));
            }
        }
        doClientWish();
    }
}
