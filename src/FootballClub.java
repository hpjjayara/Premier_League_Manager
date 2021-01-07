import java.util.HashMap;

public class FootballClub extends SportsClub {


    public FootballClub() {

    }

    public FootballClub(String clubName, String clubLocation, HashMap<String, Integer> statistic) {
        super(clubName, clubLocation, statistic);
    }

    public FootballClub(String clubName, String clubLocation) {
        super(clubName, clubLocation);
    }

    public FootballClub(HashMap<String, Integer> statistic) {

    }


    @Override
    public String toString() {
        return "FootballClub[ ]";
    }


}



