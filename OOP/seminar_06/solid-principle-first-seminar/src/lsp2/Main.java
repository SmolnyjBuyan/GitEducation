package lsp2;

import lsp2.factory.OrderFactory;
import lsp2.model.Order;
import lsp2.model.OrderBonus;
import lsp2.util.OrderCalculator;

public class Main {
    public static void main(String[] args) {
        OrderFactory creator = new OrderFactory();
        OrderCalculator calculator = new OrderCalculator();
        calculator.add(creator.create(3, 2, false));
        calculator.add(creator.create(1, 3, true));

        for (Order order : calculator) {
            System.out.println(order);
        }

        System.out.printf("Order sum %d", calculator.calcAmount());

        Order order = new OrderBonus(1, 6);
        System.out.println("\n" + order);
        System.out.println(order.getAmount());
}
}
