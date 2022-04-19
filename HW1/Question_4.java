import java.util.Scanner;

public class Question_4 {
    static void SortCordinates(int[] X_Cordinate,int[] Y_Cordinate) {
        //bubble sort for sort cordinates Based on X cordinates:
        int temp;
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (X_Cordinate[j] > X_Cordinate[j + 1]) {
                    temp = X_Cordinate[j];
                    X_Cordinate[j] = X_Cordinate[j + 1];
                    X_Cordinate[j + 1] = temp;
                    temp = Y_Cordinate[j];
                    Y_Cordinate[j] = Y_Cordinate[j + 1];
                    Y_Cordinate[j + 1] = temp;
                }
            }
        }
        //Sort Y :
        if(Y_Cordinate[1] > Y_Cordinate[0]){
            temp = Y_Cordinate[0];
            Y_Cordinate[0] = Y_Cordinate[1];
            Y_Cordinate[1] = temp;
        }
        if(Y_Cordinate[3] > Y_Cordinate[2]){
            temp = Y_Cordinate[2];
            Y_Cordinate[2] = Y_Cordinate[3];
            Y_Cordinate[3] = temp;
        }
    }
    static boolean CheckOverlap(int[] X_Cordinate_1,int[] Y_Cordinate_1,int[] X_Cordinate_2,int[] Y_Cordinate_2){

        if((Y_Cordinate_1[1] > Y_Cordinate_2[0]) || (Y_Cordinate_2[1] > Y_Cordinate_1[0]))
            return false;

        if((X_Cordinate_1[0] > X_Cordinate_2[3]) || (X_Cordinate_2[0] > X_Cordinate_1[3]))
            return false;

        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String String_1 = scanner.nextLine();
        String String_2 = scanner.nextLine();
        String_1 = String_1.replaceAll(","," ");
        String_2 = String_2.replaceAll(","," ");
        String[] temp_1 = String_1.split(" ");//Even indexes are x and odd indexes are y.
        String[] temp_2 = String_2.split(" ");//Even indexes are x and odd indexes are y.
        int[] X_Cordinate_1 = new int[4];
        int[] Y_Cordinate_1 = new int[4];
        int[] X_Cordinate_2 = new int[4];
        int[] Y_Cordinate_2 = new int[4];
        //cast from string format to integer format :
        int X_index = 0,Y_index = 0;
        for(int Index = 0;Index < 7 ;Index += 2){
            X_Cordinate_1[X_index] = Integer.parseInt(temp_1[Index]);
            X_Cordinate_2[X_index] = Integer.parseInt(temp_2[Index]);
            X_index++;
            Y_Cordinate_1[Y_index] = Integer.parseInt(temp_1[Index + 1]);
            Y_Cordinate_2[Y_index] = Integer.parseInt(temp_2[Index + 1]);
            Y_index++;
        }
        SortCordinates(X_Cordinate_1,Y_Cordinate_1);
        SortCordinates(X_Cordinate_2,Y_Cordinate_2);
        if( ! (CheckOverlap(X_Cordinate_1,Y_Cordinate_1,X_Cordinate_2,Y_Cordinate_2)))
            System.out.print("False");
        else{
            System.out.println("True");
            int OverlapLength = Math.min(X_Cordinate_1[3],X_Cordinate_2[3]) - Math.max(X_Cordinate_1[0],X_Cordinate_2[0]);
            int OverlapWidth = Math.min(Y_Cordinate_1[0],Y_Cordinate_2[0]) - Math.max(Y_Cordinate_1[3],Y_Cordinate_2[3]);
            System.out.print(OverlapLength * OverlapWidth);
        }
    }
}
