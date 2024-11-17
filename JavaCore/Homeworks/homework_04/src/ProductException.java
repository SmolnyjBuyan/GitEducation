public class ProductException extends RuntimeException {
    public ProductException() {
        this("Такого продукта не существует");
    }

    public ProductException(String message) {
        super(message);
    }
}
