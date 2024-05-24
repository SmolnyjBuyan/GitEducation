// Вы работаете с приложением для учета имен пользователей. Ваша задача - разработать программу, которая принимает на вход пять имен пользователей
// (или использует имена по умолчанию, если аргументы не предоставлены) и подсчитывает, сколько раз каждое имя встречается.
// Программа должна использовать HashMap для хранения имен и их количества вхождений.
// По завершении, программа выводит результат в виде пар "имя - количество".

import java.util.HashMap;

public class Task_02 {
    public static void main(String[] args) {
        NamesCounter nm = new NamesCounter();

        nm.addName("Серега");
        nm.addName("Серега");
        nm.addName("Серега");
        nm.addName("Серега");
        nm.addName("Серега");
        nm.addName("Столяр");
        nm.addName("Столяр");
        nm.addName("Столяр");
        nm.showNamesOccurrences();
    }
}

class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    public void addName(String name) {
        if (names.containsKey(name)) {
            names.put(name, names.get(name) + 1);
        } else {
            names.put(name, 1);
        }
    }

    public void showNamesOccurrences() {
        System.out.println(names);
    }
}
