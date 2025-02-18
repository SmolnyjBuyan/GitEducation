import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StylizedPanel extends JPanel {
    public StylizedPanel(LayoutManager layout, String title) {
        super(layout);
        setBorder(BorderFactory.createTitledBorder(null, title,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20)));
    }
}
