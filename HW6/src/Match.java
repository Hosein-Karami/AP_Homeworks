public class Match {

    private final String firstTeamName;
    private final String secondTeamName;
    private final String date;

    //Constructor :
    public Match(String firstTeamName,String secondTeamName,String date){
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
        this.date = date;
    }

    /**
     * get access to information of match.
     * @return : information of match in string format.
     */
    @Override
    public String toString() {
        return "First team : " + firstTeamName + "       Second team : " + secondTeamName + "      Date : " + date;
    }

}
