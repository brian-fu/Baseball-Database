
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;

public class Frame extends JFrame {
    
    Frame () {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JLabel title = placeImage("title.png", 0.29, 0.27);
        this.add(title);

        JLabel startIcon = placeImage("startIcon.png", 0.409, 0.146);
        this.add(startIcon);

        JLabel startButton = placeImage("startButton3.png", 0.45, 0.5);
        this.add(startButton);

        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage()); // Change icon of frame
        this.getContentPane().setBackground(new Color(28,145,163)); // Change the color of background

        this.setTitle("Softball Tracker!"); // Title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exiting program when closing
        this.setResizable(false);
        this.setSize(screenSize); // Set the dimensions
        this.setLayout(null);
        this.setVisible(true); // Frame is visible
        
    }

    public JLabel placeImage(String file, double widthMultiplier, double heightMultiplier) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenHeight = screenSize.getHeight();
        double screenWidth = screenSize.getWidth();
        
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon(file);
        int imageWidth = image.getIconWidth();
        int imageHeight = image.getIconHeight();
        label.setIcon(image);
        label.setBounds((int)(screenWidth*widthMultiplier), (int)(screenHeight*heightMultiplier), imageWidth, imageHeight);
        
        return label;
    }
}