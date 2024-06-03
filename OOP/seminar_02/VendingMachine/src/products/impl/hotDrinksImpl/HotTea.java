package products.impl.hotDrinksImpl;

import products.impl.HotDrink;

public class HotTea extends HotDrink {

    private boolean isWithLemon;
    private String type;
    public HotTea(String name, double price) {
        super(name, price);
        this.isWithLemon = false;
        this.type = TypeOfTea.GREEN.getType();
    }

    public HotTea(String name, double price, float volume, int temperature, boolean isSugared) {
        super(name, price, volume, temperature, isSugared);
        this.isWithLemon = false;
        this.type = TypeOfTea.BLACK.getType();
    }

    public HotTea(String name, double price, float volume, int temperature, boolean isSugared,
                  boolean isWithLemon, String type) {
        super(name, price, volume, temperature, isSugared);
        this.isWithLemon = isWithLemon;
        this.type = type;
    }

    public boolean isWithLemon() {
        return isWithLemon;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "HotTea{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", temperature=" + temperature + "°C" +
                ", isSugared=" + isSugared +
                ", isWithLemon=" + isWithLemon +
                ", type=" + type +
                '}';
    }
}
