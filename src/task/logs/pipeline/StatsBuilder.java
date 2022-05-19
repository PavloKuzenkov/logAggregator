package task.logs.pipeline;


import task.logs.model.LogRow;
import task.logs.model.LogRowEvent;
import task.logs.model.stats.HourStats;
import task.logs.model.stats.OfficeStats;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StatsBuilder {


    public OfficeStats buildStats(List<LogRowEvent> logRowStats) {
        Map<String, Map<String, Map<Integer, Map<Integer, HourStats>>>> officeMap = groupBy(logRowStats);
        for (String office : officeMap.keySet()) {
            Map<String, Map<Integer, Map<Integer, HourStats>>> userMap = officeMap.get(office);
            for (String user : userMap.keySet()) {
                Map<Integer, Map<Integer, HourStats>> dayMap = userMap.get(user);
                for (Integer dayNumber : dayMap.keySet()) {
                    Map<Integer, HourStats> hourMap = dayMap.get(dayNumber);
                }
            }
        }
        return  null;
    }

    /**
     * return grouped log events in following format:
     * Map<Office, Map<User, Map<Day, Map<Hour, HourStats>>>>
     */
    protected Map<String, Map<String, Map<Integer, Map<Integer, HourStats>>>> groupBy(List<LogRowEvent> logRowStats) {

        Map<String, Map<String, Map<Integer, Map<Integer, HourStats>>>> collect = logRowStats.stream().collect(
                Collectors.groupingBy(x -> x.getLogRow().getOfficeName(),
                        Collectors.groupingBy(x -> x.getLogRow().getUserName(),
                                Collectors.groupingBy(x -> x.getLogRow().getMonthDay(),
                                        Collectors.groupingBy(time -> time.getLogRow().getLogEventTime().getHour(),
                                                collectingAndThen(toList(), getStatsCountFunction())
                                        )))));
        return collect;
    }

    /**
     * Create function to count average statistic per events
     * @return
     */
    private Function<List<LogRowEvent>, HourStats> getStatsCountFunction() {
        return list -> {

            long count = list.stream().filter(logrow -> LogRowEvent.EventType.DOC_SCAN == logrow.getEventType()).count();
            long avgDocScan = (long) list.stream().filter(logrow -> LogRowEvent.EventType.DOC_SCAN == logrow.getEventType()).
                    mapToLong(LogRowEvent::getExecutionTime).summaryStatistics().getAverage();
            long avgShow = (long) list.stream().filter(logrow -> LogRowEvent.EventType.DOC_SHOW == logrow.getEventType()).
                    mapToLong(LogRowEvent::getExecutionTime).summaryStatistics().getAverage();
            long avgSave = (long) list.stream().filter(logrow -> LogRowEvent.EventType.DOC_SAVE == logrow.getEventType()).
                    mapToLong(LogRowEvent::getExecutionTime).summaryStatistics().getAverage();
            HourStats hourStats = new HourStats(count, avgDocScan, avgSave, avgShow);
            return hourStats;
        };
    }

}
