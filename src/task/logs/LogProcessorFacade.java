package task.logs;

import task.logs.model.LogRowEvent;
import task.logs.presentation.ConsolePrinter;
import task.logs.pipeline.LogCollector;
import task.logs.pipeline.LogReducer;
import task.logs.pipeline.PositionBasedPerformanceEvaluator;
import task.logs.pipeline.StatsBuilder;
import task.logs.model.stats.OfficeStats;

import java.util.List;

/**
 * Entry point class to process log rows
 */
public class LogProcessorFacade {
    // it can be constructor args or properties
    private static  String documentEntryStartPattern = "“*********Starting scan********”;";
    private static  String documentEntryEnd = "Image showed in applet";

    // instantiation of classes below could be replaced with factory or IOC/DI
    private LogReducer logReducer = new LogReducer();
    private PositionBasedPerformanceEvaluator performanceEvaluator = new PositionBasedPerformanceEvaluator();
    private StatsBuilder statsBuilder = new StatsBuilder();
    private ConsolePrinter consolePrinter = new ConsolePrinter();


    public void processLogs(String officeName, String userName, Integer day, Integer hour) {
        //TODO: here should be logic how to read logs from filesystem.
        LogCollector logCollector = new LogCollector(documentEntryStartPattern, documentEntryEnd);
        /*
            // iterate over log rows and collect
            logCollector.processLogLine("London", "Pavlo", 1, new Date(), "Scan done. Image loaded in memory");
         */
        logReducer.reduce(logCollector.getAllEntries(), officeName, userName, day, hour);
        List<LogRowEvent> logRowEvents = performanceEvaluator.evaluate(logCollector.getAllEntries());
        OfficeStats officeStats = statsBuilder.buildStats(logRowEvents);
        consolePrinter.print(officeStats);
    }

    public static void main(String[] args) {
        new LogProcessorFacade().processLogs(null, null, null, null);
    }

}
