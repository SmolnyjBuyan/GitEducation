import java.util.*;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<String>(List.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));

        Map<String, Set<String>> stations = new HashMap<String, Set<String>>();
        stations.put("kone", new HashSet<String>(List.of("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<String>(List.of("wa", "id", "mt")));
        stations.put("kthree", new HashSet<String>(List.of("or", "nv", "ca")));
        stations.put("kfour", new HashSet<String>(List.of("nv", "ut")));
        stations.put("kfive", new HashSet<String>(List.of("ca", "az")));

        Set<String> finalStations = new HashSet<String>();

        String bestStation = null;
        Set<String> statesCovered = new HashSet<>();

        while (!statesNeeded.isEmpty()) {
            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                entry.getValue().retainAll(statesNeeded);
                if (entry.getValue().size() > statesCovered.size()) {
                    statesCovered = entry.getValue();
                    bestStation = entry.getKey();
                }
            }
            finalStations.add(bestStation);
            statesNeeded.removeAll(statesCovered);
        }

        System.out.println(finalStations);
    }
}
