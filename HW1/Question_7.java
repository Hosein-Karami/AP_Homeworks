import java.util.Scanner;

public class Question_7 {

    static boolean CheckBijenctive(char Alphabet,String Word,String String_1,String[] WordsArray){
        for(int Index = 0;Index < String_1.length();Index++){
            if(String_1.charAt(Index) == Alphabet){
                if( ! (WordsArray[Index].equals(Word)))
                    return false;
            }
            if(WordsArray[Index].equals(Word)){
                if(String_1.charAt(Index) != Alphabet)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string_1 = scanner.nextLine();
        String string_2 = scanner.nextLine();

        String[] Words = string_2.split(" ");//make an string array from string_2 words.
        //Number of words in string_2 is Words.length,therefore :
        if(Words.length != string_1.length())
            System.out.println("False");

        else{
            boolean result = true;
            for(int Index = 0;Index < string_1.length();Index++){
                if( ! (CheckBijenctive(string_1.charAt(Index),Words[Index],string_1,Words))){
                    result = false;
                    break;
                }
            }
            if(result)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
