/**
 * this class is used to save log's information and print them.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/3/2022
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private LocalDateTime time;
    private String logLevel;
    private String message;
    private final String className;

    /**
     * this is private constructor and you can not use this constructor out of this class.
     * @param className : name of the class where log happen.
     */
    private Logger(String className){
        this.className = className;
    }

    /**
     * this method is used when we want make object from this class because constructor of this class is private.
     * @param className : name of the class where log happen.
     * @return : refrence of the logger object.
     */
    static Logger getInstance(String className){
        Logger logger = new Logger(className);
        return logger;
    }
    
    /**
     * this method is used when we want to make an info log,sets the log's time and it's level.
     */
    void infoLogSetter() {
        time = LocalDateTime.now();//Set log time with now time.
        logLevel = "Info";
    }

    /**
     * this method is used when we want to make a warning log,sets the log's time and it's level.
     */
    void warnLogSetter(){
        time = LocalDateTime.now();//Set log time with now time.
        logLevel = "Warn";
    }

    /**
     * this method is used when we want to make an error log,sets the log's time and it's level.
     */
    void errorLogSetter(){
        time = LocalDateTime.now();//Set log time with now time.
        logLevel = "Error";
    }

    /**
     * this class is used to print the log.
     */
    void print(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:ms");
        String information = (formatter.format(time) + " [" + logLevel + "] " + className);//information of time and level and class.
        System.out.println(information);
        System.out.println(message);
        //Print more information :
        if(logLevel.equals("Info")) {
            System.out.println(information);
            System.out.println("Report : Operation in progress.");
        }
        else if(logLevel.equals("Error")){
            System.out.println(information);
            System.out.println("Error : Something is wrong.");
        }
        else{
            System.out.println(information);
            System.out.println("Warning : It's better to fix the code.");
        }
    }

    /**
     * this method is used to set the log's message.
     * @param request : request in string format.
     * @param information : some information.
     */
    void setMessage(String request,String[] information){

        int index = 0;
        //Replace {} with information by regex.
        while(index < information.length){
            request = request.replaceFirst("\\{}",information[index]);
            index++;
        }

        message = request;
    }
}
