package logger;

class LoggerService {
    private static volatile Logger chainStart;
    private static LoggerSubject loggerSubject;

    static void init(){
        loggerSubject = new LoggerSubject();
        loggerSubject.addObserver("INFO",new ConsoleObserver());
        loggerSubject.addObserver("ERROR",new FileObserver());
        Logger debugLogger = new DebugLogger(null,loggerSubject);
        Logger errorLogger = new ErrorLogger(debugLogger,loggerSubject);
        chainStart = new InfoLogger(errorLogger,loggerSubject);
    }

    private LoggerService() {
        init();
    }

    public static Logger getInstance(){
        if(chainStart==null){
            init();
        }
        return chainStart;
    }

    public void log(String message, String level) {
        chainStart.handle(message, level);
    }

    public static void addObserver(String observer,ILogObserver logObserver){
        if(loggerSubject==null){
            init();
        }
        loggerSubject.addObserver(observer,logObserver);
    }

}