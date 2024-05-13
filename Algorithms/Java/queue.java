import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class queue {
    public static void main(String[] args) {
        Map<String, String[]> graph = new HashMap<>();

        graph.put("you", new String[]{"alice", "bob", "claire"});
        graph.put("alice", new String[]{"peggy"});
        graph.put("bob", new String[]{"anuj", "peggy"});
        graph.put("claire", new String[]{"thom", "jonny"});
        graph.put("annuj", null);
        graph.put("peggy", null);
        graph.put("thom", null);
        graph.put("johny", null);

        Deque<String> searchQue = new ArrayDeque<>();
        Set<String> searched = new HashSet<>();

        searchQue.add("you");
        boolean isThere = false;
        while (!searchQue.isEmpty()) {
            String person = searchQue.pollFirst();

            if (personIsSeller(person)) {
                System.out.println(person + " is a mango seller");
                isThere = true;
            } else {
                String[] friends = graph.get(person);
                if (friends == null) continue;
                for (String friend : friends) {
                    if (friend != null && !searched.contains(friend)) {
                        searched.add(friend);
                        searchQue.addLast(friend);
                    }
                }
            }
            System.out.println("Множество" + searched);
        }
        if (isThere == false) {
            System.out.println("There is no mango seller");
        }
    }

    public static boolean personIsSeller(String name) {
        return name == "peggy";
    }

}
