import java.util.HashMap;

public class Team {
    private HashMap<Integer, Player> rosterHashMap;

    private String teamName;

    private int teamID;
    private int gamesPlayed;
    private int wins;
    private int losses;
    private double winningPercentage;
    private int runsScored;
    private int runsAgainst;
    private int runDifferential;
    private int currentStreak;

//TEAM CONSTRUCTOR
    public Team(HashMap<Integer, Player> rosterHashMap, int teamID, String teamName, int gamesPlayed, int wins, int losses,
            double winningPercentage, int runsScored, int runsAgainst, int runDifferential, int currentStreak) {
        this.rosterHashMap = rosterHashMap;
        this.teamID = teamID;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.winningPercentage = winningPercentage;
        this.runsScored = runsScored;
        this.runsAgainst = runsAgainst;
        this.runDifferential = runDifferential;
        this.currentStreak = currentStreak;
    }

    public HashMap<Integer, Player> getRosterHashMap() {
        return rosterHashMap;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamID(){
        return teamID;
    }

    //TEAM STATS
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        this.wins += 1;
        this.gamesPlayed += 1;
    }

    public int getLosses() {
        return losses;
    }

    public void addLoss() {
        this.losses += 1;
        this.gamesPlayed += 1;
    }

    public double getWinningPercentage() {
        winningPercentage = roundThreeDigits(((double) wins) / gamesPlayed);
        return winningPercentage;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void addRunsScored(int runsScored){
        this.runsScored += runsScored;
    }

    public int getRunsAgainst() {
        return runsAgainst;
    }

    public void addRunsAgainst(int runsAgainst){
        this.runsAgainst += runsAgainst;
    }

    public int getRunDifferential() { // RS - RA
        runDifferential = getRunsScored() - getRunsAgainst();
        return runDifferential;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void resetCurrentStreak(){
        this.currentStreak = 0;
    }

    public void updateCurrentStreak(int currentStreak) {
        this.currentStreak += currentStreak;
    }


    //METHODS:
    public double roundThreeDigits(double num){
        return ((double)((int) ((num) * 1000))/1000);
    }

    @Override
    public String toString() {
        return "Team{" +
                "rosterHashMap=" + rosterHashMap +
                ", teamName='" + teamName + '\'' +
                ", teamID=" + teamID +
                ", gamesPlayed=" + gamesPlayed +
                ", wins=" + wins +
                ", losses=" + losses +
                ", winningPercentage=" + winningPercentage +
                ", runsScored=" + runsScored +
                ", runsAgainst=" + runsAgainst +
                ", runDifferential=" + runDifferential +
                ", currentStreak=" + currentStreak +
                '}';
    }
}
