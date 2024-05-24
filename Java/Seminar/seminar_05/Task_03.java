// Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет. 
// Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
// повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования. (Например, add - egg изоморфны)
// буква может не меняться, а остаться такой же. (Например, note - code)


import java.util.HashMap;
import java.util.Map;

public class Task_03 {

    public static void main(String[] args) {
        String firstString = "мфффеыва";
        String secondString = "фмммэждл";
        
        System.out.println(isStringsIsomorph(firstString, secondString));

    }

    public static boolean isStringsIsomorph(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) return false;

        Map<Character, Character> letters = new HashMap<>();

        for (int i = 0; i < firstString.length(); i++) {
            if (letters.containsKey(firstString.charAt(i))) {
                if (letters.get(firstString.charAt(i)) != secondString.charAt(i)) return false;
                continue;
            } else if (letters.containsValue(secondString.charAt(i))) {
                return false;
            }

            letters.put(firstString.charAt(i), secondString.charAt(i));
        }

        System.out.println(letters);

        return true;
    }
}