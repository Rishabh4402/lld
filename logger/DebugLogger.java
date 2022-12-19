package logger;

import java.util.Objects;

class DebugLogger extends Logger {
    DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    void handle(String message, String level) {
        if (Objects.equals(level, "DEBUG")) {
            System.out.println("DEBUG: " + message);
        }
        if (nextLogger != null) {
            nextLogger.handle(message, level);
        }
    }
}