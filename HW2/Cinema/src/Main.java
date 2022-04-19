/**
 * this class is used for manage the cinema.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/03/2022
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        int rows = scanner.nextInt();
        Cinema cinema = new Cinema(rows);
        int left,right,row;
        for(int i = 1;i <= counter;i++){
            left = scanner.nextInt();
            right = scanner.nextInt();
            row = scanner.nextInt();
            if(row > rows || row < 1) {
                System.out.println("false");
                continue;
            }
            if(left > 10 || left < 1 || right > 10 || right <  1 ){
                System.out.println("false");
                continue;
            }
            if(left > right){
                System.out.println("false");
                continue;
            }
            if(cinema.checkChairs(left,right,row)){
                System.out.println("true");
                cinema.occupyChairs(left,right,row);
            }
            else
                System.out.println("false");
        }
    }
}
