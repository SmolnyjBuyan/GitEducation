package model.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger implements Loggable {
    private static final Logger logger = Logger.getLogger("FileLogger");

    static {
        try {
            FileHandler fileHandler = new FileHandler("CalculatorLogs", true);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (SecurityException | IOException e) {
            logger.log(Level.SEVERE, "Произошла ошибка при работе с FileHandler.", e);
        }
    }


    @Override
    public void log(String message) {
        logger.info(message);
    }
}
