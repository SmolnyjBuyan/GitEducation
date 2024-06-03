import products.Product;
import products.impl.*;
import products.impl.hotDrinksImpl.Coffee;
import products.impl.hotDrinksImpl.HotTea;
import products.impl.hotDrinksImpl.TypeOfCoffee;
import products.impl.hotDrinksImpl.TypeOfTea;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HotDrinkProductMachine productMachine = new HotDrinkProductMachine();

        System.out.println(productMachine.getProductList());

        Product tea = new HotTea("Greenfield", 50);
        Product blackTea = new HotTea("Tess", 50,
                Cup.SMALL.getVolume(), 70, true, true, TypeOfTea.BLACK.getType());
        Product americano = new Coffee(TypeOfCoffee.AMERICANO.getType(), 150,
                Cup.MEDIUM.getVolume(), 60, true, true);
        Product cappuccino = new Coffee(TypeOfCoffee.CAPPUCCINO.getType(), 140,
                Cup.SMALL.getVolume(), 65, true);
        Product hotChocolate = new HotDrink("Горячий шоколад", 125, Cup.LARGE.getVolume(), 50, true);

        productMachine.addProducts(List.of(tea, blackTea, americano, cappuccino, hotChocolate));

        productMachine.printProductList();

        productMachine.getProduct("Американо", Cup.MEDIUM.getVolume(), 60);

        productMachine.printProductList();

        productMachine.getProduct("Капучино", Cup.SMALL.getVolume(), 65);

        productMachine.printProductList();

        HotDrinkProductMachine secondProductMachine = new HotDrinkProductMachine
                (List.of(blackTea, blackTea, tea, tea, cappuccino, americano));

        secondProductMachine.printProductList();
        secondProductMachine.getProduct("Молоко");

    }
}
