public class Player{
    // PLAYER IDENTIFIERS
    private String firstName;
    private String lastName;
    private int playerID;
    private int teamNumber;
    private int jerseyNumber;
    
    
    // PLAYER STATS
    private int gamesPlayed;
    private int plateAppearances;
    private int runs;
    private int hits;
    private int singles;
    private int doubles;
    private int triples;
    private int homeRuns;
    private int rbi;
    private int walks;
    private int hitByPitch;
    private int strikeouts;
    private int stolenBases; 
    private int atBats;

    // PITCHING STATS
    private int runsGivenUp;
    private int strikeoutsPitched;
    private int walksAllowed;
    private int hitsAllowed;
    private double inningsPitched;

    // CALCULATED PITCHING STATS
    private double walksHitsPerInning;
    private double hitterAverageAgainst;
    private double earnedRunAverage;

    //CALCULATED BATTING STATS
    
    private double battingAverage;
    private double onBasePercentage;
    private double sluggingPercentage;
    private double onBasePlusSlugging;

    //PLAYER CONSTRUCTOR


    //PLAYER INFORMATION
    //------------------------------------------------------------------------------
    public int getID() {
        return playerID;
    }
    
    public Player(String firstName, String lastName, int playerID, int teamNumber, int jerseyNumber, int gamesPlayed,
        int plateAppearances, int runs, int hits, int singles, int doubles, int triples, int homeRuns, int rbi,
        int walks, int hitByPitch, int strikeouts, int stolenBases, int atBats, int runsGivenUp,
        int strikeoutsPitched, int walksAllowed, int hitsAllowed, double inningsPitched, double walksHitsPerInning,
        double hitterAverageAgainst, double earnedRunAverage, double battingAverage, double onBasePercentage,
        double sluggingPercentage, double onBasePlusSlugging) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.playerID = playerID;
        this.teamNumber = teamNumber;
        this.jerseyNumber = jerseyNumber;
        this.gamesPlayed = gamesPlayed;
        this.plateAppearances = plateAppearances;
        this.runs = runs;
        this.hits = hits;
        this.singles = singles;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.rbi = rbi;
        this.walks = walks;
        this.hitByPitch = hitByPitch;
        this.strikeouts = strikeouts;
        this.stolenBases = stolenBases;
        this.atBats = atBats;
        this.runsGivenUp = runsGivenUp;
        this.strikeoutsPitched = strikeoutsPitched;
        this.walksAllowed = walksAllowed;
        this.hitsAllowed = hitsAllowed;
        this.inningsPitched = inningsPitched;
        this.walksHitsPerInning = walksHitsPerInning;
        this.hitterAverageAgainst = hitterAverageAgainst;
        this.earnedRunAverage = earnedRunAverage;
        this.battingAverage = battingAverage;
        this.onBasePercentage = onBasePercentage;
        this.sluggingPercentage = sluggingPercentage;
        this.onBasePlusSlugging = onBasePlusSlugging;

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
    //------------------------------------------------------------------------------
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getPlateAppearances(){
        return plateAppearances;
    }

