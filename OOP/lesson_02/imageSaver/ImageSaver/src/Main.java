import app.Viewer;
import pictures.Image;
import pictures.extensions.Bmp;
import pictures.extensions.Png;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Viewer viewer =  new Viewer();
        viewer.newFile("cat_2", "src/samples/cat_2.jpg");

        viewer.getCurrentPicture().showImage();

        viewer.SaveAs("src/samples/", new Png());
        viewer.SaveAs("src/samples/", new Bmp());
    }
}