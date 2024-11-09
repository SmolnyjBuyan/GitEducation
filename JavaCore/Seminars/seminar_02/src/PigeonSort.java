import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PigeonSort {
    int[] array;

    public PigeonSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Arrays.stream(array).forEach(s -> treeMap.put(s, treeMap.getOrDefault(s, 0) + 1));

        int i = 0;
        for (Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                array[i++] = entry.getKey();
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
