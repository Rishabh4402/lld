package logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerSubject {
    Map<String, List<ILogObserver>> logObservers;

    LoggerSubject() {
        logObservers = new HashMap<>();
    }

    void addObserver(String observer, ILogObserver ILogObserver) {
        List<ILogObserver> logObserverList = logObservers.getOrDefault(observer, new ArrayList<>());
        logObserverList.add(ILogObserver);
        logObservers.put(observer, logObserverList);
    }

    void removeObserver(ILogObserver logObserver) {
        logObservers.forEach((s, logObservers1) -> logObservers1.remove(logObserver));
    }

    void notifyObservers(String observer, String message) {
        logObservers.forEach(((s, logObservers1) -> {
            if (s.equals(observer)) {
                logObservers1.forEach(logObserver -> logObserver.log(message));
            }
        }));
    }
}
