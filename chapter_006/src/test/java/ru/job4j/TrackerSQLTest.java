package ru.job4j;

import org.junit.Test;
import ru.job4j.trackersql.TrackerSQL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }
}
