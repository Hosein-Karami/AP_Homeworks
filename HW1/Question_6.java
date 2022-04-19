import java.util.Scanner;

public class Question_6 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] Array = new int[15];

        int CounterOfDijits = 0;
        while(number > 0){
            Array[CounterOfDijits] = number % 10;
            number /= 10;
            CounterOfDijits++;
        }

        //Check that is impossible or not :
        int Index;
        boolean Impossible = true; //we need this boolean to check impossible
        //impossible check :
        for(Index = 0;Index < CounterOfDijits - 1;Index++){
            if(Array[Index] > Array[Index+1]){
                Impossible = false;
                break;
            }
        }
        if(Impossible)
            System.out.println("-1");
        else{
            //check that they are Descending or not (From right):
            boolean Descending = true;
            for(Index = 0;Index < CounterOfDijits - 1;Index++){
                if(Array[Index] < Array[Index+1]){
                    Descending = false;
                    break;
                }
            }
            if(Descending){
                //Swap the first two number from right :
                int temp = Array[0];
                Array[0] = Array[1];
                Array[1] = temp;
            }
            else{
                for(Index = 0;Index < CounterOfDijits - 1;Index++) {
                    if (Array[Index] > Array[Index + 1])
                        break;
                }
                int tempIndex = 0,min = 10;
                //find smallest number that greater than Array[Index + 1]:
                for(int i = 0;i <= Index;i++){
                    if(Array[i] > Array[Index + 1] && Array[i] < min) {
                        tempIndex = i;
                        min = Array[i];
                    }
                }
                //swap :
                int temp = Array[Index + 1];
                Array[Index + 1] = Array[tempIndex];
                Array[tempIndex] = temp;

                for(int i = Index;i > 0 ;i--){
                    for(int j = 0;j < i;j++){
                        if(Array[j] < Array[j+1]){
                            temp = Array[j+1];
                            Array[j+1] = Array[j];
                            Array[j] = temp;
                        }
                    }
                }
            }
            //Make new number :
            int NewNumber = 0;
            for(Index = 0;Index < CounterOfDijits;Index++)
                NewNumber += (Array[Index] * Math.pow(10,Index));
            System.out.println(NewNumber);
        }
    }
}
