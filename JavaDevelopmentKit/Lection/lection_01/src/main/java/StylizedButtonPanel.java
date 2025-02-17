import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StylizedButtonPanel extends JPanel {
    public StylizedButtonPanel(LayoutManager layout, String title) {
        super(layout);
        setBorder(BorderFactory.createTitledBorder(null, title,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 20)));
    }
}
