package ru.job4j;

import org.junit.Test;
import ru.job4j.searchQueue.PrioriytQueue;
import ru.job4j.searchQueue.Task;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {

    @Test
    public void whenHigerPriority() {
        PrioriytQueue queue = new PrioriytQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesk(), is("urgent"));
    }
}