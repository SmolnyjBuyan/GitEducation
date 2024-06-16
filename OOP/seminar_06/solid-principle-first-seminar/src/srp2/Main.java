package srp2;

import srp2.model.Order;
import srp2.service.OrderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter order:");
        Order order = new Order("", "", 0, 0);
        OrderService service = new OrderService(order);
        service.inputFromConsole();
        service.saveToJson();
    }
}
