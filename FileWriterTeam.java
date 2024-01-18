import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileWriterTeam {

    public static void writer(String teamsFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(teamsFile, false))) {
            HashMap<Integer, Team> teams = Main.getTeams();
            // Write Header Line
            writer.write("teamID,teamName,gamesPlayed,wins,losses,runsScored,runsAgainst,runDifferential,winningPercentage");
            writer.newLine();

            // Write Team Data
            for (HashMap.Entry<Integer, Team> entry : teams.entrySet()) {
                Team team = entry.getValue();

                writer.write(team.getTeamID() + "," + team.getTeamName() + "," + team.getGamesPlayed() + "," +
                        team.getWins() + "," + team.getLosses() + "," + team.getRunsScored() +
                        "," + team.getRunsAgainst() + "," + team.getRunDifferential() + "," + team.getWinningPercentage());

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