package logger;

public class FileObserver implements ILogObserver {

    @Override
    public void log(String message) {
        System.out.println("File: " + message);
    }
}
