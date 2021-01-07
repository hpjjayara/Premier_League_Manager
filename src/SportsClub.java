import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SportsClub implements Comparable<SportsClub>, Serializable {
    private static final long serialVersionUID = 3L; //for backend serializable

    private String clubName;
    private String clubLocation;
    private HashMap<String, Integer> statistic;

    public SportsClub(String clubName, String clubLocation, HashMap<String, Integer> statistic) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.statistic = statistic;
    }

    public SportsClub() {

    }

    public SportsClub(String name, String location) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public HashMap<String, Integer> getStatistic() {
        return statistic;
    }

    public void setStatistic(HashMap<String, Integer> statistic) {
        this.statistic = statistic;
    }

    public Map<String, Integer> getStatistics() {
        this.statistic = statistic;
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportsClub)) return false;
        SportsClub that = (SportsClub) o;
        return getClubName().equals(that.getClubName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClubName());
    }

    @Override
    public String toString() {
        return "SportsClub  ---> " +
                "\nclubName     : " + clubName +
                "\nclubLocation : " + clubLocation +
                "\nstatistic    : " + statistic + "\n";
    }

    //compare points and goals score
    @Override
    public int compareTo(SportsClub o) {
        if (this.getStatistic().get("Points") > o.getStatistic().get("Points")) {
            return 1;
        } else if (this.getStatistic().get("Points") < o.getStatistic().get("Points")) {
            return -1;
        } else {
            if ((this.getStatistic().get("GoalsSco") - this.getStatistic().get("GoalsRece")) > ((o.getStatistic().get("GoalsSco") - o.getStatistic().get("GoalsRece")))) {
                return 1;
            } else if ((this.getStatistic().get("GoalsSco") - this.getStatistic().get("GoalsRece")) < ((o.getStatistic().get("GoalsSco") - o.getStatistic().get("GoalsRece")))) {
                return -1;
            } else {
                return 0;
            }
        }


    }

}
