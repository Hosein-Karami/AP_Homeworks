public class Main {

    public static void main(String[] args){

        LoggingTest loggingTest = new LoggingTest("Main");

        loggingTest.makeInfoLog("Authentication request is: name:{}, Password:{}", new String[]{" Parham Ahmady", "123456"});
        System.out.println();//Go to next line.
        loggingTest.makeWarningLog("Warning : {} , solve : {}" , new String[]{"Null exception possible.","Initialize the refrence."});
        System.out.println();//Go to next line.
        loggingTest.makeErrorLog("error : {}",new String[]{"Divided by zero."});

    }
}
