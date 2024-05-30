import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product apple = new Product("apple", 20, LocalDate.now());
        Product orange = new Product("orange", 56, LocalDate.now());
        Product watermelon = new Product("watermelon", 100 , LocalDate.now());

        List<Product> productList = new ArrayList<>(List.of(apple, orange, watermelon));

        ProductMachine productMachine = new ProductMachine();
        productMachine.addProducts(productList);

        System.out.println(String.format("\n Это яблоко: %s", productMachine.getProduct("apple")));
        System.out.println(String.format("\n Это яблоко: %s", productMachine.getProduct("orange")));
        System.out.println(String.format("\n Это яблоко: %s", productMachine.getProduct("watermelon")));
    }
}
