import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task03 {
    public static void main(String[] args) {
        List<String> fileLines = getLines("task_01.txt");
        System.out.println(fileLines);

        fileLines = replace(fileLines,',', ';');
        System.out.println(fileLines);

        write(fileLines, "task_03.txt");

    }

    public static List<String> getLines(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public static List<String> replace(List<String> lines, char oldSymbol, char newSymbol) {
        return lines.stream().map(s -> s.replace(oldSymbol, newSymbol)).collect(Collectors.toList());
    }

    public static void write(List<String> lines, String fileName) {
        Path path = Paths.get(fileName);
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
