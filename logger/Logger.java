package logger;

abstract class Logger {
    protected Logger nextLogger;
    protected LoggerSubject loggerSubject;

    Logger(Logger current, LoggerSubject loggerSubject) {
        nextLogger = current;
        this.loggerSubject = loggerSubject;
    }

    abstract void handle(String message, String level);

    public void log(String level, String message) {
        handle(message,level);
    }
}