package patterns.generating.factory.solution;

import java.util.HashMap;
import java.util.Map;

public class DB {
    private final static Map<String, String> DB = new HashMap<>();

    static {
        fillDB();
    }

    private static void fillDB() {
        DB.put("u", "1");
    }

    public static boolean contains(UserA u) {
        return DB.get(u.getLogin()).equals(u.getPassword());
    }
}
