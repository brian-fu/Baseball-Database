import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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

    // Public componenets
    public static TextField teamName = new TextField("teamNameField", 1130, 600, 300, 80, Color.WHITE, littleFont);
    public static TextArea repeatTeamAlert = new TextArea("repeatTeamAlert", "Team name is already used in this league!", 890,800, 900, 200, standardBgColor, littleFont, Color.BLACK, false);

    public static ArrayList<String> teamList = new ArrayList<String>();

    public DropdownChooser teamNamesChooser;

    public static String currentTeam;

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

        windowList[1].add(new WindowChangePicture("teamCreatorButton", "createTeamButton.png", 1138, 300, 284, 70, standardBgColor, "Team Creator", this));
        windowList[1].add(new WindowChangePicture("teamEditorButton", "editTeamButton.png", 1138, 500, 284, 70, standardBgColor, "Team Editor", this));
        windowList[1].add(new WindowChangePicture("statEditorButton", "statEditorButton.png", 1138, 700, 284, 70, standardBgColor, "Stat Editor", this));
        windowList[1].add(new WindowChangePicture("statTrackerButton", "statTrackerButton.png", 1138, 900, 284, 70, standardBgColor, "Stat Tracker", this));

        // -----------------------------------------------------------------------------------------

        windowList[2] = new Window("Team Creator", displayHeight, displayWidth, false);

        windowList[2].add(new WindowChangePicture("teamCreatorBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));
        windowList[2].add(teamName);
        windowList[2].add(new TextArea("teamNameLabel", "TEAM NAME", 1080,500, 500, 200, standardBgColor, bigFont, Color.BLACK, true));
        windowList[2].add(new TeamExtractPicture("createTeamButton", "createTeamActionButton.png", 1168, 700, 224, 74, standardBgColor, this));
        windowList[2].add(repeatTeamAlert);
        
        // -----------------------------------------------------------------------------------------

        windowList[3] = new Window("Team Editor", displayHeight, displayWidth, true);

        windowList[3].add(new WindowChangePicture("teamEditorBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));
        windowList[3].add(new TextArea("gamesPlayedLabel", "Games Played", 700, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(new NumberTextField("gamesPlayed", 690, 180, 300, 70, Color.WHITE, littleFont));
        windowList[3].add(new TextArea("plateAppsLabel", "Plate Apps", 1160, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(new NumberTextField("plateApps", 1140, 180, 250, 70, Color.WHITE, littleFont));
        windowList[3].add(new TextArea("runsLabel", "Runs", 1560, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(new NumberTextField("runs", 1510, 180, 200, 70, Color.WHITE, littleFont));
        windowList[3].add(new TextArea("hitsLabel", "Hits", 1920, 120, 100, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(new NumberTextField("hits", 1860, 180, 200, 70, Color.WHITE, littleFont));
        windowList[3].add(new TextArea("singlesLabel", "Singles", 2230, 120, 300, 50, standardBgColor, littleFont, Color.BLACK, true));
        windowList[3].add(new NumberTextField("singles", 1860, 180, 200, 70, Color.WHITE, littleFont));

        // -----------------------------------------------------------------------------------------

        windowList[4] = new Window("Stat Editor", displayHeight, displayWidth, true);

        windowList[4].add(new WindowChangePicture("gameBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));

        // -----------------------------------------------------------------------------------------

        windowList[5] = new Window("Stat Tracker", displayHeight, displayWidth, true);

        windowList[5].add(new WindowChangePicture("statBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));

        // -----------------------------------------------------------------------------------------

        changeWindow("Team Editor");
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


    public void teamEditorInitialize() {
        // EXTREMELY CHINESE WAY TO UPDATE THE DROP CHOOSER, but it works
        Component[] componentList = windowList[3].getPanel().getComponents();

        for (Component c : componentList) {

            if (c instanceof JComboBox) {
                windowList[3].getPanel().remove(c);
            }
        }

        teamNamesChooser = new DropdownChooser("teamNameChooser", 50, 300, 500, 100, Color.WHITE, this, teamList, bigFont);
        windowList[3].add(teamNamesChooser);
        frame.setVisible(true);
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

        if (windowID.equals("Team Editor")) {
            teamEditorInitialize();
        }
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

        else if (command.contains("EXTRACT TEAM NAME")) {
            String newTeamName = teamName.getText().trim();
            if (!newTeamName.equals("")) {
                for (int i = 0; i < teamList.size(); i++) {
                    if (teamList.get(i).equals(newTeamName)) {
                        makeTimedVisible(repeatTeamAlert);
                        return;
                    }
                }
                teamList.add(newTeamName); // Backend
                teamName.emptyText();
            }
        }

        else if (command.contains("SELECTED NAME")) {
            currentTeam = (String)teamNamesChooser.getComboBox().getSelectedItem(); // Backend
        }
    }
}
