package patterns.generating.singleton.solution;

public class DB {
    private static DB instance;
    private final String pathToDB;

    private DB(String pathToDB) {
        // Этот код эмулирует медленную инициализацию.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.pathToDB = pathToDB;
    }

    public static DB getInstance(String value) {
        if (instance == null) {
            instance = new DB(value);
        }
        return instance;
    }

    public String getPathToDB() {
        return pathToDB;
    }
}


