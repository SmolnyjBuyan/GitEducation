import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class log {
    static {
        try(FileInputStream in = new FileInputStream("log.config")){ //относительный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception e) {
            e.printStackTrace();
    }
}

public static Logger log(String className) {
    return Logger.getLogger(className);
    }
}