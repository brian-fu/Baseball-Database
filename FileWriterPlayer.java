import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileWriterPlayer {
    public static void writer(String playersFile) {

        HashMap<Integer, Player> players = Main.getPlayers();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(playersFile, false))) {
            // Write Header Line
            writer.write("F_NAME,L_NAME,ID,teamID,NUMBER,GP,PA,R,H,1B,2B,3B,HR,RBI,BB,HBP,SO,SB,R_GivenUp,SO_Pitched,BB_Allowed,H_Allowed,IP");
            writer.newLine();

            // Write Player Data
            for (HashMap.Entry<Integer, Player> entry : players.entrySet()) {
                Player player = entry.getValue();
                writer.write(player.getFirstName() + "," + player.getLastName() + "," +
                        player.getID() + "," + player.getTeamNumber() + "," + player.getJerseyNumber() + "," +
                        player.getGamesPlayed() + "," + player.getPlateAppearances() + "," +
                        player.getRuns() + "," + player.getHits() + "," + player.getSingles() + "," +
                        player.getDoubles() + "," + player.getTriples() + "," + player.getHomeRuns() + "," +
                        player.getRbis() + "," + player.getWalks() + "," + player.getHitByPitch() + "," +
                        player.getStrikeouts() + "," + player.getStolenBases() + "," + player.getAtBats() + "," +
                        player.getRunsGivenUp() + "," + player.getStrikeoutsPitched() + "," +
                        player.getWalksAllowed() + "," + player.getHitsAllowed() + "," +
                        player.getInningsPitched());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}