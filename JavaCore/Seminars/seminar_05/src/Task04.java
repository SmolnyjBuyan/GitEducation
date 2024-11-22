import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task04 {
    public static void main(String[] args) {
       printFiles(".");
    }

    private static void printFiles(String dirName, String indent) {
        try (Stream<Path> stream = Files.list(Paths.get(dirName))) {
            stream.forEach(f -> printFile(f, indent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFile(Path path, String indent) {
        System.out.println(indent + path);
        if (Files.isDirectory(path)) {
            printFiles(path.toString(), indent + "\t");
        }
    }

    private static void printFiles(String dirName) {
        printFiles(dirName, "");
    }
}
