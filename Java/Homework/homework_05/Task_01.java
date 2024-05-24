// Напишите программу, представляющую телефонную книгу. Программа должна иметь следующие функции:

// add(String name, Integer phoneNum): Добавляет запись в телефонную книгу.
// Если запись с именем name уже существует, добавляет новый номер телефона в существующую запись.
// Если запись с именем name не существует, создает новую запись с этим именем и номером телефона phoneNum.

// find(String name): Поиск номеров телефона по имени в телефонной книге.
// Если запись с именем name существует, возвращает список номеров телефона для этой записи.
// Если запись с именем name не существует, возвращает пустой список.

// getPhoneBook(): Возвращает всю телефонную книгу в виде HashMap, где ключи - это имена, а значения - списки номеров телефона.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task_01 {

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Серега", 6755034);
        pb.add("Серега", 9998877);
        pb.add("Мама", 5640517);
        System.out.println(pb.getPhoneBook());
        System.out.println(pb.find("Серега"));
        System.out.println(pb.find("Мама"));
        System.out.println(pb.find("Андрцу"));
    }
}

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            phoneBook.put(name, new ArrayList<>(List.of(phoneNum)));
        }      
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        
        return new ArrayList<>();
    }

    public HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}