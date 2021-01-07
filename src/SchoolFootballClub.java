import java.util.HashMap;

public class SchoolFootballClub extends FootballClub {
    private String schName;

    public SchoolFootballClub() {
        super();
    }

    public SchoolFootballClub(String schName, String clubName, String clubLocation, HashMap<String, Integer> statistic) {
        super(clubName, clubLocation, statistic);
        this.schName = schName;
    }

    public SchoolFootballClub(String clubName, String clubLocation, String schName) {
        super(clubName, clubLocation);
        this.schName = schName;
    }

    public SchoolFootballClub(HashMap<String, Integer> statistics) {
        super(statistics);
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    @Override
    public String toString() {
        return "SchoolFootballClub ---> " +
                "\n   Club Name       : " + getClubName() +
                "\n   Club Location   : " + getClubLocation() +
                "\n   School Name     : " + schName +
                "\n   Statistics      : " + getStatistic() + "\n";
    }
}
