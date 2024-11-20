import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Contain {
    public static void main(String[] args) {
        String lyricsEnd = "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n";

        System.out.println(containsIgnoreCase("tell", Paths.get("file_01.txt")));
    }

    public static boolean containsIgnoreCase(String word, String text) {
        if (word == null || text == null) return false;
        if (word.isEmpty()) return true;

        for (int i = 0; i < text.length() - word.length(); i++) {
            if (text.regionMatches(true, i, word, 0, word.length())) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsIgnoreCase(String word, Path fileName) {
        if (!Files.exists(fileName)) return false;
        List<String> lines;

        try {
            lines = Files.readAllLines(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines.stream().anyMatch(s -> containsIgnoreCase(word, s));
    }
}
