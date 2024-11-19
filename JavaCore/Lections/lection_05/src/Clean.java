import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Clean {
    public static void main(String[] args) {
        List<Path> paths = new ArrayList<>();
        paths.add(Paths.get("file_01.txt"));
        paths.add(Paths.get("file_02.txt"));
        paths.add(Paths.get("file_03.txt"));

        paths.forEach(p -> {
            try {
                Files.delete(p);
            } catch (NoSuchFileException e){
                System.out.println(e.getFile() + " does not exist");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
