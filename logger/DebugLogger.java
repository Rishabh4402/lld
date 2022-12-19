package logger;

import java.util.Objects;

class DebugLogger extends Logger {
    DebugLogger(Logger nextLogger,LoggerSubject loggerSubject) {
        super(nextLogger,loggerSubject);
    }

    void handle(String message, String level) {
        if (Objects.equals(level, "DEBUG")) {
            loggerSubject.notifyObservers("DEBUG","DEBUG: " + message);
        }
        if (nextLogger != null) {
            nextLogger.handle(message, level);
        }
    }
}