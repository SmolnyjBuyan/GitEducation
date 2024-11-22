import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Task01 {
    public static void main(String[] args) {
        backup(".");
    }

    public static void backup(String dirName) {
        createBackupDir();

        try (Stream<Path> stream = Files.list(Paths.get(dirName))) {
            stream.filter(p -> !Files.isDirectory(p)).forEach(p -> {
                try {
                    Files.copy(p, Paths.get("./backup/" + p.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (NotDirectoryException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createBackupDir() {
        Path backupDir = Paths.get("backup");
        if (Files.exists(backupDir)) return;
        try {
            Files.createDirectory(backupDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
