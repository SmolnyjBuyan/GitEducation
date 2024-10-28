public class Task_02 {
    public static void main(String[] args) {
        expr(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1);
    }

    public static double expr(int[] intArray, int d) {
        if (intArray.length < 9) {
            System.out.println("It's not possible to evaluate the expression - intArray[8] / d as there is no 8th element in the given array.");
            return Double.NaN;
        } else if (d == 0) {
            System.out.println("It's not possible to evaluate the expression - intArray[8] / d as d = 0.");
            return Double.NaN;
        }
//        System.out.println(STR."intArray[8] / d = \{intArray[8]} / \{d} = \{(double) intArray[8] / d}");
        System.out.printf("intArray[8] / d = %s / %s = %s", intArray[8], d, (double) intArray[8] / d);
        return (double) intArray[8] / d;
    }
}
