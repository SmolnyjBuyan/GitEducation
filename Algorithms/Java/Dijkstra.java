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

        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", infinity);

        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        System.out.println("graph: " + graph);
        System.out.println("costs: " + costs);
        System.out.println("parents: " + parents);
        System.out.println("processed: " + processed );
   
        String node = findLowestCostNode(costs, processed);

        while (node != null) {
            Integer cost = costs.get(node);
            Map<String, Integer> neighbours = graph.get(node);

            for (Map.Entry<String, Integer> entry : neighbours.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();

                Integer newCost = cost + value;
                if (costs.get(key) > newCost) {
                    costs.put(key, newCost);
                    parents.put(key, node);
                }
            }
            processed.add(node);

            System.out.println("graph: " + graph);
            System.out.println("costs: " + costs);
            System.out.println("parents: " + parents);
            System.out.println("processed: " + processed );

            node = findLowestCostNode(costs, processed);
        }
    }

    public static String findLowestCostNode(Map<String, Integer> costs, ArrayList<String> processed) {
        Integer lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (value < lowestCost && !processed.contains(key)) {
                lowestCost = value;
                lowestCostNode = key;
            } 
        }

        return lowestCostNode;
    }
}