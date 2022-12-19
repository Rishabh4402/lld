package logger;

import java.util.Objects;

class InfoLogger extends Logger {
    InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    void handle(String message, String level) {
        if (Objects.equals(level, "INFO")) {
            System.out.println("INFO: " + message);
        }
        if (nextLogger != null) {
            nextLogger.handle(message, level);
        }
    }
}