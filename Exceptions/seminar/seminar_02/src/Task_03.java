import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Task_03 {
    public static void main(String[] args) {
        createFile("Test.txt");
        editFile("Test.txt", """
                Анна=4
                Елена=5
                Марина=7
                Владимир=?
                Константин=?
                Иван=4""");

        Map<String, String> map = convertFileToHashMap("Test.txt");
        replaceUnsupportedSymbols(map);
        String result = convertMapToContent(map);
        editFile("Test.txt", result);
    }

    public static void createFile(String name) {
        File file = new File(name);
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editFile(String name, String text) {
        try {
            FileWriter fileWriter = new FileWriter(name, false);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public static Map<String, String> convertFileToHashMap(String name) {
        String content = "";
        Map<String, String> result = new HashMap<>();

        try {
            content = Files.readString(Path.of(name));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[] pairs = content.split("\n");
        for (String string : pairs) {
            String[] pair = string.split("=");
            if (pair.length != 2) {
                throw new IllegalArgumentException(STR."Неверные данные в строке \{string}");
            }
            result.put(pair[0], pair[1]);
        }
        return result;
    }

    public static void replaceUnsupportedSymbols(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("?")) {
                entry.setValue(STR."\{entry.getKey().length()}");
            } else {
                try {
                    Integer.parseInt(entry.getValue());
                } catch (NumberFormatException e) {
                    throw new NumberFormatException(STR."Неверный формат числа \{entry}");
                }
            }
        }
    }

    public static String convertMapToContent(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuilder.append(entry.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
