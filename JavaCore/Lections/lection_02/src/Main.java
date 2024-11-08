import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Cipherator cipherator = new Cipherator("I went for a walk!");
//        System.out.println(cipherator.cipherOrDecipherCaesar(true, 6));

//        ArrayShifter arrayShifter = new ArrayShifter();
//        int[] array = {1,2,3,4,5,6,7};
//        System.out.println(Arrays.toString(arrayShifter.shift(array,12)));

        StatusKeeper statusKeeper = StatusKeeper.create(new int[]{1,0,1,0,1,1,1});
        statusKeeper.print();
        statusKeeper.invertByXor();
        statusKeeper.print();
    }
}