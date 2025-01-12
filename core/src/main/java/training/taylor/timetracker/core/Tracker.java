package training.taylor.timetracker.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import training.taylor.timetracker.core.dao.TimeEntry;

import java.util.List;

@Component
public class Tracker {
    @Autowired
    private List<TimeEntry> entries;

    public void add(TimeEntry entry) {
        if (entries != null) {
            entries.add(entry);
        } else {
            throw new IllegalStateException("Entries list is not initialized");
        }
    }

    public void remove(TimeEntry entry) {
        if (entries != null) {
            entries.remove(entry);
        } else {
            throw new IllegalStateException("Entries list is not initialized");
        }
    }

    public int size() {
        if (entries != null) {
            return entries.size();
        } else {
            throw new IllegalStateException("Entries list is not initialized");
        }
    }

    public TimeEntry get(int index) {
        if (entries == null) {
            throw new IllegalStateException("Entries list is not initialized");
        }
        if (index < 0 || index >= entries.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return entries.get(index);
    }
}

