package clients;

import marketplace.Basket;
import marketplace.Market;
import products.Product;

public abstract class Actor implements ActorBehavior {
    protected String name;
    protected double amountOfMoney;
    protected boolean isReadyToOrder;
    protected boolean isReceivedAnOrder;
    public Basket basket;

    public Actor(String name, double amountOfMoney) {
        this.name = name;
        this.amountOfMoney = amountOfMoney;
        this.isReadyToOrder = false;
        this.isReceivedAnOrder = false;
        this.basket = new Basket();
    }

    public abstract String getName();
    public abstract double getAmountOfMoney();
    public abstract void setAmountOfMoney(double amount);
    public abstract void addProductToBasket(Product product, Market market);
}
