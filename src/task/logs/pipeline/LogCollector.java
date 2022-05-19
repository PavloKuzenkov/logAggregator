package task.logs.pipeline;


import task.logs.model.LogRow;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LogCollector {

    private  String documentEntryStartPattern;
    private  String documentEntryEnd;

    private List<LogRow> entryRecords;
    private List<List<LogRow>> allEntries = new LinkedList<>();

    public LogCollector(String documentEntryStartPattern, String documentEntryEnd) {
        this.documentEntryStartPattern = documentEntryStartPattern;
        this.documentEntryEnd = documentEntryEnd;
    }

    public void processLogLine(String officeName, String userName, int monthDay, Date timeInMilliseconds, String logString) {
        if(logString.endsWith(documentEntryStartPattern)){
            entryRecords = new ArrayList<>();
        } else if(logString.endsWith(documentEntryEnd)){
            allEntries.add(entryRecords);
        }
        LocalDateTime logEventTime = LocalDateTime.ofInstant(timeInMilliseconds.toInstant(), ZoneId.systemDefault());
        LogRow logRow = new LogRow(officeName, userName, monthDay, logEventTime, logString);
        entryRecords.add(logRow);
    }

    public List<List<LogRow>> getAllEntries() {
        return allEntries;
    }
}
