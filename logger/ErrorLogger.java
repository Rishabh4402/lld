package logger;

import java.util.Objects;

class ErrorLogger extends Logger {
    ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    void handle(String message, String level) {
        if (Objects.equals(level, "ERROR")) {
            System.out.println("ERROR: " + message);
        }
        if (nextLogger != null) {
            nextLogger.handle(message, level);
        }
    }
}