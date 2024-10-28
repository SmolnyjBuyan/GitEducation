public class Task_03 {
    public static void main(String[] args) {
        System.out.println(expr(10, 2));
        printSum(10, 2);
    }

    public static double expr(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return (double) a / b;
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}
