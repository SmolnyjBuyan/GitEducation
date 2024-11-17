public class CustomerException extends RuntimeException {
    public CustomerException() {
        this("Такого покупателя не существует");
    }

    public CustomerException(String message) {
        super(message);
    }
}
