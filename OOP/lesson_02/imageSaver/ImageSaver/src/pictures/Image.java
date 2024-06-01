package pictures;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    protected String fileName;
    protected String filePath;
    protected BufferedImage picture;

    public Image(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;

        try {
            picture = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showImage() {
        JLabel label = new JLabel(new ImageIcon(picture));

        JPanel jPanel = new JPanel();
        jPanel.add(label);

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(picture.getWidth(), picture.getHeight()));
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public BufferedImage getPicture() {
        return picture;
    }
}
