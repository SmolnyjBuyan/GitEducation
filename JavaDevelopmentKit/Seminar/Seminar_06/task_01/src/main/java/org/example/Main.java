package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class Main {
    public static void main(String[] args) {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(new double[]{1, 2, 3, 4, 5});
        System.out.println(descriptiveStatistics.getMax());
        System.out.println(descriptiveStatistics.getMin());
        System.out.println(descriptiveStatistics.getSum());
        System.out.println(descriptiveStatistics.getMean());

        System.out.println(CombinatoricsUtils.factorial(5));
        System.out.println(ArithmeticUtils.lcm(9, 21));
        System.out.println(ArithmeticUtils.gcd(9, 21));
        System.out.println(ArithmeticUtils.isPowerOfTwo(128));
    }
}