/**
 * this class is used to save information that is common between users and admins and get access to them.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Users;

import java.time.LocalDateTime;

public abstract class GeneralUser {

    private final String userName;
    private final String password;
    private final LocalDateTime joinDate;

    //Constructor :
    protected GeneralUser(String userName,String password){
        this.userName = userName;
        this.password = password;
        joinDate = LocalDateTime.now();
    }

    /**
     * this method get access to username of user.
     * @return : username of user.
     */
    public String getUserName(){
        return userName;
    }

    /**
     * this method get access to password of user.
     * @return : password of user.
     */
    public String getPassword(){
        return password;
    }

    /**
     * this method get access to join_date of user.
     * @return : join_date of user.
     */
    public LocalDateTime getJoinDate() {
        return joinDate;
    }
}
