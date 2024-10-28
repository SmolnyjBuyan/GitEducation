package Task_04;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(int i, int j) {
        super(STR."Неверный данные в ячейке [\{i},\{j}]");
    }
}
