package Task_03;

import java.io.FileNotFoundException;

public class FileNotExistException extends FileNotFoundException {
    public FileNotExistException() {
        super("Файл не существует");
    }
}
