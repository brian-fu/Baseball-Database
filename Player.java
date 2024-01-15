public class Player{
    //PLAYER INFORMATION
    private int playerID;
    private String firstName;
    private String lastName;
    private int jerseyNumber;
    private int teamNumber;
    
    //PLAYER STATS
    private int gamesPlayed;
    private int atBats;
    private int runs;
    private int hits;
    private int singles;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int rbi;
    private int walks;
    private int strikeouts;
    private int stolenBases;
    private int basesAdvanced; //Heathfield Stat ***Add total number of bases accumulated 

    //PITCHING STATS
    private double inningsPitched;
    private int strikeoutsPitched;
    private int walksAllowed;
    private int hitsAllowed;
    private int homeRunsAllowed;
    private double walksHitsPerInning;
    private double hitterAverageAgainst;

    //CALCULATED STATS
    private double battingAverage;
    private double onBasePercentage;
    private double sluggingPercentage;
    private double onBasePlusSlugging;

    //PLAYER CONSTRUCTOR
    public Player(int playerID, String firstName, String lastName, int jerseyNumber, int teamNumber, int gamesPlayed, int atBats,
            int runs, int hits, int singles, int doubles, int triples, int homeRuns, int rbi, int walks, int strikeouts,
            int stolenBases, int basesAdvanced, double inningsPitched, int strikeoutsPitched, int walksAllowed,
            int hitsAllowed, int homeRunsAllowed, double walksHitsPerInning, double hitterAverageAgainst,
            double battingAverage, double onBasePercentage, double sluggingPercentage, double onBasePlusSlugging) {

        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
        this.teamNumber = teamNumber;
        this.gamesPlayed = gamesPlayed;
        this.atBats = atBats;
        this.runs = runs;
        this.hits = hits;
        this.singles = singles;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.rbi = rbi;
        this.walks = walks;
        this.strikeouts = strikeouts;
        this.stolenBases = stolenBases;
        this.basesAdvanced = basesAdvanced;
        this.inningsPitched = inningsPitched;
        this.strikeoutsPitched = strikeoutsPitched;
        this.walksAllowed = walksAllowed;
        this.hitsAllowed = hitsAllowed;
        this.homeRunsAllowed = homeRunsAllowed;
        this.walksHitsPerInning = walksHitsPerInning;
        this.hitterAverageAgainst = hitterAverageAgainst;
        this.battingAverage = battingAverage;
        this.onBasePercentage = onBasePercentage;
        this.sluggingPercentage = sluggingPercentage;
        this.onBasePlusSlugging = onBasePlusSlugging;
    }

    //PLAYER INFORMATION
    public int getID() {
        return playerID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getTeamNumber(){
        return teamNumber;
    }

    //PLAYER STATS
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void addGamesPlayed(int gamesPlayed) {
        this.gamesPlayed =+ 1;
    }

    public int getAtBats() {
        return atBats;
    }

    public void addAtBat() {
        this.atBats += 1;
    }

    public int getRuns() {
        return runs;
    }

    public void addRun() {
        this.runs += 1;
    }

    public int getHits() {
        return hits;
    }

    public void addHit() {
        this.hits += 1;
    }

    public int getSingles(){
        return singles;
    }

    public void addSingle(){
        this.singles += 1;
    }
    
    public int getDoubles() {
        return doubles;
    }

    public void addDouble() {
        this.doubles += 1;
    }

    public int getTriples() {
        return triples;
    }

    public void addTriple() {
        this.triples += 1;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void addHomeRun() {
        this.homeRuns += 1;
    }

    public int getRbi() {
        return rbi;
    }

    public void addRbi(int rbi) {
        this.rbi += rbi;
    }

    public int getWalks() {
        return walks;
    }

    public void addWalk() {
        this.walks += 1;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void addStrikeout() {
        this.strikeouts += 1;
    }

    public int getStolenBases() {
        return stolenBases;
    }

    public void addStolenBase() {
        this.stolenBases += 1;
    }

    public int getBasesAdvanced() {
        return basesAdvanced;
    }

    public void addBasesAdvanced(int basesAdvanced) {
        this.basesAdvanced += basesAdvanced;
    }

    // PITCHING STATS 
    public double getInningsPitched(){
        return inningsPitched;
    }

    public void addInningsPitched(double newInnings){
        inningsPitched += newInnings;
    }

    public int getStrikeoutsPitched(){
        return strikeoutsPitched;
    }

    public void addStrikeoutsPitched(){
        strikeoutsPitched += 1;
    }

    public int getWalksAllowed(){
        return walksAllowed;
    }

    public void addWalksAllowed(){
        walksAllowed += 1;
    }
    
    public int getHitsAllowed() {
        return hitsAllowed;
    }

    public void addHitsAllowed() {
        hitsAllowed += 1;
    }

    public int getHomeRunsAllowed() {
        return homeRunsAllowed;
    }

    public void addHomeRunsAllowed() {
        homeRunsAllowed += 1;
    }

    //CALCULATED STATS
    public double getWalksHitsPerInning() {
        try { // Accounts for Division by ZERO
            double inningsPitchedValue = getInningsPitched();
            walksHitsPerInning = (inningsPitchedValue != 0) ?
                    roundThreeDigits((getWalksAllowed() + getHitsAllowed()) / inningsPitchedValue) : 0.00;
        } catch (ArithmeticException e) {
            walksHitsPerInning = 0.00;
        }
    
        return walksHitsPerInning;
    }
    
    public double getHitterAverageAgainst() {
        try { // Accounts for Division by ZERO
            double inningsPitchedValue = getInningsPitched();
            hitterAverageAgainst = (inningsPitchedValue != 0) ?
                    roundThreeDigits(getHitsAllowed() / (inningsPitchedValue * 3)) : 0.00;
        } catch (ArithmeticException e) {
            hitterAverageAgainst = 0.00;
        }
    
        return hitterAverageAgainst;
    }
    
    public double getBattingAverage() {
        try { // Accounts for Division by ZERO
            double atBatsValue = getAtBats();
            battingAverage = (atBatsValue != 0) ? roundThreeDigits(getHits() / atBatsValue) : 0.00;
        } catch (ArithmeticException e) {
            battingAverage = 0.00;
        }
    
        return battingAverage;
    }
    
    public double getOnBasePercentage() {
        try { // Accounts for Division by ZERO
            double atBatsValue = getAtBats();
            onBasePercentage = (atBatsValue != 0) ?
                    roundThreeDigits((getHits() + getWalks()) / atBatsValue) : 0.00;
        } catch (ArithmeticException e) {
            onBasePercentage = 0.00;
        }
    
        return onBasePercentage;
    }
    
    public double getSluggingPercentage() {
        try { // Accounts for Division by ZERO
            double atBatsValue = getAtBats();
            sluggingPercentage = (atBatsValue != 0) ?
                    roundThreeDigits((getSingles() + getDoubles() * 2 + getTriples() * 3 + getHomeRuns() * 4) / atBatsValue) : 0.00;
        } catch (ArithmeticException e) {
            sluggingPercentage = 0.00;
        }
    
        return sluggingPercentage;
    }
    
    public double getOnBasePlusSlugging() {
        try { // Accounts for Division by ZERO
            onBasePlusSlugging = getOnBasePercentage() + getSluggingPercentage();
        } catch (ArithmeticException e) {
            onBasePlusSlugging = 0.00;
        }
    
        return onBasePlusSlugging;
    }

    //METHODS:
    public double roundThreeDigits(double num){
        return ((double)((int) ((num) * 1000))/1000);
    }

    @Override // Override toString to Print all Player Stats
    public String toString(){
        return  "\nPlayer Details:" + "\n  First Name: " + getFirstName() +
                "\n  Last Name: " + getLastName() + "\n  Jersey Number: " + getJerseyNumber() +
                "\n  Team Number: " + getTeamNumber() + "\n  Games Played: " + getGamesPlayed() +
                "\n  At Bats: " + getAtBats() + "\n  Runs: " + getRuns() +
                "\n  Hits: " + getHits() + "\n  Singles: " + getSingles() +
                "\n  Doubles: " + getDoubles() + "\n  Triples: " + getTriples() +
                "\n  Home Runs: " + getHomeRuns() + "\n  RBI: " + getRbi() +
                "\n  Walks: " + getWalks() + "\n  Strikeouts: " + getStrikeouts() +
                "\n  Stolen Bases: " + getStolenBases() + "\n  Bases Advanced: " + getBasesAdvanced() +
                "\n  Innings Pitched: " + getInningsPitched() + "\n  Strikeouts Pitched: " + getStrikeoutsPitched() +
                "\n  Walks Allowed: " + getWalksAllowed() + "\n  Hits Allowed: " + getHitsAllowed() +
                "\n  Home Runs Allowed: " + getHomeRunsAllowed() + "\n  Walks Hits Per Inning: " + getWalksHitsPerInning() +
                "\n  Hitter Average Against: " + getHitterAverageAgainst() + "\n  Batting Average: " + getBattingAverage() +
                "\n  On Base Percentage: " + getOnBasePercentage() + "\n  Slugging Percentage: " + getSluggingPercentage() +
                "\n  On Base Plus Slugging: " + getOnBasePlusSlugging() +
                "\n----------------------------------";
    }
}