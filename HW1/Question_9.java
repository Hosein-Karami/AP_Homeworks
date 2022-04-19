import java.util.Scanner;

public class Question_9 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String BinaryString = scanner.nextLine();
        int CounterOf_1 = 0;
        for(int Index = 0;Index < BinaryString.length();Index++){
            if(BinaryString.charAt(Index) == '1')
                CounterOf_1++;
        }
        if((CounterOf_1) % 3 != 0)
            System.out.println("0");
        else if(CounterOf_1 == 0){
            //number of ways equls to how many ways that we can choose 2 position from (n-1) position to put the insulator to divide into 3 substring = C(n,2) :
            int result = (BinaryString.length() - 1) * (BinaryString.length() - 2) / 2;
            System.out.println(result);
        }
        else{
             int[] IndexOf_1 = new int[CounterOf_1];
             int TempIndex = 0;
             for(int i = 0;i < BinaryString.length();i++){
                 if(BinaryString.charAt(i) == '1')
                     IndexOf_1[TempIndex ++] = i;
             }

             CounterOf_1 /= 3;
             int x = IndexOf_1[CounterOf_1] - IndexOf_1[CounterOf_1 - 1];//between the first and second group.
             int y = IndexOf_1[2 * CounterOf_1] - IndexOf_1[2 * CounterOf_1 - 1];//between the second and third group,therefore According to the principle of multiplication :
             System.out.println(x * y);
        }
    }
}
