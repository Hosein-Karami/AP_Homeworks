import java.util.Scanner;
import java.lang.String;

public class Question_5 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String Equation = scanner.nextLine();
        int CurrentIndex = 0;//for move in Equation string.

        String FirstFactor_temp = "";
        while(true){
            CurrentIndex++;
            if(Equation.charAt(CurrentIndex) == 'x'|| Equation.charAt(CurrentIndex) == 'X')
                break;
            FirstFactor_temp = FirstFactor_temp + Equation.charAt(CurrentIndex);
        }
        float FirstFactor = Float.parseFloat(FirstFactor_temp);//cast the string to float
        CurrentIndex += 5;//move string to ignore unnumberic members :

        String SecondFactor_temp = "";
        while(true){
            CurrentIndex++;
            if(Equation.charAt(CurrentIndex) == 'x' || Equation.charAt(CurrentIndex) == 'X')
                break;
            SecondFactor_temp = SecondFactor_temp + Equation.charAt(CurrentIndex);
        }
        float SecondFactor = Float.parseFloat(SecondFactor_temp);//cast the string to float
        CurrentIndex += 3;//move to ignore unnumberic members.

        String ThirdFactor_temp = "";
        while(true){
            CurrentIndex++;
            if(Equation.charAt(CurrentIndex) == ')')
                break;
            ThirdFactor_temp = ThirdFactor_temp + Equation.charAt(CurrentIndex);
        }
        float ThirdFactor = Float.parseFloat(ThirdFactor_temp);//cast the string to float

        //Print result.
        if(FirstFactor == 0){
            //this is a first degree equation.
            if(SecondFactor == 0)
                System.out.println("Roots are not real");

            else {
                float result = (-ThirdFactor) / SecondFactor;

                if (result == -0)
                    System.out.println("0.00");
                else
                    System.out.printf("%.2f", result);
            }
        }
        else{
            float Delta = (float) ((Math.pow(SecondFactor,2)) - (4 * FirstFactor * ThirdFactor));
            if(Delta < 0)
                System.out.print("Roots are not real");
            else if(Delta == 0){
                float result = (-SecondFactor) / (2 * FirstFactor);
                if(result == -0)
                    System.out.println("0.00");
                else
                    System.out.printf("%.2f",result);
            }
            else{
                float result_1 = (float) (((-SecondFactor) + (Math.sqrt(Delta))) / (2 * FirstFactor));//Big answer
                float result_2 = (float) (((-SecondFactor) - (Math.sqrt(Delta))) / (2 * FirstFactor));//Small answer
                System.out.printf("%.2f\n%.2f",result_1,result_2);
            }
        }
    }
}
