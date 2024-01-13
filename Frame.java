
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Frame extends JFrame {
    
    Frame () {
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JLabel title = placeImage("title.png", 771, 400);
        this.add(title);

        JLabel startIcon = placeImage("startIcon.png", 1050, 220);
        this.add(startIcon);

        JLabel startButton = placeImage("startButton.png", 1167, 720);
        this.add(startButton);

        // Default frame setup
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

    public JLabel placeImage(String file, int x, int y) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenHeight = screenSize.getHeight();
        double screenWidth = screenSize.getWidth();
        
        // JLabel label = new JLabel();
        ImageIcon image = new ImageIcon(file);
        
        int resizedWidth = (int)(image.getIconWidth()*(screenWidth/2560));
        int resizedHeight = (int)(image.getIconHeight()*(screenHeight/1440));

        try {
            BufferedImage tempImage = ImageIO.read(getClass().getResource(file));
            Image resizedImage = tempImage.getScaledInstance(resizedWidth, resizedHeight, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(resizedImage));

            label.setBounds((int)(x*(screenWidth/2560)), (int)(y*(screenHeight/1440)), resizedWidth, resizedHeight);

            return label;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}