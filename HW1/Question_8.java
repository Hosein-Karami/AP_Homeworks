import java.util.Scanner;

public class Question_8 {
    static void Print(int[] Array,int K) {
        boolean print = true;//check that no pair of one(1) come together :
        for (int Index = 0; Index < K - 1; Index++) {
            if (Array[Index] == 1 && Array[Index + 1] == 1)
                print = false;
        }
        if (print) {
            //Check that print (", ") or not,we should not print (", ") before the array that only have 0 like 00000:
            boolean PrintComma = false;
            for (int i = 0; i < K; i++) {
                if (Array[i] == 1) {
                    PrintComma = true;
                    break;
                }
            }
            if (PrintComma)
                System.out.print(", ");
            for(int Index = 0;Index < K;Index++)
                System.out.print(Array[Index]);
        }
    }

    static void Function(int K,int[] Array,int Index){
         if(Index == K) {
             Print(Array,K);
             return;
         }
         //each member can be 1 or 0 :

         Array[Index] = 0;
         Function(K,Array,Index + 1);


         Array[Index] = 1;
         Function(K,Array,Index+1);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int[] Array = new int[K];
        Function(K,Array,0);
    }
}
