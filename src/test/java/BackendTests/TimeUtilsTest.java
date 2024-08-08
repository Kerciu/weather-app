package test.java.BackendTests;

import main.java.backend.utils.TimeUtils;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeUtilsTest {
    @Test
    public void testFindIndexOfCurrentTime() {
        JSONArray timeData = new JSONArray();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");
        String currentTime = LocalDateTime.now().format(formatter);

        timeData.add("2024-08-10T03:00");
        timeData.add(currentTime);
        timeData.add("2024-08-10T07:00");

        int index = TimeUtils.findIndexOfCurrentTime(timeData);
        assertEquals(1, index);
    }

    @Test
    public void testFindIndexOfCurrentTimeWhenNoMatch() {
        JSONArray timeData = new JSONArray();
        timeData.add("2024-08-10T03:00");
        timeData.add("2024-08-10T04:00");
        timeData.add("2024-08-10T05:00");

        int index = TimeUtils.findIndexOfCurrentTime(timeData);
        assertEquals(0, index);
    }
}
