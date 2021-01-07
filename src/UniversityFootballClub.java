import java.util.HashMap;

public class UniversityFootballClub extends FootballClub {
    private String uniName;

    public UniversityFootballClub() {
        super();
    }

    public UniversityFootballClub(String uniName, String clubName, String clubLocation, HashMap<String, Integer> statistic) {
        super(clubName, clubLocation, statistic);
        this.uniName = uniName;
    }

    public UniversityFootballClub(String clubName, String clubLocation, String uniName) {
        super(clubName, clubLocation);
        this.uniName = uniName;
    }

    public UniversityFootballClub(HashMap<String, Integer> statistic) {
        super(statistic);
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub ---> " +
                "\n   Club Name       : " + getClubName() +
                "\n   Club Location   : " + getClubLocation() +
                "\n   University Name : " + uniName +
                "\n   Statistics      : " + getStatistic() + "\n";
    }


}
