package task.logs.pipeline;



import task.logs.model.LogRow;
import task.logs.model.LogRowEvent;

import java.util.ArrayList;
import java.util.List;

public class PositionBasedPerformanceEvaluator {

    public List<LogRowEvent> evaluate(List<List<LogRow>> entries){
        List<LogRowEvent> result = new ArrayList<>(entries.size() * 3);
        for (List<LogRow> entry : entries) {
            result.add(сalcDocumentScan(entry));
            result.add(calcSaveTime(entry));
            result.add(calcShowTime(entry));
        }
        return result;
    }

    protected LogRowEvent сalcDocumentScan(List<LogRow> entry){
        //TODO: logic how to find and calculate time ms here
        return new LogRowEvent(entry.get(0), LogRowEvent.EventType.DOC_SCAN, 10L);
    }

    protected LogRowEvent calcSaveTime(List<LogRow> entry){
        //TODO: logic how to find and calculate time ms here
        return new LogRowEvent(entry.get(0), LogRowEvent.EventType.DOC_SAVE, 50L);
    }

    protected LogRowEvent calcShowTime(List<LogRow> entry){
        //TODO: logic how to find and calculate time ms here
        return new LogRowEvent(entry.get(0), LogRowEvent.EventType.DOC_SHOW, 100L);
    }


}
