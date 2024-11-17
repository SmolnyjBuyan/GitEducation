public class Order {
    private Customer customer;
    private Product product;
    private int productAmount;

    public Order(Customer customer, Product product, int productAmount) {
        this.customer = customer;
        this.product = product;
        this.productAmount = productAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", productAmount=" + productAmount +
                '}';
    }
}
