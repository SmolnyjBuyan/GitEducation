package clients;

import marketplace.Market;
import products.Product;

public class Human extends Actor {


    public Human(String name, double amountOfMoney) {
        super(name, amountOfMoney);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    @Override
    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public void addProductToBasket(Product product, Market market) {
        if (market.getCustomers().contains(this)) {
            basket.addToBasket(product, market);
        }
    }

    @Override
    public void setReadyToOrder(boolean ready) {
        isReadyToOrder = ready;
    }

    @Override
    public void setReceivedAnOrder(boolean received) {
        isReceivedAnOrder = received;
    }

    @Override
    public boolean isReadyToOrder() {
        return isReadyToOrder;
    }

    @Override
    public boolean isReceivedAnOrder() {
        return isReceivedAnOrder;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
