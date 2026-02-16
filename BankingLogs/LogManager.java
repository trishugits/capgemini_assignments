package CapgeminiTraining.BankingLogs;

import java.util.List;

public interface LogManager {
    void addLogEntry(String account, ActionType actionType, double amount, Status status);
    List<LogEntry> getLogByAccount(String account);
    List<LogEntry> getRecentNLogs(int n);
    List<LogEntry> getLogByActionType(ActionType actionType);
    List<LogEntry> detectSuspicious();
}
