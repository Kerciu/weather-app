package test.java.GuiTests;

import main.java.backend.model.WeatherConditions;
import main.java.frontend.gui.ColorClimate;
import main.java.frontend.utility.ColorConstants;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorClimateTest {
    @Test
    public void testSunnyPaletteAbove35() {
        WeatherConditions condition = WeatherConditions.SUNNY;
        double temperature = 36.0;
        ColorClimate colorClimate = new ColorClimate(condition, temperature);
        Color[] expected = ColorConstants.SUNNY_ABOVE_35;
        Color[] actual = colorClimate.getColorPalette();
        assertEquals(expected.length, actual.length, "Palette lengths are different.");
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }

    @Test
    public void testSunnyPaletteBetween25And35() {
        WeatherConditions condition = WeatherConditions.SUNNY;
        double temperature = 30.0;
        ColorClimate colorClimate = new ColorClimate(condition, temperature);
        Color[] expected = ColorConstants.SUNNY_ABOVE_25_AND_BELOW_35;
        Color[] actual = colorClimate.getColorPalette();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }

    @Test
    public void testSunnyCloudyPaletteAbove30() {
        WeatherConditions condition = WeatherConditions.SUNNY_CLOUDY;
        double temperature = 31.0;
        ColorClimate colorClimate = new ColorClimate(condition, temperature);
        Color[] expected = ColorConstants.SUNNY_CLOUDY_ABOVE_30;
        Color[] actual = colorClimate.getColorPalette();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }

    @Test
    public void testCloudyPaletteBelow25() {
        WeatherConditions condition = WeatherConditions.CLOUDY;
        double temperature = 20.0;
        ColorClimate colorClimate = new ColorClimate(condition, temperature);
        Color[] expected = ColorConstants.CLOUDY_BELOW_25;
        Color[] actual = colorClimate.getColorPalette();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }

    @Test
    public void testRainPaletteAbove25() {
        WeatherConditions condition = WeatherConditions.RAIN;
        double temperature = 26.0;
        ColorClimate colorClimate = new ColorClimate(condition, temperature);
        Color[] expected = ColorConstants.RAINY_ABOVE_25;
        Color[] actual = colorClimate.getColorPalette();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }

    @Test
    public void testThunderstormPaletteBelow25() {
        WeatherConditions condition = WeatherConditions.THUNDERSTORM;
        double temperature = 22.0;
        ColorClimate colorClimate = new ColorClimate(condition, temperature);
        Color[] expected = ColorConstants.THUNDERSTORM_BELOW_25;
        Color[] actual = colorClimate.getColorPalette();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }

    @Test
    public void testButtonGradientColorsForSunny() {
        WeatherConditions condition = WeatherConditions.SUNNY;
        ColorClimate colorClimate = new ColorClimate(condition, 25.0);
        Color[] expected = ColorConstants.BUTTON_GRADIENT_SUNNY;
        Color[] actual = colorClimate.getButtonGradientColors();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }

    @Test
    public void testButtonGradientColorsForFog() {
        WeatherConditions condition = WeatherConditions.FOG;
        ColorClimate colorClimate = new ColorClimate(condition, 15.0);
        Color[] expected = ColorConstants.BUTTON_GRADIENT_FOG;
        Color[] actual = colorClimate.getButtonGradientColors();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], "Color at index " + i + " is incorrect.");
        }
    }
}
