import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static Customer andrey = new Customer("Котов", "Андрей", "Андреевич",
            LocalDate.of(1993, 10, 30), "89115554466");
    static Customer dmitriy = new Customer("Чупров", "Дмитрий", "Александрович",
            LocalDate.of(1992, 1, 6), "89114445566");

    static Customer[] customers = {andrey, dmitriy};

    static Product mars = new Product("Mars", new BigDecimal(60));
    static Product snickers = new Product("Snickers", new BigDecimal(80));
    static Product bounty = new Product("Bounty", new BigDecimal(70));
    static Product twix = new Product("Twix", new BigDecimal(75));
    static Product milka = new Product("Milka", new BigDecimal(120));

    static Product[] products = {mars, snickers, bounty, twix, milka};

    static Order[] orders = new Order[5];
    static int ordersCount = 0;

    public static void main(String[] args) {
        Product neo = new Product("Neo", new BigDecimal(1000));
        Customer viktor = new Customer("Гагарин", "Виктор", "Викторович",
                LocalDate.of(1992, 3,29), "89298887733");

        confirmOrder(andrey, neo, 1);
        confirmOrder(dmitriy, mars, -10);
        confirmOrder(andrey, snickers, 2);
//        confirmOrder(viktor, mars, 4);

        System.out.println(Arrays.toString(orders));

    }

    public static Order makeOrder(Customer customer, Product product, int productAmount) {
        if (!isExist(customer)) throw new CustomerException();
        if (!isExist(product)) throw new ProductException();
        if (productAmount <= 0 || productAmount >= 100) throw new AmountException(customer, product);

        return new Order(customer, product, productAmount);
    }

    public static boolean isExist(Customer customer) {
        return Arrays.asList(customers).contains(customer);
    }

    public static boolean isExist(Product product) {
        return Arrays.asList(products).contains(product);
    }

    public static void confirmOrder(Customer customer, Product product, int productAmount) {
        try {
            orders[ordersCount] = makeOrder(customer, product, productAmount);
            ordersCount++;
        } catch (ProductException e) {
            System.out.println(e.getMessage());
        } catch (AmountException e) {
            orders[ordersCount] = (makeOrder(customer, product, 1));
            ordersCount++;
        } catch (CustomerException e) {
            throw new CustomerException();
        }
    }
}