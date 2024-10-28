public class Task_04 {
    public static void main(String[] args) {
        try {
            System.out.println(expr(' '));
        } catch (Exception e) {
            System.err.println(STR."Error: \{e.getMessage()}");
        }
    }

    public static String expr(char a) throws Exception {
        if (a == ' ') {
            throw new Exception("Empty string has been input.");
        }
//        return STR."Your input was - \{a}";
        return String.format("Your input was - %s", a);
    }
}
