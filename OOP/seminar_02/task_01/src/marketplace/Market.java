package marketplace;

import clients.Actor;
import products.Product;

import java.util.*;

public class Market implements QueueBehaviour, MarketBehaviour {

    private List<Actor> customers = new ArrayList<>();
    private HashMap<Product, Integer> products = new HashMap<>();
    private Queue<Actor> queue = new LinkedList<>();

    @Override
    public void acceptToMarket(Actor customer) {
        customers.add(customer);
    }

    @Override
    public void releaseFromMarket(List<Actor> customers) {
        customers.removeFirst();
    }

    @Override
    public void update() {
        makeAnOrder();
        pickupAnOrder();
        getOutQueue();
        releaseFromMarket(customers);
    }

    public void giveProduct(Product product) {
        products.put(product, products.get(product) - 1);
        if (products.get(product) < 1) {
            products.remove(product);
        }
    }

    @Override
    public void getInQueue(Actor customer) {
        if (customer.isReadyToOrder()) {
            queue.add(customer);
        }
    }

    @Override
    public void makeAnOrder() {
        if (queue.peek().basket.getBasketFullPrice() <= queue.peek().getAmountOfMoney()) {
            pickupAnOrder();
        } else {
            queue.peek().setReadyToOrder(false);
            queue.poll();
        }
    }

    @Override
    public void pickupAnOrder() {
        queue.peek().setAmountOfMoney(queue.peek().getAmountOfMoney() - queue.peek().basket.getBasketFullPrice());
        queue.peek().setReceivedAnOrder(true);
        queue.peek().basket.clearBasket();
    }

    @Override
    public void getOutQueue() {
        if (queue.peek().isReceivedAnOrder()) queue.remove();
    }


    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    public void addProducts(Product product, Integer quantity) {
        if (quantity  <= 0) {
            return;
        }
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }

    }


    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public List<Actor> getCustomers() {
        return customers;
    }

    public Queue<Actor> getQueue() {
        return queue;
    }
}
