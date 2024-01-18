import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Application implements ActionListener {

    public static final int windowCount = 6;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static JFrame frame;
    public static int displayHeight = screenSize.height;
    public static int displayWidth = screenSize.width;

    public static Window[] windowList = new Window[windowCount];
    public static Window currentWindow;

    public static Color standardBgColor = new Color(28,145,163);

    public static Font titleFont = new Font("Osaka", Font.BOLD, 50);
    public static Font subtitleFont = new Font("Osaka", Font.BOLD, 30);

    public static TextField teamName = new TextField("teamNameField", 1130, 600, 300, 80, Color.WHITE, subtitleFont);

    public void runApplication() throws IOException {
        frame = new JFrame("Softball Tracker!");
        initializeFrame(frame);

        // -----------------------------------------------------------------------------------------

        windowList[0] = new Window("Start Screen", displayHeight, displayWidth);

        windowList[0].add(new Picture("startTitle", "title.png", 771, 400, 1018, 221));
        windowList[0].add(new Picture("startBall", "startIcon.png", 1050, 220, 660, 371));
        windowList[0].add(new WindowChangePicture("startButton", "startButton.png", 1167, 720, 225, 96, standardBgColor, "Menu", this));

        // -----------------------------------------------------------------------------------------

        windowList[1] = new Window("Menu", displayHeight, displayWidth);

        windowList[1].add(new WindowChangePicture("teamCreatorButton", "createTeamButton.png", 1138, 300, 284, 70, standardBgColor, "Team Creator", this));
        windowList[1].add(new WindowChangePicture("teamEditorButton", "editTeamButton.png", 1138, 500, 284, 70, standardBgColor, "Team Editor", this));
        windowList[1].add(new WindowChangePicture("statEditorButton", "statEditorButton.png", 1138, 700, 284, 70, standardBgColor, "Stat Editor", this));
        windowList[1].add(new WindowChangePicture("statTrackerButton", "statTrackerButton.png", 1138, 900, 284, 70, standardBgColor, "Stat Tracker", this));

        // -----------------------------------------------------------------------------------------

        windowList[2] = new Window("Team Creator", displayHeight, displayWidth);

        windowList[2].add(new WindowChangePicture("teamCreatorBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));
        windowList[2].add(teamName);
        windowList[2].add(new TextArea("teamNameLabel", "TEAM NAME", 1130,500, 500, 200, standardBgColor, titleFont, Color.BLACK));
        windowList[2].add(new TeamExtractPicture("createTeamButton", "createTeamActionButton.png", 1168, 700, 224, 74, standardBgColor, this));

        
        // -----------------------------------------------------------------------------------------

        windowList[3] = new Window("Team Editor", displayHeight, displayWidth);

        windowList[3].add(new WindowChangePicture("teamEditorBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));

        // -----------------------------------------------------------------------------------------

        windowList[4] = new Window("Stat Editor", displayHeight, displayWidth);

        windowList[4].add(new WindowChangePicture("gameBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));

        // -----------------------------------------------------------------------------------------

        windowList[5] = new Window("Stat Tracker", displayHeight, displayWidth);

        windowList[5].add(new WindowChangePicture("statBackButton", "backButton.png", 50, 50, 200, 95, standardBgColor, "Menu", this));

        // -----------------------------------------------------------------------------------------

        changeWindow("Start Screen");
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

    public static void changeWindow(String windowID) {
        
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.contains("CHANGE WINDOW ")) {
            command = command.replace("CHANGE WINDOW ", "");
            changeWindow(command);
        }

        else if (command.contains("EXTRACT TEAM NAME")) {
            String newTeamName = teamName.getText();
            teamName.emptyText();
        }
    }
}
