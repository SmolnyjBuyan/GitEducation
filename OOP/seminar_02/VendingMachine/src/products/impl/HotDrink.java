package products.impl;

import products.Product;

public class HotDrink extends Product {

    protected float volume;
    protected int temperature;
    protected boolean isSugared;

    public HotDrink(String name, double price) {
        super(name, price);
        this.volume = Cup.MEDIUM.getVolume();
        this.temperature = 75;
        this.isSugared = false;
    }

    public HotDrink(String name, double price, float volume, int temperature, boolean isSugared) {
        super(name, price);
        this.volume = volume;
        this.temperature = temperature;
        this.isSugared = isSugared;
    }

    public float getVolume() {
        return volume;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "HotDrink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", temperature=" + temperature + "°C" +
                ", isSugared=" + isSugared +
                '}';
    }
}
