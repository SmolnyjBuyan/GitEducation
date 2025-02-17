import javax.swing.*;
import java.awt.*;

public class StylizedLabel extends JLabel {
    public StylizedLabel(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 20));
    }
}
