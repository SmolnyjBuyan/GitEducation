package comparatorTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Comparator<List<Long>> comparator = Comparator.comparing(list -> Integer.valueOf(list.size()));
        // Comparator<List<Long>> comparator = (list1, list2) ->
        // (Integer.valueOf(list1.size())).compareTo(list2.size());

        List<Long> first = List.of(453654L, 23432432L, 43543543L);
        List<Long> fourth = List.of(453654L, 23432432L, 43543543L, 324345634L);
        List<Long> second = List.of(453654L, 23432432L);
        List<Long> third = List.of(453654L);

        List<List<Long>> lists = new ArrayList<>();
        lists.add(first);
        lists.add(second);
        lists.add(third);
        lists.add(fourth);

        System.out.println(lists);

        Collections.sort(lists, comparator);
        System.out.println(lists);

        Set<List<Long>> msgSet = new TreeSet(comparator);
        msgSet.add(first);
        msgSet.add(second);
        msgSet.add(third);
        msgSet.add(fourth);

        System.out.println("Это TreeSet: ");
        System.out.println(msgSet);
    }
}
