package logger;

class Main {
    public static void main(String[] args) {
        LoggerService loggerService = new LoggerService();
        loggerService.log("Hello", "ERROR");
    }
}