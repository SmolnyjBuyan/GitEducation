import products.Product;
import products.ProductMachine;
import products.impl.BottleOfWater;
import products.impl.EPackage;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Product apple = new Product("apple", 20, LocalDate.now());
//        Product orange = new Product("orange", 56, LocalDate.now());
//        Product watermelon = new Product("watermelon", 100 , LocalDate.now());
//
//        List<Product> productList = new ArrayList<>(List.of(apple, orange, watermelon));
//
//        ProductMachine productMachine = new ProductMachine();
//        productMachine.addProducts(productList);
//
//        System.out.println(String.format("\n Это яблоко: %s", productMachine.getProduct("apple")));
//        System.out.println(String.format("\n Это яблоко: %s", productMachine.getProduct("orange")));
//        System.out.println(String.format("\n Это яблоко: %s", productMachine.getProduct("watermelon")));

        Product bottle1 = new BottleOfWater("Родники", 55, LocalDate.of(2024, 5, 1));
        Product bottle2 = new BottleOfWater("Родники Газированная", 55, LocalDate.of(2024, 5, 1),
                0.5F ,EPackage.GLASS.getMaterial(),true);

        ProductMachine pm = new ProductMachine();

        System.out.println(pm.getProductList());

        pm.addProducts(List.of(bottle1, bottle1, bottle1, bottle2, bottle2, bottle2, bottle2));

        System.out.println(pm.getProductList());

        pm.getProduct("Родники");

        System.out.println(pm.getProductList());

    }
}
