import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileReaderPlayer {

    public static HashMap<Integer, Player> reader(HashMap<Integer, Player> players, String playersFile){ // Reads Player File and Converts to Hash Map
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(playersFile));
            String line = "";
            line = bufferedReader.readLine(); // Skips First Line Header
            
            while((line = bufferedReader.readLine()) != null) { // Loops through all lines of file
                String[] values = line.split(","); // Splits Line
                //PLAYER INFORMATION
                int playerID = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                int jerseyNumber = Integer.parseInt(values[3]);
                int teamNumber = Integer.parseInt(values[4]);
                //PLAYER STATS
                int gamesPlayed = Integer.parseInt(values[5]);
                int atBats = Integer.parseInt(values[6]);
                int runs = Integer.parseInt(values[7]);
                int hits = Integer.parseInt(values[8]);
                int singles = Integer.parseInt(values[9]);
                int doubles = Integer.parseInt(values[10]);
                int triples = Integer.parseInt(values[11]);
                int homeRuns = Integer.parseInt(values[12]);
                int rbi = Integer.parseInt(values[13]);
                int walks = Integer.parseInt(values[14]);
                int strikeouts = Integer.parseInt(values[15]);
                int stolenBases = Integer.parseInt(values[16]);
                int basesAdvanced = Integer.parseInt(values[17]); //Heathfield Stat ***Add total number of bases accumulated 
                //PITCHING STATS
                double inningsPitched = Double.parseDouble(values[18]);
                int strikeoutsPitched = Integer.parseInt(values[19]);
                int walksAllowed = Integer.parseInt(values[20]);
                int hitsAllowed = Integer.parseInt(values[21]);
                int homeRunsAllowed = Integer.parseInt(values[22]);
                double walksHitsPerInning = Double.parseDouble(values[23]);
                double hitterAverageAgainst = Double.parseDouble(values[24]);
                //CALCULATED STATS
                double battingAverage = Double.parseDouble(values[25]);
                double onBasePercentage = Double.parseDouble(values[26]);
                double sluggingPercentage = Double.parseDouble(values[27]);
                double onBasePlusSlugging = Double.parseDouble(values[28]);
                //Creates New Object to be added to Hashmap
                Player player = new Player(playerID, firstName, lastName, jerseyNumber, teamNumber, gamesPlayed, atBats, runs, hits, singles, 
                doubles, triples, homeRuns, rbi, walks, strikeouts, stolenBases, basesAdvanced, inningsPitched, strikeoutsPitched, walksAllowed, 
                hitsAllowed, homeRunsAllowed, walksHitsPerInning, hitterAverageAgainst, battingAverage, onBasePercentage, sluggingPercentage, onBasePlusSlugging);

                players.put(playerID, player); 
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
              if (bufferedReader != null)
                bufferedReader.close();
                return players;
            } catch (IOException e) {
              e.printStackTrace();
            }

        }
        return players;
    }
}
