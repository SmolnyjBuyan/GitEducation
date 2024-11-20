import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Files.createFile(Paths.get("file_01.txt"));
        } catch (IOException e) {
            System.out.println("File already exists " + e.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file_01.txt", true))) {
            bufferedWriter.write("Never gonna give you up");
            bufferedWriter.newLine();
            bufferedWriter.write("Never gonna let you down");
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file_02.txt"))) {
            bufferedWriter.write("Never gonna run around and desert you");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String lyricsEnd = "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n";
        try {
            Files.write(Paths.get("file_03.txt"), lyricsEnd.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        concat("file_01.txt", "file_02.txt");
        concat("file_01.txt", "file_03.txt");
    }

    public static void concat(String filePath, String fileToAppendPath) {
        Path file = Paths.get(filePath);
        Path fileToAppend = Paths.get(fileToAppendPath);

        List<Path> paths = Arrays.asList(file, fileToAppend);
        for (Path path : paths) {
            if (!Files.isRegularFile(path)) {
                System.out.println(file + " does not exist");
                return;
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToAppendPath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}