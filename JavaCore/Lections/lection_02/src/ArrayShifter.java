public class ArrayShifter {

    private int adjustmentOffset(int[] array, int offset) {
        return Math.abs(offset) % array.length;
    }

    private int[] leftShiftOneMove (int[] array, int offset) {
        offset = adjustmentOffset(array, offset);
        int[] temp = new int[offset];

        for (int i = 0; i < offset; i++) {
            temp[i] = array[i];
        }

        for (int i = 0; i < array.length - offset; i++) {
            array[i] = array[i + offset];
        }

        for (int i = array.length - offset; i < array.length; i++) {
            array[i] = temp[i - (array.length - offset)];
        }

        return array;
    }

    private int[] rightShiftOneMove (int[] array, int offset) {
        offset = adjustmentOffset(array, offset);
        int[] temp = new int[offset];

        for (int i = 0; i < offset; i++) {
            temp[i] = array[(array.length - offset) + i];
        }

        for (int i = array.length - 1; i >= offset; i--) {
            array[i] = array[i - offset];
        }

        for (int i = 0; i < offset; i++) {
            array[i] = temp[i];
        }

        return array;
    }

    private int[] leftShiftOneByOne(int[] array, int offset) {
        int temp;

        for (int i = 0; i < offset; i++) {
            temp = array[0];
            int j;

            for (j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }

            array[j] = temp;
        }

        return array;
    }

    public int[] shift(int[] array, int offset) {
        if (offset < 0) {
            return leftShiftOneMove(array, offset);
        } else if(offset > 0) {
            return rightShiftOneMove(array, offset);
        } else {
            return array;
        }
    }

}
