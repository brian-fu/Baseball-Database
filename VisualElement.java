import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class VisualElement {

    protected JComponent component;

    protected String type;
    protected String id;

    protected int xPosition;
    protected int yPosition;
    protected int height;
    protected int width;

    protected Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected double screenWidth = screenSize.getWidth();
    protected double screenHeight = screenSize.getHeight();

    protected Color background;

    public boolean isVisible() {
        return isVisible;
    }

    protected boolean isVisible;

    public VisualElement(String id, int xPosition, int yPosition, int width, int height, Color background) {
        this.id = id;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.width = width;
        this.background = background;
    }

    public void display() {
        component.setBounds(resizeHorizontal(xPosition, screenWidth), resizeVertical(yPosition, screenHeight), resizeHorizontal(width, screenWidth), resizeVertical(height, screenHeight));
        component.setBackground(background);

        component.validate();
        component.setVisible(isVisible);
    }

    public int resizeHorizontal(double initial, double frameSize) { // RESIZE ACCORDING TO 2560
        double ratio = frameSize/2560;
        return (int) (ratio*initial);
    }

    public int resizeVertical(double initial, double frameSize) { // RESIZE ACCORDING TO 1440
        double ratio = frameSize/1440;
        return (int) (ratio*initial);
    } 

    public void makeVisible() {
        isVisible = true;
        display();
    }

    public void makeInvisible() {
        isVisible = false;
        display();
    }
    
    public JComponent getComponent() {
        return component;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setBackground(Color background) {
        this.background = background;
    }  
}

class Picture extends VisualElement {

    protected JLabel image;
    protected Image resizedImage;

    public Picture(String id, String filePath, int xPosition, int yPosition, int width, int height) throws IOException {
        super(id, xPosition, yPosition, width, height, Color.WHITE);
        this.type = "Picture";

        BufferedImage tempImage = ImageIO.read(getClass().getResource(filePath));
        resizedImage = tempImage.getScaledInstance(resizeHorizontal(width, screenWidth), resizeVertical(height, screenHeight), Image.SCALE_SMOOTH);
        this.image = new JLabel(new ImageIcon(resizedImage));
        this.component = image;
        makeVisible();
    }

}

class InteractablePicture extends VisualElement {
    protected JButton imageButton;
    protected ImageIcon imageIcon;

    public InteractablePicture(String id, String filePath, int xPosition, int yPosition, int width, int height, Color bgColor, ActionListener actionListener) throws IOException {
        super(id, xPosition, yPosition, width, height, bgColor);
        this.type = "Interactable Picture";

        BufferedImage tempImage = ImageIO.read(getClass().getResource(filePath));
        Image resizedImage = tempImage.getScaledInstance(resizeHorizontal(width, screenWidth), resizeVertical(height, screenHeight), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);

        imageButton = new JButton(imageIcon);
        imageButton.addActionListener(actionListener);
        imageButton.setBorderPainted(false);
        this.component = imageButton;
        makeVisible();
    }
}

class TextField extends VisualElement {
    protected JTextField textField;

    public TextField(String id, int xPosition, int yPosition, int width, int height, Color bgColor, Font font) {
        super(id, xPosition, yPosition, width, height, bgColor);
        this.type = "Text Field";

        textField = new JTextField();
        textField.setFont(font);
        this.component = textField;
        makeVisible();
    }

    public String getText() {
        return textField.getText();
    }

    public void emptyText() {
        textField.setText(null);
    }
}

class NumberTextField extends VisualElement {
    protected JFormattedTextField numberTextField;
    protected NumberFormatter numberFormatter;

    public NumberTextField(String id, int xPosition, int yPosition, int width, int height, Color bgColor, Font font, String display, boolean fixed) {
        super(id, xPosition, yPosition, width, height, bgColor);
        this.type = "Number Text Field";

        numberFormatter = new NumberFormatter(NumberFormat.getInstance());
        numberTextField = new JFormattedTextField(numberFormatter);
        numberTextField.setFont(font);
        numberTextField.setValue(new Double(display));
        if (fixed) {
            numberTextField.setEditable(false);
        }
        this.component = numberTextField;
        makeVisible();
    }

    public NumberTextField(String id, int xPosition, int yPosition, int width, int height, Color bgColor, Font font) {
        super(id, xPosition, yPosition, width, height, bgColor);
        this.type = "Number Text Field";

        numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance()) {
            @Override
            public Object stringToValue(String text) throws ParseException {
                if (text.length() == 0) {
                    return null;
                }
                return super.stringToValue(text);
            }
        };
        numberFormatter.setAllowsInvalid(false);
        numberTextField = new JFormattedTextField(numberFormatter);
        numberTextField.setFont(font);
        this.component = numberTextField;
        makeVisible();
    }

    public String getText() {
        return numberTextField.getText();
    }
}

