package test.java.GuiTests;

import main.java.backend.model.WeatherConditions;
import main.java.frontend.utility.WeatherStateResolver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherStateResolverTest {
    @Test
    public void testGetWeatherImagePathSunny() {
        WeatherConditions condition = WeatherConditions.SUNNY;
        String expectedPath = "assets/images/weather/sunny.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathCloudy() {
        WeatherConditions condition = WeatherConditions.CLOUDY;
        String expectedPath = "assets/images/weather/cloudy.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathFog() {
        WeatherConditions condition = WeatherConditions.FOG;
        String expectedPath = "assets/images/weather/foggy.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathDrizzle() {
        WeatherConditions condition = WeatherConditions.DRIZZLE;
        String expectedPath = "assets/images/weather/drizzle.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathRain() {
        WeatherConditions condition = WeatherConditions.RAIN;
        String expectedPath = "assets/images/weather/rainy.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathSleet() {
        WeatherConditions condition = WeatherConditions.SLEET;
        String expectedPath = "assets/images/weather/sleet.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathSnowy() {
        WeatherConditions condition = WeatherConditions.SNOWY;
        String expectedPath = "assets/images/weather/snowy.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathDownpour() {
        WeatherConditions condition = WeatherConditions.DOWNPOUR;
        String expectedPath = "assets/images/weather/downpour.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathSnowstorm() {
        WeatherConditions condition = WeatherConditions.SNOWSTORM;
        String expectedPath = "assets/images/weather/snowstorm.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathThunderstorm() {
        WeatherConditions condition = WeatherConditions.THUNDERSTORM;
        String expectedPath = "assets/images/weather/dark-and-stormy.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathHailThunderstorm() {
        WeatherConditions condition = WeatherConditions.HAIL_THUNDERSTORM;
        String expectedPath = "assets/images/weather/hail.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherImagePathDefault() {
        WeatherConditions condition = WeatherConditions.SUNNY_CLOUDY; // Use a default condition
        String expectedPath = "assets/images/weather/cloudy-sunny.png";
        String actualPath = WeatherStateResolver.getWeatherImagePath(condition);
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void testGetWeatherConditionNameSunny() {
        WeatherConditions condition = WeatherConditions.SUNNY;
        String expectedName = "Sunny";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameSunnyCloudy() {
        WeatherConditions condition = WeatherConditions.SUNNY_CLOUDY;
        String expectedName = "Sunny with Clouds";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameCloudy() {
        WeatherConditions condition = WeatherConditions.CLOUDY;
        String expectedName = "Cloudy";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameFog() {
        WeatherConditions condition = WeatherConditions.FOG;
        String expectedName = "Foggy";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameDrizzle() {
        WeatherConditions condition = WeatherConditions.DRIZZLE;
        String expectedName = "Drizzle";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameRain() {
        WeatherConditions condition = WeatherConditions.RAIN;
        String expectedName = "Rainy";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameSleet() {
        WeatherConditions condition = WeatherConditions.SLEET;
        String expectedName = "Sleet";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameSnowy() {
        WeatherConditions condition = WeatherConditions.SNOWY;
        String expectedName = "Snowy";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameDownpour() {
        WeatherConditions condition = WeatherConditions.DOWNPOUR;
        String expectedName = "Downpour";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameSnowstorm() {
        WeatherConditions condition = WeatherConditions.SNOWSTORM;
        String expectedName = "Snowstorm";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameThunderstorm() {
        WeatherConditions condition = WeatherConditions.THUNDERSTORM;
        String expectedName = "Thunderstorm";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameHailThunderstorm() {
        WeatherConditions condition = WeatherConditions.HAIL_THUNDERSTORM;
        String expectedName = "Hail with Thunderstorm";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void testGetWeatherConditionNameDefault() {
        WeatherConditions condition = WeatherConditions.SUNNY_CLOUDY;
        String expectedName = "Sunny with Clouds";
        String actualName = WeatherStateResolver.getWeatherConditionName(condition);
        assertEquals(expectedName, actualName);
    }
}
