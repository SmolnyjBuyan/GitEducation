package patterns.structural.wrappers.facade.solution;

public class Run {
    public static void main(String[] args) {
        Integer[] ints = new Integer[]{2, 4, 6, 1, 14, 2, -7, 66, 0, -555};
        Double[] doubles = new Double[]{31d, 3d, 5d, 55d, 12d, 47d, 0d, -1d, 125d, -15d};

        GBArrays<Integer> integerGBArrays = new GBArrays<>(ints);
        GBArrays<Double> doubleGBArrays = new GBArrays<>(doubles);

        integerGBArrays.sort();
        doubleGBArrays.sort();

        System.out.println(integerGBArrays.search(14));
        System.out.println(doubleGBArrays.search(47.0));
    }
}
