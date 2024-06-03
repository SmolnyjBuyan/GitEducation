package marketplace;

import products.Product;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private HashMap<Product, Integer> products;

    public Basket() {
        this.products = new HashMap<>();
    }

    public void addToBasket(Product product, Market market) {
        if (market.getProducts().containsKey(product)) {
            market.giveProduct(product);
            if (products.containsKey(product)) {
                products.put(product, products.get(product) + 1);
            } else {
                products.put(product, 1);
            }
        } else {
            System.out.println("Недостаточно товара '" + product.getName() + "' для добавления в корзину");
        }
    }

    public void removeProductFromBasket(Product product, Market market) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) - 1);
            if (products.get(product) == 0) {
                products.remove(product);
            }
            market.addProduct(product);
        } else {
            System.out.println("В корзине такого товара нет!");
        }
    }

    public double getBasketFullPrice() {
        double sum = 0;
        for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            sum = sum + (entry.getKey().getPrice() * entry.getValue());
        }
        return sum;
    }

    public HashMap<Product, Integer> getBasket() {
        return products;
    }

    public void clearBasket() {
        products.clear();
    }
}
