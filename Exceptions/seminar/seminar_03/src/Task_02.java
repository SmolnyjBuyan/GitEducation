import java.io.IOException;

public class Task_02 {
    public static void main(String[] args) {
        try (Counter counter = new Counter()){
            System.out.println(counter);
            counter.add();
            System.out.println(counter);
            counter.add();
            System.out.println(counter);
            counter.add();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Counter counter = new Counter();
        System.out.println(counter);
        try {
            counter.add();
            counter.close();
            counter.add();
        } catch (Exception e) {
            System.out.println("Сработало исключение " + e.getClass());
        }
        System.out.println(counter);
    }
}

class Counter implements AutoCloseable{
    private int i;
    private boolean isOpen = true;
    public void add() throws IOException {
        if (!isOpen) throw new IOException();
        i++;
    }

    @Override
    public void close() throws Exception {
        isOpen = false;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "i=" + i +
                '}';
    }
}
