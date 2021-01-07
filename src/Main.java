import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        launch(args);
        Locale.setDefault(Locale.US);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        premierLeagueManager.addArrayList(); // application starts it should read all the information saved in the previous file

        Scanner sc = new Scanner(System.in);
        String option = "z";
        while (!option.equalsIgnoreCase("Q")) { //select the options
            System.out.println("\n<<--------Welcome To Premier League Manager !!!-------->>");
            System.out.println("Enter \"C\" to Create a new football club :");
            System.out.println("Enter \"M\" to Add played match marks :");
            System.out.println("Enter \"D\" to Delete an existing club from the premier league :");
            System.out.println("Enter \"F\" to Display the various statistics for a selected club :");
            System.out.println("Enter \"V\" to Display the Premier League Table :");
            System.out.println("Enter \"A\" to Add a played match :");
            System.out.println("Enter \"S\" to store data :");
            System.out.println("Enter \"R\" to read and load data :");
            System.out.println("Enter \"1\" to Display the clubs list by points :");
            System.out.println("Enter \"2\" to Display the clubs list by goal score :");
            System.out.println("Enter \"3\" to Display the clubs list by wins :");
            System.out.println("Enter \"4\" to Display the generate  a random match :");
            System.out.println("Enter \"5\" to Display the Match list by date :");
            System.out.println("Enter \"6\" to Display the match details searching date :");
            System.out.println("Enter \"Q\" to quit :");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            option = sc.nextLine();

            switch (option.toLowerCase()) {
                case "c":
                    try {
                        System.out.println("Create a new football club");
                        premierLeagueManager.createNewFootballClub();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "m":
                    try {
                        System.out.println("Add played match marks");
                        premierLeagueManager.addPlayedMatchMarks();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "d":
                    try {
                        System.out.println("Delete an existing club from the premier league");
                        premierLeagueManager.deleteExistingClub();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "f":
                    try {
                        System.out.println("Display the various statistics for a selected club");
                        premierLeagueManager.variousStatisticsSelectedClub();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "v":
                    try {
                        System.out.println("Display the Premier League Table");
                        premierLeagueManager.premierLeagueTable();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "a":
                    try {
                        System.out.println("Add a played match");
                        premierLeagueManager.addPlayedMatch();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "s":
                    try {
                        System.out.println("Store data");
                        premierLeagueManager.storeSportClubData();
                        premierLeagueManager.storeMatchesDataWithDate();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "r":
                    try {
                        System.out.println("Read and load data");
                        premierLeagueManager.readAndLoadSportClubData();
                        premierLeagueManager.readAndLoadMatchData();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "1":
                    try {
                        System.out.println("Display the clubs list by points");
                        premierLeagueManager.clubListByPoints();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "2":
                    try {
                        System.out.println("Display the clubs list by goal score");
                        premierLeagueManager.clubsListByGoalScore();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "3":
                    try {
                        System.out.println("Display the clubs list by wins");
                        premierLeagueManager.clubListByWins();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;

                case "4":
                    try {
                        System.out.println("Display the generate  a random match");
                        premierLeagueManager.displayRandomMatch();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "5":
                    try {
                        System.out.println("Display the Match list by date");
                        premierLeagueManager.matchListByDate();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;
                case "6":
                    try {
                        System.out.println("Display the match details search by date");
                        premierLeagueManager.detailsSearchByDate();

                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                    }
                    break;


                case "q":
                    System.out.println("quit the program");
                    break;
            }
        }

    }

}
