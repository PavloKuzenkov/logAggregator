package task.logs.model.stats;

public class HourStats {
    private long totalDocScanned;
    private long avgScanTime;
    private long avgSaveTime;
    private long avgShowTime;

    public HourStats(long totalDocScanned, long avgScanTime, long avgSaveTime, long avgShowTime) {

        this.totalDocScanned = totalDocScanned;
        this.avgScanTime = avgScanTime;
        this.avgSaveTime = avgSaveTime;
        this.avgShowTime = avgShowTime;
    }
}
