import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileWriterTeam {

    public static void writer(HashMap<Integer, Team> teams, String teamsFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(teamsFile, false))) {
            // Write Header Line
            writer.write("teamID,teamName,winningPercentage,gamesPlayed,wins,losses,runsScored,runsAgainst,runDifferential,currentStreak");
            writer.newLine();

            // Write Team Data
            for (HashMap.Entry<Integer, Team> entry : teams.entrySet()) {
                Team team = entry.getValue();

                writer.write(team.getTeamID() + "," + team.getTeamName() + "," + team.getWinningPercentage() + "," + 
                team.getGamesPlayed() + "," + team.getWins() + "," + team.getLosses() + "," + team.getRunsScored()+ 
                "," + team.getRunsAgainst() + "," + team.getRunDifferential() + "," + team.getCurrentStreak());
                
                writer.newLine();

                // Check if the team has a roster before writing player IDs
                if (!team.getRosterHashMap().isEmpty()) {
                    // Write Player IDs
                    StringBuilder playerIds = new StringBuilder();
                    for (int playerId : team.getRosterHashMap().keySet()) {
                        playerIds.append(playerId).append(",");
                    }
                    // Remove the trailing comma
                    playerIds.deleteCharAt(playerIds.length() - 1);
                    writer.write(playerIds.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}