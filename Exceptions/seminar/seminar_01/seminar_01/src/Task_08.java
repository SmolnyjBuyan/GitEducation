public class Task_08 {
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1}, {1,0,1}, {0,1}, {0}};
        System.out.println(isTrue(matrix));
    }

    public static boolean isTrue(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != matrix.length - i) return false;
        }
        return true;
    }
}
