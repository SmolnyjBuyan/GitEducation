package products.impl;

import products.Product;

import java.time.LocalDate;

public class HotDrink extends Product {

    private float volume;
    private int temperature;
    private boolean isSugared;

    public HotDrink(String name, double price, LocalDate releaseDate) {
        super(name, price, releaseDate);
        this.volume = 0.2F;
        this.temperature = 75;
        this.isSugared = false;
    }

    public HotDrink(String name, double price, LocalDate releaseDate, float volume, int temperature, boolean isSugared) {
        super(name, price, releaseDate);
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
                ", releaseDate=" + releaseDate +
                ", volume=" + volume +
                ", temperature=" + temperature + "°C" +
                ", isSugared=" + isSugared +
                '}';
    }
}
