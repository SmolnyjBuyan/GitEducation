import java.util.Arrays;
import java.util.List;

public class BackPackManager {

//    public void countMaxPossibleValue(List<Item> items, BackPack backPack) {
//        int[][] table = new int[items.size()][backPack.getCapacity()];
//
//        for (int j = 0; j < backPack.getCapacity(); j++) {
//            if (items.getFirst().getWeight() <= j + 1) {
//                table[0][j] = items.getFirst().getPrice();
//            } else {
//                table[0][j] = 0;
//            }
//        }
//
//        for (int i = 1; i < table.length; i++) {
//            for (int j = 0; j < table[0].length; j++) {
//                int currentPrice;
//                if (j + 1 - items.get(i).getWeight() > 0) {
//                    currentPrice = items.get(i).getPrice() + table[i - 1][j + 1 - items.get(i).getWeight()];
//                } else if (j + 1 - items.get(i).getWeight() == 0) {
//                    currentPrice = items.get(i).getPrice();
//                } else {
//                    currentPrice = 0;
//                }
//                table[i][j] = Math.max(currentPrice, table[i - 1][j]);
//            }
//        }
//
//        for (int i = 0; i < table.length; i++) {
//            System.out.println(Arrays.toString(table[i]));
//        }
//    }

    public void countMaxPossibleValue(List<Item> items, BackPack backPack) {
        BackPack[][] table = new BackPack[items.size()][backPack.getCapacity()];

        for (int j = 0; j < backPack.getCapacity(); j++) {
            table[0][j] = new BackPack(j + 1);

            if (items.getFirst().getWeight() <= table[0][j].getCapacity()) {
                table[0][j].addItem(items.getFirst());
            }
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = new BackPack(j + 1);
                int currentPrice;

                if (table[i][j].getCapacity() - items.get(i).getWeight() > 0) {
                    table[i][j].addItem(items.get(i));
                    for (Item item : table[i - 1][table[i][j].getCapacity() - items.get(i).getWeight()].getItems()) {
                        table[i][j].addItem(item);
                    }
                } else if (table[i][j].getCapacity() - items.get(i).getWeight() == 0) {
                    table[i][j].addItem(items.get(i));
                }

                if (table[i][j].getPrice() < table[i - 1][j].getPrice()) {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        System.out.println(table[items.size() - 1][backPack.getCapacity() - 1]);
    }
}
