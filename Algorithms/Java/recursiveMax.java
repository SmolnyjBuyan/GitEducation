public class recursiveMax {
    public static void main(String[] args) {
        int[] array = new int[] {29, 3, 28, 5, 6, 7, 5};
        
        System.out.println(findMax(array));
    }

    private static int findMax(int[] array) {
        return findMax(array, array.length - 1);
    }

    // private static int findMax(int[] array, int index) {
    //     if (index == 0) return array[index];

    //     if (array[index] > findMax(array, index - 1)) {
    //         return array[index];
    //     } else {
    //         return findMax(array, index - 1);
    //     }
        
    // }

    private static int findMax(int[] array, int index) {
        if (index == 0) return array[index];

        int max = findMax(array, index - 1); // {29, 3, 30, 5, 6, 7, 5}
        if (max > array[index]) {
            return max;
        } else {
            return array[index];
        }
    }
}
