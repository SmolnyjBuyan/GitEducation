import javax.swing.*;
import java.awt.*;

public class StylizedRadioButton extends JRadioButton {
    public StylizedRadioButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 15));
    }

    public StylizedRadioButton(String text, boolean selected) {
        this(text);
        setSelected(selected);
    }
}
