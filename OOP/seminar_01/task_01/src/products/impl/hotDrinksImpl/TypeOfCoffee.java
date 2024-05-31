package products.impl.hotDrinksImpl;

public enum TypeOfCoffee {
    ESPRESSO("Эспрессо"), AMERICANO("Американо"), LATTE("Латте"), CAPPUCCINO("Капучино");

    public final String type;
    TypeOfCoffee(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
