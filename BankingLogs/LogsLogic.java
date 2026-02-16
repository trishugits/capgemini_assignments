package CapgeminiTraining.BankingLogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogsLogic implements LogManager {
    private HashMap<String, ArrayList<LogEntry>> accountlogs;
    private List<LogEntry> allLogs;
    private HashMap<ActionType, ArrayList<LogEntry>> actionlogs;
    @Override
    public void addLogEntry(String account, ActionType actionType, double amount, Status status) {

    }

    @Override
    public List<LogEntry> getLogByAccount(String account) {
        return accountlogs.getOrDefault(account, new ArrayList<>());
    }

    @Override
    public List<LogEntry> getRecentNLogs(int n) {
        List<LogEntry> recentNLogs = new ArrayList<>();
        int count=0;
        for (LogEntry log : allLogs) {
            if(count >= n){
                break;
            }
            recentNLogs.add(log);
            count++;
        }
        return recentNLogs;
    }

    @Override
    public List<LogEntry> getLogByActionType(ActionType actionType) {
        return actionlogs.getOrDefault(actionType, new ArrayList<>());
    }

    @Override
    public List<LogEntry> detectSuspicious() {
        return SuspiciousDetector.detectSuspicious(allLogs);
    }
}
