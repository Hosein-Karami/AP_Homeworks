/**
 * this class is used for manage the cinema.
 * @author Hosein Karami
 * @version 1.0
 * @since 3/03/2022
 */
public class Cinema {
    private final int rows;
    private final Row[] cinemaRows;
    //Constructor :
    public Cinema(int rows) {
        this.rows = rows;
        cinemaRows = new Row[rows];
        for(int i = 0;i < rows;i++)
            cinemaRows[i] = new Row();
    }
    //this method is used to change the value of Occupacy of chairs in rows :
    public void setChair(int r,int c){
        cinemaRows[r-1].setChair(c);
    }

    //this method is used for return Occupacy value of chairs in rows :
    public boolean getChair(int r,int c){
         return cinemaRows[r-1].getChair(c);
    }

    //this method is used for occupy the chairs :
    public void occupyChairs(int l,int r,int x){
        for(int i = l;i <= r;i++)
            setChair(x,i);
    }

    //this method is check the Occupy of chairs :
    public boolean checkChairs(int l,int r,int x){
        for(int i = l;i <= r;i++){
            if(getChair(x,i))
                return false;
        }
        return true;
    }
}
