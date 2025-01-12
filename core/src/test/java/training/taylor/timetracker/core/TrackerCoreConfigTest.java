package training.taylor.timetracker.core;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import training.taylor.timetracker.core.dao.TimeEntry;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackerCoreConfig.class)
public class TrackerCoreConfigTest {

    @Autowired
    private List<TimeEntry> entries;

    @Test
    public void testEntriesNotNull() {
        // Verify that the entries list is successfully injected and not null
        assertNotNull("Entries list should not be null", entries);
    }

    @Test
    public void testAddTimeEntry() {
        // Add a TimeEntry and verify the size of the list
        TimeEntry entry = new TimeEntry();
        entries.add(entry);
        assertEquals("Entries list should contain 1 element", 1, entries.size());
        assertSame("The added entry should be in the list", entry, entries.get(0));
    }

    @Test
    public void testRemoveTimeEntry() {
        // Add and remove a TimeEntry, and verify the list is empty
        TimeEntry entry = new TimeEntry();
        entries.add(entry);
        entries.remove(entry);
        assertTrue("Entries list should be empty after removing the entry", entries.isEmpty());
    }
}

