package products.impl.hotDrinksImpl;

import products.impl.HotDrink;

public class Coffee extends HotDrink {

    private boolean isWithCream;

    public Coffee(String name, double price) {
        super(name, price);
        this.isWithCream = false;
    }

    public Coffee(String name, double price, float volume, int temperature, boolean isSugared) {
        super(name, price, volume, temperature, isSugared);
        this.isWithCream = false;
    }

    public Coffee(String name, double price, float volume,
                  int temperature, boolean isSugared, boolean isWithCream) {
        super(name, price, volume, temperature, isSugared);
        this.isWithCream = isWithCream;
    }

    public boolean isWithCream() {
        return isWithCream;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", temperature=" + temperature + "°C" +
                ", isSugared=" + isSugared +
                ", isWithCream=" + isWithCream +
                '}';
    }
}
