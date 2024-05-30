import java.util.ArrayList;
import java.util.List;

public class ProductMachine {

    private List<Product> productList;

    public void addProducts(List<Product> productList) {
        this.productList.addAll(productList);
    }

    public Product getProduct(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                Product result = product;
                productList.remove(product);
                return result;
            }
        }

        System.out.println("No such product" + name);
        return null;
    }

    public ProductMachine() {
        this.productList = new ArrayList<>();
    }

    public ProductMachine(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
