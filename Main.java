import java.util.HashMap;

public class Main {

    private static String playersFile = "players.csv";
    private static String teamsFile = "teams.csv";
    public static void main(String[] args){

        HashMap<Integer, Player> players = new HashMap<>();
        HashMap<Integer, Team> league = new HashMap<>();
        
        players = FileReaderPlayer.reader(players, playersFile);

        /* PRINT ENTIRE PLAYER HASHMAP
        for (HashMap.Entry<Integer, Player> entry : players.entrySet()) {
            Player player = entry.getValue();

            System.out.println(player.toString());
        }
        */

        league = FileReaderTeam.reader(players, teamsFile);
        
        FileWriterPlayer.writer(players, playersFile);

        league.get(1).addWin();
        league.get(2).addLoss();

        System.out.println(league.get(1).getRosterHashMap().get(1));
        System.out.println(league.get(2).getRosterHashMap().get(2));
        FileWriterTeam.writer(league, teamsFile);
    }

    public static void getStandings(){
        
    }
}