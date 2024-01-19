import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.cert.PolicyQualifierInfo;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.util.HashMap;

public class Application implements ActionListener {

    public static final int windowCount = 6;


    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static JFrame frame;
    public static int displayHeight = screenSize.height;
    public static int displayWidth = screenSize.width;

    public static Window[] windowList = new Window[windowCount];
    public static Window currentWindow;

    public static Color standardBgColor = new Color(28,145,163);

    public static Font bigFont = new Font("Osaka", Font.BOLD, 50);
    public static Font midFont = new Font("Osaka", Font.BOLD, 40);
    public static Font littleFont = new Font("Osaka", Font.BOLD, 30);
    public static Font tinyFont = new Font("Osaka", Font.BOLD, 15);


    // Public componenets
    public static TextField teamName = new TextField("teamNameField", 1130, 600, 300, 80, Color.WHITE, littleFont);
    public static TextArea repeatTeamAlert = new TextArea("repeatTeamAlert", "Team name is already used in this league!", 890,800, 900, 200, standardBgColor, littleFont, Color.BLACK, false);
    public static TextArea teamCreationSuccessAlert = new TextArea("teamCreationSuccessAlert", "Team Successfully Created!", 1030,800, 900, 200, standardBgColor, littleFont, Color.BLACK, false);

    public static TextArea noTeamsAlert = new TextArea("noTeamsAlert", "***Could not ADD PLAYER, Please Create a TEAM***", 900,1250, 1300, 200, standardBgColor, littleFont, Color.BLACK, false);
    public static TextArea playerAddedAlert = new TextArea("playerAddedAlert", "***Player Successfully Added!***", 900,1250, 1300, 200, standardBgColor, littleFont, Color.BLACK, false);
    public static TextArea checkPlayerInfoAlert = new TextArea("checkPlayerInfoAlert", "***Please Check Player Information and Try Again.***", 900,1250, 1300, 200, standardBgColor, littleFont, Color.BLACK, false);
    public static TextArea checkPlayerStatsAlert = new TextArea("checkPlayerStatsAlert", "***Please Check Player Stats Validity and Try Again***", 900,1250, 1300, 200, standardBgColor, littleFont, Color.BLACK, false);
    public static TextArea existingJerseyNumberAlert = new TextArea("existingJerseyNumberAlert", "***Someone On The Team Already Has This Jersey Number.***", 900,1250, 1300, 200, standardBgColor, littleFont, Color.BLACK, false);
    

    public DropdownChooser teamNamesChooser;
    public DropdownChooser playerNamesChooser;

    public static String currentTeam;
    public static String currentPlayer;
    // WINDOW 3 COMPONENTS
    public DropdownChooser teamNamesChooserEditor = new DropdownChooser("teamNameChooser", 50, 300, 450, 75, Color.WHITE, this, littleFont, false, null);
    public static TextField firstNameField = new TextField("firstName", 155, 530, 250, 70, Color.WHITE, littleFont);
    public static TextField lastNameField = new TextField("lastName", 155, 750, 250, 70, Color.WHITE, littleFont);
    public static NumberTextField jerseyNumField = new NumberTextField("jerseyNum", 110, 970, 330, 70, Color.WHITE, littleFont);

    public static NumberTextField gamesPlayedField = new NumberTextField("gamesPlayed", 690, 180, 300, 70, Color.WHITE, littleFont);
    public static NumberTextField plateAppsField = new NumberTextField("plateApps", 1140, 180, 250, 70, Color.WHITE, littleFont);
    public static NumberTextField runsField = new NumberTextField("runs", 1510, 180, 200, 70, Color.WHITE, littleFont);
    public static NumberTextField hitsField = new NumberTextField("hits", 1860, 180, 200, 70, Color.WHITE, littleFont);
    public static NumberTextField singlesField = new NumberTextField("singles", 2180, 180, 240, 70, Color.WHITE, littleFont);