class TextArea extends VisualElement {
    protected JTextArea textArea;

    public TextArea(String id, String text, int xPosition, int yPosition, int width, int height, Color bgColor, Font font, Color textColor, boolean visible) {
        super(id, xPosition, yPosition, width, height, bgColor);
        this.type = "Text Area";

        textArea = new JTextArea(text);
        textArea.setFont(font);
        textArea.setForeground(textColor);
        textArea.setEditable(false);

        this.component = textArea;
        if (visible == true) {
            makeVisible();
        }
    }
}

class WindowChangePicture extends InteractablePicture {
    protected String targetWindow;

    public WindowChangePicture(String id, String filepath, int xPosition, int yPosition, int width, int height, Color bgColor, String targetWindow, ActionListener actionListener) throws IOException {
        super(id, filepath, xPosition, yPosition, width, height, bgColor, actionListener);
        this.type = "WindowChangePicture";
        this.targetWindow = targetWindow;

        imageButton.setActionCommand("CHANGE WINDOW " + targetWindow);
    }
}

class TeamExtractPicture extends InteractablePicture {
    public TeamExtractPicture(String id, String filepath, int xPosition, int yPosition, int width, int height, Color bgColor, ActionListener actionListener) throws IOException {
        super(id, filepath, xPosition, yPosition, width, height, bgColor, actionListener);
        this.type = "Extract Text Picture";

        imageButton.setActionCommand("EXTRACT TEAM NAME");
    }
}

class AddPlayerButton extends InteractablePicture {
    public AddPlayerButton(String id, String filepath, int xPosition, int yPosition, int width, int height, Color bgColor, ActionListener actionListener) throws IOException {
        super(id, filepath, xPosition, yPosition, width, height, bgColor, actionListener);
        this.type = "Add Player Button";

        imageButton.setActionCommand("ADD PLAYER");
    }
}

class ExitButton extends InteractablePicture {
    public ExitButton(String id, String filepath, int xPosition, int yPosition, int width, int height, Color bgColor, ActionListener actionListener) throws IOException {
        super(id, filepath, xPosition, yPosition, width, height, bgColor, actionListener);
        this.type = "Exit Button";

        imageButton.setActionCommand("EXIT");
    }
}

class InteractableObject extends VisualElement {

    protected ActionListener actionListener;

    public InteractableObject(String id, int xPosition, int yPosition, int width, int height, Color background, ActionListener actionListener) {
        super(id, xPosition, yPosition, width, height, background);
        this.type = "InteractableObject";
        this.actionListener = actionListener;
    }

}

class DropdownChooser extends InteractableObject {
    protected JComboBox<String> comboBox;
    protected String[] names;

    public DropdownChooser(String id, int xPosition, int yPosition, int width, int height, Color bgColor, ActionListener actionListener, ArrayList<String> list, Font font) {
        super(id, xPosition, yPosition, width, height, bgColor, actionListener);
        this.type = "Dropdown Chooser";

        names = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            names[i] = list.get(i);
        }

        comboBox = new JComboBox<String>(names);
        comboBox.setFont(font);
        comboBox.addActionListener(actionListener);
        comboBox.setActionCommand("SELECTED NAME");
        this.component = comboBox;
        makeVisible();
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }
}

class InteractableTextField extends InteractableObject {

    protected Font font;

    public InteractableTextField(String id, int xPosition, int yPosition, int width, int height, Color background, ActionListener actionListener, Font font) {
        super(id, xPosition, yPosition, width, height, background, actionListener);
        this.type = "InteractableTextField";
        this.font = font;
    }

}

class Button extends InteractableTextField {

    protected JButton button;

    public Button(String id, int xPosition, int yPosition, int width, int height, Color background, ActionListener actionListener,
            String text, Font font) {
        super(id, xPosition, yPosition, width, height, background, actionListener, font);

        this.type = "Button";
        this.button = new JButton(text);
        button.setBackground(background);
        button.setFont(font);
        button.addActionListener(actionListener);
        this.component = button;
        makeVisible();
    }

    public JButton getButton() {
        return button;
    }

    public ActionListener getAction() {
        return actionListener;
    }
}

class WindowChangeButton extends Button {
    protected String targetWindow;

    public WindowChangeButton(String id, int xPosition, int yPosition, int width, int height, Color background, ActionListener actionListener,
            String text, Font font, String targetWindow) {
        super(id, xPosition, yPosition, width, height, background, actionListener, text, font);
        this.type = "WindowChangeButton";
        this.targetWindow = targetWindow;
        button.setActionCommand("CHANGE WINDOW " + targetWindow);
        makeVisible();
    }

}