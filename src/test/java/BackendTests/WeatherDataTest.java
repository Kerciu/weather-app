package test.java.BackendTests;

import main.java.backend.model.WeatherConditions;
import main.java.backend.model.WeatherData;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherDataTest {
    @Test
    public void testToJSON() {
        WeatherData weatherData = new WeatherData(WeatherConditions.SUNNY, 25.0, 60.0, 5.5);

        JSONObject json = weatherData.toJSON();

        assertEquals(WeatherConditions.SUNNY, json.get("weather_condition"));
        assertEquals(25.0, json.get("temperature"));
        assertEquals(60.0, json.get("humidity"));
        assertEquals(5.5, json.get("wind_speed"));
    }
}
