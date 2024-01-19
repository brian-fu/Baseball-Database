import java.awt.*;
import javax.swing.*;

public class Window {
    
    public static Color backgroundColor = new Color(28,145,163);

    protected JPanel window;
    private String id;
    private int width;
    private int height;

    private boolean initialize;

    public Window(String id, int height, int width, boolean initialize) {
        window = new JPanel();
        window.setLayout(null);
        
        this.id = id;
        this.width = width;
        this.height = height;
        this.initialize = initialize;

        window.setBounds(0, 0, height, width);
        window.setBackground(backgroundColor);

    }

    public void add(VisualElement visualElement) {
        // Check if visualElement and its component are not null before adding it to the panel
        if (visualElement != null && visualElement.getComponent() != null) {
            window.add(visualElement.getComponent());
        }
    }

    public String getID() {
        return id;
    }

    public JPanel getPanel() {
        return window;
    }

    public boolean getInitialize() {
        return initialize;
    }
}
