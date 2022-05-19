package task.logs.model;

public class LogRowEvent {

    private Long executionTime;
    private EventType eventType;
    private LogRow logRow;

    public LogRowEvent(LogRow logRow, EventType eventType, Long executionTime) {
        this.executionTime = executionTime;
        this.eventType = eventType;
        this.logRow = logRow;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public LogRow getLogRow() {
        return logRow;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    public enum EventType {
        DOC_SCAN,
        DOC_SAVE,
        DOC_SHOW
    }
}
