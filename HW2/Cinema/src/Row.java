/**
 * this class is used for manage the chairs.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/03/2022
 */
public class Row {
    private final Chairs[] left = new Chairs[3];
    private final Chairs[] middle = new Chairs[4];
    private final Chairs[] right = new Chairs[3];

    //Constructor :
    public Row(){
        for(int i = 0;i < 3;i++)
            left[i] = new Chairs();
        for(int i = 0;i < 4;i++)
            middle[i] = new Chairs();
        for(int i = 0;i < 3;i++)
            right[i] = new Chairs();
    }

    //this method is used for check a chair is occupancied or not :
    public boolean getChair(int c){
        if(1 <= c && c <= 3)
            return left[c-1].getOccupancy();
        else if(4 <= c && c <= 7)
            return middle[c-4].getOccupancy();
        else
            return right[c-8].getOccupancy();
    }


    //this method is used for change a chair stable :
    public void setChair(int c){
        //if Occupacy is true should change to false and if is false should change to true :
        if(1 <= c && c <= 3){
            if(left[c-1].getOccupancy())
                left[c-1].setOccupancy_2();
            else
                left[c-1].setOccupancy();
        }
        else if(4 <= c && c <= 7){
            if(middle[c-4].getOccupancy())
                middle[c-4].setOccupancy_2();
            else
                middle[c-4].setOccupancy();
        }
        else{
            if(right[c-8].getOccupancy())
                right[c-8].setOccupancy_2();
            else
                right[c-8].setOccupancy();
        }
    }
}