    public static NumberTextField doublesField = new NumberTextField("doubles", 785, 460, 260, 70, Color.WHITE, littleFont);
    public static NumberTextField triplesField = new NumberTextField("triples", 1195, 460, 260, 70, Color.WHITE, littleFont);
    public static NumberTextField homerunsField = new NumberTextField("homeruns", 1610, 460, 280, 70, Color.WHITE, littleFont);
    public static NumberTextField rbisField = new NumberTextField("rbis", 2025, 460, 200, 70, Color.WHITE, littleFont);

    public static NumberTextField walksField = new NumberTextField("walks", 785, 740, 260, 70, Color.WHITE, littleFont);
    public static NumberTextField hbpsField = new NumberTextField("hbps", 1195, 740, 220, 70, Color.WHITE, littleFont);
    public static NumberTextField strikeoutsField = new NumberTextField("strikeouts", 1535, 740, 280, 70, Color.WHITE, littleFont);
    public static NumberTextField stolenBasesField = new NumberTextField("stolenBases", 1970, 740, 310, 70, Color.WHITE, littleFont);

    public static TextField inningsPitchedField = new TextField("innings", 690, 1060, 250, 70, Color.WHITE, littleFont);
    public static NumberTextField runsGivenUpField = new NumberTextField("runsgivenup", 1070, 1060, 330, 70, Color.WHITE, littleFont);
    public static NumberTextField strikeoutsPitchedField = new NumberTextField("strikeoutsAgainst", 1520, 1060, 290, 70, Color.WHITE, littleFont);
    public static NumberTextField walksAllowedField = new NumberTextField("walksAgainst", 1920, 1060, 235, 70, Color.WHITE, littleFont);
    public static NumberTextField hitsAllowedField = new NumberTextField("hitsAgainst", 2240, 1060, 200, 70, Color.WHITE, littleFont);

