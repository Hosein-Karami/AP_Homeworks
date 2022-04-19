/**
 * this class is used for manage the chairs.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/03/2022
 */
public class Chairs {
     private boolean Occupancy = false;

     //this method is used for change the value of Occupancy when somebody sit on chair.
     public void setOccupancy(){
         Occupancy = true;
     }

     //this method is used for change the value of Occupancy when somebody stand up from chair.
     public void setOccupancy_2(){
         Occupancy = false;
     }

     //this method is used for access to the occupancy.
     public boolean getOccupancy(){
         return Occupancy;
     }
}
