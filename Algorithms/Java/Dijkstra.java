import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Integer infinity = Integer.MAX_VALUE;
        Map<String, Integer> costs = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        ArrayList<String> processed = new ArrayList<>();

        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 4);
        
        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);

        graph.put("fin", new HashMap<>());

        System.out.println(graph.get("start").get("a"));
        System.out.println(graph.get("start").get("b"));
        System.out.println(graph.get("a").get("fin"));
        System.out.println(graph.get("start"));
        System.out.println(graph.get("fin").keySet());
        System.out.println(graph);
        System.out.println(processed);

        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", infinity);

        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);
        
        




    }

    // public static String findLowestCostNode(Map<String,Integer> nodes) {
    //     return node;
    // }
}