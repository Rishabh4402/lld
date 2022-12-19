package logger;

public class ConsoleObserver implements ILogObserver {
    @Override
    public void log(String message) {
        System.out.println("Console: " + message);
    }
}
