// Дан LinkedList с несколькими элементами разного типа.
// В методе revert класса LLTasks реализуйте разворот этого списка без использования встроенного функционала.

// Дан 
// [1, One, 2, Two]

// // Вывод
// [1, One, 2, Two]
// [Two, 2, One, 1]

import java.util.LinkedList;

public class Task_01 {

    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();
        ll.add(1);
        ll.add("One");
        ll.add(2);
        ll.add("Two");

        System.out.println(ll);
        System.out.println(LLTasks.revert(ll));
    }
}

class LLTasks {
    public static LinkedList<Object> revert(LinkedList<Object> ll) {
        LinkedList<Object> result = new LinkedList<>();
        int length = ll.size();

        for (int i = 0; i < length; i++) {
            result.add(ll.pollLast());
        }

        return result;
    }
}