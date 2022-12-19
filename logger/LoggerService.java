package logger;

class LoggerService {
    Logger chainStart;

    LoggerService() {
        Logger debugLogger = new DebugLogger(null);
        Logger errorLogger = new ErrorLogger(debugLogger);
        chainStart = new InfoLogger(errorLogger);
    }

    public void log(String message, String level) {
        chainStart.handle(message, level);
    }
}