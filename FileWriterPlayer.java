import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileWriterPlayer {
    public static void writer(HashMap<Integer, Player> players, String playersFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(playersFile, false))) {
            // Write Header Line
            writer.write("playerID,firstName,lastName,jerseyNumber,teamNumber,gamesPlayed,atBats,runs,hits,singles,doubles," +
                    "triples,homeRuns,rbi,walks,strikeouts,stolenBases,basesAdvanced,inningsPitched,strikeoutsPitched,walksAllowed,hitsAllowed," +
                    "homeRunsAllowed,walksHitsPerInning,hitterAverageAgainst,battingAverage,onBasePercentage,sluggingPercentage,onBasePlusSlugging");

            writer.newLine();
            // Write Player Data
            for (HashMap.Entry<Integer, Player> entry : players.entrySet()) {
                Player player = entry.getValue();
                writer.write(entry.getKey() + "," + player.getFirstName() + "," + player.getLastName() + "," +
                        player.getJerseyNumber() + "," + player.getTeamNumber() + "," + player.getGamesPlayed() + "," +
                        player.getAtBats() + "," + player.getRuns() + "," + player.getHits() + "," + player.getSingles() + "," +
                        player.getDoubles() + "," + player.getTriples() + "," + player.getHomeRuns() + "," + player.getRbi() + "," +
                        player.getWalks() + "," + player.getStrikeouts() + "," + player.getStolenBases() + "," +
                        player.getBasesAdvanced() + "," + player.getInningsPitched() + "," + player.getStrikeoutsPitched() + "," +
                        player.getWalksAllowed() + "," + player.getHitsAllowed() + "," + player.getHomeRunsAllowed() + "," +
                        player.getWalksHitsPerInning() + "," + player.getHitterAverageAgainst() + "," +
                        player.getBattingAverage() + "," + player.getOnBasePercentage() + "," + player.getSluggingPercentage() + "," +
                        player.getOnBasePlusSlugging());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}