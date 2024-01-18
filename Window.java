import java.awt.*;
import javax.swing.*;

public class Window {
    
    public static Color backgroundColor = new Color(28,145,163);

    protected JPanel window;
    private String id;
    private int width;
    private int height;

    public Window(String id, int height, int width) {
        window = new JPanel();
        window.setLayout(null);
        
        this.id = id;
        this.width = width;
        this.height = height;

        window.setBounds(0, 0, height, width);
        window.setBackground(backgroundColor);

    }

    public void add(Component component) {
        window.add(component);
        window.setVisible(true);
    }

    public String getID() {
        return id;
    }

    public JPanel getPanel() {
        return window;
    }
}
