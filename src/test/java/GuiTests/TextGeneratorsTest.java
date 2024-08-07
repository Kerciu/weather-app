package test.java.GuiTests;

import main.java.frontend.text.HumidityTextGenerator;
import main.java.frontend.text.TemperatureTextGenerator;
import main.java.frontend.text.WeatherCondDescriptionMaker;
import main.java.frontend.text.WindSpeedTextGenerator;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TextGeneratorsTest {
    @org.junit.Test
    @Test
    public void testWeatherCondDescription()
    {
        JLabel label = WeatherCondDescriptionMaker.createDescriptionLabel();

        Rectangle bounds = label.getBounds();

        assertNotNull(label, "Label should not be null");
        assertEquals(0, bounds.x, "X should be 0");
        assertEquals(405, bounds.y, "Y should be 405");
        assertEquals(450, bounds.width, "Width should be 450");
        assertEquals(36, bounds.height, "Height should be 36");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.PLAIN, label.getFont().getStyle());
        assertEquals(32, label.getFont().getSize());

        assertEquals(SwingConstants.CENTER, label.getHorizontalAlignment());
    }

    @org.junit.Test
    @Test
    public void testTemperatureText()
    {
        JLabel label = TemperatureTextGenerator.generateLabel();

        Rectangle bounds = label.getBounds();
        assertNotNull(label, "Label should not be null");
        assertEquals(0, bounds.x, "X should be 0");
        assertEquals(350, bounds.y, "Y should be 350");
        assertEquals(450, bounds.width, "Width should be 450");
        assertEquals(54, bounds.height, "Height should be 54");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.BOLD, label.getFont().getStyle());
        assertEquals(48, label.getFont().getSize());

        assertEquals(SwingConstants.CENTER, label.getHorizontalAlignment());
    }

    @org.junit.Test
    @Test
    public void testHumidityText()
    {
        JLabel label = HumidityTextGenerator.generateLabel();

        Rectangle bounds = label.getBounds();

        String humiditySubString = "<html><b>Humidity</b> ";
        assertEquals(label.getText().substring(0, humiditySubString.length()), humiditySubString);

        assertNotNull(label, "Label should not be null");
        assertEquals(90, bounds.x, "X should be 90");
        assertEquals(500, bounds.y, "Y should be 500");
        assertEquals(85, bounds.width, "Width should be 85");
        assertEquals(55, bounds.height, "Height should be 55");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.PLAIN, label.getFont().getStyle());
        assertEquals(16, label.getFont().getSize());
    }

    @org.junit.Test
    @Test
    public void testWindspeedText()
    {
        JLabel label = WindSpeedTextGenerator.generateLabel();

        Rectangle bounds = label.getBounds();

        String humiditySubString = "<html><b>Windspeed</b> ";
        assertEquals(label.getText().substring(0, humiditySubString.length()), humiditySubString);

        assertNotNull(label, "Label should not be null");
        assertEquals(310, bounds.x, "X should be 310");
        assertEquals(500, bounds.y, "Y should be 500");
        assertEquals(88, bounds.width, "Width should be 88");
        assertEquals(55, bounds.height, "Height should be 55");

        assertEquals("Dialog", label.getFont().getName());
        assertEquals(Font.PLAIN, label.getFont().getStyle());
        assertEquals(16, label.getFont().getSize());
    }
}
