public class Task_02 {
    public static void main(String[] args) {
        String[][] matrix = {{"10", "20"}, {"sd"}, {"10", "20", "78"}};
        System.out.println(sum2d(null));
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        try {
            for (String[] strings : arr) {
                for (String string : strings) {
                    int val;
                    try {
                        val = Integer.parseInt(string);
                    } catch (NumberFormatException e) {
                        val = 0;
                    }
                    sum += val;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Полученная матрица равна null, результатом операции будет 0");
        }

        return sum;
    }
}
