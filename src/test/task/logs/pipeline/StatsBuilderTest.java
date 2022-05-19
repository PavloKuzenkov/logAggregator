package task.logs.pipeline;


import task.logs.model.LogRow;
import task.logs.model.LogRowEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StatsBuilderTest {


    public static void main(String[] args) {
        StatsBuilder statsBuilder = new StatsBuilder();
        List<LogRowEvent> logRowStats = new ArrayList<>();

        logRowStats.add(new LogRowEvent(
                new LogRow("London", "Pavlo", 1, LocalDateTime.now(), "scanLog"),
                LogRowEvent.EventType.DOC_SCAN, 10L));


        logRowStats.add(new LogRowEvent(
                new LogRow("London", "Pavlo", 2, LocalDateTime.now(), "scanLog"),
                LogRowEvent.EventType.DOC_SCAN, 10L));

        logRowStats.add(new LogRowEvent(
                new LogRow("London", "Pavlo", 2, LocalDateTime.now(), "scanLog"),
                LogRowEvent.EventType.DOC_SCAN, 20L));

        logRowStats.add(new LogRowEvent(
                new LogRow("London", "Pavlo", 2, LocalDateTime.now(), "show log"),
                LogRowEvent.EventType.DOC_SHOW, 20L));


        logRowStats.add(new LogRowEvent(
                new LogRow("London", "John", 2, LocalDateTime.now(), "showLog"),
                LogRowEvent.EventType.DOC_SHOW, 15L));

        statsBuilder.buildStats(logRowStats);
    }


}
