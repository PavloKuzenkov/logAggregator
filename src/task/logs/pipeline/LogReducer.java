package task.logs.pipeline;

import task.logs.model.LogRow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Reduce logs according to input criteria
 */
public class LogReducer {

    public List<List<LogRow>> reduce(List<List<LogRow>> list, String officeName, String userName, Integer day, Integer hour) {
        Stream<List<LogRow>> listStream = list.stream();
        if (officeName != null) {
            listStream = listStream.filter(logRows -> {
                return logRows.stream().anyMatch(logRow -> logRow.getOfficeName().equalsIgnoreCase(officeName));
            });
        }
        if (userName != null){
            listStream = listStream.filter(logRows -> {
                return logRows.stream().anyMatch(logRow -> logRow.getUserName().equalsIgnoreCase(userName));
            });
        }
        if (day != null){
            // similar logic here
        }
        return listStream.collect(Collectors.toList());
    }
}
