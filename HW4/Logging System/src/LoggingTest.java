/**
 * this class is used to make log and report it.
 * @author Hosein Karami
 * @version 1.0
 * @since 4/3/2022
 */

public class LoggingTest {

    private Logger logger;

    LoggingTest(String className){
        logger = Logger.getInstance(className);
    }

    /**
     * this method is used to make an info log.
     * @param request : request of user.
     * @param information : some information.
     */
    void makeInfoLog(String request, String[] information){
        logger.infoLogSetter();
        logger.setMessage(request,information);
        logger.print();
    }

    /**
     * this method is used to make a warning log.
     * @param request : request of user.
     * @param information : some information.
     */
    void makeWarningLog(String request,String[] information){
        logger.warnLogSetter();
        logger.setMessage(request,information);
        logger.print();
    }

    /**
     * this method is used to make an error log.
     * @param request : request of user.
     * @param information : some information.
     */
    void makeErrorLog(String request,String[] information){
        logger.errorLogSetter();
        logger.setMessage(request,information);
        logger.print();
    }
}
