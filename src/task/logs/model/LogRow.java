package task.logs.model;

import java.time.LocalDateTime;

public class LogRow {

    private String officeName;
    private String userName;
    private int monthDay;

    private LocalDateTime logEventTime;
    private String logString;

    public LogRow(String officeName, String userName, int monthDay, LocalDateTime logEventTime, String logString) {
        this.officeName = officeName;
        this.userName = userName;
        this.monthDay = monthDay;
        this.logEventTime = logEventTime;
        this.logString = logString;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public LocalDateTime getLogEventTime() {
        return logEventTime;
    }

    public void setLogEventTime(LocalDateTime logEventTime) {
        this.logEventTime = logEventTime;
    }

    public String getLogString() {
        return logString;
    }

    public void setLogString(String logString) {
        this.logString = logString;
    }
}
