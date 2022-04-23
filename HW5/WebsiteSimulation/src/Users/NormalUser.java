/**
 * this class is used to save information of normal users and get access to them.
 * @author : Hosein Karami
 * @since 4/21/22
 * @version 1.0
 */

package Users;

public class NormalUser extends User {

    private int downloadCounter;//Counter films that user downloaded.

    //Constructor :
    public NormalUser(String userName,String password){
        super(userName,password);
        downloadCounter = 0;
    }

    /**
     * this method return the number of downloads of this user.
     * @return : number of downloads of this user.
     */
    public int getDownloadCounter() {
        return downloadCounter;
    }

    /**
     * this method is used when a normal user download a film to increase his/her downloadCounter.
     */
    public void download(){
        downloadCounter += 1;
    }

}
