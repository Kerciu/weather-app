package test.java.BackendTests;

import main.java.backend.model.WeatherData;
import main.java.backend.service.WeatherService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WeatherServiceTest {
    private static WeatherData testWeatherData;

    public static void setTestWeatherData(WeatherData weatherData) {
        testWeatherData = weatherData;
    }

    public static WeatherData getWeatherData(double latitude, double longitude) {
        return testWeatherData;
    }

    @Test
    public void testGetWeatherData() {
        double latitude = 52.2297;
        double longitude = 21.0122;

        WeatherData weatherData = WeatherService.getWeatherData(latitude, longitude);

        assertNotNull(weatherData);
        assertNotNull(weatherData.toJSON().get("weather_condition"));
        assertTrue(weatherData.toJSON().get("temperature") instanceof Double);
        assertTrue(weatherData.toJSON().get("humidity") instanceof Double);
        assertTrue(weatherData.toJSON().get("wind_speed") instanceof Double);
    }
}
