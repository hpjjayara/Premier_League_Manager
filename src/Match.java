import java.io.Serializable;

public class Match implements Serializable {
    private static final long serialVersionUID = 1L; //for backend serializable

    private String teamOneName;
    private String teamTwoName;
    private int teamOneScore;
    private int teamTwoScore;
    private int teamOnePoint;
    private int teamTwoPoint;
    private Date dateOfMatch; //get date by date class

    public Match(String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore, int teamOnePoint, int teamTwoPoint, Date dateOfMatch) {
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
        this.teamOnePoint = teamOnePoint;
        this.teamTwoPoint = teamTwoPoint;
        this.dateOfMatch = dateOfMatch;
    }

    public Match() {

    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public int getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(int teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public int getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(int teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    public int getTeamOnePoint() {
        return teamOnePoint;
    }

    public void setTeamOnePoint(int teamOnePoint) {
        this.teamOnePoint = teamOnePoint;
    }

    public int getTeamTwoPoint() {
        return teamTwoPoint;
    }

    public void setTeamTwoPoint(int teamTwoPoint) {
        this.teamTwoPoint = teamTwoPoint;
    }

    public Date getDateOfMatch() {
        return dateOfMatch;
    }


    public void setDateOfMatch(Date dateOfMatch) {
        this.dateOfMatch = dateOfMatch;
    }


    @Override
    public String toString() {
        return "Matches    -------->  " +
                "\nTeam one name    : " + teamOneName +
                "\nTeam one score   : " + teamOneScore +
                "\nTeam one point   : " + teamOnePoint +
                "\nTeam two name    : " + teamTwoName +
                "\nTeam two score   : " + teamTwoScore +
                "\nTeam two point   : " + teamTwoPoint +
                "\nDate of Match    : " + dateOfMatch.getDate() + "\n";
    }

}
