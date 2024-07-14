public class Task_01 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 5, 6, 7};
        System.out.println(checkArraysSize(array, 7));
    }

    public static int checkArraysSize(int[] array, int min) {
        return array.length < min ? -1 : array.length;
    }
}
