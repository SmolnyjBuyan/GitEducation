import java.util.ArrayList;
import java.util.List;

public class BackPack {
    private int capacity;
    private int weight;
    private List<Item> items;

    public BackPack(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (item.getWeight() + weight <= capacity) {
            items.add(item);
            weight += item.getWeight();
        } else {
            System.out.println(item.getName() + "В рюкзаке недостаточно места");
        }
    }

    public void addAllItems(Item... items) {
        int sumWeight = 0;
        List<Item> itemsToAdd = new ArrayList<>(List.of(items));
        for (Item item : itemsToAdd) {
            sumWeight += item.getWeight();
        }
        if (sumWeight + weight <= capacity) {
            this.items.addAll(itemsToAdd);
            weight += sumWeight;
        } else {
            System.out.println("В рюкзаке недостаточно места");
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        int sum = 0;
        for (Item item : items) {
            sum+=item.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "BackPack{" +
                "capacity=" + capacity +
                ", weight=" + weight +
                ", items=" + items +
                '}';
    }
}
