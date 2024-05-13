import java.util.HashMap;

public class hashmapTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Андрей", 5);
        int grade = map.get("Андрей");
        map.put("Сергей", 5);
        System.out.println(map);
        System.out.println(grade);
        System.out.println(map.containsKey("Сергей"));

        if (map.containsKey("Андрей")) {
            System.out.println("Крутой мужик");
        }
    }
}