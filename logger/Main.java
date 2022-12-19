package logger;

class Main {
    public static void main(String[] args) {
        Logger logger = LoggerService.getInstance();
        LoggerService.addObserver("INFO",new FileObserver());
        logger.log("INFO","Hello Observer pattern");
    }
}