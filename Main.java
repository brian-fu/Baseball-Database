import java.util.HashMap;
import java.io.IOException;

public class Main {

    // ATTRIBUTES OF LEAGUE
    //------------------------------------------------------------------------------
    private static String playersFile = "players.csv";
    private static String teamsFile = "teams.csv";

    private static HashMap<Integer, Player> players = new HashMap<>();
    private static HashMap<Integer, Team> league = new HashMap<>();
    //------------------------------------------------------------------------------

    // GETTERS / SETTERS FOR PLAYER HASHMAP
    //------------------------------------------------------------------------------
    public static HashMap<Integer, Player> getPlayers(){
        return players;
    }

    public static void addPlayer(int playerID, Player player){
        players.put(playerID, player);
    }

    public static void removePlayer(int playerID){
        players.remove(playerID);
    }

    // GETTERS / SETTERS FOR LEAGUE HASHMAP
    public static HashMap<Integer, Team> getTeams(){
        return league;
    }

    public static void removeTeam(int teamID){
        league.remove(teamID);
    }

    // METHODS 
    //------------------------------------------------------------------------------
    public static int generateTeamID(){
        int newTeamID = 1;
        while (league.get(newTeamID) != null){newTeamID++;}
        return newTeamID;
    }

    public static Team createTeam(String teamName){
        HashMap<Integer, Player> teamRoster = new HashMap<>();
        int newTeamID = generateTeamID();
        Team newTeam = new Team(teamRoster, teamName, newTeamID, 0, 0, 0, 0, 0, 0, 0.0);
        league.put(newTeamID, newTeam);
        return newTeam;
    }
    

    //------------------------------------------------------------------------------
    // MAIN
    public static void main(String[] args) throws IOException {
        players = FileReaderPlayer.reader(players, playersFile);
        league = FileReaderTeam.reader(players, teamsFile);

        Application softballTracker = new Application();
        softballTracker.runApplication();

        /*Team blueJays = createTeam("Blue Jays");
        blueJays.addPlayer("Christopher", "Min", 15);
        blueJays.addPlayer("Brian", "Fu", 16);
        blueJays.setWins(5);
        blueJays.setLosses(3);
        blueJays.setRunsAgainst(10);
        blueJays.setRunsScored(30);
        System.out.println(blueJays.toString());

        int p1ID = blueJays.getPlayerID(15);

        players.get(p1ID).setHits(5);
        players.get(p1ID).setStrikeouts(3);
        */

        //FileWriterTeam.writer(teamsFile);
        //FileWriterPlayer.writer(playersFile);
    }


    
}