import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class PremierLeagueManager implements LeagueManager {
    Scanner sc = new Scanner(System.in);

    private ArrayList<SportsClub> sportsClubsArrayList = new ArrayList<>();
    private ArrayList<Match> matchesClubArrayList = new ArrayList<>();

    private String sportsClubFilename = "src/sportClubData.txt";
    private String matchFilename = "src/matchesData.txt";

    @Override
    public void createNewFootballClub() {
        System.out.println("Enter club name :");
        String clubName = sc.next();

        boolean found = false;
        for (SportsClub sportsClub : sportsClubsArrayList) {

            if (sportsClub.getClubName().equalsIgnoreCase(clubName)) {  //compare user input name equals another entered name and compare Ignore Case it
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("This club name is entered as the name of another club name");
        } else {
            System.out.println("Enter club location : ");
            String clubLocation = sc.next();

            System.out.println();
            System.out.println("Select the age range : ");
            System.out.println("Enter 1 option for under 18 : ");
            System.out.println("Enter 2 option for under 23 : ");
            System.out.println("\nEnter your option : ");

            int rangeOfAge = sc.nextInt();
            System.out.println(rangeOfAge);

            switch (rangeOfAge) {
                case 1:
                    System.out.print("Enter school name : ");
                    String schName = sc.next();
                    SchoolFootballClub schoolFootballClub = new SchoolFootballClub(clubName, clubLocation, schName); //set values
                    schoolFootballClub.setClubName(clubName);
                    schoolFootballClub.setClubLocation(clubLocation);
                    schoolFootballClub.setSchName(schName);
                    sportsClubsArrayList.add(schoolFootballClub); //add to arrayList
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter university name : ");
                    String uniName = sc.next();

                    UniversityFootballClub universityFootballClub = new UniversityFootballClub(clubName, clubLocation, uniName); //set values
                    universityFootballClub.setClubName(clubName);
                    universityFootballClub.setClubLocation(clubLocation);
                    universityFootballClub.setUniName(uniName);
                    sportsClubsArrayList.add(universityFootballClub); //add to arrayList
                    System.out.println();
                    break;
                default:
                    System.out.print("Invalid Input, Please enter 1 or 2 only.");
                    break;

            }
            System.out.println();
            System.out.println(sportsClubsArrayList);
            System.out.println();

        }
    }

    @Override
    public void addPlayedMatchMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter club name,you want to add match marks : ");
        String clubName = sc.nextLine();

        for (SportsClub sportsClub : sportsClubsArrayList) {
            if (sportsClub.getClubName().equals(clubName)) {  //compare user input name equals another entered name

                HashMap<String, Integer> statistics = new HashMap<>();

                System.out.print("Enter wins                        : ");
                Integer wins = sc.nextInt();
                statistics.put("Wins", wins); //put wins values to HashMap like as key value pare


                System.out.print("Enter draws                       : ");
                Integer draws = sc.nextInt();
                statistics.put("Draws", draws); //put draws values to HashMap like as key value pare

                System.out.print("Enter defeats                     : ");
                Integer defeats = sc.nextInt();
                statistics.put("Defeats", defeats); //put defeats values to HashMap like as key value pare

                System.out.print("Enter number of seasons played    : ");
                Integer numberOfSeasonsPlayed = sc.nextInt();
                statistics.put("Seasons", numberOfSeasonsPlayed); //put numberOfSeasonsPlayed values to HashMap like as key value pare

                System.out.print("Enter number of goals scored      : ");
                Integer numberOfGoalsScored = sc.nextInt();
                statistics.put("GoalsSco", numberOfGoalsScored); //put numberOfGoalsScored values to HashMap like as key value pare

                System.out.print("Enter number of goals received    : ");
                Integer numberOfGoalsReceived = sc.nextInt();
                statistics.put("GoalsRece", numberOfGoalsReceived); //put numberOfGoalsReceived values to HashMap like as key value pare

                System.out.print("Enter number of current points    : ");
                Integer numberOfCurrentPoints = sc.nextInt();
                statistics.put("Points", numberOfCurrentPoints); //put numberOfCurrentPoints values to HashMap like as key value pare

                System.out.print("Enter number of matches played    : ");
                Integer numberOfMatchesPlayed = sc.nextInt();
                statistics.put("Matches", numberOfMatchesPlayed); //put values numberOfMatchesPlayed to HashMap like as key value pare

                sportsClub.setStatistic(statistics); //set statistics
                System.out.println();

            }
        }
        System.out.println(sportsClubsArrayList);

    }

    @Override
    public void deleteExistingClub() {
        System.out.println("Enter club name,you want delete : ");
        String deleteClubName = sc.next();
        boolean found = false;

        for (SportsClub sportsClub : sportsClubsArrayList) {
            if (sportsClub.getClubName().equals(deleteClubName)) { //compare user input name equals another entered name
                sportsClubsArrayList.remove(sportsClub); //remove club in arrayList
                found = true;
                break;
            }
        }


        if (found) {
            System.out.println("That club was successfully removed.");
        } else {
            System.out.println("That club was not found.");
        }

    }

    @Override
    public void variousStatisticsSelectedClub() {
        System.out.println("Enter club name,you want to find various statistics of selected club : ");
        String selectedClubName = sc.next();
        boolean found = false;

        for (SportsClub sportsClub : sportsClubsArrayList) {
            if (sportsClub.getClubName().equals(selectedClubName)) { //compare user input name equals another entered name
                //Display selected club name and statistics in CLI
                System.out.println("\nClub name      : " + sportsClub.getClubName() +
                        "\nWins           : " + sportsClub.getStatistic().get("Wins") +
                        "\nDraws          : " + sportsClub.getStatistic().get("Draws") +
                        "\nDefeats        : " + sportsClub.getStatistic().get("Defeats") +
                        "\nSeason         : " + sportsClub.getStatistic().get("Seasons") +
                        "\nGoal Score     : " + sportsClub.getStatistic().get("GoalsSco") +
                        "\nGoals Received : " + sportsClub.getStatistic().get("GoalsRece") +
                        "\nPoints         : " + sportsClub.getStatistic().get("Points") +
                        "\nMatches        : " + sportsClub.getStatistic().get("Matches"));

                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("\nThat club name and statistic were successfully founded.");
        } else {
            System.out.println("\nThat club name was not found.");
        }

    }

    @Override
    public void premierLeagueTable() {
        //create table for Premier League Table
        System.out.println("\n                                             Premier League Table");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%20s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Seasons", "Goalsco", "GoalsRece", "Points", "Matches");
        System.out.println();
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");


        for (SportsClub sportsClub : sportsClubsArrayList) {

            if (sportsClub.getStatistic() != null) {
                System.out.format("|%20s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                        sportsClub.getClubName(), sportsClub.getStatistic().get("Wins"), sportsClub.getStatistic().get("Draws"), sportsClub.getStatistic().get("Defeats"), sportsClub.getStatistic().get("Seasons"), sportsClub.getStatistic().get("GoalsSco"), sportsClub.getStatistic().get("GoalsRece"), sportsClub.getStatistic().get("Points"), sportsClub.getStatistic().get("Matches"));
                System.out.println();
            } else {
                System.out.format("|%20s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                        sportsClub.getClubName(), "-", "-", "-", "-", "-", "-", "-", "-");
                System.out.println();
            }
        }
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------+");
        System.out.println();

        ArrayList<SportsClub> clubsWithStats = new ArrayList<>(); //create new arrayList

        //add clubs details to new arrayList
        for (SportsClub club : sportsClubsArrayList) {
            if (club.getStatistic() != null) {
                clubsWithStats.add(club);
            }
        }
        Collections.sort(clubsWithStats, Collections.reverseOrder()); //sort points and if points are equal then compare goal difference using by reverse collection sort
        //Display sorted table
        System.out.println("\n                          Premier League Table Descending Order By Points &  Goal Difference");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%20s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Seasons", "Goalsco", "GoalsRece", "GoalDiff", "Points", "Matches");
        System.out.println();
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------+");


        for (SportsClub sportsClub : clubsWithStats) {

            if (sportsClub.getStatistic() != null) {
                System.out.format("|%20s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                        sportsClub.getClubName(), sportsClub.getStatistic().get("Wins"), sportsClub.getStatistic().get("Draws"), sportsClub.getStatistic().get("Defeats"), sportsClub.getStatistic().get("Seasons"), sportsClub.getStatistic().get("GoalsSco"), sportsClub.getStatistic().get("GoalsRece"), (sportsClub.getStatistic().get("GoalsSco") - sportsClub.getStatistic().get("GoalsRece")), sportsClub.getStatistic().get("Points"), sportsClub.getStatistic().get("Matches"));
                System.out.println();
            } else {
                System.out.format("|%20s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                        sportsClub.getClubName(), "-", "-", "-", "-", "-", "-", "-", "-");
                System.out.println();
            }
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println();


    }

    @Override
    public void addPlayedMatch() {
        LocalDate localDate = LocalDate.now();

        System.out.println("Enter year  : ");
        int year = sc.nextInt();
        if (year < 1000 || year > localDate.getYear()) { //get date between 1000 year to current year
            System.out.println("\n" + year + " is an invalid year.");
            return;
        }

        System.out.println("Enter month : ");
        int month = sc.nextInt();
        if (month > 12 || month < 1) { //validation of month
            System.out.println("\n" + month + " is an invalid month.");
            return;
        }

        System.out.println("Enter day   : ");
        int day = sc.nextInt();
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) { //validation for odd months
            if (day < 1 || day > 31) {
                System.out.println("\n" + day + " is an invalid day.");
                return;
            }
        } else if (month == 2) { //this for february month
            if (year % 4 == 0 && (day < 1 || day > 29)) {  //leap year february month
                System.out.println("\n" + day + " is an invalid day.");
                return;
            } else if (year % 4 != 0 && (day < 1 || day > 28)) {
                System.out.println("\n" + day + " is an invalid day.");
                return;
            }
        } else {
            if (day < 1 || day > 30) {
                System.out.println("\n" + day + " is an invalid day."); //validation for other month
                return;
            }
        }

        //set date
        Date dateOfMatch = new Date(day, month, year);
//        dateOfMatch.setDay(day);
//        dateOfMatch.setMonth(month);
//        dateOfMatch.setYear(year);

        SportsClub club1 = null;
        SportsClub club2 = null;
        //get team one
        System.out.println("\nEnter team one club name : ");
        String name1 = sc.next();

        boolean found1 = false;
        for (SportsClub sportsClub : sportsClubsArrayList) {
            if (sportsClub.getClubName().equals(name1)) {
                club1 = sportsClub;
                found1 = true;
                break;
            }
        }

        if (found1) {
            System.out.println("That club name and statistic were successfully founded.\n");
        } else {
            System.out.println("That club name was not found.\n");
        }
        //get team two
        System.out.println("Enter team two club name : ");
        String name2 = sc.next();

        boolean found2 = false;
        for (SportsClub sportsClub : sportsClubsArrayList) {
            if (sportsClub.getClubName().equals(name2)) {
                club2 = sportsClub;
                found2 = true;
                break;
            }
        }

        if (found2) {
            System.out.println("That club name and statistic were successfully founded.\n");
        } else {
            System.out.println("That club name was not found.\n");
        }

        if (!name1.equals(name2)) {

            if (found1 && found2) {

                System.out.println("\nGoals Score ------>");
                System.out.println("Enter number of goals scored of 1st club : ");
                int goalScore1 = sc.nextInt();
                int newGoalScore1 = club1.getStatistic().get("GoalsSco") + goalScore1;
                club1.getStatistic().replace("GoalsSco", newGoalScore1); //replace HashMap in new value

                System.out.println("\nEnter number of goals scored of 2st club : ");
                int goalScore2 = sc.nextInt();
                int newGoalScore2 = club2.getStatistic().get("GoalsSco") + goalScore2;
                club2.getStatistic().replace("GoalsSco", newGoalScore2); //replace HashMap in new value

                int newGoalReceived1 = club1.getStatistic().get("GoalsRece") + goalScore2;
                club1.getStatistic().replace("GoalsRece", newGoalReceived1); //replace HashMap in new value
                int newGoalReceived2 = club2.getStatistic().get("GoalsRece") + goalScore1;
                club2.getStatistic().replace("GoalsRece", newGoalReceived2); //replace HashMap in new value

                int newMatch1 = club1.getStatistic().get("Matches") + 1;
                club1.getStatistic().replace("Matches", newMatch1); //replace HashMap in new value
                int newMatch2 = club2.getStatistic().get("Matches") + 1;
                club2.getStatistic().replace("Matches", newMatch2); //replace HashMap in new value

                int matchPoint1 = 0;
                int matchPoint2 = 0;

                int newPoint1;
                int newPoint2;


                if (goalScore1 > goalScore2) {
                    int newWin1 = club1.getStatistic().get("Wins") + 1;
                    club1.getStatistic().replace("Wins", newWin1);  //replace HashMap in new value
                    newPoint1 = club1.getStatistic().get("Points") + 3;
                    club1.getStatistic().replace("Points", newPoint1); //replace HashMap in new value
                    int newDefeat2 = club2.getStatistic().get("Defeats") + 1;
                    club2.getStatistic().replace("Defeats", newDefeat2); //replace HashMap in new value

                    matchPoint1 = 3;

                    Match match1 = new Match(name1, name2, goalScore1, goalScore2, matchPoint1, matchPoint2, dateOfMatch);
                    matchesClubArrayList.add(match1); //add match to matchesClubArrayList

                    System.out.println("\n<------------------------------------First Club Won The Match------------------------------------->\n");
                    System.out.println("                                       First Club Score Grater Than Second Club Score(Update Results)");
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.printf("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Seasons", "Goalsco", "GoalsRece", "Points", "Matches", "Date");
                    System.out.println();
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "1st Club Name : " + name1, club1.getStatistic().get("Wins"), club1.getStatistic().get("Draws"), club1.getStatistic().get("Defeats"), club1.getStatistic().get("Seasons") + 1, club1.getStatistic().get("GoalsSco"), club1.getStatistic().get("GoalsRece"), club1.getStatistic().get("Points"), club1.getStatistic().get("Matches") + 1, match1.getDateOfMatch().getDate());
                    System.out.println();
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "2st Club Name : " + name2, club2.getStatistic().get("Wins"), club2.getStatistic().get("Draws"), club2.getStatistic().get("Defeats"), club2.getStatistic().get("Seasons") + 1, club2.getStatistic().get("GoalsSco"), club2.getStatistic().get("GoalsRece"), club2.getStatistic().get("Points"), club2.getStatistic().get("Matches") + 1, match1.getDateOfMatch().getDate());
                    System.out.println();

                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");

                    System.out.println();
                    System.out.println("                                         Team One And Team Two For Played Day");
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.printf("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Goalsco", "GoalsRece", "Points", "Matches", "Date");
                    System.out.println();
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");

                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "1st Club Name : " + match1.getTeamOneName(), 1, 0, 0, match1.getTeamOneScore(), match1.getTeamTwoScore(), match1.getTeamOnePoint(), 1, match1.getDateOfMatch().getDate());
                    System.out.println();
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "2st Club Name : " + match1.getTeamTwoName(), 0, 0, 1, match1.getTeamTwoScore(), match1.getTeamOneScore(), match1.getTeamTwoPoint(), 1, match1.getDateOfMatch().getDate());
                    System.out.println();

                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");


                } else if (goalScore1 == goalScore2) {
                    int newDraw1 = club1.getStatistic().get("Draws") + 1;
                    club1.getStatistic().replace("Draws", newDraw1); //replace HashMap in new value
                    newPoint1 = club1.getStatistic().get("Points") + 1;
                    club1.getStatistic().replace("Points", newPoint1); //replace HashMap in new value
                    int newDarw2 = club2.getStatistic().get("Draws") + 1;
                    club2.getStatistic().replace("Draws", newDarw2); //replace HashMap in new value
                    newPoint2 = club2.getStatistic().get("Points") + 1;
                    club2.getStatistic().replace("Points", newPoint2); //replace HashMap in new value

                    matchPoint1 = 1;
                    matchPoint2 = 1;

                    Match match2 = new Match(name1, name2, goalScore1, goalScore2, matchPoint1, matchPoint2, dateOfMatch);
                    matchesClubArrayList.add(match2); //add match to matchesClubArrayList

                    System.out.println("\n<----------------------------------------Draw The Match---------------------------------------->\n");
                    System.out.println("                                       First Club Score Equal To Second Club Score(Update Results)");
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.printf("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Seasons", "Goalsco", "GoalsRece", "Points", "Matches", "Date");
                    System.out.println();
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "1st Club Name : " + name1, club1.getStatistic().get("Wins"), club1.getStatistic().get("Draws"), club1.getStatistic().get("Defeats"), club1.getStatistic().get("Seasons") + 1, club1.getStatistic().get("GoalsSco"), club1.getStatistic().get("GoalsRece"), club1.getStatistic().get("Points"), club1.getStatistic().get("Matches") + 1, match2.getDateOfMatch().getDate());
                    System.out.println();
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "2st Club Name : " + name2, club2.getStatistic().get("Wins"), club2.getStatistic().get("Draws"), club2.getStatistic().get("Defeats"), club2.getStatistic().get("Seasons") + 1, club2.getStatistic().get("GoalsSco"), club2.getStatistic().get("GoalsRece"), club2.getStatistic().get("Points"), club2.getStatistic().get("Matches") + 1, match2.getDateOfMatch().getDate());
                    System.out.println();

                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");

                    System.out.println();
                    System.out.println("                                         Team One And Team Two For Played Day");
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.printf("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Goalsco", "GoalsRece", "Points", "Matches", "Date");
                    System.out.println();
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");

                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "1st Club Name : " + match2.getTeamOneName(), 0, 1, 0, match2.getTeamOneScore(), match2.getTeamTwoScore(), match2.getTeamOnePoint(), 1, match2.getDateOfMatch().getDate());
                    System.out.println();
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "2st Club Name : " + match2.getTeamTwoName(), 0, 1, 0, match2.getTeamTwoScore(), match2.getTeamOneScore(), match2.getTeamTwoPoint(), 1, match2.getDateOfMatch().getDate());
                    System.out.println();

                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");


                } else {
                    int newWin2 = club2.getStatistic().get("Wins") + 1;
                    club2.getStatistic().replace("Wins", newWin2); //replace HashMap in new value
                    newPoint2 = club2.getStatistic().get("Points") + 3;
                    club2.getStatistic().replace("Points", newPoint2); //replace HashMap in new value
                    int newDefeat1 = club1.getStatistic().get("Defeats") + 1;
                    club1.getStatistic().replace("Defeats", newDefeat1); //replace HashMap in new value

                    matchPoint2 = 3;

                    Match match3 = new Match(name1, name2, goalScore1, goalScore2, matchPoint1, matchPoint2, dateOfMatch);
                    matchesClubArrayList.add(match3); //add match to matchesClubArrayList

                    System.out.println("\n<------------------------------------Second Club Won The Match------------------------------------>\n");
                    System.out.println("                                       Second Club Score Grater Than First Club Score(Update Results)");
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.printf("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Seasons", "Goalsco", "GoalsRece", "Points", "Matches", "Date");
                    System.out.println();
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");

                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "1st Club Name : " + name1, club1.getStatistic().get("Wins"), club1.getStatistic().get("Draws"), club1.getStatistic().get("Defeats"), club1.getStatistic().get("Seasons") + 1, club1.getStatistic().get("GoalsSco"), club1.getStatistic().get("GoalsRece"), club1.getStatistic().get("Points"), club1.getStatistic().get("Matches") + 1, match3.getDateOfMatch().getDate());
                    System.out.println();
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "2st Club Name : " + name2, club2.getStatistic().get("Wins"), club2.getStatistic().get("Draws"), club2.getStatistic().get("Defeats"), club2.getStatistic().get("Seasons") + 1, club2.getStatistic().get("GoalsSco"), club2.getStatistic().get("GoalsRece"), club2.getStatistic().get("Points"), club2.getStatistic().get("Matches") + 1, match3.getDateOfMatch().getDate());
                    System.out.println();

                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");

                    System.out.println();
                    System.out.println("                                         Team One And Team Two For Played Day");
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.printf("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |", "Club Name", "Wins", "Draws", "Defeats", "Goalsco", "GoalsRece", "Points", "Matches", "Date");
                    System.out.println();
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");

                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "1st Club Name : " + match3.getTeamOneName(), 0, 0, 1, match3.getTeamOneScore(), match3.getTeamTwoScore(), match3.getTeamOnePoint(), 1, match3.getDateOfMatch().getDate());
                    System.out.println();
                    System.out.format("|%30s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s |",
                            "2st Club Name : " + match3.getTeamTwoName(), 1, 0, 0, match3.getTeamTwoScore(), match3.getTeamOneScore(), match3.getTeamTwoPoint(), 1, match3.getDateOfMatch().getDate());
                    System.out.println();

                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------+");

                }
            } else {
                System.out.println("Please enter, only create club name or first create club and after enter match details.");
            }
        } else {
            System.out.println("First club name equals to second club. Please enter different two clubs names for the match");
        }

    }

    @Override
    public void storeSportClubData() {
        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file1 = new FileOutputStream(sportsClubFilename);
            ObjectOutputStream out1 = new ObjectOutputStream(file1);

            // Method for serialization of object
            out1.writeObject(sportsClubsArrayList);

            out1.close();
            file1.close();

            System.out.println("\nsportsClubsArrayList Object has been serialized\n");

        } catch (IOException ex) {
            System.out.println("IOException is caught\n");
        }
    }

    @Override
    public void storeMatchesDataWithDate() {
        // Serialization
        try {
            //Saving of object in a file
            FileOutputStream file2 = new FileOutputStream(matchFilename);
            ObjectOutputStream out2 = new ObjectOutputStream(file2);

            // Method for serialization of object
            out2.writeObject(matchesClubArrayList);

            out2.close();
            file2.close();

            System.out.println("matchesClubArrayList Object has been serialized\n");

        } catch (IOException ex) {
            System.out.println("IOException is caught\n");
        }

    }

    @Override
    public void readAndLoadSportClubData() {
        ArrayList<SportsClub> clubs;
        // Deserialization
        FileInputStream file1 = null;
        ObjectInputStream in1 = null;

        try {
            // Reading the object from a file
            file1 = new FileInputStream(sportsClubFilename);
            in1 = new ObjectInputStream(file1);

            // Method for deserialization of object
            clubs = (ArrayList<SportsClub>) in1.readObject();

            System.out.println("\n<-------Sport Club Details------->");
            for (SportsClub sportsClub : clubs) {
                System.out.println("\nClub name       : " + sportsClub.getClubName());
                System.out.println("Club location   : " + sportsClub.getClubLocation());
                System.out.println("Club statistic  : " + sportsClub.getStatistic());
            }

            sportsClubsArrayList = clubs;

            System.out.println("\nsportsClubsArrayList Object has been de-serialized. \n");

        } catch (IOException ex) {
            System.out.println("IOException is caught\n");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught\n");
        } finally {
            try {

                in1.close();
                file1.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public void readAndLoadMatchData() {
        ArrayList<Match> matches;
        // Deserialization
        FileInputStream file2 = null;
        ObjectInputStream in2 = null;

        try {
            // Reading the object from a file
            file2 = new FileInputStream(matchFilename);
            in2 = new ObjectInputStream(file2);

            // Method for deserialization of object
            matches = (ArrayList<Match>) in2.readObject();

            System.out.println("<-------Matches played clubs details  ------->");
            for (Match match : matches) {
                System.out.println("\nTeam one name                   : " + match.getTeamOneName());
                System.out.println("Team one score                  : " + match.getTeamOneScore());
                System.out.println("Team one points                 : " + match.getTeamOnePoint());
                System.out.println("Team two name                   : " + match.getTeamTwoName());
                System.out.println("Team two score                  : " + match.getTeamTwoScore());
                System.out.println("Team one points                 : " + match.getTeamTwoPoint());
                System.out.println("Team one & Team two played date : " + match.getDateOfMatch().getDate());

            }
            in2.close();
            file2.close();

            matchesClubArrayList = matches;

            System.out.println("\nmatchesClubArrayList Object has been de-serialized. \n");

        } catch (IOException ex) {
            System.out.println("IOException is caught\n");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught\n");
        } finally {
            try {

                in2.close();
                file2.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public void addArrayList() {
        // all the information saved in the previous file
        try {
            ArrayList<SportsClub> clubs;
            // Reading the object from a file
            FileInputStream file1 = new FileInputStream(sportsClubFilename);
            ObjectInputStream in1 = new ObjectInputStream(file1);
            clubs = (ArrayList<SportsClub>) in1.readObject(); // Method for deserialization of object
            sportsClubsArrayList = clubs; //now arrayList values save previous arrayList

            ArrayList<Match> match;
            // Reading the object from a file
            FileInputStream file2 = new FileInputStream(matchFilename);
            ObjectInputStream in2 = new ObjectInputStream(file2);
            match = (ArrayList<Match>) in2.readObject(); // Method for deserialization of object
            matchesClubArrayList = match; //now arrayList values save previous arrayList
        } catch (IOException ex) {
            System.out.println("IOException is caught\n");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught\n");
        }
    }

    public void tableForSportClub(String newLabel) {
        //create table
        ArrayList<List<String>> clubArrayList = new ArrayList<>();

        for (SportsClub sportsClub : sportsClubsArrayList) {
            ArrayList<String> addStringArray = new ArrayList<>();

            addStringArray.add(sportsClub.getClubName());
            addStringArray.add(sportsClub.getStatistic().get("Wins").toString());
            addStringArray.add(sportsClub.getStatistic().get("Draws").toString());
            addStringArray.add(sportsClub.getStatistic().get("Defeats").toString());
            addStringArray.add(sportsClub.getStatistic().get("GoalsSco").toString());
            addStringArray.add(sportsClub.getStatistic().get("GoalsRece").toString());
            addStringArray.add(sportsClub.getStatistic().get("Points").toString());
            addStringArray.add(sportsClub.getStatistic().get("Matches").toString());
            addStringArray.add(sportsClub.getStatistic().get("Seasons").toString());

            clubArrayList.add(addStringArray);

        }
        TableView<List<String>> table = new TableView<>();

        ObservableList<List<String>> data = FXCollections.observableArrayList(clubArrayList);

        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("Premier League Manager");

        stage.setWidth(1080);
        stage.setHeight(620);

        Label label = new Label();
        label.setText(newLabel);
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);

        TableColumn<List<String>, String> clubNameCol = new TableColumn<>("Club Name");
        clubNameCol.setMinWidth(200);
        clubNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));

        TableColumn<List<String>, String> winsCol = new TableColumn<>("Wins");
        winsCol.setMinWidth(100);
        winsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));

        TableColumn<List<String>, String> drawsCol = new TableColumn<>("Draws");
        drawsCol.setMinWidth(100);
        drawsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));

        TableColumn<List<String>, String> defeatsCol = new TableColumn<>("Defeats");
        defeatsCol.setMinWidth(100);
        defeatsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));

        TableColumn<List<String>, String> goalsScoCol = new TableColumn<>("Goals Sco");
        goalsScoCol.setMinWidth(100);
        goalsScoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));

        TableColumn<List<String>, String> goalsReceCol = new TableColumn<>("Goals Rece");
        goalsReceCol.setMinWidth(100);
        goalsReceCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));

        TableColumn<List<String>, String> pointsCol = new TableColumn<>("Points");
        pointsCol.setMinWidth(100);
        pointsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));

        TableColumn<List<String>, String> matchesCol = new TableColumn<>("Matches");
        matchesCol.setMinWidth(100);
        matchesCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(7)));

        TableColumn<List<String>, String> seasonCol = new TableColumn<>("Season");
        seasonCol.setMinWidth(100);
        seasonCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(8)));

        table.setItems(data);

        table.getColumns().addAll(clubNameCol, winsCol, drawsCol, defeatsCol, goalsScoCol, goalsReceCol, pointsCol, matchesCol, seasonCol);

        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setStyle("-fx-background-color: #ccccff");
        vbox.setPadding(new Insets(30, 30, 60, 30));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.showAndWait();

    }

    @Override
    public void clubListByPoints() {
        //sort points
        Collections.sort(sportsClubsArrayList, new Comparator<SportsClub>() {
            @Override
            public int compare(SportsClub o1, SportsClub o2) {
                return o2.getStatistic().get("Points").compareTo(o1.getStatistic().get("Points"));
            }
        });

        String labelPoint = "Teams And Statistics Order By number Of Points";
        tableForSportClub(labelPoint);

    }

    @Override
    public void clubsListByGoalScore() {
        //sort goals score
        Collections.sort(sportsClubsArrayList, new Comparator<SportsClub>() {
            @Override
            public int compare(SportsClub o1, SportsClub o2) {
                return o2.getStatistic().get("GoalsSco").compareTo(o1.getStatistic().get("GoalsSco"));
            }
        });


        String labelGoalScore = ("Teams And Statistics Order By Number Of Goals Score");
        tableForSportClub(labelGoalScore);

    }

    @Override
    public void clubListByWins() {
        //sort wins
        Collections.sort(sportsClubsArrayList, new Comparator<SportsClub>() {
            @Override
            public int compare(SportsClub o1, SportsClub o2) {
                return o2.getStatistic().get("Wins").compareTo(o1.getStatistic().get("Wins"));
            }
        });


        String labelGoalScore = ("Teams And Statistics Order By Number Of Wins");
        tableForSportClub(labelGoalScore);

    }

    @Override
    public void displayRandomMatch() {
        ArrayList<List<String>> clubArrayList = new ArrayList<>();

        for (SportsClub sportsClub : sportsClubsArrayList) {
            //create club name and HashMap elements to String arrayList
            ArrayList<String> addStringArray = new ArrayList<>();

            addStringArray.add(sportsClub.getClubName());
            //HashMap element convert to string and add it to arrayList
            addStringArray.add(sportsClub.getStatistic().get("Wins").toString());
            addStringArray.add(sportsClub.getStatistic().get("Draws").toString());
            addStringArray.add(sportsClub.getStatistic().get("Defeats").toString());
            addStringArray.add(sportsClub.getStatistic().get("GoalsSco").toString());
            addStringArray.add(sportsClub.getStatistic().get("GoalsRece").toString());
            addStringArray.add(sportsClub.getStatistic().get("Points").toString());
            addStringArray.add(sportsClub.getStatistic().get("Matches").toString());
            addStringArray.add(sportsClub.getStatistic().get("Seasons").toString());

            clubArrayList.add(addStringArray); //add addStringArray to clubArrayList

        }
        TableView<List<String>> table = new TableView<>();

        ObservableList<List<String>> data = FXCollections.observableArrayList(clubArrayList);

        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("Premier League Manager");
        stage.setWidth(1080);
        stage.setHeight(800);

        final Label label = new Label("List Of Clubs");
        label.setFont(new Font("Arial", 20));

        table.setEditable(false);


        TableColumn<List<String>, String> clubNameCol = new TableColumn<>("Club Name");
        clubNameCol.setMinWidth(200);
        clubNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));

        TableColumn<List<String>, String> winsCol = new TableColumn<>("Wins");
        winsCol.setMinWidth(100);
        winsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));

        TableColumn<List<String>, String> drawsCol = new TableColumn<>("Draws");
        drawsCol.setMinWidth(100);
        drawsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));

        TableColumn<List<String>, String> defeatsCol = new TableColumn<>("Defeats");
        defeatsCol.setMinWidth(100);
        defeatsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));

        TableColumn<List<String>, String> goalsScoCol = new TableColumn<>("Goals Sco");
        goalsScoCol.setMinWidth(100);
        goalsScoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));

        TableColumn<List<String>, String> goalsReceCol = new TableColumn<>("Goals Rece");
        goalsReceCol.setMinWidth(100);
        goalsReceCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));

        TableColumn<List<String>, String> pointsCol = new TableColumn<>("Points");
        pointsCol.setMinWidth(100);
        pointsCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));

        TableColumn<List<String>, String> matchesCol = new TableColumn<>("Matches");
        matchesCol.setMinWidth(100);
        matchesCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(7)));

        TableColumn<List<String>, String> seasonCol = new TableColumn<>("Season");
        seasonCol.setMinWidth(100);
        seasonCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(8)));


        HBox hbButtons = new HBox();
        Button generatesRandomMatch = new Button("Generates Random Match");

        EventHandler<ActionEvent> event = e -> {
            Stage stage1 = new Stage();
            stage1.setTitle("Premier League Manager");

            final Label label1 = new Label("Random Match");
            label1.setFont(new Font("Arial", 20));

            GridPane gridPane = new GridPane();
            gridPane.setHgap(60);
            gridPane.setVgap(15);
            gridPane.setAlignment(Pos.CENTER);

            SportsClub updateClub1 = null;
            SportsClub updateClub2 = null;

            final int[] randomGenerateClubs = new Random().ints(1, sportsClubsArrayList.size()).distinct().limit(2).toArray(); //generate two random different values between 1 and size of arrayList using int array
            //get random object in int array
            SportsClub club1 = sportsClubsArrayList.get(randomGenerateClubs[0]);
            SportsClub club2 = sportsClubsArrayList.get(randomGenerateClubs[1]);

            String name1 = club1.getClubName();
            String name2 = club2.getClubName();


            for (SportsClub sportsClub : sportsClubsArrayList) {
                if (sportsClub.getClubName().equals(name1)) { //equals of in arrayList  club name and random name
                    updateClub1 = sportsClub;
                }
            }

            for (SportsClub sportsClub : sportsClubsArrayList) {
                if (sportsClub.getClubName().equals(name2)) { //equals of in arrayList  club name and random name
                    updateClub2 = sportsClub;
                }
            }

            //get random values for goals score between 0 to 20
            int max = 20;
            int min = 0;
            int score1 = (int) (Math.random() * (max - min + 1) + min);
            int score2 = (int) (Math.random() * (max - min + 1) + min);

            int newGoalScore1 = updateClub1.getStatistic().get("GoalsSco") + score1;
            updateClub1.getStatistic().replace("GoalsSco", newGoalScore1); //replace hashMap by new values
            int newGoalScore2 = updateClub2.getStatistic().get("GoalsSco") + score2;
            updateClub2.getStatistic().replace("GoalsSco", newGoalScore2);

            int newGoalReceived1 = updateClub1.getStatistic().get("GoalsRece") + score2;
            updateClub1.getStatistic().replace("GoalsRece", newGoalReceived1);
            int newGoalReceived2 = updateClub2.getStatistic().get("GoalsRece") + score1;
            updateClub2.getStatistic().replace("GoalsRece", newGoalReceived2);

            int newMatch1 = updateClub1.getStatistic().get("Matches") + 1;
            updateClub1.getStatistic().replace("Matches", newMatch1);
            int newMatch2 = updateClub2.getStatistic().get("Matches") + 1;
            updateClub2.getStatistic().replace("Matches", newMatch2);

            int wins1;
            int wins2;
            int draws1;
            int draws2;
            int defeats1;
            int defeats2;
            int points1;
            int points2;

            if (score1 > score2) {
                wins1 = 1;
                draws1 = 0;
                defeats1 = 0;
                points1 = 3;
                wins2 = 0;
                draws2 = 0;
                defeats2 = 1;
                points2 = 0;

                int newWin1 = updateClub1.getStatistic().get("Wins") + wins1;
                updateClub1.getStatistic().replace("Wins", newWin1);
                int newPoint1 = updateClub1.getStatistic().get("Points") + points1;
                updateClub1.getStatistic().replace("Points", newPoint1);
                int newDefeat2 = updateClub2.getStatistic().get("Defeats") + defeats2;
                updateClub2.getStatistic().replace("Defeats", newDefeat2);

            } else if (score1 == score2) {
                wins1 = 0;
                draws1 = 1;
                defeats1 = 0;
                points1 = 1;
                wins2 = 0;
                draws2 = 1;
                defeats2 = 0;
                points2 = 1;

                int newDraw1 = updateClub1.getStatistic().get("Draws") + draws1;
                updateClub1.getStatistic().replace("Draws", newDraw1);
                int newPoint1 = updateClub1.getStatistic().get("Points") + points1;
                updateClub1.getStatistic().replace("Points", newPoint1);
                int newDarw2 = updateClub2.getStatistic().get("Draws") + defeats2;
                updateClub2.getStatistic().replace("Draws", newDarw2);
                int newPoint2 = updateClub2.getStatistic().get("Points") + points2;
                updateClub2.getStatistic().replace("Points", newPoint2);

            } else {
                wins1 = 0;
                draws1 = 0;
                defeats1 = 1;
                points1 = 0;
                wins2 = 1;
                draws2 = 0;
                defeats2 = 0;
                points2 = 3;

                int newWin2 = updateClub2.getStatistic().get("Wins") + wins2;
                updateClub2.getStatistic().replace("Wins", newWin2);
                int newPoint2 = updateClub2.getStatistic().get("Points") + points2;
                updateClub2.getStatistic().replace("Points", newPoint2);
                int newDefeat1 = updateClub1.getStatistic().get("Defeats") + defeats1;
                updateClub1.getStatistic().replace("Defeats", newDefeat1);
            }

            //create labels  for team one
            Label firstClubName = new Label("First Club Name  ");
            Label goalScoreFirstClub = new Label("Goal Score       ");
            Label goalReceivedFirstClub = new Label("Goal Received    ");
            Label winsFirstClub = new Label("Wins             ");
            Label drawsFirstClub = new Label("Draws            ");
            Label defeatsFirstClub = new Label("Defeats          ");
            Label pointsFirstClub = new Label("Points           ");

            // create text fields for label
            TextField t1 = new TextField();
            t1.setEditable(false);
            t1.setText(club1.getClubName()); //set values to text field
            TextField t2 = new TextField();
            t2.setEditable(false);
            t2.setText(String.valueOf(score1));
            TextField t3 = new TextField();
            t3.setEditable(false);
            t3.setText(String.valueOf(score2));
            TextField t4 = new TextField();
            t4.setEditable(false);
            t4.setText(String.valueOf(wins1));
            TextField t5 = new TextField();
            t5.setEditable(false);
            t5.setText(String.valueOf(draws1));
            TextField t6 = new TextField();
            t6.setEditable(false);
            t6.setText(String.valueOf(defeats1));
            TextField t7 = new TextField();
            t7.setEditable(false);
            t7.setText(String.valueOf(points1));

            //create labels  for team two
            Label secondClubName = new Label("Second Club Name");
            Label goalScoreSecondClub = new Label("Goal Score");
            Label goalReceivedSecondClub = new Label("Goal Received");
            Label winsSecondClub = new Label("Wins");
            Label drawsSecondClub = new Label("Draws");
            Label defeatsSecondClub = new Label("Defeats");
            Label pointsSecondClub = new Label("Points");

            // create two textfields for label
            TextField t9 = new TextField();
            t9.setEditable(false);
            t9.setText(club2.getClubName()); //set values to text field
            TextField t10 = new TextField();
            t10.setEditable(false);
            t10.setText(String.valueOf(score2));
            TextField t11 = new TextField();
            t11.setEditable(false);
            t11.setText(String.valueOf(score1));
            TextField t12 = new TextField();
            t12.setEditable(false);
            t12.setText(String.valueOf(wins2));
            TextField t13 = new TextField();
            t13.setEditable(false);
            t13.setText(String.valueOf(draws2));
            TextField t14 = new TextField();
            t14.setEditable(false);
            t14.setText(String.valueOf(defeats2));
            TextField t15 = new TextField();
            t15.setEditable(false);
            t15.setText(String.valueOf(points2));


            LocalDate localDate = LocalDate.now();
            int startYear = 2016;
            int endYear = localDate.getYear();
            int year = (int) (Math.random() * (endYear - startYear + 1)) + startYear; //Random year
            int month = (int) (Math.random() * 12) + 1;
            Calendar c = Calendar.getInstance();   //Create Calendar objects
            c.set(year, month, 0);   //Setting Date
            int numberOfDaysForMonth = c.get(Calendar.DAY_OF_MONTH); //How many days to get the corresponding year and month
            int day = (int) (Math.random() * numberOfDaysForMonth + 1);

            Date nowDate = new Date(day, month, year); //set day, month, year

            Label dateLabel = new Label("Date            ");
            TextField t16 = new TextField();
            t16.setEditable(false);
            t16.setText(String.valueOf(nowDate)); //set string values of date to text field

            Button addMatch = new Button("Add Match");
            //labels and text fields  set in gridPane
            gridPane.addRow(1, label1);
            gridPane.addRow(4, firstClubName, t1);
            gridPane.addRow(6, goalScoreFirstClub, t2);
            gridPane.addRow(8, goalReceivedFirstClub, t3);
            gridPane.addRow(10, winsFirstClub, t4);
            gridPane.addRow(12, drawsFirstClub, t5);
            gridPane.addRow(14, defeatsFirstClub, t6);
            gridPane.addRow(16, pointsFirstClub, t7);
            gridPane.addRow(4, secondClubName, t9);
            gridPane.addRow(6, goalScoreSecondClub, t10);
            gridPane.addRow(8, goalReceivedSecondClub, t11);
            gridPane.addRow(10, winsSecondClub, t12);
            gridPane.addRow(12, drawsSecondClub, t13);
            gridPane.addRow(14, defeatsSecondClub, t14);
            gridPane.addRow(16, pointsSecondClub, t15);
            gridPane.addRow(18, dateLabel, t16);

            addMatch.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event1) {
                    Match generateMatch = new Match(name1, name2, score1, score2, points1, points2, nowDate);
                    matchesClubArrayList.add(generateMatch); //add new match to match arrayList
                }
            });

            gridPane.add(addMatch, 2, 23);
            gridPane.setStyle("-fx-background-color: #ccccff");

            Scene sc = new Scene(gridPane, 1080, 800);
            stage1.setScene(sc);
            stage1.showAndWait();
        };

        generatesRandomMatch.setOnAction(event);
        hbButtons.getChildren().add(generatesRandomMatch);
        hbButtons.setAlignment(Pos.CENTER_RIGHT);

        table.setItems(data);
        table.getColumns().addAll(clubNameCol, winsCol, drawsCol, defeatsCol, goalsScoCol, goalsReceCol, pointsCol, matchesCol, seasonCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setStyle("-fx-background-color: #ccccff");
        vbox.setPadding(new Insets(30, 30, 60, 30));
        vbox.getChildren().addAll(label, table, hbButtons);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void matchListByDate() {
        TableView<Match> table = new TableView<>();
        ObservableList<Match> data = FXCollections.observableArrayList(matchesClubArrayList);

        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("Premier League Manager");
        stage.setWidth(1300);
        stage.setHeight(650);

        final Label label = new Label("List Of Matches With Dates");
        label.setFont(new Font("Arial", 20));

        TableColumn teamOneCol = new TableColumn("Team One");
        TableColumn teamTwoCol = new TableColumn("Team Two");
        table.setEditable(false);
        teamOneCol.setEditable(false);
        teamTwoCol.setEditable(false);

        TableColumn teamOneNameCol = new TableColumn("Club Name");
        teamOneNameCol.setMinWidth(150);
        teamOneNameCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamOneName"));

        TableColumn teamTwoNameCol = new TableColumn("Club Name");
        teamTwoNameCol.setMinWidth(150);
        teamTwoNameCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamTwoName"));

        TableColumn teamOneScoreCol = new TableColumn("Goals Score");
        teamOneScoreCol.setMinWidth(130);
        teamOneScoreCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamOneScore"));

        TableColumn teamTwoScoreCol = new TableColumn("Goals Score");
        teamTwoScoreCol.setMinWidth(130);
        teamTwoScoreCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamTwoScore"));

        TableColumn teamOneReceivedCol = new TableColumn("Goals Received");
        teamOneReceivedCol.setMinWidth(130);
        teamOneReceivedCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamTwoScore"));

        TableColumn teamTwoReceivedCol = new TableColumn("Goals Received");
        teamTwoReceivedCol.setMinWidth(130);
        teamTwoReceivedCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamOneScore"));

        TableColumn teamOnePointCol = new TableColumn("Point");
        teamOnePointCol.setMinWidth(130);
        teamOnePointCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamOnePoint"));

        TableColumn teamTwoPointCol = new TableColumn("Point");
        teamTwoPointCol.setMinWidth(130);
        teamTwoPointCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamTwoPoint"));

        TableColumn dateOfMatchCol = new TableColumn("Date Of Match");
        dateOfMatchCol.setMinWidth(150);
        dateOfMatchCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("dateOfMatch"));

        HBox hbButtons = new HBox();
        Button sortButton = new Button("View Club List By Date");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //sort date by comparing day, month, year
                Collections.sort(matchesClubArrayList, new Comparator<Match>() {
                    @Override
                    public int compare(Match o1, Match o2) {
                        if (o1.getDateOfMatch().getYear() > o2.getDateOfMatch().getYear()) {
                            return 1;
                        } else if (o1.getDateOfMatch().getYear() < o2.getDateOfMatch().getYear()) {
                            return -1;
                        } else {
                            if ((o1.getDateOfMatch().getMonth()) > o2.getDateOfMatch().getMonth()) {
                                return 1;
                            } else if (o1.getDateOfMatch().getMonth() < o2.getDateOfMatch().getMonth()) {
                                return -1;
                            } else {
                                if ((o1.getDateOfMatch().getDay() > o2.getDateOfMatch().getDay())) {
                                    return 1;
                                } else if (o1.getDateOfMatch().getDay() < o2.getDateOfMatch().getDay()) {
                                    return -1;
                                } else {
                                    return 0;
                                }
                            }
                        }
                    }
                });

                TableView<Match> table = new TableView<>();
                ObservableList<Match> data = FXCollections.observableArrayList(matchesClubArrayList); //set to arrayList to observableArrayList

                final Label label = new Label("Match List By Date");
                label.setFont(new Font("Arial", 20));

                table.setEditable(false);

                TableColumn teamOneCol = new TableColumn("Team One");
                TableColumn teamTwoCol = new TableColumn("Team Two");

                teamOneCol.setEditable(false);
                teamTwoCol.setEditable(false);

                TableColumn teamOneNameCol = new TableColumn("Club Name");
                teamOneNameCol.setMinWidth(150);
                teamOneNameCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamOneName"));

                TableColumn teamTwoNameCol = new TableColumn("Club Name");
                teamTwoNameCol.setMinWidth(150);
                teamTwoNameCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamTwoName"));


                TableColumn teamOneScoreCol = new TableColumn("Goals Score");
                teamOneScoreCol.setMinWidth(130);
                teamOneScoreCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamOneScore"));

                TableColumn teamTwoScoreCol = new TableColumn("Goals Score");
                teamTwoScoreCol.setMinWidth(130);
                teamTwoScoreCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamTwoScore"));

                TableColumn teamOneReceivedCol = new TableColumn("Goals Received");
                teamOneReceivedCol.setMinWidth(130);
                teamOneReceivedCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamTwoScore"));

                TableColumn teamTwoReceivedCol = new TableColumn("Goals Received");
                teamTwoReceivedCol.setMinWidth(130);
                teamTwoReceivedCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamOneScore"));


                TableColumn teamOnePointCol = new TableColumn("Point");
                teamOnePointCol.setMinWidth(130);
                teamOnePointCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamOnePoint"));

                TableColumn teamTwoPointCol = new TableColumn("Point");
                teamTwoPointCol.setMinWidth(130);
                teamTwoPointCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamTwoPoint"));


                TableColumn dateOfMatchCol = new TableColumn("Date Of Match");
                dateOfMatchCol.setMinWidth(150);
                dateOfMatchCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("dateOfMatch"));


                table.setItems(data);
                teamOneCol.getColumns().addAll(teamOneNameCol, teamOneScoreCol, teamOneReceivedCol, teamOnePointCol);
                teamTwoCol.getColumns().addAll(teamTwoNameCol, teamTwoScoreCol, teamTwoReceivedCol, teamTwoPointCol);
                table.getColumns().addAll(teamOneCol, teamTwoCol, dateOfMatchCol);


                final VBox vbox = new VBox();
                vbox.setSpacing(30);
                vbox.setStyle("-fx-background-color: #ccccff");
                vbox.setPadding(new Insets(30, 30, 60, 30));
                vbox.getChildren().addAll(label, table);

                ((Group) scene.getRoot()).getChildren().addAll(vbox);
                stage.setScene(scene);
                stage.show();
            }
        };
        sortButton.setOnAction(event);
        hbButtons.getChildren().add(sortButton);
        hbButtons.setAlignment(Pos.CENTER_RIGHT);

        table.setItems(data);
        teamOneCol.getColumns().addAll(teamOneNameCol, teamOneScoreCol, teamOneReceivedCol, teamOnePointCol);
        teamTwoCol.getColumns().addAll(teamTwoNameCol, teamTwoScoreCol, teamTwoReceivedCol, teamTwoPointCol);
        table.getColumns().addAll(teamOneCol, teamTwoCol, dateOfMatchCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setStyle("-fx-background-color: #ccccff");
        vbox.setPadding(new Insets(30, 30, 60, 30));
        vbox.getChildren().addAll(label, table, hbButtons);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.showAndWait();

    }

    @Override
    public void detailsSearchByDate() {
        Stage stage = new Stage();
        stage.setTitle("Premier League Manager");
        VBox vbox = new VBox();
        vbox.setSpacing(30);
        Scene scene = new Scene(vbox, 800, 500);
        stage.setScene(scene);

        Label label1 = new Label("Date Selection And Search Matches");
        label1.setFont(new Font("Arial", 20));
        //get date picker
        DatePicker date = new DatePicker();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //date create "dd/MM/yyyy" this format
        date.setConverter(new StringConverter<LocalDate>() {

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null)
                    return "";
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
        //now date set to placeholder
        date.setValue(LocalDate.now());
        date.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        Label checkInlabel = new Label("Date:");
        gridPane.add(checkInlabel, 0, 4);
        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(date, 0, 5);
        gridPane.addRow(0, label1);

        Button addButton = new Button("Search");
        gridPane.add(addButton, 2, 5);
        addButton.setOnAction(event -> {
            ArrayList<Match> selectedMatch = new ArrayList<>();

            for (Match m : matchesClubArrayList) {
                java.util.Date matchDate = null;
                java.util.Date selectedDate = null;

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    //match arrayList date and selected date set "dd/MM/yyyy" this format
                    matchDate = format.parse(m.getDateOfMatch().getDate());
                    selectedDate = format.parse(date.getValue().format(dateTimeFormatter));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (selectedDate.compareTo(matchDate) == 0) { //match arrayList date compare with date picker selected date
                    selectedMatch.add(m); //add selected date match to new arrayList

                }
            }

            if (selectedMatch.size() <= 0) { //selected match arrayList empty then show  alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Premier League Manager");
                alert.setHeaderText("Match For Selected Day");
                alert.setContentText("No Matches Played In Selected Day!!!");
                alert.showAndWait();
            } else {
                //Display selected date matched in table
                TableView<Match> table = new TableView<>();
                ObservableList<Match> data = FXCollections.observableArrayList(selectedMatch);

                Scene scene1 = new Scene(new Group());
                Stage stage1 = new Stage();
                stage1.setTitle("Premier League Manager");
                stage1.setWidth(1300);
                stage1.setHeight(650);

                final Label label = new Label("Matches Of Selected Date");
                label.setFont(new Font("Arial", 20));

                TableColumn teamOneCol = new TableColumn("Team One");
                TableColumn teamTwoCol = new TableColumn("Team Two");

                table.setEditable(false);
                teamOneCol.setEditable(false);
                teamTwoCol.setEditable(false);

                TableColumn teamOneNameCol = new TableColumn("Club Name");
                teamOneNameCol.setMinWidth(150);
                teamOneNameCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamOneName"));

                TableColumn teamTwoNameCol = new TableColumn("Club Name");
                teamTwoNameCol.setMinWidth(150);
                teamTwoNameCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamTwoName"));

                TableColumn teamOneScoreCol = new TableColumn("Goals Score");
                teamOneScoreCol.setMinWidth(130);
                teamOneScoreCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamOneScore"));

                TableColumn teamTwoScoreCol = new TableColumn("Goals Score");
                teamTwoScoreCol.setMinWidth(130);
                teamTwoScoreCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamTwoScore"));

                TableColumn teamOneReceivedCol = new TableColumn("Goals Received");
                teamOneReceivedCol.setMinWidth(130);
                teamOneReceivedCol.setCellValueFactory(new PropertyValueFactory<Match, String>("teamTwoScore"));

                TableColumn teamTwoReceivedCol = new TableColumn("Goals Received");
                teamTwoReceivedCol.setMinWidth(130);
                teamTwoReceivedCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamOneScore"));

                TableColumn teamOnePointCol = new TableColumn("Point");
                teamOnePointCol.setMinWidth(130);
                teamOnePointCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamOnePoint"));

                TableColumn teamTwoPointCol = new TableColumn("Point");
                teamTwoPointCol.setMinWidth(130);
                teamTwoPointCol.setCellValueFactory(new PropertyValueFactory<SportsClub, String>("teamTwoPoint"));

                TableColumn dateOfMatchCol = new TableColumn("Date Of Match");
                dateOfMatchCol.setMinWidth(150);
                dateOfMatchCol.setCellValueFactory(new PropertyValueFactory<Match, String>("dateOfMatch"));

                table.setItems(data);
                teamOneCol.getColumns().addAll(teamOneNameCol, teamOneScoreCol, teamOneReceivedCol, teamOnePointCol);
                teamTwoCol.getColumns().addAll(teamTwoNameCol, teamTwoScoreCol, teamTwoReceivedCol, teamTwoPointCol);
                table.getColumns().addAll(teamOneCol, teamTwoCol, dateOfMatchCol);

                final VBox vbox1 = new VBox();
                vbox1.setSpacing(30);
                vbox1.setStyle("-fx-background-color: #ccccff");
                vbox1.setPadding(new Insets(30, 30, 60, 30));
                vbox1.getChildren().addAll(label, table);

                ((Group) scene1.getRoot()).getChildren().addAll(vbox1);
                stage1.setScene(scene1);
                stage1.show();
            }
        });

        vbox.getChildren().add(gridPane);
        vbox.setPadding(new Insets(30, 30, 60, 30));
        vbox.setStyle("-fx-background-color: #ccccff");
        stage.setScene(scene);
        stage.showAndWait();
    }


}












