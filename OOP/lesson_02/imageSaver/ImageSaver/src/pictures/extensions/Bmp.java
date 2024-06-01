package pictures.extensions;

import pictures.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Bmp extends ImageFormat {

    @Override
    public void SaveAs(Image image, String path) {
        try {
            ImageIO.write(image.getPicture(), "bmp", new File(String.format("%s%s.bmp", path, image.getFileName())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
