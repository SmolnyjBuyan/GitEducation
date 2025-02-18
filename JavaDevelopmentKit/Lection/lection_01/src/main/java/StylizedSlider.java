import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StylizedSlider extends JSlider {
    public StylizedSlider(int min, int max, int value) {
        super(min, max, value);
        setPaintLabels(true);
        setMajorTickSpacing(1);
        setFont(new Font("Arial", Font.BOLD, 15));
    }
}