    public void runApplication() throws IOException {

        frame = new JFrame("Softball Tracker!");
        initializeFrame(frame);

        // -----------------------------------------------------------------------------------------

        windowList[0] = new Window("Start Screen", displayHeight, displayWidth, false);

        windowList[0].add(new Picture("startTitle", "title.png", 771, 400, 1018, 221));
        windowList[0].add(new Picture("startBall", "startIcon.png", 1050, 220, 660, 371));
        windowList[0].add(new WindowChangePicture("startButton", "startButton.png", 1167, 720, 225, 96, standardBgColor, "Menu", this));

        // -----------------------------------------------------------------------------------------

        windowList[1] = new Window("Menu", displayHeight, displayWidth, false);

        windowList[1].add(new Picture("startTitle", "title.png", 771, 250, 1018, 221));
        windowList[1].add(new Picture("startBall", "startIcon.png", 1050, 70, 660, 371));
        windowList[1].add(new WindowChangePicture("teamCreatorButton", "createTeamButton.png", 688, 600, 568, 140, standardBgColor, "Team Creator", this));
        windowList[1].add(new WindowChangePicture("teamEditorButton", "editTeamButton.png", 1288, 600, 568, 140, standardBgColor, "Team Editor", this));
        windowList[1].add(new WindowChangePicture("statManual", "statManualButton.png", 688, 900, 568, 140, standardBgColor, "Stat Manual", this));
        windowList[1].add(new WindowChangePicture("statTrackerButton", "statTrackerButton.png", 1288, 900, 568, 140, standardBgColor, "Stat Tracker", this));

        windowList[1].add(new ExitButton("exitButton", "exitButton.png", 2260, 1290, 252, 82, standardBgColor, this));

        // -----------------------------------------------------------------------------------------

        windowList[2] = new Window("Team Creator", displayHeight, displayWidth, false);

        windowList[2].add(new WindowChangePicture("teamCreatorBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));
        windowList[2].add(teamName);
        windowList[2].add(new TextArea("teamNameLabel", "TEAM NAME", 1080,500, 500, 200, standardBgColor, bigFont, Color.BLACK, true));
        windowList[2].add(new TeamExtractPicture("createTeamButton", "createTeamActionButton.png", 1168, 700, 224, 74, standardBgColor, this));
        windowList[2].add(repeatTeamAlert);
        windowList[2].add(teamCreationSuccessAlert);
        
        // -----------------------------------------------------------------------------------------

        windowList[3] = new Window("Team Editor", displayHeight, displayWidth, true);

        windowList[3].add(teamNamesChooserEditor);

        windowList[3].add(noTeamsAlert);
        windowList[3].add(playerAddedAlert);
        windowList[3].add(checkPlayerInfoAlert);
        windowList[3].add(checkPlayerStatsAlert);
        windowList[3].add(existingJerseyNumberAlert);

        windowList[3].add(new WindowChangePicture("teamEditorBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));

        windowList[3].add(new TextArea("hittingStatsLabel", "HITTING STATS", 1250, 10, 700, 100, standardBgColor, bigFont, Color.BLACK, true));
        windowList[3].add(new TextArea("pitchingStatsLabel", "PITCHING STATS", 1250, 850, 700, 100, standardBgColor, bigFont, Color.BLACK, true));

        windowList[3].add(new TextArea("firstnameLabel", "First Name", 180, 470, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(firstNameField);
        windowList[3].add(new TextArea("lastnameLabel", "Last Name", 180, 690, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(lastNameField);
        windowList[3].add(new TextArea("jerseynumLabel", "Jersey Number", 130, 910, 500, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(jerseyNumField);

        windowList[3].add(new TextArea("gamesPlayedLabel", "Games Played", 700, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(gamesPlayedField);
        windowList[3].add(new TextArea("plateAppsLabel", "Plate Apps", 1160, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(plateAppsField);
        windowList[3].add(new TextArea("runsLabel", "Runs", 1560, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(runsField);
        windowList[3].add(new TextArea("hitsLabel", "Hits", 1920, 120, 100, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(hitsField);
        windowList[3].add(new TextArea("singlesLabel", "Singles", 2230, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(singlesField);

        windowList[3].add(new TextArea("doublesLabel", "Doubles", 840, 400, 200, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(doublesField);
        windowList[3].add(new TextArea("triplesLabel", "Triples", 1260, 400, 200, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(triplesField);
        windowList[3].add(new TextArea("homerunsLabel", "Homeruns", 1650, 400, 200, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(homerunsField);
        windowList[3].add(new TextArea("rbiLabel", "RBIs", 2080, 400, 200, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(rbisField);

        windowList[3].add(new TextArea("walksLabel", "Walks", 860, 680, 200, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(walksField);
        windowList[3].add(new TextArea("hbpLabel", "HBPs", 1260, 680, 200, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(hbpsField);
        windowList[3].add(new TextArea("strikeoutsLabel", "Strikeouts", 1580, 680, 200, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(strikeoutsField);
        windowList[3].add(new TextArea("stolenbasesLabel", "Stolen Bases", 2000, 680, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(stolenBasesField);

        windowList[3].add(new TextArea("inningLabel", "Innings", 750, 1000, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(inningsPitchedField);
        windowList[3].add(new TextArea("inningintructionsLabel", "(For partial innings, input 0.333 and 0.666 for 1 and 2 outs respectively)", 690, 1160, 700, 50, standardBgColor, tinyFont, Color.BLACK, true));
        windowList[3].add(new TextArea("runsgivenupLabel", "Runs Given Up", 1100, 1000, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(runsGivenUpField);
        windowList[3].add(new TextArea("strikeoutsagainstLabel", "Strikeouts", 1570, 1000, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(strikeoutsPitchedField);
        windowList[3].add(new TextArea("walksagainstLabel", "Walks", 1970, 1000, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(walksAllowedField);
        windowList[3].add(new TextArea("hitsagainstLabel", "Hits", 2300, 1000, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(hitsAllowedField);

        windowList[3].add(new AddPlayerButton("addPlayerButton", "addPlayerButton.png", 120, 1150, 304, 134, standardBgColor, this));

        // -----------------------------------------------------------------------------------------

        windowList[4] = new Window("Stat Manual", displayHeight, displayWidth, true);

        windowList[4].add(new WindowChangePicture("gameBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));
        windowList[4].add(new Picture("statManual", "statInstructions.png", 700, 500, 1073, 254));

        // -----------------------------------------------------------------------------------------

        windowList[5] = new Window("Stat Tracker", displayHeight, displayWidth, true);

        windowList[5].add(new WindowChangePicture("statBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));

        windowList[5].add(new Picture("teamStats", "teamStats.png", 725, 200, 1664, 182));
        windowList[5].add(new Picture("battingStats", "battingStats.png", 840, 800, 1427, 410));
        windowList[5].add(new Picture("pitchingStats", "pitchingStats.png", 700, 500, 1733, 170));

        NumberTextField[] textFieldArray = {
            new NumberTextField("Player GamesPlayed", 870, 910, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("At-Bats", 1100, 910, 180, 50, Color.WHITE, littleFont),
            new NumberTextField("Plate Appearances", 1320, 910, 220, 50, Color.WHITE, littleFont),
            new NumberTextField("Runs", 1580, 910, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Hits", 1820, 910, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Singles", 2050, 910, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Doubles", 870, 1020, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Triples", 1100, 1020, 180, 50, Color.WHITE, littleFont),
            new NumberTextField("Homeruns", 1320, 1020, 220, 50, Color.WHITE, littleFont),
            new NumberTextField("RBIs", 1580, 1020, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Walks", 1820, 1020, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("HBP", 2050, 1020, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Strikeouts", 870, 1140, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Stolen Bases", 1100, 1140, 180, 50, Color.WHITE, littleFont),
            new NumberTextField("Batting AVG", 1320, 1140, 220, 50, Color.WHITE, littleFont),
            new NumberTextField("On-Base%", 1580, 1140, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Slugging%", 1820, 1140, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("OPS", 2050, 1140, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Innings", 720, 605, 210, 50, Color.WHITE, littleFont),
            new NumberTextField("Runs Given Up", 960, 605, 210, 50, Color.WHITE, littleFont),
            new NumberTextField("ERA", 1200, 605, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Strikeouts", 1420, 605, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Walks", 1640, 605, 170, 50, Color.WHITE, littleFont),
            new NumberTextField("Hits", 1845, 605, 165, 50, Color.WHITE, littleFont),
            new NumberTextField("Whip", 2050, 605, 165, 50, Color.WHITE, littleFont),
            new NumberTextField("Hitter AVG", 2250, 605, 160, 50, Color.WHITE, littleFont),
            new NumberTextField("Team Games Played", 750, 315, 200, 50, Color.WHITE, littleFont),
            new NumberTextField("Wins", 980, 315, 190, 50, Color.WHITE, littleFont),
            new NumberTextField("Losses", 1200, 315, 230, 50, Color.WHITE, littleFont),
            new NumberTextField("Winning%", 1470, 315, 200, 50, Color.WHITE, littleFont),
            new NumberTextField("Runs Scored", 1700, 315, 205, 50, Color.WHITE, littleFont),
            new NumberTextField("Runs Against", 1935, 315, 200, 50, Color.WHITE, littleFont),
            new NumberTextField("Run Differential", 2170, 315, 200, 50, Color.WHITE, littleFont)
        };

        for (NumberTextField textField : textFieldArray) {
            windowList[5].add(textField);
        }

        teamNamesChooser = new DropdownChooser("TeamDropDown", 100, 200, 500, 50, standardBgColor, this, littleFont, false, null);
        playerNamesChooser = new DropdownChooser("PlayerDropDown", 100, 800, 500, 50, standardBgColor, this, littleFont, true, null);

        windowList[5].add(teamNamesChooser);
        windowList[5].add(playerNamesChooser);
        playerNamesChooser.getComponent().setVisible(true);
        teamNamesChooser.getComponent().setVisible(true);

    
        

        // -----------------------------------------------------------------------------------------

        changeWindow("Menu");
        frame.setVisible(true);
    }

    public static void initializeFrame(JFrame frame) {
        frame.setSize(screenSize);
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(standardBgColor);
        frame.setResizable(false);
    }

    public static void refresh() {
        frame.getContentPane().removeAll();
        frame.validate();
    }

    public void changeWindow(String windowID) throws IOException {
        
        Window bufferWindow = null;

        for (int i = 0; i < windowList.length; i++) {
            if (windowList[i].getID().equals(windowID)) {
                bufferWindow = windowList[i];
                break;
            }
        }

        refresh();
        frame.add(bufferWindow.getPanel());
        frame.revalidate();
        frame.repaint();
        currentWindow = bufferWindow;

        /*if (windowID.equals("Team Editor")) {
            teamNamesChooserEditor.updateTeamItems();
        }*/

    }

    public static void makeTimedVisible(VisualElement element) {
        element.makeVisible();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                element.makeInvisible();
            }
        };

        timer.schedule(task, 2000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        HashMap<Integer, Player> players = Main.getPlayers();
        HashMap<Integer, Team> teams = Main.getTeams();

        String command = e.getActionCommand();
        if (command.contains("CHANGE WINDOW ")) {
            command = command.replace("CHANGE WINDOW ", "");
            try {
                changeWindow(command);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    // CREATE TEAM
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (command.contains("EXTRACT TEAM NAME")) {
            String newTeamName = teamName.getText().trim();
            if (!newTeamName.equals("")) {
                

                for (HashMap.Entry<Integer, Team> entry : teams.entrySet()) { // Checks for Existing Team
                    Team team = entry.getValue();
                    if(team.getTeamName().trim().toLowerCase().equals(newTeamName.toLowerCase())){
                        makeTimedVisible(repeatTeamAlert);
                        return;
                    }
                }

                makeTimedVisible(teamCreationSuccessAlert);
                Main.createTeam(newTeamName); 
                teamName.emptyText();
            }
        }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (command.contains("SELECTED NAME")) {
            currentTeam = (String) teamNamesChooser.getComboBox().getSelectedItem();
            int currentTeamID = -1;
        
            if (Main.getTeams().isEmpty()) {
                System.out.println("NO TEAMS");
            } else {
                for (HashMap.Entry<Integer, Team> entry : teams.entrySet()) {
                    Team team = entry.getValue();
                    if (team.getTeamName().equals(currentTeam)) {
                        currentTeamID = team.getTeamID();
                        break;
                    }
                }
            }
        
            if (currentTeamID != -1) {
                HashMap<Integer, Player> selectedTeamRoster = teams.get(currentTeamID).getRosterHashMap();
                playerNamesChooser.updatePlayerItems(selectedTeamRoster);
                System.out.println("YAZ");
        
                // GETTING CURRENT PLAYER SELECTED
                //-----------------------------------------------------------------------------------------------------------------------------------------------------------
                currentPlayer = (String) playerNamesChooser.getComboBox().getSelectedItem();
        
                String[] currentPlayerPlaceHolder = currentPlayer.split(" ");
        
                String currentPlayerFirstName = currentPlayerPlaceHolder[0].trim();
                String currentPlayerLastName = currentPlayerPlaceHolder[1].trim();
        
                int currentPlayerID = -1;
        
                if (selectedTeamRoster.isEmpty()) {
                    System.out.println("NO PLAYERS");

                } else {
                    for (HashMap.Entry<Integer, Player> entry : selectedTeamRoster.entrySet()) {
                        Player player = entry.getValue();
                        if (player.getFirstName().equals(currentPlayerFirstName) && player.getLastName().equals(currentPlayerLastName)) {
                            currentPlayerID = player.getID();
                            break;
                        }
                    }
                }


            }
        }
    // ACTION ADD PLAYER (WINDOW 3)
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------
        else if(command.contains("ADD PLAYER")){
            
            int currentTeamID = -1;
            currentTeam = (String)teamNamesChooserEditor.getComboBox().getSelectedItem();
            if(Main.getTeams().isEmpty()){ // Defend against when there are no teams in the league
                System.out.println("NO TEAMS");
                makeTimedVisible(noTeamsAlert);
            }
            
            else{
                for (HashMap.Entry<Integer, Team> entry : teams.entrySet()) { // Finds Team ID based on team name
                    Team team = entry.getValue();
                    if(team.getTeamName().equals(currentTeam)){
                        currentTeamID = team.getTeamID();
                        break;
                    }
                }
            }
            
            if(currentTeamID != -1){ // Passed NO TEAMS Check

                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                int jerseyNum = jerseyNumField.getText().isEmpty() ? 0 : Integer.parseInt(jerseyNumField.getText());

                if(firstName.equals("") || lastName.equals("") || jerseyNum == 0){ // Checks for if Names / Jersey Num Empty
                    makeTimedVisible(checkPlayerInfoAlert);
                }

                for(HashMap.Entry<Integer, Player> entry : players.entrySet()) { // Checks for Same Jersey Number on Team
                    Player currentPlayer = entry.getValue();
                    if(currentPlayer.getJerseyNumber() == (jerseyNum)){
                        makeTimedVisible(existingJerseyNumberAlert);
                        return;
                    }
                }
                
                int gamesPlayed = gamesPlayedField.getText().isEmpty() ? 0 : Integer.parseInt(gamesPlayedField.getText());
                int plateAppearances = plateAppsField.getText().isEmpty() ? 0 : Integer.parseInt(plateAppsField.getText());

                int runs = runsField.getText().isEmpty() ? 0 : Integer.parseInt(runsField.getText());
                int hits = hitsField.getText().isEmpty() ? 0 : Integer.parseInt(hitsField.getText());
                int singles = singlesField.getText().isEmpty() ? 0 : Integer.parseInt(singlesField.getText());
                int doubles = doublesField.getText().isEmpty() ? 0 : Integer.parseInt(doublesField.getText());
                int triples = triplesField.getText().isEmpty() ? 0 : Integer.parseInt(triplesField.getText());
                int homeRuns = homerunsField.getText().isEmpty() ? 0 : Integer.parseInt(homerunsField.getText());

                int rbis = rbisField.getText().isEmpty() ? 0 : Integer.parseInt(rbisField.getText());
                int walks = walksField.getText().isEmpty() ? 0 : Integer.parseInt(walksField.getText());

                int hitByPitch = hbpsField.getText().isEmpty() ? 0 : Integer.parseInt(hbpsField.getText());
                int strikeouts = strikeoutsField.getText().isEmpty() ? 0 : Integer.parseInt(strikeoutsField.getText());
                int stolenBases = stolenBasesField.getText().isEmpty() ? 0 : Integer.parseInt(stolenBasesField.getText());

                double inningsPitched = inningsPitchedField.getText().isEmpty() ? 0.0 : Double.parseDouble(inningsPitchedField.getText());
                int runsGivenUp = runsGivenUpField.getText().isEmpty() ? 0 : Integer.parseInt(runsGivenUpField.getText());
                int strikeoutsPitched = strikeoutsPitchedField.getText().isEmpty() ? 0 : Integer.parseInt(strikeoutsPitchedField.getText());
                int walksAllowed = walksAllowedField.getText().isEmpty() ? 0 : Integer.parseInt(walksAllowedField.getText());
                int hitsAllowed = hitsAllowedField.getText().isEmpty() ? 0 : Integer.parseInt(hitsAllowedField.getText());

                // Checks for VALIDITY Of Stats
                if((singles + doubles + triples + homeRuns) != hits || (walks + strikeouts + hitByPitch + hits) != plateAppearances){
                    makeTimedVisible(checkPlayerStatsAlert);
                    return;
                }

                // Generates ID for New Player
                int playerID = Main.generatePlayerID();

                // Instantiates New Player Object
                Player newPlayer = new Player(firstName, lastName, playerID, currentTeamID, jerseyNum, gamesPlayed, plateAppearances, runs,
                hits, singles, doubles, triples, homeRuns, rbis, walks, hitByPitch, strikeouts, stolenBases,
                runsGivenUp, strikeoutsPitched, walksAllowed, hitsAllowed, inningsPitched);

                Main.addPlayer(playerID, newPlayer); 
                makeTimedVisible(playerAddedAlert);
            }
            
        }

        //EXIT CODE / SAVE FILE
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------
        else if (command.contains("EXIT")) {
            FileWriterTeam.writer("teams.csv");
            FileWriterPlayer.writer("players.csv");
            frame.dispose();
        }
    }
}