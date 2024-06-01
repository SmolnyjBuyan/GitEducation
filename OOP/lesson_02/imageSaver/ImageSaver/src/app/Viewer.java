package app;

import pictures.Image;
import pictures.extensions.ImageFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Viewer {
    private List<Image> pictures;
    private int index;

    public Viewer() {
        pictures = new ArrayList<Image>();
        index = -1;
    }

    public void newFile(String fileName, String filePath) {
        pictures.add(new Image(fileName, filePath));
        index ++;
    }

    public Image getCurrentPicture() {
        return pictures.get(index);
    }

    public void SaveAs(String path, ImageFormat format) throws IOException {
        format.SaveAs(pictures.get(index), path);
    }
}
