import javax.swing.*;
import java.awt.*;

public class StylizedSlider extends JSlider {
    public StylizedSlider(int min, int max) {
        super(min, max);
        setPaintLabels(true);
        setMajorTickSpacing(1);
        setFont(new Font("Arial", Font.BOLD, 15));
    }
}
