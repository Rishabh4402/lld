package logger;

import java.util.Objects;

class ErrorLogger extends Logger {
    ErrorLogger(Logger nextLogger,LoggerSubject loggerSubject) {
        super(nextLogger,loggerSubject);
    }

    void handle(String message, String level) {
        if (Objects.equals(level, "ERROR")) {
            loggerSubject.notifyObservers("ERROR","ERROR: " + message);
        }
        if (nextLogger != null) {
            nextLogger.handle(message, level);
        }
    }
}