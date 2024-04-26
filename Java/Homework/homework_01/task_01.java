// Вычислить n-ое треугольного число(сумма чисел от 1 до n).

// Внутри класса Answer напишите метод countNTriangle, который принимает число n и возвращает его n-ое треугольное число.
// Если число n < 1 (ненатуральное) метод должен вернуть -1.

public class task_01 {

    public static void main(String[] args) {
        Answer answer = new Answer();
        int result = answer.countNTriangle(6);
        System.out.println(result);
    }
}

class Answer {

    public int countNTriangle(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }
}    