    public void setPlateAppearances(int plateAppearances){
        this.plateAppearances = plateAppearances;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getSingles(){
        return singles;
    }

    public void setSingles(int singles){
        this.singles = singles;
    }
    
    public int getDoubles() {
        return doubles;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public int getTriples() {
        return triples;
    }

    public void setTriples(int triples) {
        this.triples = triples;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(int homeruns) {
        this.homeRuns = homeruns;
    }

    public int getRbis() {
        return rbi;
    }

    public void setRbis(int rbi) {
        this.rbi += rbi;
    }

    public int getWalks() {
        return walks;
    }

    public void setWalks(int walks) {
        this.walks = walks;
    }

    public int getHitByPitch(){
        return hitByPitch;
    }

    public void setHitByPitch(int hitByPitch){
        this.hitByPitch = hitByPitch;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(int strikeouts) {
        this.strikeouts = strikeouts;
    }

    public int getStolenBases() {
        return stolenBases;
    }

    public void setStolenBases(int stolenBases) {
        this.stolenBases = stolenBases;
    }

    // PITCHING STATS 
    //------------------------------------------------------------------------------
    public double getInningsPitched(){
        return inningsPitched;
    }

    public void setInningsPitched(int inningsPitched){
        this.inningsPitched = inningsPitched;
    }

    public int getRunsGivenUp(){
        return runsGivenUp;
    }

    public void setRunsGivenUp(int runsGivenUp){
        this.runsGivenUp = runsGivenUp;
    }

    public int getStrikeoutsPitched(){
        return strikeoutsPitched;
    }

    public void setStrikeoutsPitched(int strikeoutsPitched){
        this.strikeoutsPitched = strikeoutsPitched;
    }

    public int getWalksAllowed(){
        return walksAllowed;
    }

    public void setWalksAllowed(int walksAllowed){
        this.walksAllowed = walksAllowed;
    }
    
    public int getHitsAllowed() {
        return hitsAllowed;
    }

    public void setHitsAllowed(int hitsAllowed) {
        this.hitsAllowed += hitsAllowed;
    }

    //CALCULATED STATS
    //------------------------------------------------------------------------------
    public int getAtBats() { // Plate Appearances - (Walks + Hit by Pitch)
        atBats = getPlateAppearances() - getWalks() - getHitByPitch(); 
        return atBats;
    }

    public double getWalksHitsPerInning() { // (Walks Allowed + Hits Allowed) / Total Innings Pitched
        
        double inningsPitchedValue = getInningsPitched();
        walksHitsPerInning = (inningsPitchedValue != 0) ? roundThreeDigits((getWalksAllowed() + getHitsAllowed()) / inningsPitchedValue) : 0.00;
        return walksHitsPerInning;
    }
    
    public double getHitterAverageAgainst() { // (Hits Allowed / (Batters Faced - Walks Allowed))

        double inningsPitchedValue = getInningsPitched();
        hitterAverageAgainst = (inningsPitchedValue != 0) ? roundThreeDigits(getHitsAllowed() / (inningsPitchedValue * 3 - getWalksAllowed())) : 0.00;
        return hitterAverageAgainst;
    }

    public double getEarnedRunAverage() { // (Runs Given Up / (Innings Pitched / 9))
        
        double inningsPitchedValue = getInningsPitched();
        earnedRunAverage = (inningsPitchedValue != 0) ? roundThreeDigits(getRunsGivenUp() / (inningsPitchedValue / 9)) : 0.00;
        return earnedRunAverage;
    }
    
    public double getBattingAverage() { // (Hits / At Bats)

        int atBatsValue = getAtBats();
        battingAverage = (atBatsValue != 0) ? roundThreeDigits(getHits() / atBatsValue) : 0.00;
        return battingAverage;
    }
    
    public double getOnBasePercentage() { // (Hits + Walks + Hit By Pitch) / Plate Appearances
            
        int plateAppearancesValue = getPlateAppearances();
        onBasePercentage = (plateAppearancesValue != 0) ? roundThreeDigits((getHits() + getWalks() + getHitByPitch()) / plateAppearancesValue) : 0.00;
        return onBasePercentage;
    }
    
    public double getSluggingPercentage() { // (Singles * 1 + Doubles * 2 + Triples * 3 + Homeruns * 4) / At Bats
            
        int atBatsValue = getAtBats();
        sluggingPercentage = (atBatsValue != 0) ? roundThreeDigits((getSingles() + getDoubles() * 2 + getTriples() * 3 + getHomeRuns() * 4) / atBatsValue) : 0.00;
        return sluggingPercentage;
    }
    
    public double getOnBasePlusSlugging() { // On Base Percentage + Slugging Percentage
        
        onBasePlusSlugging = getOnBasePercentage() + getSluggingPercentage();
        return onBasePlusSlugging;
    }

    //METHODS:
    public double roundThreeDigits(double num){
        return ((double)((int) ((num) * 1000))/1000);
    }

    //TO STRING
    @Override
    public String toString() {
        return "Player{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", playerID=" + playerID +
            ", teamNumber=" + teamNumber +
            ", jerseyNumber=" + jerseyNumber +
            ", gamesPlayed=" + gamesPlayed +
            ", plateAppearances=" + plateAppearances +
            ", runs=" + runs +
            ", hits=" + hits +
            ", singles=" + singles +
            ", doubles=" + doubles +
            ", triples=" + triples +
            ", homeRuns=" + homeRuns +
            ", rbi=" + rbi +
            ", walks=" + walks +
            ", hitByPitch=" + hitByPitch +
            ", strikeouts=" + strikeouts +
            ", stolenBases=" + stolenBases +
            ", atBats=" + atBats +
            ", runsGivenUp=" + runsGivenUp +
            ", strikeoutsPitched=" + strikeoutsPitched +
            ", walksAllowed=" + walksAllowed +
            ", hitsAllowed=" + hitsAllowed +
            ", inningsPitched=" + inningsPitched +
            ", walksHitsPerInning=" + walksHitsPerInning +
            ", hitterAverageAgainst=" + hitterAverageAgainst +
            ", earnedRunAverage=" + earnedRunAverage +
            ", battingAverage=" + battingAverage +
            ", onBasePercentage=" + onBasePercentage +
            ", sluggingPercentage=" + sluggingPercentage +
            ", onBasePlusSlugging=" + onBasePlusSlugging +
            '}';
    }
}