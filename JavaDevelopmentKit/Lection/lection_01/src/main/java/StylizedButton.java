import javax.swing.*;
import java.awt.*;

public class StylizedButton extends JButton {
    public StylizedButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 20));
    }
}
