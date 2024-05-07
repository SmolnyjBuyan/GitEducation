public class sum {
    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 6};

        long startTime = System.nanoTime();
        System.out.println(sumOfElements(array));
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;
        System.out.println(timeElapsed);
    }

    private static int sumOfElements(int[] array) {
        return sumOfElements(array, 0);
    }
    private static int sumOfElements(int[] array, int index) {
        if (array.length == index) return 0;  

        return array[index] + sumOfElements(array, index + 1);
    }
}
