package products.impl.hotDrinksImpl;

public enum TypeOfTea {
    GREEN("Зеленый"), BLACK("Черный");

    public final String type;

    TypeOfTea(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
