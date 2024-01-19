import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileReaderPlayer {

    public static HashMap<Integer, Player> reader(HashMap<Integer, Player> players, String playersFile) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(playersFile));
            String line = "";
            line = bufferedReader.readLine(); // Skips First Line Header

            while ((line = bufferedReader.readLine()) != null) { // Loops through all lines of file
                String[] values = line.split(","); // Splits Line

                // PLAYER INFORMATION
                String firstName = values[0];
                String lastName = values[1];
                int playerID = Integer.parseInt(values[2]);
                int teamID = Integer.parseInt(values[3]);
                int jerseyNumber = Integer.parseInt(values[4]);

                // PLAYER STATS
                int gamesPlayed = Integer.parseInt(values[5]);
                int plateAppearances = Integer.parseInt(values[6]);
                int runs = Integer.parseInt(values[7]);
                int hits = Integer.parseInt(values[8]);
                int singles = Integer.parseInt(values[9]);
                int doubles = Integer.parseInt(values[10]);
                int triples = Integer.parseInt(values[11]);
                int homeRuns = Integer.parseInt(values[12]);
                int rbi = Integer.parseInt(values[13]);
                int walks = Integer.parseInt(values[14]);
                int hitByPitch = Integer.parseInt(values[15]);
                int strikeouts = Integer.parseInt(values[16]);
                int stolenBases = Integer.parseInt(values[17]);

                // PITCHING STATS
                int runsGivenUp = Integer.parseInt(values[19]);
                int strikeoutsPitched = Integer.parseInt(values[20]);
                int walksAllowed = Integer.parseInt(values[21]);
                int hitsAllowed = Integer.parseInt(values[22]);
                double inningsPitched = Double.parseDouble(values[23]);


                // Creates New Object to be added to Hashmap
                Player player = new Player(firstName, lastName, playerID, teamID, jerseyNumber,
                    gamesPlayed, plateAppearances, runs, hits, singles, doubles, triples, homeRuns,
                    rbi, walks, hitByPitch, strikeouts, stolenBases,
                    runsGivenUp, strikeoutsPitched, walksAllowed, hitsAllowed, inningsPitched
                    );

                players.put(playerID, player);
            }
            
        } catch (IOException e) {
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