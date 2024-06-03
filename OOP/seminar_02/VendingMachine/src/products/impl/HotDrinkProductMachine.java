package products.impl;

import products.Product;
import products.ProductMachine;

import java.util.List;

public class HotDrinkProductMachine extends ProductMachine {
    @Override
    public void addProducts(List<Product> productList) {
        this.productList.addAll(productList);
    }

    public HotDrinkProductMachine() {
        super();
    }

    public HotDrinkProductMachine(List<Product> products) {
        super(products);
    }

    public Product getProduct(String name, float volume, int temperature) {
        for (Product product : productList) {
            if (product instanceof HotDrink) {
                if ((product).getName().equals(name)
                        && (((HotDrink)product).getVolume() == volume)
                        && (((HotDrink)product).getTemperature() == temperature)){
                    Product result = product;
                    productList.remove(product);
                    return result;
                }
            }
        }

        System.out.println("No such product: " + name + " " + volume + " л. " + temperature + " °C");
        return null;
    }
}
