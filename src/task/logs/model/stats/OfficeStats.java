package task.logs.model.stats;

import java.util.List;

public class OfficeStats {
    private String name;
    private long docsCount;
    // child models here. Maybe the same model can be reused for all levels
    private List<Object> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDocsCount() {
        return docsCount;
    }

    public void setDocsCount(long docsCount) {
        this.docsCount = docsCount;
    }

    public List<Object> getUsers() {
        return users;
    }

    public void setUsers(List<Object> users) {
        this.users = users;
    }
}
