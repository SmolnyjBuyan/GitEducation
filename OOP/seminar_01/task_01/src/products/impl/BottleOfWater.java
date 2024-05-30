package products.impl;

import products.Product;

import java.time.LocalDate;

public class BottleOfWater extends Product {

    private float volume;
    private String pack;
    private boolean isSpark;

    public BottleOfWater(String name, double price, LocalDate releaseDate) {
        super(name, price, releaseDate);
        this. isSpark = false;
        this.volume = 1;
        this.pack = EPackage.PLASTIC.getMaterial();
    }

    public BottleOfWater(String name, double price, LocalDate releaseDate, float volume, String pack, boolean isSpark) {
        super(name, price, releaseDate);
        this.volume = volume;
        this.pack = pack;
        this.isSpark = isSpark;
    }

    public String getPack() {
        return pack;
    }

    public float getVolume() {
        return volume;
    }

    public boolean isSpark() {
        return isSpark;
    }

    @Override
    public String toString() {
        return "BottleOfWater{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", volume=" + volume +
                ", pack='" + pack + '\'' +
                ", isSpark=" + isSpark +
                '}';
    }
}
