package logger;

import java.util.Objects;

class InfoLogger extends Logger {
    InfoLogger(Logger nextLogger, LoggerSubject loggerSubject) {
        super(nextLogger, loggerSubject);
    }

    void handle(String message, String level) {
        if (Objects.equals(level, "INFO")) {
            loggerSubject.notifyObservers("INFO","INFO: " + message);
        }
        if (nextLogger != null) {
            nextLogger.handle(message, level);
        }
    }
}