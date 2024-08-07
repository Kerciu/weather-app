package main.java.backend.utils;

import org.json.simple.JSONArray;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    public static int findIndexOfCurrentTime(JSONArray timeData)
    {
        String currentTime = getCurrentTime();

        for (int i = 0; i < timeData.size(); ++i)
        {
            String time = (String) timeData.get(i);
            if (time.equalsIgnoreCase(currentTime)) return i;
        }

        return 0;
    }

    private static String getCurrentTime()
    {
        LocalDateTime localDateTime = LocalDateTime.now();

        // format date to be something like ""2024-08-10T05:00"
        return localDateTime.format(createDateTimeFormatter());
    }

    private static DateTimeFormatter createDateTimeFormatter()
    {
        String formatPattern = "yyyy-MM-dd'T'HH':00'";
        return DateTimeFormatter.ofPattern(formatPattern);
    }
}
