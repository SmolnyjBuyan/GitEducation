public class recursiveLength {
    private static int countElements(int[] array) {
        return countElements(array, 0);
    }

    private static int countElements(int[] array, int index) {
        if (index == array.length) return 0;

        return 1 + countElements(array, index + 1);
    }
    public static void main(String[] args) {
        int[] array = new int[] {2, 3, 4, 5, 6, 7, 8};

        System.out.println(countElements(array));
    }
}
