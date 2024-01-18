import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileReaderTeam {

    public static HashMap<Integer, Team> reader(HashMap<Integer, Player> players, String teamsFile) {
        HashMap<Integer, Team> teams = new HashMap<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(teamsFile));

            // Read the first line to skip the header
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] teamInfo = line.split(",");

                // Extracting team information from the array
                int teamID = Integer.parseInt(teamInfo[0].trim());
                String teamName = teamInfo[1].trim();
                int gamesPlayed = Integer.parseInt(teamInfo[3].trim());
                int wins = Integer.parseInt(teamInfo[4].trim());
                int losses = Integer.parseInt(teamInfo[5].trim());
                int runsScored = Integer.parseInt(teamInfo[6].trim());
                int runsAgainst = Integer.parseInt(teamInfo[7].trim());
                int runDifferential = Integer.parseInt(teamInfo[8].trim());
                double winningPercentage = Double.parseDouble(teamInfo[9].trim());

                HashMap<Integer, Player> teamRoster = new HashMap<>();

                // Read the next line which contains player IDs
                line = bufferedReader.readLine();
                if (line != null) {
                    String[] playerIDs = line.split(",");
                    // Puts all players of team roster into hashmap
                    for (String playerIdStr : playerIDs) {
                        if (!playerIdStr.trim().isEmpty()) {
                            int playerID = Integer.parseInt(playerIdStr.trim());
                            teamRoster.put(playerID, players.get(playerID));
                        }
                    }
                }

                Team team = new Team(teamRoster, teamName, teamID, gamesPlayed, wins, losses, runsScored, runsAgainst, runDifferential, winningPercentage);
                teams.put(teamID, team);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return teams;
    }
}