// Создать список типа ArrayList<String>.
// Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.

import java.util.ArrayList;
import java.util.List;

public class task_02 {
    public static void main(String[] args) {

        ArrayList list = new ArrayList<String>();
        list.add(76);
        list.add("cat");
        list.add("volvo");
        list.add("dog");
        list.add(12);
        list.add(88);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) instanceof Integer) {
                list.remove(i);
            }
            
        }

        System.out.println(list); 
    }
}
