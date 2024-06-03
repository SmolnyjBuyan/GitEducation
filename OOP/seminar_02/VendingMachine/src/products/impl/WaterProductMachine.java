package products.impl;

import products.Product;
import products.ProductMachine;

import java.util.List;

public class WaterProductMachine extends ProductMachine {
    @Override
    public void addProducts(List<Product> productList) {
        this.productList.addAll(productList);
    }

    public WaterProductMachine() {
        super();
    }

    public WaterProductMachine(List<Product> products) {
        super(products);
    }
}
