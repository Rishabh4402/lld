package logger;

abstract class Logger {
    protected Logger nextLogger;

    Logger(Logger current) {
        nextLogger = current;
    }

    abstract void handle(String message, String level);
}