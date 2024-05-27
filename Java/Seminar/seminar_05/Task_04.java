// Написать программу, определяющую правильность расстановки скобок в выражении.
// Пример 1: a+(d*3) - истина
// Пример 2: [a+(1*3) - ложь
// Пример 3: [6+(3*3)] - истина
// Пример 4: {a}[+]{(d*3)} - истина
// Пример 5: <{a}+{(d*3)}> - истина
// Пример 6: {a+]}{(d*3)} - ложь


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Task_04 {
    public static void main(String[] args) {
        String expression = "{a+]}{(d*3)}";

        System.out.println(isRight(expression));
    }

    public static boolean isRight(String expression) {
        Map<Character, Character> brackets = new HashMap<>(Map.of('{', '}', '(', ')', '[', ']', '<', '>'));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < expression.length(); i++) {
            if (brackets.containsKey(expression.charAt(i))) {
                stack.addFirst(expression.charAt(i));
            } else if (brackets.containsValue(expression.charAt(i))) {
                if (expression.charAt(i) != brackets.get(stack.pollFirst())) {
                    return false;
                }
            }
        }

        if (stack.pollFirst() != null) {
            return false;
        }

        return true;
    }
}
