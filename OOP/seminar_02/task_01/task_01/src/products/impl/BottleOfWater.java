package products.impl;

import products.Product;

import java.time.LocalDate;

public class BottleOfWater extends Product {

    private float volume;
    private String pack;
    private boolean isSpark;
    private LocalDate releaseDate;

    public BottleOfWater(String name, double price) {
        super(name, price);
        this. isSpark = false;
        this.volume = 1;
        this.releaseDate = LocalDate.now();
        this.pack = EPackage.PLASTIC.getMaterial();
    }

    public BottleOfWater(String name, double price, float volume, String pack, boolean isSpark, LocalDate releaseDate) {
        super(name, price);
        this.volume = volume;
        this.pack = pack;
        this.isSpark = isSpark;
        this.releaseDate = releaseDate;
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

    public LocalDate getReleaseDate() {
        return releaseDate;
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
