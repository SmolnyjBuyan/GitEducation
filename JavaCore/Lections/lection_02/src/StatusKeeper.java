import java.util.Arrays;

public class StatusKeeper {
    int[] statuses;

    private StatusKeeper(int[] statuses) {
        this.statuses = statuses;
    }

    public static StatusKeeper create(int[] statuses) {
        if (isValid(statuses)) {
            return new StatusKeeper(statuses);
        }

        return null;
    }

    private static boolean isValid(int[] statuses) {
        return Arrays.stream(statuses).allMatch(s -> s == 0 || s == 1);
    }

    public void invertBySubtraction() {
        statuses = Arrays.stream(statuses).map(s ->  1 - s).toArray();
    }

    public void invertByXor() {
        statuses = Arrays.stream(statuses).map(s -> s ^ 1).toArray();
    }

    public void print() {
        System.out.println(Arrays.toString(statuses));
    }
}
