package CapgeminiTraining.BankingLogs;
import java.util.*;
public class SuspiciousDetector {
    public static List<LogEntry> detectSuspicious(List<LogEntry> logs) {
        List<LogEntry> suspicious = new ArrayList<>();
        Map<String, Deque<LogEntry>> map = new HashMap<>();
        for (LogEntry log : logs) {
            if(log.getActionType() == ActionType.WITHDRAW && log.getAmount() > 50000) {
                suspicious.add(log);
            }
            map.putIfAbsent(log.getAccountNumber(), new ArrayDeque<>());
            Deque<LogEntry> deque = map.get(log.getAccountNumber());
            deque.addLast(log);
            if (deque.size() == 5) {
                deque.removeFirst();
            }
            long failedCounts = deque.stream().filter(l -> l.getActionType() == ActionType.FAILED_LOGIN).count();
            if (failedCounts > 3) {
                suspicious.add(log);
            }
        }
        return suspicious;
    }

}
