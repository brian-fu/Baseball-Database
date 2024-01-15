import java.util.HashMap;

public class League {
    private HashMap<Integer, Team> leagueHashMap;
    private int maxLeagueSize;
    private int currentLeagueSize;

    public League(HashMap<Integer, Team> leagueHashMap, int maxLeagueSize) {
        this.leagueHashMap = leagueHashMap;
        this.maxLeagueSize = maxLeagueSize;
        this.currentLeagueSize = 0;
    }
}
