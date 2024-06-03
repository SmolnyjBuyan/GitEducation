package products.impl;

import products.Product;
import products.ProductMachine;

import java.util.List;

public class WaterProductMachine extends ProductMachine {
    public WaterProductMachine() {
        super();
    }

    public WaterProductMachine(List<Product> products) {
        super(products);
    }
}
