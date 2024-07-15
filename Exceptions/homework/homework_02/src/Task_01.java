public class Task_01 {
    public static void main(String[] args) {
        isFloat("3.14");
        isFloat("Ivan");
    }

    public static float isFloat(String input) {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a float number. Please, try again.");
            return Float.NaN;
        } catch (NullPointerException e) {
            System.out.println("Your input is null.");
            return Float.NaN;
        }
    }
}
