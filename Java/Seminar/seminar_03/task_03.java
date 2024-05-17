// Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
// что на 0-й позиции каждого внутреннего списка содержится название жанра,
// а на остальных позициях - названия книг.
// Напишите метод для заполнения данной структуры.

import java.util.ArrayList;
import java.util.List;

public class task_03 {
    public static void main(String[] args) {
        List<ArrayList<String>> catalog = new ArrayList<>();
        AddGenre("Ужасы", catalog);
        AddGenre("Комедия", catalog);
        AddGenre("Роман", catalog);

        System.out.println(catalog);
        System.out.println(isThere("Комедия", catalog));
        AddGenre("Комедия", catalog);
        AddBook("Роман", "Война и Мир", catalog);
        AddBook("Роман", "Война и Мир", catalog);
        AddBook("Комедия", "Толстый и тонкий", catalog);
        System.out.println(catalog);
    }

    private static void AddBook(String genre, String book, List<ArrayList<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).toLowerCase().trim().equals(genre.toLowerCase().trim())) {
                if (!list.get(i).contains(book)) {
                    list.get(i).add(book);
                    return;
                } else {
                    System.out.println("Такое произведение уже есть в каталоге");
                    return;
                }  
            }
        }
    System.out.println("Такого жанра нет в каталоге");
    }

    private static void AddGenre(String genre, List<ArrayList<String>> list) {
        if (isThere(genre, list)) {
            System.out.println("Такой жанр уже есть в каталоге");
        } else {
            ArrayList<String> newGenre = new ArrayList<>();
            newGenre.add(genre);
            list.add(newGenre);
        }
    }

    private static boolean isThere(String genre, List<ArrayList<String>> list) {
        for (ArrayList<String> arrayList : list) {
            if (arrayList.get(0).toLowerCase().trim().equals(genre.toLowerCase().trim())) {
                return true;
            }
        }

        return false;
    }   
}
