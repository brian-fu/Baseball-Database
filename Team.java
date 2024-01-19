import java.util.HashMap;

public class Team {
    // TEAM ROSTER
    private HashMap<Integer, Player> rosterHashMap;

    // TEAM IDENTIFIERS
    private String teamName;
    private int teamID;

    // TEAM STATS
    private int gamesPlayed;
    private int wins;
    private int losses;
    private int runsScored;
    private int runsAgainst;
    private int runDifferential;

    private double winningPercentage;

    // TEAM CONSTRUCTOR
    public Team(HashMap<Integer, Player> rosterHashMap, String teamName, int teamID, int gamesPlayed, int wins,
        int losses, int runsScored, int runsAgainst, int runDifferential, double winningPercentage) {

        this.rosterHashMap = rosterHashMap;
        this.teamName = teamName;
        this.teamID = teamID;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.runsScored = runsScored;
        this.runsAgainst = runsAgainst;
        this.runDifferential = runDifferential;
        this.winningPercentage = winningPercentage;

    }

    // GETTERS AND SETTERS:

    // TEAM IDENTIFIERS
    //------------------------------------------------------------------------------
    public HashMap<Integer, Player> getRosterHashMap() {
        return rosterHashMap;
    }

    public void addRosterHashMap(int playerID, Player player){
        rosterHashMap.put(playerID, player);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    public int getTeamID(){
        return teamID;
    }
    //------------------------------------------------------------------------------

    //TEAM STATS
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        int addedGames = wins - this.wins;
        this.gamesPlayed += addedGames;
        
        this.wins = wins;
        this.winningPercentage = getWinningPercentage(); // AUTO UPDATE 
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        int addedGames = losses - this.losses;
        this.gamesPlayed += addedGames;

        this.losses = losses;
        this.winningPercentage = getWinningPercentage(); // AUTO UPDATE 
        
    }

    public double getWinningPercentage() { // Wins / Games Played
        
        winningPercentage = (gamesPlayed != 0) ? roundThreeDigits(((double) wins) / gamesPlayed) : 0.00;
        return winningPercentage;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored){
        this.runsScored = runsScored;
        this.runDifferential = getRunDifferential();
    }

    public int getRunsAgainst() {
        return runsAgainst;
    }

    public void setRunsAgainst(int runsAgainst){
        this.runsAgainst = runsAgainst;
        this.runDifferential = getRunDifferential(); // AUTO UPDATE 
    }

    public int getRunDifferential() { // RS - RA
        runDifferential = getRunsScored() - getRunsAgainst();
        return runDifferential;
    }

    //METHODS:
    //------------------------------------------------------------------------------
    public double roundThreeDigits(double num){
        return ((double)((int) ((num) * 1000))/1000);
    }

    public void addPlayer(String firstName, String lastName, int jerseyNumber) {

        HashMap<Integer, Player> players = Main.getPlayers();

        int newPlayerID = 1;
        while(players.get(newPlayerID) != null){newPlayerID++;}

        Player newPlayer = new Player(firstName, lastName, newPlayerID, teamID, jerseyNumber, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0);
        
        Main.addPlayer(newPlayerID, newPlayer);
        rosterHashMap.put(newPlayerID, newPlayer);

    }

    // REMOVE METHOD BASED ON PLAYER ID
    /* 
    public void removePlayer(int playerIdToRemove){
        Main.removePlayer([playerIdToRemove]);
        rosterHashMap.remove(playerIdToRemove);
    }

    */

    // REMOVE METHOD BASED ON JERSEY NUMBER
    public void removePlayer(int playerJerseyNumber){
        int playerIdToRemove = getPlayerID(playerJerseyNumber);

        Main.removePlayer(playerIdToRemove);
        rosterHashMap.remove(playerIdToRemove);

    }

    public int getPlayerID(int playerJerseyNumber){
        
        int playerID = 0;
        // Iterate through rosterHashMap to find the player with the matching jersey number
        for (Player player : rosterHashMap.values()) {
            if (player.getJerseyNumber() == playerJerseyNumber) {
                playerID = player.getID();
                break; // Found the player, exit the loop
            }
        }

        return playerID;
    }

    @Override
    public String toString() {
        StringBuilder playerInfo = new StringBuilder("Team{" +
                ", teamName='" + teamName + '\'' +
                ", teamID=" + teamID +
                ", gamesPlayed=" + gamesPlayed +
                ", wins=" + wins +
                ", losses=" + losses +
                ", runsScored=" + runsScored +
                ", runsAgainst=" + runsAgainst +
                ", runDifferential=" + runDifferential +
                ", winningPercentage=" + winningPercentage +
                ", \nplayers=[\n");
        
        // Iterate through rosterHashMap and append first name, last name, and jersey number
        for (Player player : rosterHashMap.values()) {
            playerInfo.append("{FirstName=").append(player.getFirstName())
                    .append(", LastName=").append(player.getLastName())
                    .append(", JerseyNumber=").append(player.getJerseyNumber())
                    .append("},\n");
        }
    
        // Remove the trailing comma and space if there are players
        if (!rosterHashMap.isEmpty()) {
            playerInfo.setLength(playerInfo.length() - 2);
        }
    
        playerInfo.append("]}");
    
        return playerInfo.toString();
    }
}
