import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item recorder = new Item("Магнитофон", 3000, 4);
        Item laptop = new Item("Ноутбук", 2000, 3);
        Item guitar = new Item("Гитара", 1500, 1);

        BackPack backPack = new BackPack(4);
        BackPackManager backPackManager = new BackPackManager();

        backPackManager.countMaxPossibleValue(List.of(guitar, recorder, laptop), backPack);
    }
}